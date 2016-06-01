package algoFormers.juego;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import algoFormers.tablero.colocable.robot.equipos.EquipoDeAutobots;
import algoFormers.tablero.colocable.robot.equipos.EquipoDeDecepticons;

public class TurnoTest {
	
	private Jugador miJugador1;
	private Jugador miJugador2;
	
	@Before
	public void setUp() throws Exception {
		this.miJugador1 = new Jugador("Barry",new EquipoDeAutobots());
		this.miJugador2 = new Jugador("Oliver",new EquipoDeDecepticons());
	}
	
	@Test
	public void test01TurnoArrancaEn1(){
		Turno miTurno = new Turno(this.miJugador1,this.miJugador2);
		assertEquals(miTurno.obtenerTurnoActual(),1);
	}
	
	@Test
	public void test02TurnoSeIncrementa(){
		Turno miTurno = new Turno(this.miJugador1,this.miJugador2);
		miTurno.avanzarTurno();
		assertEquals(miTurno.obtenerTurnoActual(),2);
	}
	
	@Test
	public void test03TurnoImparJuegaJugador1(){
		Turno miTurno = new Turno(this.miJugador1,this.miJugador2);
		miTurno.avanzarTurno(); /*Turno2*/
		miTurno.avanzarTurno(); /*Turno3*/
		assertTrue(this.miJugador1.puedeJugar());
		assertFalse(this.miJugador2.puedeJugar());
	}
	
	@Test
	public void test04TurnoParJuegaJugador2(){
		Turno miTurno = new Turno(this.miJugador1,this.miJugador2);
		miTurno.avanzarTurno(); /*Turno2*/
		assertTrue(this.miJugador2.puedeJugar());
		assertFalse(this.miJugador1.puedeJugar());
	}

}
