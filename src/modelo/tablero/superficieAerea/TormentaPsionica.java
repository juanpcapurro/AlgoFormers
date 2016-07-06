package modelo.tablero.superficieAerea;

import modelo.tablero.colocable.robots.ModoAlgoformer;
import modelo.tablero.colocable.robots.armas.Ataque;
import modelo.tablero.colocable.robots.modificadores.DebuffTormenta;
import modelo.tablero.superficie.Superficie;

public class TormentaPsionica extends StateSuperficieAerea {

	public void recibirAtaque(Superficie superficieActual, Ataque ataque) {
	}


	@Override
	public void afectarUnidadTerrestre(ModoAlgoformer modoAlgoformer) {

	}

	@Override
	public void afectarUnidadAerea(ModoAlgoformer modoAlgoformer) {
		modoAlgoformer.afectarEstado(new DebuffTormenta());
	}

	@Override
	public void afectarUnidadHumanoide(ModoAlgoformer modoAlgoformer) {

	}
}
