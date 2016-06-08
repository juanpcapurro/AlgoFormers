package algoFormers.tablero.colocable.robots;

import algoFormers.tablero.colocable.robots.armas.*;

public abstract class EstadoAlgoFormer extends AlgoFormer{
	protected int velocidad;
	protected int distanciaDeAtaque;
	protected int ataque;
	
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
