package algoFormers.tablero.colocable.robots;

public class ModoHumanoide extends ModoAlgoformer{

	public ModoHumanoide(int ataque, int distanciaDeAtaque, int velocidad) {
		super(ataque, distanciaDeAtaque, velocidad);
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
	
