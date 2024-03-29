package modelo.tablero.colocable.robots;

import modelo.tablero.superficie.Superficie;

public class ModoAlternoAereo extends ModoAlgoformer {

	public ModoAlternoAereo(Vida vida,int ataque, int distanciaDeAtaque, int velocidad) {
		super(vida,ataque, distanciaDeAtaque, velocidad);
	}

	@Override
	public void pasarPor(Superficie superficieTerrestre, Superficie superficieArea) {
		superficieTerrestre.afectarUnidadAerea(this);
		superficieArea.afectarUnidadAerea(this);
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
