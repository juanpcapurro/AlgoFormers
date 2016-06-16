package algoFormers.tablero.superficieTerrestre;

import algoFormers.tablero.colocable.robots.ModoAlgoformer;
import algoFormers.tablero.colocable.robots.armas.Ataque;
import algoFormers.tablero.colocable.robots.modificadores.DebuffEspinas;

class Pantanoso extends StateSuperficieTerrestre {

    public void recibirAtaque(StateSuperficieTerrestre superficieActual, Ataque ataque) {
    }


    @Override
    public void afectarUnidadTerrestre(ModoAlgoformer modoAlgoformer) {
        modoAlgoformer.afectarEstado(new DebuffEspinas());
    }

    @Override
    public void afectarUnidadAerea(ModoAlgoformer modoAlgoformer) {

    }
}
