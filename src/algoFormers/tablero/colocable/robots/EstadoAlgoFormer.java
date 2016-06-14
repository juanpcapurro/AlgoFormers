package algoFormers.tablero.colocable.robots;

public  class EstadoAlgoFormer extends AlgoFormer{
	protected int velocidad;
	protected int distanciaDeAtaque;
	protected int ataque;

	EstadoAlgoFormer(int unAtaque, int unaDistancia, int unaVelocidad){
		ataque=unAtaque;
		velocidad=unaVelocidad;
		distanciaDeAtaque=unaDistancia;
	}

	public int getVelocidad(){
		return velocidad;
	}
	public int getAtaque(){
		return ataque;
	}
	public int getDistanciaDeAtaque(){
		return distanciaDeAtaque;
	}






}
