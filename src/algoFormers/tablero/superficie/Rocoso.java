package algoFormers.tablero.superficie;

import algoFormers.tablero.colocable.robots.armas.Ataque;


class Rocoso extends StateSuperficie {

	@Override
	public void recibirAtaque(Superficie superficieActual, Ataque unAtaque) {
	    superficieActual.cambiarActual(new Llano());
	}

}
