package algoFormers.tablero.colocable.robots;

import algoFormers.tablero.colocable.Colocable;
import algoFormers.tablero.colocable.robots.armas.*;
import algoFormers.tablero.superficie.Superficie;

public class AlgoFormer extends Colocable {
	protected ContextoModoAlgoformer modoActual;
	protected int ptosDeVida;
	Modificador modificadorDeEstado;

    public AlgoFormer(){
	}

	public boolean ocupaLugar(){
		return true;
	}
	public int getVelocidad(){
		return modoActual.getVelocidad();
	}
	public int getAtaque(){
		return modoActual.getAtaque();
	}
	public int getDistanciaDeAtaque(){
		return modoActual.getDistanciaDeAtaque();
	}
	public  boolean estaVivo(){return ptosDeVida>0;}
	public void cambiarModo(){
		modoActual.cambiarModo();
	}

    public int getPuntosDeVida(){ return ptosDeVida;}

	@Override
	public void recibirAtaque(Ataque unAtaque) {
		ptosDeVida-=(unAtaque.getDanio());
	}

	@Override
	public void pasarPor(Superficie superficieTerrestre,Superficie superficieAerea) {
		modoActual.pasarPor(superficieTerrestre, superficieAerea);
	}
	public void setModificadorDeEstado(Modificador modificador){
		modoActual.setModificador(modificador);
	}
}

