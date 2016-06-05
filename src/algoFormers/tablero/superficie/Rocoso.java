package algoFormers.tablero.superficie;

import algoFormers.tablero.colocable.robots.armas.Ataque;


class Rocoso extends Superficie{
    private static Rocoso ourInstance = new Rocoso();

    public static Rocoso getInstance() {
        return ourInstance;
    }

    private Rocoso() {
    }

	@Override
	public void recibirAtaque(SuperficieConcretaActual superficieActual,Ataque unAtaque) {
	    superficieActual.cambiarActual(Llano.getInstance());
	}

}
