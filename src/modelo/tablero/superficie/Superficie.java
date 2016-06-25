package modelo.tablero.superficie;

import modelo.tablero.Atacable;
import modelo.tablero.colocable.robots.ModoAlgoformer;
import modelo.tablero.colocable.robots.armas.Ataque;

public abstract class Superficie implements Atacable {

    public void recibirAtaque(Ataque unAtaque) {

    }

    public abstract void afectarUnidadTerrestre(ModoAlgoformer modoAlgoformer);
    public abstract void afectarUnidadAerea(ModoAlgoformer modoAlgoformer);
}
