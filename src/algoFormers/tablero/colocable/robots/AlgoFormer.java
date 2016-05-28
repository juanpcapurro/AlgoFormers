package algoFormers.tablero.colocable.robots;

import algoFormers.tablero.colocable.Colocable;

public class AlgoFormer extends Colocable{
	protected int ptosDeVida;

	public AlgoFormer(){

	}

	public boolean ocupaLugar(){
		return true;
	}

	public  boolean estaVivo(){return (this.ptosDeVida > 0);}

	public  void recibirAtaque(int ataque){ this.ptosDeVida -= ataque ;}
}

