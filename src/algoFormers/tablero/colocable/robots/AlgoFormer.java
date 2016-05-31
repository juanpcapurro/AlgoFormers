package algoFormers.tablero.colocable.robots;

import algoFormers.tablero.colocable.Colocable;

public class AlgoFormer extends Colocable {
	
	protected int ptosDeVida;
	/*Los siguientes deben diferenciarse entre alterno y */
	protected int distanciaDeAtaque;
	protected int ataque;
	protected int velocidad;


    public AlgoFormer(){

	}

	public boolean ocupaLugar(){
		return true;
	}

	public  boolean estaVivo(){return (this.ptosDeVida > 0);}

	public  void recibirAtaque(int ataque){ this.ptosDeVida -= ataque ;}

    public int getPuntosDeVida(){ return this.ptosDeVida;}
}

