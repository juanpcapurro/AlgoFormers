
package algoFormers.juego;

import algoFormers.tablero.colocable.robot.equipos.EquipoDeAlgoFormers;

public class Jugador {



	public String nombreDeJugador;
	public EquipoDeAlgoFormers miEquipo;
	boolean esMiTurno;
	
	public Jugador(String nuevoNombre, EquipoDeAlgoFormers equipoElegido){
		this.nombreDeJugador = nuevoNombre;
		this.miEquipo = equipoElegido;
	}
	
	public boolean sigueEnJuego(){
		return (this.getMiEquipo().equipoSigueConVida());
	}
	
	public String getNombreDeJugador() {
		return this.nombreDeJugador;
	}

	public EquipoDeAlgoFormers getMiEquipo() {
		return (this.miEquipo);
	}

	public void esSuTurno(boolean b) {
		this.esMiTurno = b;
	}
	
	public boolean puedeJugar(){
		return this.esMiTurno;
	}
}
