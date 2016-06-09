package algoFormers.tablero.superficieTerrestre;

import algoFormers.tablero.colocable.robots.armas.Ataque;
import algoFormers.tablero.superficie.Superficie;

public class SuperficieTerrestre extends Superficie {

	StateSuperficieTerrestre actual;

    public SuperficieTerrestre(){actual=new Llano();}

    public void cambiarARocoso(){
        actual.cambiarARocoso(this);
    }

    public void cambiarAPantanoso(){
        actual.cambiarAPantanoso(this);
    }
    public void cambiarALlano(){
        actual.cambiarALlano(this);
    }
    public StateSuperficieTerrestre verActual(){
        return actual;
    }
    public void cambiarActual(StateSuperficieTerrestre aCambiar){
        actual= aCambiar;
    }

    public void recibirAtaque(Ataque ataque) {
        actual.recibirAtaque(this, ataque);
    }
}
