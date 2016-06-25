package vista.controladores;

import modelo.juego.Partida;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.util.Hashtable;

public class ImagenObjeto extends ImageView {
    private static final int HEIGTH =80 ;
    private static final int WIDTH = 97;

    public  ImagenObjeto(Hashtable<String, String> imagenes, Partida partida) {
        String imagen;
        imagen = imagenes.get((partida.obtenerColocable()).getClass().toString());
        setImage(new Image(imagen));
        setFitHeight(HEIGTH-20);
        setFitWidth(WIDTH-20);
        setOpacity(1);
        setPickOnBounds(false);
        setMouseTransparent(false);
        setHigherEffect();
        setLowerEffect();
    }

    void setHigherEffect(){
        ImageView imagen=this;
        this.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                imagen.setScaleY(1.5);
                imagen.setScaleX(1.5);
                event.consume();
            }
        });
    }

    void setLowerEffect() {
        ImageView imagen = this;
        this.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                imagen.setScaleY(1);
                imagen.setScaleX(1);
                event.consume();
            }
        });
    }
}
