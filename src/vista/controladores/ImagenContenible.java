package vista.controladores;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImagenContenible extends ImageView implements ContenidoCasillero {
    ImagenContenible(Image imagen){
        setImage(imagen);
        setMouseTransparent(true);
    }

    @Override
    public void notificarEntrada() {

    }

    @Override
    public void notificarSalida() {

    }
}
