package modelo.tablero.superficieTerrestre;

import modelo.tablero.colocable.robots.ModoAlgoformer;
import modelo.tablero.colocable.robots.armas.Ataque;
import modelo.tablero.colocable.robots.modificadores.DebuffPantano;

public class Pantanoso extends StateSuperficieTerrestre {

    public void recibirAtaque(StateSuperficieTerrestre superficieActual, Ataque ataque) {
    }


    @Override
    public void afectarUnidadTerrestre(ModoAlgoformer modoAlgoformer) {
        modoAlgoformer.afectarEstado(new DebuffPantano());
    }

    @Override
    public void afectarUnidadAerea(ModoAlgoformer modoAlgoformer) {

    }
}
