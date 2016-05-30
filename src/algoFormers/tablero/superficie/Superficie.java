package algoFormers.tablero.superficie;

import algoFormers.tablero.Atacable;

public abstract class Superficie implements Atacable {

    public abstract void cambiarALlano(SuperficieConcretaActual superficieActual);
    public abstract void cambiarARocoso(SuperficieConcretaActual superficieActual);
    public abstract void cambiarAPantanoso(SuperficieConcretaActual superficieActual);

}
