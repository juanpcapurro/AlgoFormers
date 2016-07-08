package vista.controladores;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Screen;
import vista.ControlledScreen;
import vista.ScreensController;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import static vista.mainApp.primaryStage;
import static vista.mainApp.screenInicial;


public class ScreenFinalController implements Initializable, ControlledScreen {


    public AnchorPane panelSuperior;
    public Label cartelGanador;
    public static String winner="";

    ScreensController myController;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        panelSuperior.setPrefSize(screenBounds.getWidth(), screenBounds.getHeight());

       cartelGanador.setText("HA GANADO EL JUGADOR: " + winner);

    }

    static void setWinner(String theWinner){
        winner=theWinner;
    }

    public void setScreenParent(ScreensController screenParent) {
        myController = screenParent;
    }

    @Override
    public void setNombreJugadores(String nj1, String nj2) {

    }

    @FXML
    public void reiniciarJuego(){
        myController.setScreen(screenInicial);
    }


    @FXML
    public void salir(){
        primaryStage.close();
    }

}