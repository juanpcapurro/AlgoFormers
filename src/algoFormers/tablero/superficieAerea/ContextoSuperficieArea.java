package algoFormers.tablero.superficieAerea;

import algoFormers.tablero.colocable.robots.armas.Ataque;
import algoFormers.tablero.superficie.Superficie;

import java.util.Random;

public class ContextoSuperficieArea {
    StateSuperficieAerea actual;

    public ContextoSuperficieArea(){
        int i = (new Random()).nextInt(Integer.MAX_VALUE)%3;
        StateSuperficieAerea[] vectorRandom= {new Nube(), new NebulosaDeAndromeda(), new TormentaPsionica()};
        actual=vectorRandom[i];
    }

    void cambiarANebulosa(){
        actual=new NebulosaDeAndromeda();
    }
    void cambiarTormenta(){
        actual=new TormentaPsionica();
    }
    void cambiarNube(){
        actual=new Nube();
    }

    void recibirAtaque(Ataque ataque){
        actual.recibirAtaque(ataque);
    }
    public Superficie getActual(){
        return actual;
    }
}
