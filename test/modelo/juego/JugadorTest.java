package modelo.juego;

import modelo.tablero.Tablero;
import modelo.tablero.colocable.robots.armas.Ataque;
import modelo.tablero.colocable.robots.decepticon.BoneCrusher;
import modelo.tablero.colocable.robots.decepticon.Frenzy;
import modelo.tablero.colocable.robots.decepticon.Megatron;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class JugadorTest {
	private Tablero tablero;
	private Jugador jugador;
	private BoneCrusher boneCrusher;
	private Frenzy frenzy;
	private Megatron megatron;

	@Before
	public void setUp(){
		tablero=new Tablero(8);
		boneCrusher = new BoneCrusher();
		frenzy = new Frenzy();
		megatron = new Megatron();
		jugador= new Jugador("Barry", tablero, boneCrusher, frenzy, megatron);
	}
	@Test
	public void elEquipoEstaVivoAlComenzar(){
		assertTrue(jugador.equipovivo());
	}
	@Test
	public void muereElEquipoAlMorirSusAlgoFormers(){
		boneCrusher.recibirAtaque(new Ataque(1000));
		frenzy.recibirAtaque(new Ataque(1000));
		megatron.recibirAtaque(new Ataque(1000));
		assertFalse(jugador.equipovivo());
	}
	@Test
	public void combinarTomaDosTurnos(){
		jugador.combinarAlgoformers();
		assertFalse(jugador.puedeJugar());
		jugador.notificar();
		assertFalse(jugador.puedeJugar());
		jugador.notificar();
		assertTrue(jugador.puedeJugar());
	}
}
