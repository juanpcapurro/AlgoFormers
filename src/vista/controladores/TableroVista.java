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
        imagenes.put("Rocoso", "file:src/vista/imagenes/rocoso2.jpg");
        imagenes.put("Pantanoso", "file:src/vista/imagenes/pantano.jpg");
        imagenes.put("Espinas", "file:src/vista/imagenes/volcanMejorado3.gif");

        imagenes.put("NebulosaDeAndromeda", "file:src/vista/imagenes/nebulosa.gif");
        imagenes.put("Nube", "file:src/vista/imagenes/nube.png");
        imagenes.put("TormentaPsionica", "file:src/vista/imagenes/tormentaPsionica.gif");

        imagenes.put("Bumblebee ModoHumanoide", "file:src/vista/imagenes/BumblebeeHumanoide.png");
        imagenes.put("Bumblebee ModoAlternoTerrestre", "file:src/vista/imagenes/BumblebeeAlterno.png");
        imagenes.put("Optimus ModoHumanoide", "file:src/vista/imagenes/OptimusHumanoide.png");
        imagenes.put("Optimus ModoAlternoTerrestre", "file:src/vista/imagenes/OptimusAlterno.png");
        imagenes.put("Ratchet ModoHumanoide", "file:src/vista/imagenes/RatchetHumanoide.png");
        imagenes.put("Ratchet ModoAlternoAereo", "file:src/vista/imagenes/RatchetAlterno.png");

        imagenes.put("BoneCrusher ModoHumanoide", "file:src/vista/imagenes/BonecrusherHumanoide.png");
        imagenes.put("BoneCrusher ModoAlternoTerrestre", "file:src/vista/imagenes/BonecrusherAlterno.png");
        imagenes.put("Frenzy ModoHumanoide", "file:src/vista/imagenes/FrenzyHumanoide.png");
        imagenes.put("Frenzy ModoAlternoTerrestre", "file:src/vista/imagenes/FrenzyAlterno.png");
        imagenes.put("Megatron ModoHumanoide", "file:src/vista/imagenes/MegatronHumanoide.png");
        imagenes.put("Megatron ModoAlternoAereo", "file:src/vista/imagenes/MegatronAlterno.png");
        imagenes.put("EspacioVacio String", "file:src/vista/imagenes/EspacioVacio.png");

        return imagenes;
    }


}