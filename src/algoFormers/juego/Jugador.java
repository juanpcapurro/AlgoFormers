
package algoFormers.juego;

import algoFormers.tablero.colocable.robots.AlgoFormer;

import java.util.ArrayList;
import java.util.List;

public class Jugador {



	public String nombreDeJugador;
	boolean esMiTurno;
	List<AlgoFormer> equipo;
	
	public Jugador(String nuevoNombre){
		this.nombreDeJugador = nuevoNombre;
		equipo= new ArrayList<>();
	}

	
	public String getNombreDeJugador() {
		return this.nombreDeJugador;
	}


	public void agregarUnidad(AlgoFormer nuevoAlgoBot) {
		equipo.add(nuevoAlgoBot);
	}
	public boolean equipovivo(){
		for (AlgoFormer algoformer : equipo)
			if (algoformer.estaVivo())
				return true;
		return false;
	}
}
