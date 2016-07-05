package modelo.tablero.superficieTerrestre;

import modelo.tablero.colocable.robots.armas.Ataque;
import modelo.tablero.colocable.robots.armas.AtaqueAutobot;
import modelo.tablero.colocable.robots.armas.AtaqueDecepticon;
import modelo.tablero.superficie.Superficie;
import modelo.tablero.superficieAerea.ContextoSuperficieArea;

import java.util.Random;

public class ContextoSuperficieTerrestre {
    StateSuperficieTerrestre actual;

    public ContextoSuperficieTerrestre(){
        int i = (new Random()).nextInt(Integer.MAX_VALUE)%3;
        StateSuperficieTerrestre[] vectorRandom= {new Rocoso(), new Espinas(), new Pantanoso()};
        actual=vectorRandom[i];
    }
    public ContextoSuperficieTerrestre(boolean debug){
        actual=new Rocoso();
    }

    public void cambiarEspinas(){
        actual=new Espinas();
    }
    public void cambiarPantanoso(){
        actual=new Pantanoso();
    }
    public void cambiarRocoso(){
        actual=new Rocoso();
    }
    public void recibirAtaque(AtaqueAutobot ataque){
        actual.recibirAtaque(ataque);
    }
    public void recibirAtaque(AtaqueDecepticon ataque){
        actual.recibirAtaque(ataque);
    }
    public Superficie getActual(){
        return actual;
    }
}
