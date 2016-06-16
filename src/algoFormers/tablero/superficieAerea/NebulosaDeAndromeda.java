package algoFormers.tablero.superficieAerea;

import algoFormers.tablero.colocable.robots.ModoAlgoformer;
import algoFormers.tablero.colocable.robots.armas.Ataque;
import algoFormers.tablero.colocable.robots.modificadores.DebuffNebulosa;
import algoFormers.tablero.superficie.Superficie;

class NebulosaDeAndromeda extends StateSuperficieAerea {

	public void recibirAtaque(Superficie superficieActual, Ataque ataque) {
	}

	@Override
	public void afectarUnidadTerrestre(ModoAlgoformer modoAlgoformer) {

	}

	@Override
	public void afectarUnidadAerea(ModoAlgoformer modoAlgoformer) {
		modoAlgoformer.afectarEstado(new DebuffNebulosa());
	}
}
