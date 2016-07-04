package vista.controladores;

import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import modelo.juego.ProxyPartida;

import java.util.Hashtable;

public class ImagenTerrestre extends ImageView implements ContenidoCasillero{
    private static final double HEIGTH =573.0/8;
    private static final double WIDTH =1234.0/8;
    //prefHeight="573.0" prefWidth="1234.0"

    public ImagenTerrestre(Hashtable<String, String> imagenes, ProxyPartida partida) {
        String imagen;
        imagen = imagenes.get((partida.obtenerSuperficieTerrestre()).getClass().getSimpleName());
        setImage(new Image(imagen));
        setFitHeight(HEIGTH);
        setFitWidth(WIDTH);
        //setOpacity(1);
        setPickOnBounds(false);
        setMouseTransparent(true);
        setEffect(new DropShadow(10,5,5, Color.BLACK));

    }

    @Override
    public void notificarEntrada() {

    }

    @Override
    public void notificarSalida() {

    }
}