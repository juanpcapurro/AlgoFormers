package vista.controladores;

import modelo.juego.ProxyPartida;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
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
    final ImageView mira=new ImageView("file:src/vista/imagenes/mira4.png");
    final ImageView seleccion=new ImageView("file:src/vista/imagenes/mira3.png");

    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        nombreJugadorTurno.setText(mainApp.partida.getNombreJugadorQueDebeJugar());
        imprimir();
    }

    public void setScreenParent(ScreensController screenParent) {
        myController = screenParent;
    }

    public void imprimir(){
        ProxyPartida partida=new ProxyPartida(mainApp.nombreJ1,mainApp.nombreJ2,8);
        Hashtable<String,String> imagenes=TableroVista.getImagenes();
        tableroGrid.getChildren().clear();
        tableroGrid.setGridLinesVisible(true);
        tableroGrid.setPadding(new Insets(10,10,10,10));
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
                setCrosshairOff(pane);
                partida.avanzarIterador();

            }
        }
      //  myController.setScreen(screenTablero);
    }

    void setCrosshairOn(StackPane pane){
        mira.setFitHeight(70);
        mira.setFitWidth(70);
        mira.setScaleX(1.3);
        mira.setScaleY(1);
        seleccion.setFitHeight(70);
        seleccion.setFitWidth(70);
        seleccion.setScaleX(1.3);
        seleccion.setScaleY(1);
        pane.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(!pane.getChildren().contains(mira))
                    pane.getChildren().add(mira);
                event.consume();
            }
        });
        pane.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(!pane.getChildren().contains(seleccion))
                    pane.getChildren().add(seleccion);
            }
        });
    }

     void setCrosshairOff(StackPane pane) {
         pane.setOnMouseExited(new EventHandler<MouseEvent>() {
             @Override
             public void handle(MouseEvent event) {
                 pane.getChildren().remove(mira);
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