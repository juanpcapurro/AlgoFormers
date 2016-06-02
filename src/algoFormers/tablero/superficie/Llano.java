package algoFormers.tablero.superficie;

import algoFormers.tablero.colocable.robots.Ataque;

class Llano extends Superficie {
    private static Llano ourInstance = new Llano();

    public static Llano getInstance() {
        return ourInstance;
    }

    private Llano() {
    }

    @Override
    public void recibirAtaque(SuperficieConcretaActual superficieActual, Ataque ataque) {
    }


}
