package vista.controladores;


import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class TextoAyuda extends Label {
    TextoAyuda(){
        setText("HOLA, ACA Iria\n LA AYUDA \n jeje");
        setTextFill(Color.DARKRED);
        setFont(new Font("Verdana",50));
        setEffect(new DropShadow(15,Color.YELLOW));

        setLayoutX(100.0);
        setLayoutY(100.0);
    }
}
