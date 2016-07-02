package vista.controladores;

import javafx.scene.layout.GridPane;
import modelo.juego.ProxyPartida;

import java.util.Hashtable;

public class TableroVista extends GridPane {

    final int HEIGTH = 85;
    final int WIDTH = 120;
    ProxyPartida partida;

    public TableroVista(ProxyPartida nuevaPartida) {
        //partida=nuevaPartida;
/*        ImageView imagenTerrestre;
        ImageView imagenAerea;
        ImageView objeto;
        Hashtable<String, String> imagenes = getImagenes();
        StackPane pane;
        setHgap(1);
        setVgap(1);
        setGridLinesVisible(true);*/
/*        for (int j = 0; j < 8; j++) {
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
        }*/
    }



    static Hashtable<String, String> getImagenes() {
        Hashtable<String, String> imagenes = new Hashtable<>();
        imagenes.put("class modelo.tablero.superficieTerrestre.Rocoso", "file:src/vista/imagenes/rocoso2.jpg");
        imagenes.put("class modelo.tablero.superficieTerrestre.Pantanoso", "file:src/vista/imagenes/pantano.jpg");
        imagenes.put("class modelo.tablero.superficieTerrestre.Espinas", "file:src/vista/imagenes/volcanMejorado3.gif");
        imagenes.put("class modelo.tablero.superficieAerea.NebulosaDeAndromeda", "file:src/vista/imagenes/nebulosa.gif");
        imagenes.put("class modelo.tablero.superficieAerea.Nube", "file:src/vista/imagenes/nube.png");
        imagenes.put("class modelo.tablero.superficieAerea.TormentaPsionica", "file:src/vista/imagenes/tormentaPsionica.gif");
        imagenes.put("class modelo.tablero.colocable.robots.autobot.Bumblebee", "file:src/vista/imagenes/BumblebeeHumanoide.png");
        imagenes.put("class modelo.tablero.colocable.robots.autobot.Optimus", "file:src/vista/imagenes/OptimusHumanoide.png");
        imagenes.put("class modelo.tablero.colocable.robots.autobot.Ratchet", "file:src/vista/imagenes/RatchetHumanoide.png");
        imagenes.put("class modelo.tablero.colocable.robots.decepticon.BoneCrusher", "file:src/vista/imagenes/BonecrusherHumanoide.png");
        imagenes.put("class modelo.tablero.colocable.robots.decepticon.Frenzy", "file:src/vista/imagenes/FrenzyHumanoide.png");
        imagenes.put("class modelo.tablero.colocable.robots.decepticon.Megatron", "file:src/vista/imagenes/MegatronHumanoide.png");
        imagenes.put("class modelo.tablero.colocable.EspacioVacio", "file:src/vista/imagenes/EspacioVacio.png");

        return imagenes;
    }


}