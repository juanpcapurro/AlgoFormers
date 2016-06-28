package modelo.tablero.colocable.robots.decepticon;

import modelo.tablero.colocable.Colocable;
import modelo.tablero.colocable.robots.AlgoFormer;
import modelo.tablero.colocable.robots.armas.AtaqueAutobot;
import modelo.tablero.colocable.robots.armas.AtaqueDecepticon;

public abstract class Decepticon extends AlgoFormer {
    public void atacar(Colocable objetivo){
        objetivo.recibirAtaque(new AtaqueDecepticon(getAtaque()));
    }
    public void recibirAtaque(AtaqueDecepticon unAtaque){

    }
    public void recibirAtaque(AtaqueAutobot unAtaque){
        recibirAtaqueYaVerificado(unAtaque);
    }
}
