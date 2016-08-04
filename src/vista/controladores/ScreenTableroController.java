package vista.controladores;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import modelo.juego.AdaptadorPartida;
import vista.ControlledScreen;
import vista.ScreensController;
import vista.mainApp;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Hashtable;
import java.util.ResourceBundle;

import static vista.controladores.SelectionController.setResizeEffectOnButton;
import static vista.mainApp.dialogStage;
import static vista.mainApp.screenFinal;


public class ScreenTableroController implements Initializable, ControlledScreen {


    @FXML
    GridPane tableroGrid;
    @FXML
    AnchorPane panelSuperior;
    @FXML
    ProgressBar vidaBar;
    @FXML
    ImageView imagenAlgoformerJugando,robot1Imagen,robot2Imagen,robot3Imagen;;
    @FXML
    Label nombreJugadorTurno, alcance,velocidad,vidaDisponible,potenciaDeAtaque,estadoRobot1,estadoRobot2,estadoRobot3,mensajesDeAyuda;
    @FXML
    Button finalizarTurno, transformar,combinar;



    ScreensController myController;
    static AdaptadorPartida partida;
    SelectionController controladorDeSeleccion;
    static final double TABLERO_HEIGTH =573.0;
    static final double TABLERO_WIDTH =1234.0;
    static final int DIMENSION=8;
    private String nombreJugador1, nombreJugador2;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        controladorDeSeleccion=new SelectionController(imagenAlgoformerJugando,vidaDisponible,potenciaDeAtaque,
                                                        alcance,velocidad,nombreJugadorTurno,vidaBar,tableroGrid,
                                                        robot1Imagen,robot2Imagen,robot3Imagen,estadoRobot1,estadoRobot2,estadoRobot3);

        partida= crearPartida();
        imprimir(partida);
        setButtonsEvent();
        tableroGrid.setGridLinesVisible(true);
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        panelSuperior.setPrefSize(screenBounds.getWidth(), screenBounds.getHeight());
        tableroGrid.setMaxSize(TABLERO_WIDTH, TABLERO_HEIGTH);


    }

    private AdaptadorPartida crearPartida() {

        if(ScreensController.getEquipoJ1()== "autobots"){
            return new AdaptadorPartida(ScreensController.getJ2(), ScreensController.getJ1(),8);
        }
        else{
            return new AdaptadorPartida(ScreensController.getJ1(),ScreensController.getJ2(),8);
        }

    }

    public void setScreenParent(ScreensController screenParent) {
        myController = screenParent;
    }

    @Override
    public void setNombreJugadores(String nj1, String nj2) {

    }


    public void imprimir(AdaptadorPartida partida){

        ScreenTableroController.partida.setNotificarVista();
        Hashtable<String,String> imagenes= new Imagenes();
        tableroGrid.getChildren().clear();
        tableroGrid.setGridLinesVisible(true);
        for (int j=0;j<DIMENSION;j++) {
            for (int i = 0; i < DIMENSION; i++) {
                StackPane pane = new StackPane();
                ImageView imagenAerea=new ImagenAerea(imagenes, ScreenTableroController.partida);
                pane.setAlignment(imagenAerea, Pos.TOP_LEFT);
                pane.getChildren().addAll( new ImagenTerrestre(imagenes, ScreenTableroController.partida),imagenAerea , new ImagenObjeto(imagenes, ScreenTableroController.partida));
                GridPane.setConstraints(pane,j,i);
                tableroGrid.getChildren().add(pane);
                controladorDeSeleccion.setUp(pane);
                ScreenTableroController.partida.avanzarPosicionador();
            }
        }


    }



    public void setButtonsEvent(){
        controladorDeSeleccion.setTransformation(transformar);
        controladorDeSeleccion.setFinalizarTurno(finalizarTurno);
        controladorDeSeleccion.setCombinar(combinar);
        setResizeEffectOnButton(finalizarTurno);
        setResizeEffectOnButton(transformar);
        setResizeEffectOnButton(combinar);
    }


    public void mostrarPantallaFinal(){
        myController.setScreen(screenFinal);
    }

    @FXML
    public void salir(){

        mainApp.primaryStage.close();

    }
    
    @FXML
    public void ayuda() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(mainApp.class.getResource("screenAyuda.fxml"));
        AnchorPane page = loader.load();

        // CREO EL DIALOG STAGE
        dialogStage = new Stage();
        dialogStage.setTitle("AYUDA");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(mainApp.primaryStage);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);
        
    	String musicFile = "src/vista/imagenes/help.mp3";
    	Media sonido = new Media(new File(musicFile).toURI().toString());
    	MediaPlayer mediaPlayer = new MediaPlayer(sonido);
    	mediaPlayer.play();


        dialogStage.showAndWait();




    }


}