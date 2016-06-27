package vista.controladores;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImagenSeleccion extends ImageView implements ContenidoCasillero {

    ImagenSeleccion(){
        setImage(new Image("file:src/vista/imagenes/mira3.png"));
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
