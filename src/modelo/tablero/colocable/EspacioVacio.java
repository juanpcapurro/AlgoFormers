package modelo.tablero.colocable;

import modelo.tablero.colocable.robots.ContextoModoAlgoformer;
import modelo.tablero.colocable.robots.armas.Ataque;
import modelo.tablero.superficie.Superficie;

public
class EspacioVacio extends Colocable{
	public boolean ocupaLugar(){
		return false;
	}

	@Override
	public void recibirColocable(Colocable colocableEndestino) {

	}
	@Override
	public void pasarPor(Superficie superficieTerrestre, Superficie superficieAerea){}

	@Override
	public void afectarColocable(ContextoModoAlgoformer modo) {

	}

	@Override
	public boolean esMovible() {
		return false;
	}


}
