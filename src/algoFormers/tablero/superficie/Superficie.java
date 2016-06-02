package algoFormers.tablero.superficie;

import algoFormers.tablero.colocable.robots.Ataque;

public abstract class Superficie {

    public abstract void cambiarALlano(SuperficieConcretaActual superficieActual);
    public abstract void cambiarARocoso(SuperficieConcretaActual superficieActual);
    public abstract void cambiarAPantanoso(SuperficieConcretaActual superficieActual);
    public abstract void recibirAtaque(SuperficieConcretaActual superficieActual,Ataque ataque);
}
