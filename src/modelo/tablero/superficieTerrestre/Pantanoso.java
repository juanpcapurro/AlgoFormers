package modelo.tablero.superficieTerrestre;

import modelo.tablero.colocable.robots.ModoAlgoformer;
import modelo.tablero.colocable.robots.armas.Ataque;
import modelo.tablero.colocable.robots.modificadores.DebuffPantanoHumanoide;
import modelo.tablero.colocable.robots.modificadores.DebuffPantanoTerrestre;

public class Pantanoso extends StateSuperficieTerrestre {

    public void recibirAtaque(StateSuperficieTerrestre superficieActual, Ataque ataque) {
    }


    @Override
    public void afectarUnidadTerrestre(ModoAlgoformer modoAlgoformer) {
        modoAlgoformer.afectarEstado(new DebuffPantanoTerrestre());
    }

    @Override
    public void afectarUnidadAerea(ModoAlgoformer modoAlgoformer) {

    }

    @Override
    public void afectarUnidadHumanoide(ModoAlgoformer modoAlgoformer) {
        modoAlgoformer.afectarEstado(new DebuffPantanoHumanoide(modoAlgoformer));
    }
}
