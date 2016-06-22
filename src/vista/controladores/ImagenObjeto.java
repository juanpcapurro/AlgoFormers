package vista.controladores;

import algoFormers.juego.Partida;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Hashtable;

public class ImagenObjeto extends ImageView {
    private static final int HEIGTH =80 ;
    private static final int WIDTH = 80;

    public  ImagenObjeto(Hashtable<String, String> imagenes, Partida partida) {
        String imagen;
        imagen = imagenes.get((partida.obtenerColocable()).getClass().toString());
        setImage(new Image(imagen));
        setFitHeight(HEIGTH-20);
        setFitWidth(WIDTH-20);
        setOpacity(0.5);
        setPickOnBounds(false);
        setMouseTransparent(true);
    }
}
