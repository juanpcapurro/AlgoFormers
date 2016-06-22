package vista.controladores;

import algoFormers.juego.Partida;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
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

import static vista.mainApp.primaryStage;
import static vista.mainApp.screenTablero;

public class ScreenTableroController implements Initializable, ControlledScreen {

    @FXML
    public GridPane tableroGrid;
    @FXML
    public Label nombreJugadorTurno;
    ScreensController myController;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        nombreJugadorTurno.setText(mainApp.partida.getNombreJugadorQueDebeJugar());
        imprimir();
    }

    public void setScreenParent(ScreensController screenParent) {
        myController = screenParent;
    }

    public void imprimir(){
        int i=0;
        Partida partida=new Partida(mainApp.nombreJ1,mainApp.nombreJ2,8);
        Hashtable<String,String> imagenes=TableroVista.getImagenes();
        tableroGrid.setGridLinesVisible(false);
        for (Node node: tableroGrid.getChildren()){
            Button boton= (Button)node;
            ImageView imagenAerea=new ImagenAerea(imagenes,partida);
            ImageView imagenTerrestre= new ImagenTerrestre(imagenes,partida);
            ImageView imageObjeto=new ImagenObjeto(imagenes,partida);
            StackPane pane=new StackPane();
            pane.getChildren().addAll(imagenTerrestre,imagenAerea,imageObjeto);
            boton.setGraphic(pane);
            boton.autosize();
            partida.avanzarIterador();
            i++;
            if (i==64)
                break;
            }
      //  myController.setScreen(screenTablero);
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