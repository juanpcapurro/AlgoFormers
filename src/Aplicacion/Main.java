package Aplicacion;

import javafx.application.Application;
import javafx.stage.Stage;
import vista.mainApp;

import java.io.IOException;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setResizable(true);
        mainApp mainApp = new mainApp();
        mainApp.start(primaryStage);

    }



    public static void main(String[] args) {
        launch(args);
    }
}
