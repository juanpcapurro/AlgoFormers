package algoFormers.tablero.superficieTerrestre;

import algoFormers.tablero.colocable.robots.Modificador;
import algoFormers.tablero.colocable.robots.ModoAlgoformer;
import algoFormers.tablero.colocable.robots.armas.Ataque;

class Espinas extends StateSuperficieTerrestre {

	public void recibirAtaque(StateSuperficieTerrestre superficieActual, Ataque ataque) {
	}


	@Override
	public void afectarUnidadTerrestre(ModoAlgoformer modoAlgoformer) {
		Modificador modificador=new Modificador(3);
		modificador.setModificadorVida(5);
		modoAlgoformer.setModificador(modificador);
	}

	@Override
	public void afectarUnidadAerea(ModoAlgoformer modoAlgoformer) {
		Modificador modificador=new Modificador(3);
		modificador.setModificadorVida(5);
		modoAlgoformer.setModificador(modificador);
	}
}
