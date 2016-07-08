package vista.controladores;

import java.awt.*;
import java.awt.TextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import vista.ControlledScreen;
import vista.ScreensController;
import vista.mainApp;

import static vista.mainApp.*;


public class ScreenInicialController implements Initializable, ControlledScreen {
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
    public void pasarAIngresoDeNombres(){
        myController.setScreen(screenIngresoDeNombres);

    }
    @FXML
    public void salir(){
        primaryStage.close();
    }

}