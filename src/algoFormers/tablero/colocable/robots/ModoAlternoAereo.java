package algoFormers.tablero.colocable.robots;

import algoFormers.tablero.colocable.robots.armas.*;

public class ModoAlternoAereo extends EstadoAlgoFormer{
	public ModoAlternoAereo(int ataque, int distanciaDeAtaque, int velocidad){
		this.ataque = ataque;
		this.distanciaDeAtaque = distanciaDeAtaque;
		this.velocidad = velocidad;
	}
}
