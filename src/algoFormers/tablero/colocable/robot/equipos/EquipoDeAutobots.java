package algoFormers.tablero.colocable.robot.equipos;

import algoFormers.tablero.colocable.Superion;
import algoFormers.tablero.colocable.robots.Bumblebee;
import algoFormers.tablero.colocable.robots.Optimus;
import algoFormers.tablero.colocable.robots.Ratchet;

public class EquipoDeAutobots extends EquipoDeAlgoFormers {
	
	public Optimus miOptimus;
	public Ratchet miRatchet;
	public Bumblebee miBumblebee;
	public Superion miSuperion;
	


	
	public EquipoDeAutobots(){
		super();
		this.miOptimus = new Optimus() ;
		this.miRatchet = new Ratchet() ;
		this.miBumblebee = new Bumblebee() ;
		this.miSuperion = null;
	}

	@Override
	public boolean equipoSigueConVida() {
		return (this.miOptimus.estaVivo() || this.miBumblebee.estaVivo() || this.miRatchet.estaVivo());
	}
	
	public void activarModoCombinado(){
		this.estadoCombinadoActivado = true;
		this.miSuperion = new Superion(this.miOptimus, this.miBumblebee, this.miRatchet);
	}
	
	public void desactivarModoCombinado(){
		this.estadoCombinadoActivado = false;
		this.miSuperion = null;
	}
	
	public Optimus getMiOptimus() {
		return miOptimus;
	}

	public Ratchet getMiRatchet() {
		return this.miRatchet;
	}

	public Bumblebee getMiBumblebee() {
		return this.miBumblebee;
	}

	public Superion getSuperion() {
		return this.miSuperion;
	}
	
	
}
