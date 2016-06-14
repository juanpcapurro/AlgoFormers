package algoFormers.tablero.colocable.robots;

import algoFormers.tablero.colocable.Colocable;
import algoFormers.tablero.colocable.robots.armas.*;

public class AlgoFormer extends Colocable {
	protected ContextoModoAlgoformer modoActual;
	protected int ptosDeVida;
	Modificador modificadorDeEstado;

    public AlgoFormer(){
	modificadorDeEstado=new Modificador();
	}

	public boolean ocupaLugar(){
		return true;
	}
	public int getVelocidad(){
		return modificadorDeEstado.ModificadorVelocidad(modoActual.verEstadoActual());
	}
	public int getAtaque(){
		return modificadorDeEstado.ModificadorAtaque(modoActual.verEstadoActual());
	}
	public int getDistanciaDeAtaque(){
		return modificadorDeEstado.ModificadorDistancia(modoActual.verEstadoActual());
	}
	public  boolean estaVivo(){return ptosDeVida>0;}
	public void cambiarModo(){
		modoActual.cambiarModo();
	}
	public void setModificadorDeEstado(Modificador modificador){
		modificador.setAfectado(this);
		modificadorDeEstado=modificador;
	}
    public int getPuntosDeVida(){ return ptosDeVida;}

	@Override
	public void recibirAtaque(Ataque unAtaque) {
		ptosDeVida-=(unAtaque.getDanio());
	}
}

