package algoFormers.tablero.superficieAerea;

import algoFormers.tablero.colocable.robots.armas.Ataque;
import algoFormers.tablero.superficie.StateSuperficie;
import algoFormers.tablero.superficie.Superficie;

abstract class StateSuperficieAerea extends StateSuperficie{

	    public abstract void recibirAtaque(Superficie superficieActual, Ataque ataque);	

}
