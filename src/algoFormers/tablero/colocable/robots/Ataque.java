package algoFormers.tablero.colocable.robots;

import algoFormers.tablero.Atacable;

public interface Ataque {
	void atacar(Atacable target);
	int getDanio();

}
