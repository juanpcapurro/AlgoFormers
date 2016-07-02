package modelo.tablero.superficie;

import modelo.tablero.Atacable;
import modelo.tablero.colocable.robots.ModoAlgoformer;
import modelo.tablero.colocable.robots.armas.Ataque;
import modelo.tablero.colocable.robots.armas.AtaqueAutobot;
import modelo.tablero.colocable.robots.armas.AtaqueDecepticon;

public abstract class Superficie implements Atacable {

    public void recibirAtaque(AtaqueDecepticon unAtaque) {

    }
    public void recibirAtaque(AtaqueAutobot unAtaque){}

    public abstract void afectarUnidadTerrestre(ModoAlgoformer modoAlgoformer);
    public abstract void afectarUnidadAerea(ModoAlgoformer modoAlgoformer);
}
