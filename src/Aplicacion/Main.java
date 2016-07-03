package Aplicacion;

import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.stage.Stage;
import vista.mainApp;

import java.io.File;
import java.io.IOException;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        String musicFile = "src/vista/imagenes/algoformersMusic.mp3";
    	Media sonido = new Media(new File(musicFile).toURI().toString());
//    	MediaPlayer mediaPlayer = new MediaPlayer(sonido);
//    	mediaPlayer.play();
    	
    	primaryStage.setResizable(true);
        mainApp mainApp = new mainApp();
        mainApp.start(primaryStage);

    }



    public static void main(String[] args) {
        launch(args);
    }
}
