package vista.controladores;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import vista.ControlledScreen;
import vista.ScreensController;
import vista.mainApp;

import static vista.mainApp.*;


public class ScreenInicialController implements Initializable, ControlledScreen {

    ScreensController myController;
    @FXML
    TextField nombreJugador1;
    @FXML
    TextField nombreJugador2;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nombreJugador1 = new TextField();
        nombreJugador2 = new TextField();
    }

    public void setScreenParent(ScreensController screenParent) {
        myController = screenParent;
    }

    @FXML
    public void iniciarJuego(){
//        iniciarPartida(nombreJugador1.getText(),nombreJugador2.getText());
        myController.setScreen(screenSeleccionDeEquipos);
    }
    @FXML
    public void pasarAIngresoDeNombres(){
        myController.setScreen(screenIngresoDeNombres);
    }
    @FXML
    public void salir(){
        primaryStage.close();
    }

}