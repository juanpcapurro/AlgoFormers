package vista.controladores;

import algoFormers.juego.Partida;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import static vista.controladores.TableroVista.getImagenes;
import static vista.controladores.ScreenTableroController.partida;

public class SelectionController {
    static final ImageView mira=new ImageView("file:src/vista/imagenes/mira4.png");
    static final ImageView seleccion=new ImageView("file:src/vista/imagenes/mira3.png");
    static final List<Integer> initialCoordinates = new ArrayList<>();
    static final List<Integer> finalCoordinates = new ArrayList<>();
    static StackPane primeroSeleccionado=null;
    static StackPane ultimoSeleccionado=null;


    static void setCrosshairOn(StackPane pane){
        mira.setFitHeight(80);
        mira.setFitWidth(90);
        mira.setScaleX(1.3);
        mira.setScaleY(1);
        seleccion.setFitHeight(80);
        seleccion.setFitWidth(90);
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

    static void setCrosshairOff(StackPane pane) {
        pane.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                pane.getChildren().remove(mira);
                event.consume();
            }
        });
    }

    static void setHandlerCasilleroSeleccionado(Node node, Partida partida) {
        node.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                StackPane pane = (StackPane) event.getTarget();
                if (event.getButton()== MouseButton.PRIMARY)
                    procesarSelecciónPrimaria(pane);
            }
        });
    }


    static void procesarSelecciónPrimaria(StackPane pane){
        if (primeroSeleccionado==null) {
            primeroSeleccionado=pane;
            System.out.printf("%d %d ",GridPane.getRowIndex(primeroSeleccionado),GridPane.getColumnIndex(primeroSeleccionado));
        } else {
            ultimoSeleccionado=pane;
            System.out.printf("%d %d ",GridPane.getRowIndex(ultimoSeleccionado),GridPane.getColumnIndex(ultimoSeleccionado));
            partida.mover(GridPane.getRowIndex(primeroSeleccionado),GridPane.getColumnIndex(primeroSeleccionado)
                    ,GridPane.getRowIndex(ultimoSeleccionado),GridPane.getColumnIndex(ultimoSeleccionado));
            partida.resetIterador();
            actualizarCasillero();
            primeroSeleccionado=null;
        }
    }


    static void actualizarCasillero(){
        partida.setIterador(GridPane.getRowIndex(primeroSeleccionado),GridPane.getColumnIndex(primeroSeleccionado));
        restartPane(primeroSeleccionado);
        partida.setIterador(GridPane.getRowIndex(ultimoSeleccionado),GridPane.getColumnIndex(ultimoSeleccionado));
        restartPane(ultimoSeleccionado);
    }

    static void restartPane(StackPane pane){
        pane.getChildren().clear();
        ImageView imagenAerea;
        ImageView objeto;
        Hashtable<String, String> imagenes = getImagenes();
        ImageView imagenTerrestre;
        imagenTerrestre = new ImagenTerrestre(imagenes, partida);
        imagenAerea = new ImagenAerea(imagenes, partida);
        pane.setAlignment(imagenAerea, Pos.TOP_LEFT);
        objeto = new ImagenObjeto(imagenes, partida);
        pane.getChildren().addAll(imagenTerrestre, imagenAerea, objeto);
    }
}
