package modelo.juego;

import modelo.tablero.colocable.robots.decepticon.*;
import modelo.tablero.colocable.robots.autobot.*;
import modelo.tablero.colocable.robots.armas.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class JugadorTest {
	Jugador miJugador;
	static final String NOMBREJUGADOR="Barry";
	static final int VIDABUMBLEBEE=350;
	static final int VIDAOPTIMUS=500;
	static final int VIDARATCHET=150;
	static final int VIDABONECRUSHER=200;

	@Before
	public void setUp()  {
		miJugador=new Jugador(NOMBREJUGADOR);
	}

	
}
