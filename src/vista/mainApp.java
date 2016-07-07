package vista;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import modelo.juego.ProxyPartida;
import vista.controladores.AlertasController;

import java.io.IOException;

public class mainApp extends Application {

    public static Stage primaryStage;
    public static String nombreJ1="jugador1";
    public static String nombreJ2="jugador2";
    private ScreensController mainContainer;
    public static String screenInicial = "screenInicial";
    private static String screenInicialFile = "screenInicial.fxml";
    public static String screenIngresoDeNombres = "screenIngresoDeNombres";
    public static String screenIngresoDeNombresFile = "screenIngresoDeNombres.fxml";
    public static String screenSeleccionDeEquipos = "screenSeleccionDeEquipos";
    private static String screenSeleccionDeEquiposFile = "screenSeleccionDeEquipos.fxml";
    public static String screenTablero = "screenTablero";
    private static String screenTablerolFile = "screenTablero.fxml";
    public static Stage dialogStage;
    public static ProxyPartida partida;
    private static double width, height;
//
//    public static String getNombreJugador2() {
//        return partida.getNombreJugador2();
//    }


    @Override
    public void start(Stage primaryStage) {

        this.primaryStage = primaryStage;

        mainContainer = new ScreensController(this);

        this.cargarScreensEnElContenedor();

        mainContainer.setScreen(mainApp.screenInicial);

        Group root = new Group();
        root.getChildren().addAll(mainContainer);


        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        Scene scene = new Scene(root, screenBounds.getWidth(), screenBounds.getHeight());

        primaryStage.setResizable(false);
        primaryStage.setFullScreen(true);
        primaryStage.setScene(scene);
        primaryStage.setTitle("ALGOFORMERS");
        primaryStage.show();

//        letterbox(scene, mainContainer.getChildren());

    }

    public void cargarScreensEnElContenedor(){
        mainContainer.loadScreen(mainApp.screenInicial, mainApp.screenInicialFile);
        mainContainer.loadScreen(mainApp.screenIngresoDeNombres, mainApp.screenIngresoDeNombresFile);
        mainContainer.loadScreen(mainApp.screenSeleccionDeEquipos, mainApp.screenSeleccionDeEquiposFile);
        mainContainer.loadScreen(mainApp.screenTablero, mainApp.screenTablerolFile);

    }


    public static void main(String[] args) {
        launch(args);
    }

    public static void iniciarPartida(String equipoJugador1, String equipoJugador2) {
        partida = new ProxyPartida(nombreJ1,nombreJ2,8);

    }




    public static void crearCartelAlerta(String mensaje) {
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


                    AlertasController controller = loader.getController();
                    controller.setDialogStage(dialogStage);
                    controller.setearMensaje(mensaje);

                    dialogStage.showAndWait();

                } catch (IOException e) {
                    e.printStackTrace();

                }
            }

    public static double getWidth() {
        return width;
    }

    public static double getHeight() {
        return height;
    }

}
