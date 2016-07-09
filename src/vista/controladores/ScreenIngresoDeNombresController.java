package vista.controladores;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import vista.ControlledScreen;
import vista.ScreensController;
import vista.mainApp;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import static javafx.scene.input.KeyCode.T;
import static vista.mainApp.primaryStage;
import static vista.mainApp.screenSeleccionDeEquipos;


public class ScreenIngresoDeNombresController implements Initializable, ControlledScreen {
    public javafx.scene.control.TextField nombreJugador1;
    public javafx.scene.control.TextField nombreJugador2;
    public AnchorPane panelSuperior;
    public Button iniciarJuego;
    MediaPlayer mediaPlayer;
    ImageView cargando=new ImageView("file:src/vista/imagenes/loading.gif");

    ScreensController myController;



    @Override
    public void initialize(URL url, ResourceBundle rb) {


        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        panelSuperior.setPrefSize(screenBounds.getWidth(), screenBounds.getHeight());
        nombreJugador1.setText("Jugador1");
        nombreJugador2.setText("Jugador2");
    }

    public void setScreenParent(ScreensController screenParent) {
        myController = screenParent;
    }

    @Override
    public void setNombreJugadores(String nj1, String nj2) {

    }

    @FXML
    public void iniciarJuego(){
        cargando.setPreserveRatio(true);
        cargando.setEffect(new DropShadow(20, Color.BLACK));
        cargando.setX(300.0);
        cargando.setY(300.0);
        panelSuperior.getChildren().add(cargando);
        Task task=new Task() {
            @Override
            protected Object call() throws Exception {
                myController.nombresDeJugadores(nombreJugador1.getText(), nombreJugador2.getText());
                mainApp.mainContainer.loadScreen(mainApp.screenTablero, mainApp.screenTablerolFile);
                mainApp.mainContainer.loadScreen(mainApp.screenSeleccionDeEquipos,mainApp.screenSeleccionDeEquiposFile);
                myController.setScreen(screenSeleccionDeEquipos);
                return null;
            }
        };
        (new Thread(task)).start();
    }

    @FXML
    public void salir(){
        primaryStage.close();
    }

}