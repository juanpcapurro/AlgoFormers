package algoFormers.tablero.superficie;

import algoFormers.tablero.colocable.robots.Ataque;

class Pantanoso extends Superficie{
    private static Pantanoso ourInstance = new Pantanoso();

    public static Pantanoso getInstance() {
        return ourInstance;
    }

    private Pantanoso() {
    }

    @Override
    public void recibirAtaque(SuperficieConcretaActual superficieActual, Ataque ataque) {
    }

}
