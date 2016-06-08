package algoFormers.tablero.colocable.robots;

import algoFormers.tablero.colocable.Colocable;
import algoFormers.tablero.colocable.robots.armas.*;

public class AlgoFormer extends Colocable {
	protected int ptosDeVida;
	protected EstadoAlgoFormer estadoActual;

    public AlgoFormer(){

	}
	public boolean ocupaLugar(){
		return true;
	}
	public int getVelocidad(){
		return estadoActual.velocidad;
	}
	public int getAtaque(){
		return estadoActual.getAtaque();
	}
	public int getDistanciaDeAtaque(){
		return estadoActual.getDistanciaDeAtaque();
	}
	public  boolean estaVivo(){return (this.ptosDeVida > 0);}

    public int getPuntosDeVida(){ return this.ptosDeVida;}

	@Override
	public void recibirAtaque(Ataque unAtaque) {
		ptosDeVida-= unAtaque.getDanio();
	}
}

