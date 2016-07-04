package vista.controladores;

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
    StackPane primeroSeleccionado=null;
    StackPane ultimoSeleccionado=null;
    ImageView imagenBarraSuperior;
    Label superior;
    Label inferiorPrimero;
    Label inferiorCentro;
    Label inferiorUltimo;
    Label nombreActual;
    ProgressBar barraDeVida;
    SelectionController(ImageView imagenSuperior, Label supLabel, Label infLabelFirst,
                        Label infLabelSecond, Label infLabelThird, Label nombre, ProgressBar barraVida){
        imagenBarraSuperior=imagenSuperior;
        superior=supLabel;
        inferiorPrimero =infLabelFirst;
        nombreActual=nombre;
        inferiorCentro=infLabelSecond;
        inferiorUltimo=infLabelThird;
        barraDeVida=barraVida;
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
        if (primeroSeleccionado==null)
            primeroSeleccionado=pane;
        else {
            ultimoSeleccionado=pane;
            partida.mover(GridPane.getRowIndex(primeroSeleccionado),GridPane.getColumnIndex(primeroSeleccionado)
                    ,GridPane.getRowIndex(ultimoSeleccionado),GridPane.getColumnIndex(ultimoSeleccionado));
            actualizarCasillero();
            primeroSeleccionado=null;
        }
        partida.setIterador(GridPane.getRowIndex(pane),GridPane.getColumnIndex(pane));
        actualizarBarra();
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

    void actualizarBarra(){
        imagenBarraSuperior.setImage(new ImagenObjeto(getImagenes(),partida).getImage());
        superior.setText(partida.getDatos().getVidaActual());
        inferiorPrimero.setText(partida.getDatos().getAtaque());
        inferiorCentro.setText(partida.getDatos().getAlcance());
        inferiorUltimo.setText(partida.getDatos().getVelocidad());
        nombreActual.setText(partida.getDatosJugadorActual().nombreJugador);
        barraDeVida.setProgress(Float.valueOf(partida.getDatos().getVidaActual())/Float.valueOf(partida.getDatos().getVidaOriginal()));
    }

    void actualizarCasillero(){
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
