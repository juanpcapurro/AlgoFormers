package vista.controladores;

import javafx.scene.layout.GridPane;
import modelo.juego.ProxyPartida;

import java.util.Hashtable;

public class TableroVista extends GridPane {


    public TableroVista(ProxyPartida nuevaPartida) {

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