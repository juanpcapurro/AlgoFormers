package Aplicacion;

import javafx.application.Application;
import javafx.stage.Stage;
import vista.mainApp;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setResizable(true);
        primaryStage.setMaximized(true);
        primaryStage.setFullScreen(true);
        mainApp mainApp = new mainApp();
        mainApp.start(primaryStage);

    }



    public static void main(String[] args) {
        launch(args);
    }
}
