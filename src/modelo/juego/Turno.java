package modelo.juego;

import modelo.juego.jugador.Jugador;

import java.util.ArrayList;

public class Turno {

    private int turno;
    private ArrayList<Jugador> jugadores;
    private final int cantidadDeJugadores=2;

    public Turno(Jugador unJugador, Jugador otroJugador) {
        jugadores=new ArrayList<>();
        jugadores.add(unJugador);
        jugadores.add(otroJugador);
        turno=0;
    }
    
	public void avanzarTurno() {
        jugadorActual().notificar();
        turno++;
    }

    public Jugador jugadorActual(){
        Jugador jugadorActual = jugadores.get(turno % cantidadDeJugadores);
        while(!jugadorActual.puedeJugar()){
            jugadorActual.notificar();
            turno++;
            jugadorActual= jugadores.get(turno%cantidadDeJugadores);
        }
        return jugadorActual;
    }
}
