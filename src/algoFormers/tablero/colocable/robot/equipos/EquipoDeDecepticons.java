package algoFormers.tablero.colocable.robot.equipos;

import algoFormers.tablero.colocable.Menasor;
import algoFormers.tablero.colocable.Superion;
import algoFormers.tablero.colocable.robots.BoneCrusher;

import algoFormers.tablero.colocable.robots.Frenzy;
import algoFormers.tablero.colocable.robots.Megatron;


public class EquipoDeDecepticons extends EquipoDeAlgoFormers {

	public Megatron miMegatron;
	public Frenzy miFrenzy;
	public BoneCrusher miBonecrusher;
	public Menasor miMenasor;
	
	public Megatron getMiMegatron() {
		return this.miMegatron;
	}

	public Frenzy getMiFrenzy() {
		return this.miFrenzy;
	}

	public BoneCrusher getMiBonecrusher() {
		return this.miBonecrusher;
	}
	
	public EquipoDeDecepticons(){
		super();
		this.miMegatron = new Megatron() ;
		this.miFrenzy= new Frenzy() ;
		this.miBonecrusher = new BoneCrusher() ;
	}
	
	@Override
	public boolean equipoSigueConVida() {
		return (this.miMegatron.estaVivo() || this.miFrenzy.estaVivo() || this.miBonecrusher.estaVivo());
	}

	@Override
	public void activarModoCombinado() {
		this.estadoCombinadoActivado = true;
		this.miMenasor = new Menasor(this.miMegatron, this.miBonecrusher, this.miFrenzy);
	}
	
	public void desactivarModoCombinado(){
		this.estadoCombinadoActivado = false;
		this.miMenasor = null;
	}
	
	public Menasor getMenasor() {
		return this.miMenasor;
	}

}
