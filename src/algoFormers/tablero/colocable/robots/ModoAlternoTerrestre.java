package algoFormers.tablero.colocable.robots;

import algoFormers.tablero.superficie.Superficie;

public class ModoAlternoTerrestre extends ModoAlgoformer{

	public ModoAlternoTerrestre(Vida vida,int ataque, int distanciaDeAtaque, int velocidad) {
		super(vida,ataque, distanciaDeAtaque, velocidad);

	}

	@Override
	public void pasarPor(Superficie superficieTerrestre, Superficie superficieAerea) {
		superficieTerrestre.afectarUnidadTerrestre(this);
	}

	@Override
	public boolean esHumanoide() {
		return false;
	}

	@Override
	public boolean estaEnModoAlterno() {
		return true;
	}
}
