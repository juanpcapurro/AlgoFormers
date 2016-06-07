package algoFormers.juego;

import java.util.ArrayList;
import java.util.List;

public class Turno {

    private int turno;
    private List<Jugador> jugadores;
    private int cantidadDeJugadores;

	public Turno( int cantJugadores) {
        this.cantidadDeJugadores=cantJugadores;
        jugadores=new ArrayList<>();
        turno=0;
    }
    
	Jugador obtenerProximoJugador() {
        return jugadores.get(turno++ % cantidadDeJugadores);
    }



    void agregarJugador(Jugador nuevoJugador){
        jugadores.add(nuevoJugador);
    }
}
