package modelo.juego;

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
        notificarJugadores();
        turno++;
    }

    private void notificarJugadores(){
        for (Jugador jugador : jugadores)
            jugador.notificar();
    }

    public Jugador jugadorActual(){
        Jugador jugadorActual = jugadores.get(turno % cantidadDeJugadores);
        while(!jugadorActual.puedeJugar())
            avanzarTurno();
        return jugadorActual;
    }
}
