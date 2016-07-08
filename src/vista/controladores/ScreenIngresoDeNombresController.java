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

import static vista.mainApp.primaryStage;
import static vista.mainApp.screenSeleccionDeEquipos;


public class ScreenIngresoDeNombresController implements Initializable, ControlledScreen {
    public javafx.scene.control.TextField nombreJugador1;
    public javafx.scene.control.TextField nombreJugador2;
    public AnchorPane panelSuperior;


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
        myController.nombresDeJugadores(nombreJugador1.getText(), nombreJugador2.getText());
        mainApp.mainContainer.loadScreen(mainApp.screenTablero, mainApp.screenTablerolFile);
        mainApp.mainContainer.loadScreen(mainApp.screenSeleccionDeEquipos,mainApp.screenSeleccionDeEquiposFile);
        myController.setScreen(screenSeleccionDeEquipos);


    }

    @FXML
    public void salir(){
        primaryStage.close();
    }

}