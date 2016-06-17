package algoFormers.tablero.colocable;

import algoFormers.tablero.colocable.robots.ContextoModoAlgoformer;
import algoFormers.tablero.colocable.robots.armas.Ataque;
import algoFormers.tablero.superficie.Superficie;

public
class EspacioVacio extends Colocable{
	public boolean ocupaLugar(){
		return false;
	}

	@Override
	public void recibirColocable(Colocable colocableEndestino) {

	}

	@Override
	public void recibirAtaque(Ataque unAtaque) {

	}
	@Override
	public void pasarPor(Superficie superficieTerrestre, Superficie superficieAerea){}

	@Override
	public void afectarColocable(ContextoModoAlgoformer modo) {

	}


}
