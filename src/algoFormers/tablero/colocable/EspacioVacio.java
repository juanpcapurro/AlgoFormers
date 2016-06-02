package algoFormers.tablero.colocable;

import algoFormers.tablero.colocable.robots.Ataque;

public class EspacioVacio extends Colocable{
	public boolean ocupaLugar(){
		return false;
	}

	@Override
	public void recibirAtaque(Ataque unAtaque) {

	}
}
