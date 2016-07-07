package vista.controladores;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import vista.ControlledScreen;
import vista.ScreensController;


import java.net.URL;
import java.util.ResourceBundle;

import static vista.mainApp.*;


public class ScreenIngresoDeNombresController implements Initializable, ControlledScreen {
    public javafx.scene.control.TextField nombreJugador1, nombreJugador2;
    public AnchorPane panelSuperior;


    ScreensController myController;



    @Override
    public void initialize(URL url, ResourceBundle rb) {


        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        panelSuperior.setPrefSize(screenBounds.getWidth(), screenBounds.getHeight());
    }

    public void setScreenParent(ScreensController screenParent) {
        myController = screenParent;
    }

    @Override
    public void setNombreJugadores(String nj1, String nj2) {

    }

    @FXML
    public void iniciarJuego(){

        myController.setScreen(screenSeleccionDeEquipos,nombreJugador1.getText().toString(),nombreJugador2.getText().toString());

    }

    @FXML
    public void salir(){
        primaryStage.close();
    }

}