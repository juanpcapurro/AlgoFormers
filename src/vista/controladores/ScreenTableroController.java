package vista.controladores;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import vista.ControlledScreen;
import vista.ScreensController;

import java.net.URL;
import java.util.ResourceBundle;

import static vista.mainApp.primaryStage;
import static vista.mainApp.screenTablero;

public class ScreenTableroController implements Initializable, ControlledScreen {

    @FXML
    public GridPane tableroGrid;
    @FXML
    public Label nombreJugadorTurno;
    ScreensController myController;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        nombreJugadorTurno.setText(mainApp.partida.getNombreJugadorQueDebeJugar());
    }

    public void setScreenParent(ScreensController screenParent) {
        myController = screenParent;
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