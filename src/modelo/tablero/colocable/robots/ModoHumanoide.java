package modelo.tablero.colocable.robots;

import modelo.tablero.superficie.Superficie;

public class ModoHumanoide extends ModoAlgoformer{

	public ModoHumanoide(Vida vida,int ataque, int distanciaDeAtaque, int velocidad) {
		super(vida,ataque, distanciaDeAtaque, velocidad);

	}

	@Override
	public void pasarPor(Superficie superficieTerrestre, Superficie superficieAerea) {
		superficieTerrestre.afectarUnidadTerrestre(this);
	}

	@Override
	public boolean esHumanoide() {
		return true;
	}

	@Override
	public boolean estaEnModoAlterno() {
		return false;
	}
}
	
