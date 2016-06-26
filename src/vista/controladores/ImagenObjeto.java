package vista.controladores;

import algoFormers.juego.Partida;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.ImageCursor;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.util.Hashtable;

public class ImagenObjeto extends ImageView {
    private static final int HEIGTH =80 ;
    private static final int WIDTH = 90;
    ImageCursor cursor=new ImageCursor(new Image("file:src/vista/imagenes/cursorMira.png"));

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
        setEffect(new DropShadow(10,5,5, Color.BLACK));

    }

    void setHigherEffect(){
        ImageView imagen=this;
        this.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(event.getX()>=20 || event.getX()<=50 || event.getY()>=20 || event.getY()<=50) {
                    imagen.setScaleY(1.2);
                    imagen.setScaleX(1.2);
                    setCursor(cursor);
                }
                event.consume();
            }
        });
    }

    void setLowerEffect() {
        ImageView imagen = this;
        this.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(event.getX()<=20 || event.getX()>=50 || event.getY()<=20 || event.getY()>=50) {
                    imagen.setScaleY(1);
                    imagen.setScaleX(1);
                    setCursor(Cursor.DEFAULT);
                }
                event.consume();
            }
        });
    }
}
