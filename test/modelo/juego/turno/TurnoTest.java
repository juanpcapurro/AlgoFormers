package modelo.juego.turno;

import modelo.juego.jugador.Jugador;
import modelo.juego.Turno;
import modelo.juego.jugador.JugadorAutobots;
import modelo.juego.jugador.JugadorDecepticons;
import modelo.tablero.Tablero;
import modelo.tablero.colocable.robots.autobot.*;
import modelo.tablero.colocable.robots.decepticon.*;

import modelo.tablero.posiciones.Posicion;
import org.junit.*;
import static org.junit.Assert.*;

public class  TurnoTest {

	Tablero tablero = new Tablero(8);
	private Jugador jugadorAutobots;
	private Jugador jugadorDecepticons;
	private Turno turno;

	@Before
	public void setUp(){
		tablero = new Tablero(8, true);//Tablero de debug, todo rocoso y nubes
		jugadorAutobots = new JugadorAutobots("Carlos", tablero, new Bumblebee(), new Optimus(), new Ratchet());
		jugadorDecepticons = new JugadorDecepticons("Saul", tablero, new BoneCrusher(), new Frenzy(), new Megatron());
		turno = new Turno(jugadorAutobots,jugadorDecepticons);
	}
	@Test
	public void losTurnosSePasan(){
		assertEquals(turno.jugadorActual(), jugadorAutobots);
		turno.avanzarTurno();
		assertEquals(turno.jugadorActual(), jugadorDecepticons);
		turno.avanzarTurno();
		assertEquals(turno.jugadorActual(), jugadorAutobots);
	}
	@Test
	public void combinarNoPermiteJugarPorDosTurnos()throws Exception{
		assertEquals(turno.jugadorActual(),jugadorAutobots);
		turno.jugadorActual().combinarODescombinar();
		assertEquals(turno.jugadorActual(),jugadorDecepticons);//pasa el turno solo
		turno.avanzarTurno();
		assertEquals(turno.jugadorActual(),jugadorDecepticons);
		turno.avanzarTurno();//Aca puede volver a jugar el otro
		assertEquals(turno.jugadorActual(), jugadorAutobots);
		turno.jugadorActual().combinarODescombinar();
		assertEquals(turno.jugadorActual(), jugadorDecepticons);
		turno.avanzarTurno();
		assertEquals(turno.jugadorActual(), jugadorDecepticons);
	}
}
