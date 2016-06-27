package modelo.juego;

import modelo.tablero.Tablero;
import modelo.tablero.colocable.robots.decepticon.BoneCrusher;
import modelo.tablero.colocable.robots.decepticon.Frenzy;
import modelo.tablero.colocable.robots.decepticon.Megatron;
import org.junit.Test;

import static org.junit.Assert.*;

public class JugadorTest {
	private Tablero tablero=new Tablero(8);
	private Jugador jugador= new Jugador("Barry", tablero, new BoneCrusher(), new Frenzy(), new Megatron());

	@Test
	public void elEquipoEstaVivoAlComenzar(){
		assertTrue(jugador.equipovivo());
	}
}
