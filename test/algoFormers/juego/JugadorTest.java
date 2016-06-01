package algoFormers.juego;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import algoFormers.tablero.colocable.robot.equipos.EquipoDeAutobots;
import algoFormers.tablero.colocable.robot.equipos.EquipoDeDecepticons;

public class JugadorTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test01JugadorSeCreaConNombreYEquipoDecepticonVivo() {
		Jugador miJugador = new Jugador("Barry",new EquipoDeDecepticons());
		assertEquals(miJugador.getNombreDeJugador(),"Barry");
		assertEquals(miJugador.getMiEquipo().getClass(),EquipoDeDecepticons.class);
		assertTrue(miJugador.sigueEnJuego());
	}

	@Test
	public void test02JugadorSeCreaConNombreYEquipoAutobotsVivo() {
		Jugador miJugador = new Jugador("Barry",new EquipoDeAutobots());
		assertEquals(miJugador.getNombreDeJugador(),"Barry");
		assertEquals(miJugador.getMiEquipo().getClass(),EquipoDeAutobots.class);
		assertTrue(miJugador.sigueEnJuego());
	}
	
	@Test
	public void test03JugadorMuereSiMuerenSusRobots() {
		Jugador miJugador = new Jugador("Barry",new EquipoDeAutobots());
		EquipoDeAutobots miEquipo = (EquipoDeAutobots) miJugador.getMiEquipo();
		/*Mato a mano los algoformers*/
		miEquipo.getMiBumblebee().recibirAtaque(350);
		miEquipo.getMiOptimus().recibirAtaque(500);
		miEquipo.getMiRatchet().recibirAtaque(150);
		
		assertFalse(miJugador.sigueEnJuego());
	}
	
	
}
