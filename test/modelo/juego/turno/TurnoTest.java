package modelo.juego.turno;

import modelo.juego.Jugador;
import modelo.juego.Turno;

import org.junit.Before;

public class  TurnoTest {
	
	private Jugador miJugador1;
	private Jugador miJugador2;
	private Turno turno;
	static final int CANTIDADJUGADORES=2;
	
	@Before
	public void setUp() throws Exception {
		this.miJugador1 = new Jugador("Barry");
		this.miJugador2 = new Jugador("Oliver");
		turno=new Turno(miJugador1, miJugador2);
	}


}
