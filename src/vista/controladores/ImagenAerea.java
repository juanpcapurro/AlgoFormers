package vista.controladores;

import algoFormers.juego.Partida;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Hashtable;

public class ImagenAerea extends ImageView {
    private static final double WIDTH =70 ;
    private static final double HEIGTH =90;

    ImagenAerea(Hashtable<String, String> imagenes, Partida partida) {
        String imagen;
        imagen = imagenes.get((partida.obtenerSuperficieAerea()).getClass().toString());
        setImage(new Image(imagen));
        setFitHeight(HEIGTH);
        setFitWidth(WIDTH);
        setOpacity(0.5);
        setPickOnBounds(false);
        setMouseTransparent(true);
    }
}
