package vista;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import modelo.juego.JuegoFinalizado;
import modelo.juego.ProxyPartida;

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
        try {
            primaryStage.show();
        }catch (JuegoFinalizado e){
            System.out.println("JuegoFinalizado");
        }

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

    public static double getWidth() {
        return width;
    }

    public static double getHeight() {
        return height;
    }

}
