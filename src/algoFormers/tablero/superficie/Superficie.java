package algoFormers.tablero.superficie;

import algoFormers.tablero.colocable.robots.armas.Ataque;

abstract class Superficie {

    void cambiarALlano(SuperficieConcretaActual superficieActual){
        superficieActual.cambiarActual(Llano.getInstance());
    }
    void cambiarARocoso(SuperficieConcretaActual superficieActual){
        superficieActual.cambiarActual(Rocoso.getInstance());
    }
    void cambiarAPantanoso(SuperficieConcretaActual superficieActual){
        superficieActual.cambiarActual(Pantanoso.getInstance());
    }

    public abstract void recibirAtaque(SuperficieConcretaActual superficieActual,Ataque ataque);
}
