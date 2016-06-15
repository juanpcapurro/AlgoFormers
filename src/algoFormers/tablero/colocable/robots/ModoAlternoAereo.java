package algoFormers.tablero.colocable.robots;

public class ModoAlternoAereo extends ModoAlgoformer {

	public ModoAlternoAereo(int ataque, int distanciaDeAtaque, int velocidad) {
		super(ataque, distanciaDeAtaque, velocidad);
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
