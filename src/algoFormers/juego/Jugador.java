
package algoFormers.juego;

import algoFormers.tablero.colocable.robots.AlgoFormer;

import java.util.ArrayList;
import java.util.List;

public class Jugador {



	private String nombreDeJugador;
	List<AlgoFormer> equipo;
	
	public Jugador(String nuevoNombre){
		this.nombreDeJugador = nuevoNombre;
		equipo= new ArrayList<>();
	}

	
	String getNombreDeJugador() {
		return this.nombreDeJugador;
	}


	public void agregarUnidad(AlgoFormer nuevoAlgoBot) {
		equipo.add(nuevoAlgoBot);
	}

	boolean equipovivo(){
		for (AlgoFormer algoformer : equipo)
			if (algoformer.estaVivo())
				return true;
		return false;
	}


}
