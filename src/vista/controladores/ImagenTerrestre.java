package vista.controladores;

import algoFormers.juego.Partida;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Hashtable;

public class ImagenTerrestre extends ImageView {
    private static final double HEIGTH =73 ;
    private static final double WIDTH =97;

    public ImagenTerrestre(Hashtable<String, String> imagenes, Partida partida) {
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
