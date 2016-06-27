package vista.controladores;

import modelo.juego.ProxyPartida;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Hashtable;

public class ImagenTerrestre extends ImageView {
    private static final double HEIGTH =75 ;
    private static final double WIDTH =96;

    public ImagenTerrestre(Hashtable<String, String> imagenes, ProxyPartida partida) {
        String imagen;
        imagen = imagenes.get((partida.obtenerSuperficieTerrestre()).getClass().toString());
        setImage(new Image(imagen));
        setFitHeight(HEIGTH);
        setFitWidth(WIDTH);
        setOpacity(1);
        setPickOnBounds(false);
        setMouseTransparent(true);
    }
}
