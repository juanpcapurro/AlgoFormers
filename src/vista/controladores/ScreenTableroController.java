package vista.controladores;

import algoFormers.juego.Partida;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import vista.ControlledScreen;
import vista.ScreensController;
import vista.mainApp;

import java.net.URL;
import java.util.Hashtable;
import java.util.ResourceBundle;

import static vista.controladores.SelectionController.*;
import static vista.mainApp.primaryStage;
import static vista.mainApp.screenTablero;

public class ScreenTableroController implements Initializable, ControlledScreen {

    @FXML
    public GridPane tableroGrid;
    @FXML
    public Label nombreJugadorTurno;
    ScreensController myController;
    static Partida partida=new Partida(mainApp.nombreJ1,mainApp.nombreJ2,8);


    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        nombreJugadorTurno.setText(mainApp.partida.getNombreJugadorQueDebeJugar());
        imprimir();
    }

    public void setScreenParent(ScreensController screenParent) {
        myController = screenParent;
    }

   public void imprimir(){

        Hashtable<String,String> imagenes=TableroVista.getImagenes();
        tableroGrid.getChildren().clear();
        tableroGrid.setGridLinesVisible(true);
        tableroGrid.setPadding(new Insets(0,0,0,0));
        for (int j=0;j<8;j++) {
            for (int i = 0; i < 8; i++) {
                ImageView imagenAerea = new ImagenAerea(imagenes, partida);
                ImageView imagenTerrestre = new ImagenTerrestre(imagenes, partida);
                ImageView imageObjeto = new ImagenObjeto(imagenes, partida);
                StackPane pane = new StackPane();
                pane.setAlignment(imagenAerea, Pos.TOP_LEFT);
                pane.getChildren().addAll(imagenTerrestre, imagenAerea, imageObjeto);
                GridPane.setConstraints(pane,j,i);
                tableroGrid.getChildren().add(pane);
                setCrosshairOn(pane);
                setCrosshairOff(pane);
                setHandlerCasilleroSeleccionado(pane,partida);
                partida.avanzarIterador();
            }
        }
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