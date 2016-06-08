package algoFormers.tablero.colocable.robots;

import algoFormers.tablero.colocable.robots.armas.*;

public class ModoAlternoTerrestre extends EstadoAlgoFormer{
	public ModoAlternoTerrestre(int ataque, int distanciaDeAtaque, int velocidad){
		this.ataque = ataque;
		this.distanciaDeAtaque = distanciaDeAtaque;
		this.velocidad = velocidad;
	}
}
