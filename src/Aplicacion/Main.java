package Aplicacion;

import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import vista.mainApp;

import java.io.File;
import java.io.IOException;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        
        mainApp mainApp = new mainApp();
        mainApp.start(primaryStage);


    }



    public static void main(String[] args) {
        launch(args);
    }
}
