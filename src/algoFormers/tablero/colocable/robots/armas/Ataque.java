package algoFormers.tablero.colocable.robots.armas;

import algoFormers.tablero.Atacable;

public interface Ataque {
	void atacar(Atacable target);
	public int getDanio();

}
