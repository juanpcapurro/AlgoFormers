package vista.controladores;

import algoFormers.juego.Partida;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import java.util.Hashtable;

public class TableroVista extends GridPane{

    public TableroVista(Partida partida) {
        ImageView imagenTerrestre;
        ImageView imagenAerea;
        ImageView objeto;
        Hashtable<String,String> imagenes=getImagenes();
        StackPane pane;
        setHgap(1);
        setVgap(1);
        setGridLinesVisible(true);
        for (int j = 0; j < 8; j++) {
            for (int i = 0; i < 8; i++) {
                pane=new StackPane();
                imagenTerrestre=obtenerimagenTerrestre(imagenes,partida);
                imagenAerea=obtenerimagenAerea(imagenes,partida);
                objeto=obtenerimagenObjeto(imagenes,partida);
                pane.getChildren().addAll(imagenTerrestre,imagenAerea,objeto);
                GridPane.setConstraints(pane, j, i);
                partida.avanzarIterador();
                getChildren().add(pane);
            }
        }
    }

    ImageView obtenerimagenTerrestre(Hashtable<String,String> imagenes,Partida partida){
        String imagen;
        ImageView imagenTerrestre;
        imagen=imagenes.get((partida.obtenerSuperficieTerrestre()).getClass().toString());
        imagenTerrestre = new ImageView(imagen);
        imagenTerrestre.setFitHeight(100);
        imagenTerrestre.setFitWidth(100);
        return imagenTerrestre;
    }

    ImageView obtenerimagenAerea(Hashtable<String,String> imagenes,Partida partida){
        String imagen;
        ImageView imagenAerea;
        imagen=imagenes.get((partida.obtenerSuperficieAerea()).getClass().toString());
        imagenAerea = new ImageView(imagen);
        imagenAerea.setFitHeight(100);
        imagenAerea.setFitWidth(100);
        imagenAerea.setOpacity(0.5);
        imagenAerea.setEffect(new DropShadow(1000, Color.WHITE));
        return imagenAerea;
    }

    ImageView obtenerimagenObjeto(Hashtable<String,String> imagenes,Partida partida){
        String imagen;
        ImageView imagenColocable;
        imagen=imagenes.get((partida.obtenerColocable()).getClass().toString());
        imagenColocable=new ImageView(imagen);
        imagenColocable.setFitHeight(100);
        imagenColocable.setFitWidth(100);
        return imagenColocable;
    }

    Hashtable<String,String> getImagenes(){
        Hashtable<String,String> imagenes=new Hashtable<>();
        imagenes.put("class algoFormers.tablero.superficieTerrestre.Rocoso","file:src/vista/imagenes/rocoso.jpg");
        imagenes.put("class algoFormers.tablero.superficieTerrestre.Pantanoso","file:src/vista/imagenes/pantanoso.jpeg");
        imagenes.put("class algoFormers.tablero.superficieTerrestre.Espinas","file:src/vista/imagenes/espinoso.jpg");
        imagenes.put("class algoFormers.tablero.superficieAerea.NebulosaDeAndromeda","file:src/vista/imagenes/nebulosa.png");
        imagenes.put("class algoFormers.tablero.superficieAerea.Nube","file:src/vista/imagenes/nube.png");
        imagenes.put("class algoFormers.tablero.superficieAerea.TormentaPsionica","file:src/vista/imagenes/tormentaPsionica.png");
        imagenes.put("class algoFormers.tablero.colocable.robots.autobot.Bumblebee","file:src/vista/imagenes/bumblebee.png");
        imagenes.put("class algoFormers.tablero.colocable.robots.autobot.Optimus","file:src/vista/imagenes/optimus.png");
        imagenes.put("class algoFormers.tablero.colocable.robots.autobot.Ratchet","file:src/vista/imagenes/ratchet.png");
        imagenes.put("class algoFormers.tablero.colocable.robots.decepticon.BoneCrusher","file:src/vista/imagenes/boneCrusher.png");
        imagenes.put("class algoFormers.tablero.colocable.robots.decepticon.Frenzy","file:src/vista/imagenes/frenzy.png");
        imagenes.put("class algoFormers.tablero.colocable.robots.decepticon.Megatron","file:src/vista/imagenes/megatron.png");
        imagenes.put("class algoFormers.tablero.colocable.robots.decepticon.Megatron","file:src/vista/imagenes/megatron.png");
        imagenes.put("class algoFormers.tablero.colocable.EspacioVacio","file:src/vista/imagenes/EspacioVacio.png");




        return imagenes;
    }
}
