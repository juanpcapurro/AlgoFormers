package algoFormers.juego;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TurnoTest {
	
	private Jugador miJugador1;
	private Jugador miJugador2;
	private Turno turno;
	static final int CANTIDADJUGADORES=2;
	
	@Before
	public void setUp() throws Exception {
		this.miJugador1 = new Jugador("Barry");
		this.miJugador2 = new Jugador("Oliver");
		turno=new Turno(CANTIDADJUGADORES);
		turno.agregarJugador(miJugador1);
		turno.agregarJugador(miJugador2);
	}
	
	@Test
	public void test01TurnoArrancaEn1(){
		assertEquals(turno.obtenerTurnoActual(),miJugador1);
	}
	
	@Test
	public void test02TurnoSeIncrementa(){
		turno.obtenerTurnoActual();
		assertEquals(turno.obtenerTurnoActual(),miJugador2);

	}
	@Test
	public void test03TercerTurnoEsDelPrimeroJugador(){
		turno.obtenerTurnoActual();
		turno.obtenerTurnoActual();
		assertEquals(turno.obtenerTurnoActual(),miJugador1);
	}
	@Test
	public void test04CuartoTurnoEsDelSegundoJugador(){
		turno.obtenerTurnoActual();
		turno.obtenerTurnoActual();
		turno.obtenerTurnoActual();
		assertEquals(turno.obtenerTurnoActual(),miJugador2);
	}

}
