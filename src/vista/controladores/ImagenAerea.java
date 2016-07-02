package vista.controladores;

import modelo.juego.ProxyPartida;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Hashtable;

public class ImagenAerea extends ImageView {
    private static final double HEIGTH =50;
    private static final double WIDTH =97;

    ImagenAerea(Hashtable<String, String> imagenes, ProxyPartida partida) {
        String imagen;
        imagen = imagenes.get((partida.obtenerSuperficieAerea()).getClass().toString());
        setImage(new Image(imagen));
        setFitHeight(HEIGTH);
        setFitWidth(WIDTH);
        setOpacity(0.8);
        setPickOnBounds(false);
        setMouseTransparent(true);
    }
}
