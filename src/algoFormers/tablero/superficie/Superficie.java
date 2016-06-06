package algoFormers.tablero.superficie;

import algoFormers.tablero.Atacable;
import algoFormers.tablero.colocable.robots.armas.Ataque;

public class Superficie implements Atacable {
    StateSuperficie actual;

    public Superficie(){actual=new Llano();}

    public void cambiarARocoso(){
        actual.cambiarARocoso(this);
    }

    public void cambiarAPantanoso(){
        actual.cambiarAPantanoso(this);
    }
    public void cambiarALlano(){
        actual.cambiarALlano(this);
    }
    public StateSuperficie verActual(){
        return actual;
    }
    public void cambiarActual(StateSuperficie aCambiar){
        actual=aCambiar;
    }

    public void recibirAtaque(Ataque ataque) {
        actual.recibirAtaque(this, ataque);
    }
}
