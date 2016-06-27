package vista.controladores;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImagenMira extends ImageView implements ContenidoCasillero {

    ImagenMira(){
        setImage(new Image("file:src/vista/imagenes/mira4.png"));
        setFitHeight(80);
        setFitWidth(90);
        setScaleX(1.3);
        setScaleY(1);
        setMouseTransparent(true);
    }
    @Override
    public void notificarEntrada() {

    }

    @Override
    public void notificarSalida() {

    }
}
