package modelo.tablero.superficieAerea;

import modelo.tablero.colocable.robots.armas.Ataque;
import modelo.tablero.superficie.Superficie;

abstract class StateSuperficieAerea extends Superficie {

	public void recibirAtaque(Ataque unAtaque) {}

}
