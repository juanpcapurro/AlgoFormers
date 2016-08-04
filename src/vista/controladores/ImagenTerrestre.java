package vista.controladores;

import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import modelo.juego.AdaptadorPartida;

import java.util.Hashtable;

public class ImagenTerrestre extends ImageView implements ContenidoCasillero{
    private static final double HEIGTH =ScreenTableroController.TABLERO_HEIGTH/ScreenTableroController.DIMENSION;
    private static final double WIDTH =ScreenTableroController.TABLERO_WIDTH/ScreenTableroController.DIMENSION;

    public ImagenTerrestre(Hashtable<String, String> imagenes, AdaptadorPartida partida) {
        String imagen;
        imagen = imagenes.get((partida.obtenerSuperficieTerrestre()).getClass().getSimpleName());
        setImage(new Image(imagen));
        setFitHeight(HEIGTH);
        setFitWidth(WIDTH);
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