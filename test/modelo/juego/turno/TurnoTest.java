package modelo.juego.turno;

import modelo.juego.Jugador;
import modelo.juego.Turno;

import modelo.tablero.Tablero;
import modelo.tablero.colocable.robots.autobot.*;
import modelo.tablero.colocable.robots.decepticon.*;
import org.junit.Test;

public class  TurnoTest {

	Tablero tablero = new Tablero(8);
	private Jugador jugadorAutobots = new Jugador("Bonnie", tablero, new Bumblebee(), new Optimus(), new Ratchet());
	private Jugador jugadorDecepticons = new Jugador("Clyde", tablero, new BoneCrusher(), new Frenzy(), new Megatron());
	private Turno turno = new Turno(jugadorAutobots, jugadorDecepticons);

	@Test
	public void dummy(){

	}

}
