package modelo.tablero.colocable.robots;

import modelo.juego.DatosAlgoformer;
import modelo.tablero.colocable.Colocable;
import modelo.tablero.colocable.robots.armas.Ataque;
import modelo.tablero.superficie.Superficie;

public abstract class AlgoFormer extends Colocable {
	protected ContextoModoAlgoformer contextoModoActual;
	protected Vida ptosDeVida;

	public boolean ocupaLugar(){
		return true;
	}

	public int getVelocidad(){
		return contextoModoActual.getVelocidad();
	}
	public int getAtaque(){
		return contextoModoActual.getAtaque();
	}

	public int getDistanciaDeAtaque(){
		return contextoModoActual.getDistanciaDeAtaque();
	}

	public  boolean estaVivo(){return ptosDeVida.getVidaActual()>0;}

	public void transformar() throws NoPuedeTransformarsePorSerCombinado {
		contextoModoActual.cambiarModo();
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
		contextoModoActual.pasarPor(superficieTerrestre, superficieAerea);
	}

	public void recibirAtaque(Ataque unAtaque){
		recibirAtaqueYaVerificado(unAtaque);
	}
	@Override
	public void recibirColocable(Colocable colocableEnDestino){
		colocableEnDestino.afectarColocable(contextoModoActual);
	}

	public abstract void atacar(Colocable unColocable);
	public boolean consultarMovimientosDisponibles(){
		return contextoModoActual.consultarMovimientoDisponibles();
	}
	public void notificar(){
		contextoModoActual.notificar();
	}

	public DatosAlgoformer obtenerDatosAlgoformer(){
		return new DatosAlgoformer(getPuntosDeVida(), this.getClass().getSimpleName(),this.getModo().getClass().getSimpleName());//paja hacerlo polimorfico con un literal
	}
	@Override
	public void afectarColocable(ContextoModoAlgoformer modo){
		
	}

	@Override
	public boolean esMovible() throws  ObjetoInmovible{
		return contextoModoActual.tieneMovimientosDisponibles();
	}

	@Override
	public  ModoAlgoformer getModo(){
		return contextoModoActual.actual;
	}

	private void setModoDefeated(){
		if(contextoModoActual.esHumanoide())
			contextoModoActual.setActual(new DefeatedMode());
		else contextoModoActual.setActual(new ModoAlternoDefeatedMode());
	}
	@Override
	public boolean retirar(){
		if(ptosDeVida.getVidaActual()<=0) {
			setModoDefeated();
			return true;
		}
		return false;
	}

}
