package vista.controladores;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import vista.ControlledScreen;
import vista.ScreensController;
import vista.mainApp;

import java.net.URL;
import java.util.ResourceBundle;



public class ScreenSeleccionDeEquiposController implements Initializable, ControlledScreen {



    ScreensController myController;
    @FXML
    AnchorPane autobots;
    @FXML
    AnchorPane decepticons;
    @FXML
    javafx.scene.control.Button  autobotsNext;
    @FXML
    javafx.scene.control.Button  autobotsPrevious;
    @FXML
    javafx.scene.control.Button  decepticonsNext;
    @FXML
    javafx.scene.control.Button  decepticonsPrevious;
    @FXML
    MenuButton autobotJugador;
    @FXML
    MenuButton decepticonJugador;

    @FXML
    public  javafx.scene.control.MenuItem jugador1Autobot;
    @FXML
    public  javafx.scene.control.MenuItem jugador2Autobot;
    @FXML
    public  javafx.scene.control.MenuItem jugador1Decepticon;
    @FXML
    public  javafx.scene.control.MenuItem jugador2Decepticon;

    private String autobot;
    private String decepticon;
    private String equipoJugador1;
    private String equipoJugador2;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.autobot = "optimus";
        this.decepticon = "megatron";
    }

    public void setScreenParent(ScreensController screenParent) {
        myController = screenParent;
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
        this.autobotJugador.setText(mainApp.nombreJ1);
        this.decepticonJugador.setText(mainApp.nombreJ2);
        this.equipoJugador1 = "autobots";
        this.equipoJugador2 = "decepticons";
    }
    @FXML
    public void autobotJugador2(){
        this.autobotJugador.setText(mainApp.nombreJ2);
        this.decepticonJugador.setText(mainApp.nombreJ1);
        this.equipoJugador2 = "autobots";
        this.equipoJugador1 = "decepticons";
    }

    @FXML
    public void decepticonJugador1(){
        this.autobotJugador.setText(mainApp.nombreJ2);
        this.decepticonJugador.setText(mainApp.nombreJ1);
        this.equipoJugador2 = "autobots";
        this.equipoJugador1 = "decepticons";
    }
    @FXML
    public void decepticonJugador2(){
        this.autobotJugador.setText(mainApp.nombreJ1);
        this.decepticonJugador.setText(mainApp.nombreJ2);
        this.equipoJugador1 = "autobots";
        this.equipoJugador2 = "decepticons";
    }

    @FXML
    public void setearEtiquetas(){
        jugador1Autobot.setText(mainApp.nombreJ1);
        jugador1Decepticon.setText(mainApp.nombreJ1);
        jugador2Autobot.setText(mainApp.nombreJ2);
        jugador2Decepticon.setText(mainApp.nombreJ2);
    }

}