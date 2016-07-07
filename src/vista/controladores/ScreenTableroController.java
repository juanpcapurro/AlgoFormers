package vista.controladores;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Screen;
import javafx.stage.Window;
import modelo.juego.ProxyPartida;
import vista.ControlledScreen;
import vista.ScreensController;
import vista.mainApp;

import javax.swing.*;
import java.net.URL;
import java.util.Hashtable;
import java.util.ResourceBundle;

import static vista.controladores.SelectionController.setResizeEffectOnButton;


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
    static ProxyPartida partida;
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



        partida=new ProxyPartida(nombreJugador1,mainApp.nombreJ2,8);
        imprimir(partida);
        setButtonsEvent();
        tableroGrid.setGridLinesVisible(true);
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        panelSuperior.setPrefSize(screenBounds.getWidth(), screenBounds.getHeight());
        tableroGrid.setMaxSize(TABLERO_WIDTH, TABLERO_HEIGTH);


    }

    public void setScreenParent(ScreensController screenParent) {
        myController = screenParent;
    }

    @Override
    public void setNombreJugadores(String nj1, String nj2) {
        nombreJugador1 = nj1;
        nombreJugador2 = nj2;
    }

    public void imprimir(ProxyPartida partida){

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
                ScreenTableroController.partida.avanzarIterador();
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



    @FXML
    public void salir(){
        mainApp.primaryStage.close();

    }


}