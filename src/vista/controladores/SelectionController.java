package vista.controladores;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.util.Hashtable;

import static vista.controladores.ScreenTableroController.partida;
import static vista.controladores.TableroVista.getImagenes;

public class SelectionController {
    final ImagenMira mira=new ImagenMira();
    final ImagenSeleccion seleccion= new ImagenSeleccion();
    static StackPane primeroSeleccionado=null;
    static StackPane ultimoSeleccionado=null;
    static ImageView imagenBarraSuperior;
    static Label superior;
    static Label inferiorPrimero;
    static Label inferiorCentro;
    static Label inferiorUltimo;
    static Label nombreActual;
    static ProgressBar barraDeVida;
    static GridPane tablero;

    SelectionController(ImageView imagenSuperior, Label supLabel, Label infLabelFirst,
                        Label infLabelSecond, Label infLabelThird, Label nombre, ProgressBar barraVida,GridPane grid){
        imagenBarraSuperior=imagenSuperior;
        superior=supLabel;
        inferiorPrimero =infLabelFirst;
        nombreActual=nombre;
        inferiorCentro=infLabelSecond;
        inferiorUltimo=infLabelThird;
        barraDeVida=barraVida;
        tablero=grid;
    }
    void setUp(StackPane pane){
        setCrosshairOn(pane);
        setCrosshairOff(pane);
        setHandlerCasilleroSeleccionado(pane);
    }
    void setCrosshairOn(StackPane pane){

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

    void setCrosshairOff(StackPane pane) {
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

    void setHandlerCasilleroSeleccionado(Node node) {
        node.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                StackPane pane = (StackPane) event.getTarget();
                if (event.getButton()== MouseButton.PRIMARY)
                    procesarSeleccionPrimaria(pane);
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


    void procesarSeleccionPrimaria(StackPane pane){
        if (primeroSeleccionado==null) {
            primeroSeleccionado = pane;
            partida.setIterador(GridPane.getRowIndex(primeroSeleccionado), GridPane.getColumnIndex(primeroSeleccionado));
            actualizarBarra();
        }
        else {
            ultimoSeleccionado=pane;
            Task task=new Task() {
                @Override
                protected Object call() throws Exception {
                    partida.mover(GridPane.getRowIndex(primeroSeleccionado),GridPane.getColumnIndex(primeroSeleccionado)
                            ,GridPane.getRowIndex(ultimoSeleccionado),GridPane.getColumnIndex(ultimoSeleccionado));
                    primeroSeleccionado=null;
                    return null;
                }
            };
            Thread thread=new Thread(task);
            thread.start();
        }
    }

    void procesarSeleccionSecundaria(StackPane pane) throws IOException {
        if (primeroSeleccionado==null)
            return;
        partida.atacar(GridPane.getRowIndex(primeroSeleccionado),GridPane.getColumnIndex(primeroSeleccionado),
                 GridPane.getRowIndex(ultimoSeleccionado),GridPane.getColumnIndex(ultimoSeleccionado));
        actualizarCasillero();
        partida.setIterador(GridPane.getRowIndex(ultimoSeleccionado),GridPane.getColumnIndex(ultimoSeleccionado));
        actualizarBarra();
        if (Integer.valueOf(partida.getDatos().getVidaActual())<=0)
            ultimoSeleccionado.getChildren().add(new ExplosionDestruccion(ultimoSeleccionado).getView());
        else
            ultimoSeleccionado.getChildren().add(new Explosion(ultimoSeleccionado).getView());
        primeroSeleccionado=null;
}

    static void actualizarBarra() {
        if (Integer.valueOf(partida.getDatos().getVidaOriginal()) != 0) {
            imagenBarraSuperior.setImage(new ImagenObjeto(getImagenes(), partida).getImage());
            superior.setText(partida.getDatos().getVidaActual());
            inferiorPrimero.setText(partida.getDatos().getAtaque());
            inferiorCentro.setText(partida.getDatos().getAlcance());
            inferiorUltimo.setText(partida.getDatos().getVelocidad());
            nombreActual.setText(partida.getDatosJugadorActual().nombreJugador);
            barraDeVida.setProgress(Float.valueOf(partida.getDatos().getVidaActual()) / Float.valueOf(partida.getDatos().getVidaOriginal()));
        }
    }
    void actualizarCasillero(){
        partida.setIterador(GridPane.getRowIndex(primeroSeleccionado),GridPane.getColumnIndex(primeroSeleccionado));
        restartPane(primeroSeleccionado);
        partida.setIterador(GridPane.getRowIndex(ultimoSeleccionado),GridPane.getColumnIndex(ultimoSeleccionado));
        restartPane(ultimoSeleccionado);
    }

    public static void actualizarCasillero(int x, int y){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                StackPane paneAux = null;
                for (Node nodo : tablero.getChildren()) {
                    if (GridPane.getColumnIndex(nodo) ==y && GridPane.getRowIndex(nodo) ==x) {
                        paneAux = (StackPane) nodo;
                        break;
                    }
                }
                restartPane(paneAux);
                partida.setIterador(x,y);
                actualizarBarra();
            }
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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

     public void setTransformation(Button boton){
        boton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (primeroSeleccionado!=null) {
                    partida.transformar(GridPane.getRowIndex(primeroSeleccionado), GridPane.getColumnIndex(primeroSeleccionado));
                    restartPane(primeroSeleccionado);
                }
                primeroSeleccionado=null;
                actualizarBarra();
            }
        });

    }
    public void setFinalizarTurno(Button finalizarTurno){
        finalizarTurno.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                partida.saltearTurno();
                actualizarBarra();
            }
        });
    }

    static void setResizeEffectOnButton(Button boton){
        boton.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                boton.setScaleX(1.3);
                boton.setScaleY(1.3);
                boton.setEffect(new DropShadow(50, Color.BLACK));
            }
        });
        boton.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                boton.setScaleX(1);
                boton.setScaleY(1);
                boton.setEffect(new DropShadow(0,Color.BLACK));
            }
        });
    }


}
