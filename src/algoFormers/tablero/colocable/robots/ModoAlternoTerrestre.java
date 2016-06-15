package algoFormers.tablero.colocable.robots;

public class ModoAlternoTerrestre extends ModoAlgoformer{

	public ModoAlternoTerrestre(int ataque, int distanciaDeAtaque, int velocidad) {
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
