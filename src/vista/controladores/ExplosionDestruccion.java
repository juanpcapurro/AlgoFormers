package vista.controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class ExplosionDestruccion extends AnimatedGif{
        StackPane myPane;

        ExplosionDestruccion(StackPane pane) throws IOException {
            super( "file:src/vista/imagenes/explosion3.gif",5000);
            myPane=pane;
            setRemoveEffect();
            play();
        }

        private void setRemoveEffect() {
            ExplosionDestruccion explosion=this;
            setOnFinished(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    myPane.getChildren().remove(myPane.getChildren().size()-1);
                }
            });
        }


    }

