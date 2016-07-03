package vista.controladores;

import javafx.scene.Cursor;
import javafx.scene.ImageCursor;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import modelo.juego.ProxyPartida;

import java.util.Hashtable;


public class ImagenObjeto extends ImageView implements ContenidoCasillero {
    private static final int HEIGTH = 70;
    private static final int WIDTH = 90;
    ImageCursor cursor = new ImageCursor(new Image("file:src/vista/imagenes/cursorMira.png"));

    public ImagenObjeto(Hashtable<String, String> imagenes, ProxyPartida partida) {
        String imagen;
        imagen = imagenes.get((partida.obtenerColocable()).getClass().getSimpleName()+" "+partida.getEstado().getClass().getSimpleName());
        setImage(new Image(imagen));
        setFitHeight(HEIGTH - 20);
        setFitWidth(WIDTH - 20);
        setOpacity(1);
        setPickOnBounds(false);
        setMouseTransparent(true);
        setHigherEffect();
        setLowerEffect();
        setEffect(new DropShadow(10, 5, 5, Color.BLACK));

    }

    void setHigherEffect() {
        setScaleY(1.2);
        setScaleX(1.2);
        setCursor(cursor);
    }

    void setLowerEffect() {
        setScaleY(1);
        setScaleX(1);
        setCursor(Cursor.DEFAULT);
    }

    @Override
    public void notificarEntrada() {
        setHigherEffect();
    }

    @Override
    public void notificarSalida() {
        setLowerEffect();
    }
}

