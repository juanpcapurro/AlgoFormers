package modelo.juego.turno;

import modelo.juego.jugador.Jugador;
import modelo.juego.Turno;

import modelo.juego.jugador.JugadorAutobots;
import modelo.juego.jugador.JugadorDecepticons;
import modelo.tablero.Tablero;
import modelo.tablero.colocable.robots.autobot.*;
import modelo.tablero.colocable.robots.decepticon.*;
import org.junit.Test;

public class  TurnoTest {

	Tablero tablero = new Tablero(8);
	private Jugador jugadorAutobots = new JugadorAutobots("Bonnie", tablero, new Bumblebee(), new Optimus(), new Ratchet());
	private Jugador jugadorDecepticons = new JugadorDecepticons("Clyde", tablero, new BoneCrusher(), new Frenzy(), new Megatron());
	private Turno turno = new Turno(jugadorAutobots, jugadorDecepticons);

	@Test
	public void dummy(){

	}

}
