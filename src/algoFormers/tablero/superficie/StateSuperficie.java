package algoFormers.tablero.superficie;

import algoFormers.tablero.colocable.robots.armas.Ataque;

abstract class StateSuperficie {

    void cambiarALlano(Superficie superficieActual){
        superficieActual.cambiarActual(new Llano());
    }
    void cambiarARocoso(Superficie superficieActual){
        superficieActual.cambiarActual(new Rocoso());
    }
    void cambiarAPantanoso(Superficie superficieActual){
        superficieActual.cambiarActual(new Pantanoso());
    }

    public abstract void recibirAtaque(Superficie superficieActual, Ataque ataque);
}
