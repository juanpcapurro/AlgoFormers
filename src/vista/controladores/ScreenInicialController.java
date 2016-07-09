package vista.controladores;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
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
    
    @FXML
    public void ayuda() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(mainApp.class.getResource("screenAyuda.fxml"));
        AnchorPane page = loader.load();

        // CREO EL DIALOG STAGE
        dialogStage = new Stage();
        dialogStage.setTitle("AYUDA");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(mainApp.primaryStage);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);
        
    	String musicFile = "src/vista/imagenes/help.mp3";
    	Media sonido = new Media(new File(musicFile).toURI().toString());
    	MediaPlayer mediaPlayer = new MediaPlayer(sonido);
    	mediaPlayer.play();


        dialogStage.showAndWait();




    }

}