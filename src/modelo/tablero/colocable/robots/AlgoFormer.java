package modelo.tablero.colocable.robots;

import modelo.juego.DatosAlgoformer;
import modelo.tablero.colocable.Colocable;
import modelo.tablero.colocable.robots.armas.Ataque;
import modelo.tablero.posiciones.Posicion;
import modelo.tablero.superficie.Superficie;

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

	@Override
	public void recibirColocable(Colocable colocableEnDestino){
		colocableEnDestino.afectarColocable(modoActual);
	}

	public void atacar(Posicion posicionDestino){};

	public  void descombinar(){}

	public  boolean estaEnModoHumanoide(){
		return modoActual.esHumanoide();
	}

	public boolean estaEnModoAlterno(){
		return  modoActual.estaEnModoAlterno();
	}

	public void notificar(){
		modoActual.notificar();
	}
	public DatosAlgoformer obtenerDatosAlgoformer(){
		return new DatosAlgoformer(getPuntosDeVida(), this.getClass().getSimpleName());//paja hacerlo polimorfico con un literal
	}
	@Override
	public void afectarColocable(ContextoModoAlgoformer modo){
		
	}

	@Override
	public boolean esMovible() {
		return modoActual.tieneMovimientosDisponibles();
	}
}
