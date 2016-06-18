package vista.controladores;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import vista.ControlledScreen;
import vista.ScreensController;
import vista.mainApp;


public class ScreenInicialController implements Initializable, ControlledScreen {

    ScreensController myController;
    @FXML
    TextField nombreJugador1;
    @FXML
    TextField nombreJugador2;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void setScreenParent(ScreensController screenParent) {
        myController = screenParent;
    }

    @FXML
    public void iniciarJuego(){
        myController.setScreen(mainApp.screenSeleccionDeEquipos);
    }
    @FXML
    public void pasarAIngresoDeNombres(){
        myController.setScreen(mainApp.screenIngresoDeNombres);
    }
    @FXML
    public void salir(){
        mainApp.primaryStage.close();
    }
    @FXML
    public void ingresoNombreJugador1(){
       mainApp.setearNombreJugador1(nombreJugador1.getText());
    }
    @FXML
    public void ingresoNombreJugador2(){
        mainApp.setearNombreJugado2(nombreJugador2.getText());
    }
}