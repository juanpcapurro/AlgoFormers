package algoFormers.tablero.colocable.robots;

import algoFormers.tablero.superficie.Superficie;

public class ModoAlternoTerrestre extends ModoAlgoformer{

	public ModoAlternoTerrestre(int ataque, int distanciaDeAtaque, int velocidad) {
		super(ataque, distanciaDeAtaque, velocidad);

	}

	@Override
	public void pasarPor(Superficie superficieTerrestre, Superficie superficieAerea) {
		superficieTerrestre.afectarUnidadTerrestre(this);
	}
}
