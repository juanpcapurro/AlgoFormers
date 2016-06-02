package algoFormers.tablero.superficie;

import algoFormers.tablero.colocable.robots.Ataque;

/**
 * Created by Charly on 5/29/16.
 */
public class Pantanoso extends Superficie{
    private static Pantanoso ourInstance = new Pantanoso();

    public static Pantanoso getInstance() {
        return ourInstance;
    }

    private Pantanoso() {
    }

    @Override
    public void cambiarALlano(SuperficieConcretaActual superficieActual){
        superficieActual.cambiarActual(Llano.getInstance());
    }

    @Override
    public void cambiarARocoso(SuperficieConcretaActual superficieActual) {
        superficieActual.cambiarActual(Rocoso.getInstance());
    }

    @Override
    public void cambiarAPantanoso(SuperficieConcretaActual superficieActual) {
    }

    @Override
    public void recibirAtaque(SuperficieConcretaActual superficieActual, Ataque ataque) {
    }

}
