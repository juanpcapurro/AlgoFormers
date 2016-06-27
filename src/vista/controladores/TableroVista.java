package vista.controladores;

import modelo.juego.ProxyPartida;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class TableroVista extends GridPane {

    final int HEIGTH = 85;
    final int WIDTH = 120;
    static List<Integer> initialCoordinates = new ArrayList<>();
    static List<Integer> finalCoordinates = new ArrayList<>();
    ProxyPartida partida;
    GridPane grid=this;
    StackPane inicial;
    StackPane destino;
    final ImageView mira=new ImageView("file:src/vista/imagenes/mira2.png");

    public TableroVista(ProxyPartida nuevaPartida) {
        partida=nuevaPartida;
        ImageView imagenTerrestre;
        ImageView imagenAerea;
        ImageView objeto;
        Hashtable<String, String> imagenes = getImagenes();
        StackPane pane;
        setHgap(1);
        setVgap(1);
        setGridLinesVisible(true);
        for (int j = 0; j < 8; j++) {
            for (int i = 0; i < 8; i++) {
                pane = new StackPane();
                imagenTerrestre = obtenerimagenTerrestre(imagenes, partida);
                imagenAerea = obtenerimagenAerea(imagenes, partida);
                objeto = obtenerimagenObjeto(imagenes, partida);
                pane.getChildren().addAll(imagenTerrestre, imagenAerea, objeto);
                setHandlerCasilleroSeleccionado(pane, partida);
                setCrosshairOn(pane);
                setCrosshairOff(pane);
                GridPane.setConstraints(pane, j, i);
                partida.avanzarIterador();
                getChildren().add(pane);
            }
        }
    }

    void setHandlerCasilleroSeleccionado(Node node, ProxyPartida partida) {
        node.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                StackPane pane = (StackPane) event.getTarget();
                if (initialCoordinates.size() == 0) {
                    initialCoordinates.add(GridPane.getRowIndex(pane));
                    initialCoordinates.add(GridPane.getColumnIndex(pane));
                    inicial=pane;
                } else {
                    finalCoordinates.add(GridPane.getRowIndex(pane));
                    finalCoordinates.add(GridPane.getColumnIndex(pane));
                    partida.mover(initialCoordinates,finalCoordinates);
                    destino=pane;
                    partida.resetIterador();
                    actualizarCasillero();
                    initialCoordinates.clear();
                    finalCoordinates.clear();
                }
            }
        });
    }

    public Group buscarPane(List<Integer> coordinates){
        for(Node node: grid.getChildren())
            if (GridPane.getRowIndex(node)==coordinates.get(0) && GridPane.getColumnIndex(node)==coordinates.get(1) )
                return (Group)node;
        return null;
    }

    public void actualizarCasillero(){
        partida.setIterador(initialCoordinates.get(0),initialCoordinates.get(1));
        restartPane(inicial);
        partida.setIterador(finalCoordinates.get(0),finalCoordinates.get(1));
        restartPane(destino);
    }

    public void restartPane(StackPane pane){
        pane.getChildren().clear();
        ImageView imagenAerea;
        ImageView objeto;
        Hashtable<String, String> imagenes = getImagenes();
        ImageView imagenTerrestre;
        imagenTerrestre = obtenerimagenTerrestre(imagenes, partida);
        imagenAerea = obtenerimagenAerea(imagenes, partida);
        objeto = obtenerimagenObjeto(imagenes, partida);
        pane.getChildren().addAll(imagenTerrestre, imagenAerea, objeto);
    }

    public ImageView obtenerimagenTerrestre(Hashtable<String, String> imagenes, ProxyPartida partida) {
        String imagen;
        ImageView imagenTerrestre;
        imagen = imagenes.get((partida.obtenerSuperficieTerrestre()).getClass().toString());
        imagenTerrestre = new ImageView(imagen);
        imagenTerrestre.setFitHeight(HEIGTH);
        imagenTerrestre.setFitWidth(WIDTH);
        imagenTerrestre.setPickOnBounds(false);
        imagenTerrestre.setMouseTransparent(true);
        return imagenTerrestre;
    }

    ImageView obtenerimagenAerea(Hashtable<String, String> imagenes, ProxyPartida partida) {
        String imagen;
        ImageView imagenAerea;
        imagen = imagenes.get((partida.obtenerSuperficieAerea()).getClass().toString());
        imagenAerea = new ImageView(imagen);
        imagenAerea.setFitHeight(HEIGTH);
        imagenAerea.setFitWidth(WIDTH);
        imagenAerea.setOpacity(0.5);
        imagenAerea.setPickOnBounds(false);
        imagenAerea.setMouseTransparent(true);
        return imagenAerea;
    }

    ImageView obtenerimagenObjeto(Hashtable<String, String> imagenes, ProxyPartida partida) {
        String imagen;
        ImageView imagenColocable;
        imagen = imagenes.get((partida.obtenerColocable()).getClass().toString());
        imagenColocable = new ImageView(imagen);
        imagenColocable.setFitHeight(HEIGTH - 20);
        imagenColocable.setFitWidth(WIDTH - 20);
        imagenColocable.setPickOnBounds(false);
        imagenColocable.setMouseTransparent(true);
        return imagenColocable;
    }

    static Hashtable<String, String> getImagenes() {
        Hashtable<String, String> imagenes = new Hashtable<>();
        imagenes.put("class modelo.tablero.superficieTerrestre.Rocoso", "file:src/vista/imagenes/rocoso.png");
        imagenes.put("class modelo.tablero.superficieTerrestre.Pantanoso", "file:src/vista/imagenes/pantanoso.png");
        imagenes.put("class modelo.tablero.superficieTerrestre.Espinas", "file:src/vista/imagenes/espinoso.png");
        imagenes.put("class modelo.tablero.superficieAerea.NebulosaDeAndromeda", "file:src/vista/imagenes/nebulosa.png");
        imagenes.put("class modelo.tablero.superficieAerea.Nube", "file:src/vista/imagenes/nube.png");
        imagenes.put("class modelo.tablero.superficieAerea.TormentaPsionica", "file:src/vista/imagenes/tormentaPsionica.png");
        imagenes.put("class modelo.tablero.colocable.robots.autobot.Bumblebee", "file:src/vista/imagenes/BumblebeeHumanoide.png");
        imagenes.put("class modelo.tablero.colocable.robots.autobot.Optimus", "file:src/vista/imagenes/OptimusHumanoide.png");
        imagenes.put("class modelo.tablero.colocable.robots.autobot.Ratchet", "file:src/vista/imagenes/RatchetHumanoide.png");
        imagenes.put("class modelo.tablero.colocable.robots.decepticon.BoneCrusher", "file:src/vista/imagenes/BonecrusherHumanoide.png");
        imagenes.put("class modelo.tablero.colocable.robots.decepticon.Frenzy", "file:src/vista/imagenes/FrenzyHumanoide.png");
        imagenes.put("class modelo.tablero.colocable.robots.decepticon.Megatron", "file:src/vista/imagenes/MegatronHumanoide.png");
        imagenes.put("class modelo.tablero.colocable.EspacioVacio", "file:src/vista/imagenes/EspacioVacio.png");


        return imagenes;
    }

    void setCrosshairOn(StackPane pane){
        mira.setFitHeight(70);
        mira.setFitWidth(70);
        mira.setScaleX(2);
        mira.setScaleY(2);
        pane.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(!pane.getChildren().contains(mira))
                    pane.getChildren().add(mira);
                event.consume();
            }
        });
    }

    void setCrosshairOff(StackPane pane) {
        pane.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                pane.getChildren().remove(pane.getChildren().size()-1);
                event.consume();
            }
        });
    }
}