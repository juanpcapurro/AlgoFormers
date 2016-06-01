package algoFormers.tablero.colocable.robot.equipos;

public abstract class EquipoDeAlgoFormers {
	

	boolean estadoCombinadoActivado;
	
	public EquipoDeAlgoFormers(){

		this.estadoCombinadoActivado = false;
	}
	
	public abstract boolean equipoSigueConVida();
	
	public abstract void activarModoCombinado();
	public abstract void desactivarModoCombinado();
	
	
	public boolean estaEnModoCombinado(){
		return (this.estadoCombinadoActivado);
	}

}
