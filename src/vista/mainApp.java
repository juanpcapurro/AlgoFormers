package vista;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.application.Application;

public class mainApp extends Application {

    public static Stage primaryStage;
    private ScreensController mainContainer;
    private static String screenInicial = "screenInicial";
    private static String screenInicialFile = "screenInicial.fxml";
    public static String screenIngresoDeNombres = "screenIngresoDeNombres";
    public static String screenIngresoDeNombresFile = "screenIngresoDeNombres.fxml";
    public static String screenSeleccionDeEquipos;
    private static String screenSeleccionDeEquiposFile = "screenSeleccionDeEquipos.fxml";

    @Override
    public void start(Stage primaryStage) {

        this.primaryStage = primaryStage;

        mainContainer = new ScreensController();

        this.cargarScreensEnElContenedor();

        mainContainer.setScreen(mainApp.screenInicial);

        Group root = new Group();
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.setTitle("ALGOFORMERS");
        primaryStage.show();


    }

    public void cargarScreensEnElContenedor(){
        mainContainer.loadScreen(mainApp.screenInicial, mainApp.screenInicialFile);
        mainContainer.loadScreen(mainApp.screenIngresoDeNombres, mainApp.screenIngresoDeNombresFile);
        mainContainer.loadScreen(mainApp.screenSeleccionDeEquipos, mainApp.screenSeleccionDeEquiposFile);

    }


    public static void main(String[] args) {
        launch(args);
    }

    public static void setearNombreJugador1(String nombre) {
    }

    public static void setearNombreJugado2(String nombre) {
    }
}
