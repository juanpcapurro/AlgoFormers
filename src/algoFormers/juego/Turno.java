package algoFormers.juego;

import java.util.ArrayList;
import java.util.List;

public class Turno {

    int turno;
    List<Jugador> jugadores;
    int cantidadDeJugadores;
    
	public Turno( int cantJugadores) {
        this.cantidadDeJugadores=cantJugadores;
        jugadores=new ArrayList<>();
    }
    
	public Jugador obtenerTurnoActual() {
        return jugadores.get(turno++ % cantidadDeJugadores);
    }



    public void agregarJugador(Jugador nuevoJugador){
        jugadores.add(nuevoJugador);
    }
}
