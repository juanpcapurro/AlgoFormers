package vista.controladores;

import algoFormers.juego.Partida;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import vista.ControlledScreen;
import vista.ScreensController;
import vista.mainApp;

import java.net.URL;
import java.util.Hashtable;
import java.util.ResourceBundle;

import static vista.mainApp.primaryStage;
import static vista.mainApp.screenTablero;

public class ScreenTableroController implements Initializable, ControlledScreen {

    @FXML
    public GridPane tableroGrid;
    @FXML
    public Label nombreJugadorTurno;
    ScreensController myController;
    final ImageView mira=new ImageView("file:src/vista/imagenes/mira.png");

    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        nombreJugadorTurno.setText(mainApp.partida.getNombreJugadorQueDebeJugar());
        imprimir();
    }

    public void setScreenParent(ScreensController screenParent) {
        myController = screenParent;
    }

    public void imprimir(){
        Partida partida=new Partida(mainApp.nombreJ1,mainApp.nombreJ2,8);
        Hashtable<String,String> imagenes=TableroVista.getImagenes();
        tableroGrid.getChildren().clear();
        tableroGrid.setGridLinesVisible(true);
        for (int j=0;j<8;j++) {
            for (int i = 0; i < 8; i++) {
                ImageView imagenAerea = new ImagenAerea(imagenes, partida);
                ImageView imagenTerrestre = new ImagenTerrestre(imagenes, partida);
                ImageView imageObjeto = new ImagenObjeto(imagenes, partida);
                StackPane pane = new StackPane();
                pane.getChildren().addAll(imagenTerrestre, imagenAerea, imageObjeto);
                GridPane.setConstraints(pane,i,j);
                tableroGrid.getChildren().add(pane);
                setCrosshairOn(pane);
                //setCrosshairOff(pane);
                partida.avanzarIterador();

            }
        }
      //  myController.setScreen(screenTablero);
    }

    void setCrosshairOn(StackPane pane){
        mira.setFitHeight(90);
        mira.setFitWidth(90);
        mira.setScaleX(1.4);
        mira.setScaleY(1.2);
        pane.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(!pane.getChildren().contains(mira))
                    pane.getChildren().add(mira);
                event.consume();
            }
        });
    }

     void setCrosshairOff(StackPane pane) {
         pane.setOnMouseExited(new EventHandler<MouseEvent>() {
             @Override
             public void handle(MouseEvent event) {
                 pane.getChildren().remove(pane.getChildren().size()-1);
                 event.consume();
             }
         });
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