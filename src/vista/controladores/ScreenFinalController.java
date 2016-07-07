package vista.controladores;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import vista.ControlledScreen;
import vista.ScreensController;
import vista.mainApp;

import java.net.URL;
import java.util.ResourceBundle;

import static vista.mainApp.*;


public class ScreenFinalController implements Initializable, ControlledScreen {
    public javafx.scene.control.TextField nombreJugadorGanador;

    public AnchorPane panelSuperior;


    ScreensController myController;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        panelSuperior.setPrefSize(screenBounds.getWidth(), screenBounds.getHeight());

        nombreJugadorGanador.setText("HA GANADO EL JUGADOR: " + "pasar nombre del jugador");

//        nombreJugadorGanador.setText("HA GANADO EL JUGADOR: " + mainApp.winner);
    }

    public void setScreenParent(ScreensController screenParent) {
        myController = screenParent;
    }

    @Override
    public void setNombreJugadores(String nj1, String nj2) {

    }

    @FXML
    public void reiniciarJuego(){
        mainApp mainApp = new mainApp();
        mainApp.start(primaryStage);
    }


    @FXML
    public void salir(){
        primaryStage.close();
    }

}