package vista;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import vista.controladores.AlertasController;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;


public class mainApp extends Application {

    public static Stage primaryStage;
    public static String nombreJ1="jugador1";
    public static String nombreJ2="jugador2";
    public static HashMap<String, ControlledScreen> controladores = new HashMap<>();
    public static ScreensController mainContainer;
    public static String screenInicial = "src/vista/screenInicial";
    public static String screenInicialFile = "src/vista/screenInicial.fxml";
    public static String screenIngresoDeNombres = "src/vista/screenIngresoDeNombres";
    public static String screenIngresoDeNombresFile = "src/vista/screenIngresoDeNombres.fxml";
    public static String screenSeleccionDeEquipos = "src/vista/screenSeleccionDeEquipos";
    public static String screenSeleccionDeEquiposFile = "src/vista/screenSeleccionDeEquipos.fxml";
    public static String screenTablero = "src/vista/screenTablero";
    public static String screenTablerolFile = "src/vista/screenTablero.fxml";
    public static String screenFinal = "src/vista/screenFinal";
    public static String screenFinallFile = "src/vista/screenGanador.fxml";
    public static Stage dialogStage;
    static public MediaPlayer mediaPlayer;

    @Override
    public void start(Stage primaryStage) {

        this.primaryStage = primaryStage;

        mainContainer = new ScreensController();

        this.cargarScreensEnElContenedor();

        mainContainer.setScreen(mainApp.screenInicial);

        Group root = new Group();
        root.getChildren().addAll(mainContainer);


        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        Scene scene = new Scene(root, screenBounds.getWidth(), screenBounds.getHeight());

        primaryStage.setResizable(false);
        primaryStage.setFullScreen(true);
        primaryStage.setMaximized(false);
        primaryStage.setScene(scene);
        primaryStage.setTitle("ALGOFORMERS");
        String musicFile = "src/vista/imagenes/fondo.mp3";
        Media sonido = new Media(new File(musicFile).toURI().toString());
 //       mediaPlayer = new MediaPlayer(sonido);
  //      mediaPlayer.play();
        primaryStage.show();



    }

    public void cargarScreensEnElContenedor(){
        mainContainer.loadScreen(mainApp.screenInicial, mainApp.screenInicialFile);
        mainContainer.loadScreen(mainApp.screenIngresoDeNombres, mainApp.screenIngresoDeNombresFile);

    }


    public static void main(String[] args) {
        launch(args);
    }






    public static void crearCartelAlerta(String mensaje) {
        Task task = new Task() {
            @Override
            protected Object call() throws Exception {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                            FXMLLoader loader = new FXMLLoader();
                            loader.setLocation(mainApp.class.getResource("screenCartelAlerta.fxml"));
                            AnchorPane page = loader.load();

                            // CREO EL DIALOG STAGE
                            dialogStage = new Stage();
                            dialogStage.setTitle("ALERTA");
                            dialogStage.initModality(Modality.WINDOW_MODAL);
                            dialogStage.initOwner(mainApp.primaryStage);
                            Scene scene = new Scene(page);
                            dialogStage.setScene(scene);
                        	String musicFile = "src/vista/imagenes/pato.mp3";
                        	Media sonido = new Media(new File(musicFile).toURI().toString());
                        	MediaPlayer mediaPlayer = new MediaPlayer(sonido);
                        	mediaPlayer.play();


                            AlertasController controller = loader.getController();
                            controller.setDialogStage(dialogStage);
                            controller.setearMensaje(mensaje);

                            dialogStage.showAndWait();

                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    });
            return null;
            }
        };
        Thread thread=new Thread(task);
        thread.start();
    }


}
