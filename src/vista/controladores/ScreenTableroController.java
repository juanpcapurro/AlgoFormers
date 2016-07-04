package vista.controladores;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import modelo.juego.ProxyPartida;
import vista.ControlledScreen;
import vista.ScreensController;
import vista.mainApp;

import java.net.URL;
import java.util.Hashtable;
import java.util.ResourceBundle;

import static vista.controladores.SelectionController.setResizeEffectOnButton;
import static vista.mainApp.primaryStage;
import static vista.mainApp.screenTablero;

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
    Label nombreJugadorTurno, alcance,velocidad,vidaDisponible,potenciaDeAtaque;
    @FXML
    Button finalizarTurno;
    @FXML
    Button transformar;
    @FXML
    Button combinar;


    ScreensController myController;
    static ProxyPartida partida;
    SelectionController controladorDeSeleccion;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        nombreJugadorTurno.setText(mainApp.partida.getNombreJugadorQueDebeJugar());
        controladorDeSeleccion=new SelectionController(imagenAlgoformerJugando,vidaDisponible,potenciaDeAtaque,
                                                        alcance,velocidad,nombreJugadorTurno,vidaBar,tableroGrid);
        imprimir();
        setButtonsEvent();

        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        panelSuperior.setPrefSize(screenBounds.getWidth(), screenBounds.getHeight());

    }

    public void setScreenParent(ScreensController screenParent) {
        myController = screenParent;
    }

    public void imprimir(){
        partida=new ProxyPartida(mainApp.nombreJ1,mainApp.nombreJ2,8);
        partida.notificarVista();
        Hashtable<String,String> imagenes=TableroVista.getImagenes();
        tableroGrid.getChildren().clear();
        tableroGrid.setGridLinesVisible(true);
        tableroGrid.setPadding(new Insets(10,10,10,10));
        for (int j=0;j<8;j++) {
            for (int i = 0; i < 8; i++) {
                StackPane pane = new StackPane();
                ImageView imagenAerea=new ImagenAerea(imagenes,partida);
                pane.setAlignment(imagenAerea, Pos.TOP_LEFT);
                pane.getChildren().addAll( new ImagenTerrestre(imagenes, partida),imagenAerea , new ImagenObjeto(imagenes, partida));
                GridPane.setConstraints(pane,j,i);
                tableroGrid.getChildren().add(pane);
                controladorDeSeleccion.setUp(pane);
                partida.avanzarIterador();
            }
        }
    }

    public void setButtonsEvent(){
        controladorDeSeleccion.setTransformation(transformar);
        controladorDeSeleccion.setFinalizarTurno(finalizarTurno);
        setResizeEffectOnButton(finalizarTurno);
        setResizeEffectOnButton(transformar);
        setResizeEffectOnButton(combinar);
    }

    @FXML
    public void jugar(){
        myController.setScreen(screenTablero);
    }


    @FXML
    public void salir(){
        primaryStage.close();
    }


}