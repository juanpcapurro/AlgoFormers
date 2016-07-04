package vista.controladores;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImagenContenible extends ImageView implements ContenidoCasillero {
    private static final int HEIGTH = 120;
    private static final int WIDTH = 120;
    ImagenContenible(Image imagen){
        setImage(imagen);
        setMouseTransparent(true);
        setFitHeight(HEIGTH);
        setFitWidth(WIDTH);
    }

    @Override
    public void notificarEntrada() {

    }

    @Override
    public void notificarSalida() {

    }
}
