package algoFormers.tablero.superficie;

import algoFormers.tablero.Atacable;
import algoFormers.tablero.colocable.robots.ModoAlgoformer;
import algoFormers.tablero.colocable.robots.armas.Ataque;

public abstract class Superficie implements Atacable {

    public void recibirAtaque(Ataque unAtaque) {

    }

    public abstract void afectarUnidadTerrestre(ModoAlgoformer modoAlgoformer);
    public abstract void afectarUnidadAerea(ModoAlgoformer modoAlgoformer);
}
