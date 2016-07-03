package modelo.tablero.colocable.robots;

import modelo.juego.DatosAlgoformer;
import modelo.tablero.colocable.Colocable;
import modelo.tablero.colocable.robots.armas.Ataque;
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

	public  boolean estaVivo(){return ptosDeVida.getVidaActual()>0;}

	public void transformar(){
		modoActual.cambiarModo();
	}

    public int getPuntosDeVida(){ return ptosDeVida.getVidaActual();}

	public int getPuntosDeVidaOriginal(){
		return ptosDeVida.getVidaOriginal();
	}
	protected void recibirAtaqueYaVerificado(Ataque unAtaque) {
		ptosDeVida.setVidaActual(ptosDeVida.getVidaActual()-unAtaque.getDanio());
	}

	@Override
	public void pasarPor(Superficie superficieTerrestre,Superficie superficieAerea) {
		modoActual.pasarPor(superficieTerrestre, superficieAerea);
	}

	public void recibirAtaque(Ataque unAtaque){
		recibirAtaqueYaVerificado(unAtaque);
	}
	@Override
	public void recibirColocable(Colocable colocableEnDestino){
		colocableEnDestino.afectarColocable(modoActual);
	}

	public abstract void atacar(Colocable unColocable);

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

	@Override
	public  ModoAlgoformer getEstado(){
		return modoActual.modoActual;
	}

	@Override
	public boolean retirar(){
		return ptosDeVida.getVidaActual()<=0;
	}

}
