package vista.controladores;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import modelo.juego.ProxyPartida;

import java.io.IOException;
import java.util.Hashtable;

import static vista.controladores.ScreenTableroController.partida;
import static vista.controladores.TableroVista.getImagenes;

public class SelectionController {
    static final ImagenMira mira=new ImagenMira();
    static final ImagenSeleccion seleccion= new ImagenSeleccion();
    static StackPane primeroSeleccionado=null;
    static StackPane ultimoSeleccionado=null;


    static void setCrosshairOn(StackPane pane){

        pane.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(!pane.getChildren().contains(mira))
                    pane.getChildren().add(pane.getChildren().size()-2, mira);
                for (Node nodo : pane.getChildren())
                    ((ContenidoCasillero)nodo).notificarEntrada();
                event.consume();
            }
        });
        pane.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                if(!pane.getChildren().contains(seleccion))
                    pane.getChildren().add(seleccion);
                event.consume();
            }
        });
    }

    static void setCrosshairOff(StackPane pane) {
        pane.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                pane.getChildren().remove(mira);
                for (Node nodo : pane.getChildren())
                    ((ContenidoCasillero)nodo).notificarSalida();
                event.consume();
            }
        });
    }

    static void setHandlerCasilleroSeleccionado(Node node, ProxyPartida partida) {
        node.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                StackPane pane = (StackPane) event.getTarget();
                if (event.getButton()== MouseButton.PRIMARY)
                    procesarSelecciónPrimaria(pane);
                else {
                    try {
                        ultimoSeleccionado=pane;
                        procesarSeleccionSecundaria(pane);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }


    static void procesarSelecciónPrimaria(StackPane pane){
        if (primeroSeleccionado==null) {
            primeroSeleccionado=pane;
        } else {
            ultimoSeleccionado=pane;
            partida.mover(GridPane.getRowIndex(primeroSeleccionado),GridPane.getColumnIndex(primeroSeleccionado)
                    ,GridPane.getRowIndex(ultimoSeleccionado),GridPane.getColumnIndex(ultimoSeleccionado));
            partida.resetIterador();
            actualizarCasillero();
            primeroSeleccionado=null;
        }
    }

static void procesarSeleccionSecundaria(StackPane pane) throws IOException {
    if (primeroSeleccionado==null)
        return;
    System.out.println("AUCH! me disparaste");
   // partida.atacar(Gridpane.getRoxIndex(primeroSeleccionado),Gridpane.getColumnIndex(primeroSeleccionado),
  ///               Gridpane.getRoxIndex(ultimoSeleccionado),Gridpane.getColumnIndex(ultimoSeleccionado));

  //  if (partida.GetStatus(Gridpane.getRoxIndex(ultimoSeleccionado,Gridpane.getColumnIndex(ultimoSeleccionado)).getVida().toIntenger<1))
        actualizarCasillero();

    ultimoSeleccionado.getChildren().add(new Explosion(ultimoSeleccionado).getView());
    primeroSeleccionado=null;
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
        partida.setIterador(GridPane.getRowIndex(pane),GridPane.getColumnIndex(pane));
        imagenTerrestre = new ImagenTerrestre(imagenes, partida);
        imagenAerea = new ImagenAerea(imagenes, partida);
        pane.setAlignment(imagenAerea, Pos.TOP_LEFT);
        objeto = new ImagenObjeto(imagenes, partida);
        pane.getChildren().addAll(imagenTerrestre, imagenAerea, objeto);
    }

    static public void setTransformation(Button boton){
        boton.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                partida.transformar(GridPane.getRowIndex(primeroSeleccionado),GridPane.getColumnIndex(primeroSeleccionado));
                restartPane(primeroSeleccionado);
                primeroSeleccionado=null;
                System.out.println("pasa");
            }
        });

    }
}
