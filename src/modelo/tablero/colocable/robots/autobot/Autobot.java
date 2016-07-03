package modelo.tablero.colocable.robots.autobot;

import modelo.tablero.colocable.Colocable;
import modelo.tablero.colocable.robots.AlgoFormer;
import modelo.tablero.colocable.robots.armas.AtaqueAutobot;
import modelo.tablero.colocable.robots.armas.AtaqueDecepticon;

public abstract class Autobot extends AlgoFormer{
    public void atacar(Colocable objetivo){
        objetivo.recibirAtaque(new AtaqueAutobot(getAtaque()));
    }
    public void recibirAtaque(AtaqueAutobot unAtaque){

    }
    public void recibirAtaque(AtaqueDecepticon unAtaque){
        recibirAtaqueYaVerificado(unAtaque);
    }
}
