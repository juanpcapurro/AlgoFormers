
package modelo.juego;

import modelo.tablero.Tablero;
import modelo.tablero.colocable.Colocable;
import modelo.tablero.colocable.robots.AlgoFormer;
import modelo.tablero.posiciones.Posicion;

import java.util.ArrayList;

public class Jugador {

	private String nombreDeJugador;
	private Tablero tablero;
	private ArrayList<AlgoFormer> robotsJugador = new ArrayList<AlgoFormer>();
	public Jugador(String nuevoNombre, Tablero tablero, AlgoFormer unAlgoformer, AlgoFormer otroAlgoformer, AlgoFormer tercerAlgoformer){
		this.tablero= tablero;
		this.nombreDeJugador = nuevoNombre;
		robotsJugador.add(unAlgoformer);
		robotsJugador.add(otroAlgoformer);
		robotsJugador.add(tercerAlgoformer);
	}

	DatosJugador getDatosJugador() {
        ArrayList<DatosAlgoformer> listaDatos = new ArrayList<DatosAlgoformer>();
        for(AlgoFormer actual: robotsJugador)
            listaDatos.add(actual.obtenerDatosAlgoformer());
        return new DatosJugador(nombreDeJugador, listaDatos);
	}

	boolean equipovivo(){
		for (AlgoFormer unAlgoformer: robotsJugador)
			if(unAlgoformer.estaVivo())
				return true;
		return false;
	}

	public void combinarAlgoformers() {

	}

	public void transformar() {

	}

	public void mover(Posicion posicionOrigen, Posicion posicionDestino) {

	}

	public void notificar() {
		for (AlgoFormer actual: robotsJugador)
			actual.notificar();
	}

	private boolean esAlgoformerPropio(Colocable unColocable){
		for(AlgoFormer actual: robotsJugador)
			if(actual.equals(unColocable))
				return true;
		return false;
	}

    public boolean puedeJugar(){
        return true;
    }
}
