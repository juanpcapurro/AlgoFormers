package vista.controladores;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import vista.ControlledScreen;
import vista.ScreensController;
import vista.mainApp;

import java.net.URL;
import java.util.ResourceBundle;

import static vista.mainApp.screenTablero;


public class ScreenSeleccionDeEquiposController implements Initializable, ControlledScreen {

    private String nombreJugador1, nombreJugador2;
    public AnchorPane panelSuperior;
    ScreensController myController;
    @FXML
    AnchorPane autobots,decepticons;
    @FXML
    MenuButton autobotJugador, decepticonJugador;

    @FXML
    public  javafx.scene.control.MenuItem jugador1Autobot, jugador2Autobot,jugador1Decepticon,jugador2Decepticon;

    private String autobot, decepticon,equipoJugador1, equipoJugador2;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.autobot = "optimus";
        this.decepticon = "megatron";

        setNombreJugadores();
        setearEtiquetas();

        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        panelSuperior.setPrefSize(screenBounds.getWidth(), screenBounds.getHeight());
    }

    public void setScreenParent(ScreensController screenParent) {
        myController = screenParent;
    }

    @Override
    public void setNombreJugadores(String nj1, String nj2) {

    }


    public void setNombreJugadores() {

        nombreJugador1 = ScreensController.getJ1();
        nombreJugador2 = ScreensController.getJ2();
    }

    @FXML
    public void autobotsPrevious() {
        if (this.autobot == "bumblebee") {
            autobots.getStyleClass().remove("backgroundBumblebee");
            autobots.getStyleClass().add("backgroundOptimus");
            this.autobot = "optimus";
        }
        if (this.autobot == "ratchet") {
            autobots.getStyleClass().remove("backgroundRatchet");
            autobots.getStyleClass().add("backgroundBumblebee");
            this.autobot = "bumblebee";
        }
    }
    @FXML
    public void autobotsNext(){
        if (this.autobot == "bumblebee") {
            autobots.getStyleClass().remove("backgroundBumblebee");
            autobots.getStyleClass().add("backgroundRatchet");
            this.autobot = "ratchet";
        }
        if (this.autobot == "optimus") {
            autobots.getStyleClass().remove("backgroundOptimus");
            autobots.getStyleClass().add("backgroundBumblebee");
            this.autobot = "bumblebee";
        }

    }
    @FXML
    public void decepticonsPrevious(){
        if (this.decepticon == "boneCrusher") {
            decepticons.getStyleClass().remove("backgroundBoneCrusher");
            decepticons.getStyleClass().add("backgroundMegatron");
            this.decepticon = "megatron";
        }
        if (this.decepticon == "frenzy") {
            decepticons.getStyleClass().remove("backgroundFrenzy");
            decepticons.getStyleClass().add("backgroundBoneCrusher");
            this.decepticon = "boneCrusher";
        }

    }
    @FXML
    public void decepticonsNext(){
        if (this.decepticon == "boneCrusher") {
            decepticons.getStyleClass().remove("backgroundBoneCrusher");
            decepticons.getStyleClass().add("backgroundFrenzy");
            this.decepticon = "frenzy";
        }
        if (this.decepticon == "megatron") {
            decepticons.getStyleClass().remove("backgroundMegatron");
            decepticons.getStyleClass().add("backgroundBoneCrusher");
            this.decepticon = "boneCrusher";
        }

    }

    @FXML
    public void autobotJugador1(){
        this.autobotJugador.setText(nombreJugador1);
        this.decepticonJugador.setText(nombreJugador2);
        this.equipoJugador1 = "autobots";
        this.equipoJugador2 = "decepticons";
    }
    @FXML
    public void autobotJugador2(){
        this.autobotJugador.setText(nombreJugador2);
        this.decepticonJugador.setText(nombreJugador1);
        this.equipoJugador2 = "autobots";
        this.equipoJugador1 = "decepticons";
    }

    @FXML
    public void decepticonJugador1(){
        this.autobotJugador.setText(nombreJugador2);
        this.decepticonJugador.setText(nombreJugador1);
        this.equipoJugador2 = "autobots";
        this.equipoJugador1 = "decepticons";
    }
    @FXML
    public void decepticonJugador2(){
        this.autobotJugador.setText(nombreJugador1);
        this.decepticonJugador.setText(nombreJugador2);
        this.equipoJugador1 = "autobots";
        this.equipoJugador2 = "decepticons";
    }

    @FXML
    public void setearEtiquetas(){

        jugador1Autobot.setText(nombreJugador1);
        jugador1Decepticon.setText(nombreJugador1);
        jugador2Autobot.setText(nombreJugador2);
        jugador2Decepticon.setText(nombreJugador2);
    }

    @FXML
    public void jugar(){

        if(equipoJugador1 == "autobots"){
            ScreensController.asignarAutobotsAJugador(1);

        }
        else if(equipoJugador1 == "decepticons"){
            ScreensController.asignarAutobotsAJugador(2);

        }
        myController.setScreen(screenTablero,nombreJugador1,nombreJugador2);
    }

}