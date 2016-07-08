package vista;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.util.HashMap;


public class ScreensController  extends StackPane {



    private HashMap<String, Node> screens = new HashMap<>();
    static String j1, j2,equipoJ1,winnerName;




    public ScreensController() {
        super();
    }

    public static String getEquipoJ1() {
        return equipoJ1;
    }

    public static String getWinnerName() {
        return winnerName;
    }


    public void addScreen(String name, Node screen) {
        screens.put(name, screen);
    }


    public boolean loadScreen(String name, String resource) {
        try {
            FXMLLoader myLoader = new FXMLLoader(getClass().getResource(resource));
            Parent loadScreen = (Parent) myLoader.load();
            ControlledScreen myScreenControler = ((ControlledScreen) myLoader.getController());
            mainApp.controladores.put(name,myScreenControler);
            myScreenControler.setScreenParent(this);
            addScreen(name, loadScreen);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }



    public boolean setScreen(final String name) {
        if (screens.get(name) != null) {
            final DoubleProperty opacity = opacityProperty();

            if (!getChildren().isEmpty()) {    //TRANSICION
                Timeline fade = new Timeline(
                        new KeyFrame(Duration.ZERO, new KeyValue(opacity, 1.0)),
                        new KeyFrame(new Duration(1), new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent t) {
                                getChildren().remove(0);
                                Node screen = screens.get(name);
                                screen.sceneProperty();
                                screen.autosize();
                                getChildren().add(0, screen);
                                Timeline fadeIn = new Timeline(
                                        new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
                                        new KeyFrame(new Duration(1000), new KeyValue(opacity, 1.0)));  //TIEMPO DE TTRANSICION
                                fadeIn.play();
                            }
                        }, new KeyValue(opacity, 0.0)));
                fade.play();

            } else {
                setOpacity(0.0);
                Node screen = screens.get(name);
                getChildren().add(screen);
                Timeline fadeIn = new Timeline(
                        new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
                        new KeyFrame(new Duration(10), new KeyValue(opacity, 1.0)));
                fadeIn.play();
            }
            return true;
        } else {

            System.out.println("NO SE PUDO CARGAR LA PANTALLA \n");
            return false;
        }

    }


    public void setScreen(String screenName, String nj1, String nj2) {
        mainApp.controladores.get(screenName).setNombreJugadores(nj1,nj2);
        setScreen(screenName);


    }

    public void nombresDeJugadores(String text, String text1) {
        j1=text;
        j2=text1;
    }

    public static String getJ1(){
        return j1;
    }
    public static String getJ2(){
        return j2;
    }

    public static void asignarAutobotsAJugador(int i) {
        if(i == 1){
            equipoJ1 = "autobots";
        }
        else{
            equipoJ1 = "decepticons";
        }
    }



}

