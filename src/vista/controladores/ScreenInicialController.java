package vista.controladores;

import java.awt.*;
import java.awt.TextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import vista.ControlledScreen;
import vista.ScreensController;
import vista.mainApp;

import static vista.mainApp.*;


public class ScreenInicialController implements Initializable, ControlledScreen {
    public javafx.scene.control.TextField nombreJugador1;
    public javafx.scene.control.TextField nombreJugador2;

    ScreensController myController;


    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void setScreenParent(ScreensController screenParent) {
        myController = screenParent;
    }

    @FXML
    public void iniciarJuego(){
        mainApp.nombreJ1 = nombreJugador1.getText();
        mainApp.nombreJ2 = nombreJugador2.getText();
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