package modelo.juego;

import modelo.tablero.Tablero;
import modelo.tablero.colocable.robots.armas.Ataque;
import modelo.tablero.colocable.robots.autobot.Bumblebee;
import modelo.tablero.colocable.robots.autobot.Optimus;
import modelo.tablero.colocable.robots.autobot.Ratchet;
import modelo.tablero.colocable.robots.decepticon.BoneCrusher;
import modelo.tablero.colocable.robots.decepticon.Frenzy;
import modelo.tablero.colocable.robots.decepticon.Megatron;
import modelo.tablero.posiciones.Posicion;
import org.junit.Before;
import org.junit.Test;
import org.mockito.cglib.beans.BulkBean;

import static org.junit.Assert.*;

public class JugadorTest {
	private Tablero tablero;

	private Jugador jugadorDecepticons;
	private BoneCrusher boneCrusher;
	private Frenzy frenzy;
	private Megatron megatron;
	private Posicion posicionBoneCrusher;
	private Posicion posicionFrenzy;
	private Posicion posicionMegatron;

	private Jugador jugadorAutobots;
	private Ratchet ratchet;
	private Optimus optimus;
	private Bumblebee bumblebee;
	private Posicion posicionRatchet;
	private Posicion posicionBumblebee;
	private Posicion posicionOptimus;

	@Before
	public void setUp(){
		tablero=new Tablero(8);
		boneCrusher = new BoneCrusher();
		frenzy = new Frenzy();
		megatron = new Megatron();
		jugadorDecepticons= new Jugador("Barry", tablero, boneCrusher, frenzy, megatron);
		posicionBoneCrusher = tablero.obtenerPosicionAsociadaAColocable(boneCrusher);
		posicionFrenzy = tablero.obtenerPosicionAsociadaAColocable(frenzy);
		posicionMegatron = tablero.obtenerPosicionAsociadaAColocable(megatron);

		bumblebee = new Bumblebee();
		ratchet = new Ratchet();
		optimus = new Optimus();
		jugadorAutobots = new Jugador("Jorge", tablero, bumblebee, optimus, ratchet);
		posicionBumblebee = tablero.obtenerPosicionAsociadaAColocable(bumblebee);
		posicionOptimus = tablero.obtenerPosicionAsociadaAColocable(optimus);
		posicionRatchet = tablero.obtenerPosicionAsociadaAColocable(ratchet);
	}

	@Test
	public void elEquipoEstaVivoAlComenzar(){
		assertTrue(jugadorDecepticons.equipovivo());
	}
	@Test
	public void muereElEquipoAlMorirSusAlgoFormersAtacandolosDirectamente(){
		boneCrusher.recibirAtaque(new Ataque(1000));
		frenzy.recibirAtaque(new Ataque(1000));
		megatron.recibirAtaque(new Ataque(1000));
		assertFalse(jugadorDecepticons.equipovivo());
	}
	@Test
	public void muereElEquipoAlAtacarLasPosicionesDeLosAlgoformers(){
		assertTrue(jugadorAutobots.equipovivo());//Falta terminar este test
	}
	@Test
	public void combinarTomaDosTurnos(){
		jugadorDecepticons.combinarODescombinar();
		assertFalse(jugadorDecepticons.puedeJugar());
		jugadorDecepticons.notificar();
		assertFalse(jugadorDecepticons.puedeJugar());
		jugadorDecepticons.notificar();
		assertTrue(jugadorDecepticons.puedeJugar());
	}
}
