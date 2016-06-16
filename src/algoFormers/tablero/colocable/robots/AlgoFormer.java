package algoFormers.tablero.colocable.robots;

import algoFormers.tablero.colocable.Colocable;
import algoFormers.tablero.colocable.robots.armas.Ataque;
import algoFormers.tablero.posiciones.Posicion;
import algoFormers.tablero.superficie.Superficie;

public abstract class AlgoFormer extends Colocable {
	protected ContextoModoAlgoformer modoActual;
	protected Vida ptosDeVida;


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
	public  boolean estaVivo(){return ptosDeVida.getVida()>0;}
	public void transformar(){
		modoActual.cambiarModo();
	}

    public int getPuntosDeVida(){ return ptosDeVida.getVida();}

	@Override
	public void recibirAtaque(Ataque unAtaque) {
		ptosDeVida.setVida(ptosDeVida.getVida()-unAtaque.getDanio());
	}

	@Override
	public void pasarPor(Superficie superficieTerrestre,Superficie superficieAerea) {
		modoActual.pasarPor(superficieTerrestre, superficieAerea);
	}

	public void atacar(Posicion posicionDestino){};

	public  void mover(Posicion posicionOrigen, Posicion posicionDestino){}


	public  void descombinar(){}

	public  boolean estaEnModoHumanoide(){
		return modoActual.esHumanoide();
	}


	public boolean estaEnModoAlterno(){
		return  modoActual.estaEnModoAlterno();
	}



}
