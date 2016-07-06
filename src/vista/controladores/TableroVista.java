package vista.controladores;

import javafx.scene.layout.GridPane;

import java.util.Hashtable;

public class TableroVista extends GridPane {


    public TableroVista() {

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
        imagenes.put("Menasor ModoHumanoide","file:src/vista/imagenes/Menasor.png");
        imagenes.put("Bumblebee DefeatedMode", "file:src/vista/imagenes/tachados/BumblebeeHumanoideTachado.png");
        imagenes.put("Bumblebee ModoAlternoDefeatedMode", "file:src/vista/imagenes/tachados/BumblebeeAlternoTachado.png");
        imagenes.put("Optimus DefeatedMode", "file:src/vista/imagenes/tachados/OptimusHumanoideTachado.png");
        imagenes.put("Optimus ModoAlternoDefeatedMode", "file:src/vista/imagenes/tachados/OptimusAlternoTachado.png");
        imagenes.put("Ratchet DefeatedMode", "file:src/vista/imagenes/tachados/RatchetHumanoideTachado.png");
        imagenes.put("Ratchet ModoAlternoDefeatedMode", "file:src/vista/imagenes/tachados/RatchetAlternoTachado.png");
        imagenes.put("Menasor DefeatedMode","file:src/vista/imagenes/tachados/MenasorTachado.png");

        imagenes.put("BoneCrusher ModoHumanoide", "file:src/vista/imagenes/BonecrusherHumanoide.png");
        imagenes.put("BoneCrusher ModoAlternoTerrestre", "file:src/vista/imagenes/BonecrusherAlterno.png");
        imagenes.put("Frenzy ModoHumanoide", "file:src/vista/imagenes/FrenzyHumanoide.png");
        imagenes.put("Frenzy ModoAlternoTerrestre", "file:src/vista/imagenes/FrenzyAlterno.png");
        imagenes.put("Megatron ModoHumanoide", "file:src/vista/imagenes/MegatronHumanoide.png");
        imagenes.put("Megatron ModoAlternoAereo", "file:src/vista/imagenes/MegatronAlterno.png");
        imagenes.put("Superion ModoHumanoide","file:src/vista/imagenes/superion.png");
        imagenes.put("BoneCrusher DefeatedMode", "file:src/vista/imagenes/tachados/BonecrusherHumanoideTachado.png");
        imagenes.put("BoneCrusher ModoAlternoDefeatedMode", "file:src/vista/imagenes/tachados/BonecrusherAlternoTachado.png");
        imagenes.put("Frenzy DefeatedMode", "file:src/vista/imagenes/tachados/FrenzyHumanoideTachado.png");
        imagenes.put("Frenzy ModoAlternoDefeatedMode", "file:src/vista/imagenes/tachados/FrenzyAlternoTachado.png");
        imagenes.put("Megatron DefeatedMode", "file:src/vista/imagenes/tachados/MegatronHumanoideTachado.png");
        imagenes.put("Megatron ModoAlternoDefeatedMode", "file:src/vista/imagenes/tachados/MegatronAlternoTachado.png");
        imagenes.put("Superion DefeatedMode","file:src/vista/imagenes/tachados/superionTachado.png");

        imagenes.put("EspacioVacio String", "file:src/vista/imagenes/EspacioVacio.png");
        imagenes.put("BurbujaInmaculada String","file:src/vista/imagenes/burbujas.gif");
        imagenes.put("DobleCanion String","file:src/vista/imagenes/canion.png");
        imagenes.put("Flash String","file:src/vista/imagenes/flash.png");
        imagenes.put("Chispa String","file:src/vista/imagenes/chispa.gif");

        return imagenes;
    }


}