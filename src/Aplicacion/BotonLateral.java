package Aplicacion;


        import javafx.event.ActionEvent;
        import javafx.event.EventHandler;
        import javafx.scene.control.Button;
        import javafx.scene.image.ImageView;
        import javafx.scene.layout.BorderPane;

public class BotonLateral extends Button {
    public BotonLateral(BorderPane borderPane){
        setText("¡Combinar!");
        setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ImageView imagen = new ImageView("file:src/vista/imagenes/caballo.jpeg");
                imagen.setFitWidth(300);
                imagen.setFitHeight(300);
                borderPane.setCenter(imagen);
            }
        });
    }

}