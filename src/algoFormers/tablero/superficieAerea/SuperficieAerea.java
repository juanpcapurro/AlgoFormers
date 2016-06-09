package algoFormers.tablero.superficieAerea;

import algoFormers.tablero.colocable.robots.armas.Ataque;
import algoFormers.tablero.superficie.Superficie;

public class SuperficieAerea extends Superficie {
	
	StateSuperficieAerea actual;

    public SuperficieAerea(){actual= new Nube();}

	@Override
	public void recibirAtaque(Ataque unAtaque) {
	}

}
