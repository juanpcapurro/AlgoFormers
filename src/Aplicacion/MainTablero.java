package Aplicacion;

import algoFormers.juego.Partida;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import vista.controladores.TableroVista;

public class MainTablero extends  Application {

    @Override
    public void start(final Stage stage) {
        Group root= new Group();
        Scene scene=new Scene(root,800,500);
        stage.setMaximized(true);
        BorderPane borderPane=new BorderPane();
        VBox verticalBox=new VBox();
        Button boton=new BotonLateral(borderPane);
        verticalBox.setSpacing(10);
        verticalBox.setPadding(new Insets(300,15,15,15));
        verticalBox.getChildren().add(boton);
        stage.setTitle("Algoformer");
        borderPane.setPrefSize(500, 500);
        GridPane central=new TableroVista(new Partida("Charly","Barnie",8));
        borderPane.setCenter(central);
        borderPane.setLeft(verticalBox);
        root.getChildren().add(borderPane);
        stage.setScene(scene);
        stage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }

}
