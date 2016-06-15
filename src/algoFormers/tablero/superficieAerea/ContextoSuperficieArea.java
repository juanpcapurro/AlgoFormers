package algoFormers.tablero.superficieAerea;

import algoFormers.tablero.colocable.robots.armas.Ataque;
import algoFormers.tablero.superficie.Superficie;

public class ContextoSuperficieArea {
    StateSuperficieAerea actual;

    public ContextoSuperficieArea(){
        actual=new Nube();
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
    Superficie getState(){
        return actual;
    }
}
