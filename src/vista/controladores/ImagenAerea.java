package vista.controladores;

import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import modelo.juego.AdaptadorPartida;

import java.util.Hashtable;

public class ImagenAerea extends ImageView implements ContenidoCasillero{
    private static final double HEIGTH =30;
    private static final double WIDTH =50;

    ImagenAerea(Hashtable<String, String> imagenes, AdaptadorPartida partida) {
        String imagen;
        imagen = imagenes.get((partida.obtenerSuperficieAerea()).getClass().getSimpleName());
        setImage(new Image(imagen));
        setFitHeight(HEIGTH);
        setFitWidth(WIDTH);
        setOpacity(0.8);
        setPickOnBounds(false);
        setMouseTransparent(true);
        setEffect(new DropShadow(10,5,5, Color.BLACK));

    }
    @Override
    public void notificarEntrada(){
        setScaleY(1.5);
        setScaleX(1.3);
    }

    @Override
    public void notificarSalida() {
        setScaleY(1);
        setScaleX(1);
    }
}
