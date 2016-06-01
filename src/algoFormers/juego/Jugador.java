
package algoFormers.juego;

import algoFormers.tablero.colocable.robot.equipos.EquipoDeAlgoFormers;

public class Jugador {



	public String nombreDeJugador;
	public EquipoDeAlgoFormers miEquipo;
	
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
}
