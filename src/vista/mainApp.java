package vista;

import algoFormers.juego.Partida;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class mainApp extends Application {

    public static Stage primaryStage;
    public static String nombreJ1;
    public static String nombreJ2;
    private ScreensController mainContainer;
    private static String screenInicial = "screenInicial";
    private static String screenInicialFile = "screenInicial.fxml";
    public static String screenIngresoDeNombres = "screenIngresoDeNombres";
    public static String screenIngresoDeNombresFile = "screenIngresoDeNombres.fxml";
    public static String screenSeleccionDeEquipos;
    private static String screenSeleccionDeEquiposFile = "screenSeleccionDeEquipos.fxml";
    public static String screenTablero = "screenTablero";
    private static String screenTablerolFile = "screenTablero.fxml";

    public static Partida partida;

    public static String getNombreJugador1() {
        return partida.getNombreJugador1();
    }

    public static String getNombreJugador2() {
        return partida.getNombreJugador2();
    }


    @Override
    public void start(Stage primaryStage) {

        this.primaryStage = primaryStage;

        mainContainer = new ScreensController(this);

        this.cargarScreensEnElContenedor();

        mainContainer.setScreen(mainApp.screenInicial);

        Group root = new Group();
        root.resize(primaryStage.getMaxWidth(),primaryStage.getMaxHeight());
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root);


        primaryStage.setScene(scene);
        primaryStage.setTitle("   CHARLY   ");
        primaryStage.show();



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
        partida = new Partida(nombreJ1,nombreJ2,8);

    }

}
