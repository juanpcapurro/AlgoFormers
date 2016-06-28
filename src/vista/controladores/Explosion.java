package vista.controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class Explosion extends AnimatedGif{
    StackPane myPane;

    Explosion(StackPane pane) throws IOException {
        super( "file:src/vista/imagenes/explosion.gif",1000);
        myPane=pane;
        setRemoveEffect();
        play();
    }

    private void setRemoveEffect() {
        Explosion explosion=this;
        setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                myPane.getChildren().remove(myPane.getChildren().size()-1);
            }
        });
    }


}
