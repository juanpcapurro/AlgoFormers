package modelo.juego;

import modelo.juego.jugador.*;
import modelo.tablero.SinMovimientosDisponibles;
import modelo.tablero.Tablero;
import modelo.tablero.colocable.robots.NoPuedeTransformarsePorSerCombinado;
import modelo.tablero.colocable.robots.ObjetoInmovible;
import modelo.tablero.colocable.robots.armas.Ataque;
import modelo.tablero.colocable.robots.autobot.Bumblebee;
import modelo.tablero.colocable.robots.autobot.Optimus;
import modelo.tablero.colocable.robots.autobot.Ratchet;
import modelo.tablero.colocable.robots.decepticon.BoneCrusher;
import modelo.tablero.colocable.robots.decepticon.Frenzy;
import modelo.tablero.colocable.robots.decepticon.Megatron;
import modelo.tablero.posiciones.Posicion;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

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
		tablero=new Tablero(8, true);
		boneCrusher = new BoneCrusher();
		frenzy = new Frenzy();
		megatron = new Megatron();
		jugadorDecepticons= new JugadorDecepticons("Barry", tablero, boneCrusher, frenzy, megatron);
		posicionBoneCrusher = tablero.obtenerPosicionAsociadaAColocable(boneCrusher);
		posicionFrenzy = tablero.obtenerPosicionAsociadaAColocable(frenzy);
		posicionMegatron = tablero.obtenerPosicionAsociadaAColocable(megatron);

		bumblebee = new Bumblebee();
		ratchet = new Ratchet();
		optimus = new Optimus();
		jugadorAutobots = new JugadorAutobots("Jorge", tablero, bumblebee, optimus, ratchet);
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
	public void muereElEquipoAlAtacarLasPosicionesDeLosAlgoformers()throws Exception{
		assertTrue(jugadorAutobots.equipovivo());
		assertTrue(posicionFrenzy.compararPosicion(new Posicion(0, 6)));
		jugadorDecepticons.transformar(posicionFrenzy);
		jugadorDecepticons.mover(posicionFrenzy, new Posicion(1, 6));//Para que pueda atacar a todos los enemigos
		jugadorDecepticons.mover(new Posicion(1, 6), new Posicion(1, 5));
		jugadorDecepticons.mover(new Posicion(1, 5), new Posicion(1, 4));
		jugadorDecepticons.mover(new Posicion(1, 4), new Posicion(0, 4));
		posicionFrenzy = tablero.obtenerPosicionAsociadaAColocable(frenzy);
		assertTrue(posicionFrenzy.compararPosicion(new Posicion(0, 4)));
		jugadorDecepticons.notificar();
		jugadorDecepticons.transformar(posicionFrenzy);
		for (int i = 0; i < 150; i++) {
			jugadorDecepticons.atacar(posicionFrenzy, posicionBumblebee);
		}

		assertTrue(jugadorAutobots.equipovivo());
		for (int i = 0; i < 150; i++) {
			jugadorDecepticons.atacar(posicionFrenzy, posicionOptimus);
		}
		assertTrue(jugadorAutobots.equipovivo());

		for (int i = 0; i < 150; i++) {
			jugadorDecepticons.atacar(posicionFrenzy, posicionRatchet);
		}
		assertFalse(jugadorAutobots.equipovivo());
	}
	@Test(expected= NoEsAlgoFormerPropio.class)
	public void unJugadorNoPuedeAtacarConAlgoFormersAjenos() throws Exception{
		jugadorDecepticons.atacar(posicionBumblebee, posicionOptimus);
		jugadorDecepticons.atacar(posicionOptimus, posicionRatchet);
		jugadorDecepticons.atacar(posicionRatchet, posicionBumblebee);
	}
	@Test(expected= NoEsAlgoFormerPropio.class)
	public void unJugadorNoPuedeMoverAlgoFormersAjenos()throws Exception{
		jugadorDecepticons.mover(posicionBumblebee,posicionOptimus);
		jugadorDecepticons.mover(posicionOptimus,posicionRatchet);
		jugadorDecepticons.mover(posicionRatchet, posicionBumblebee);
	}
	@Test(expected= NoEsAlgoFormerPropio.class)
	public void unJugadorNoPuedeTransformarAlgoformersAjenos()throws  ObjetoInmovible, NoEsAlgoFormerPropio, YaInicioMovimiento, NoPuedeTransformarsePorSerCombinado{
		jugadorAutobots.transformar(posicionBoneCrusher);
		jugadorAutobots.transformar(posicionFrenzy);
		jugadorAutobots.transformar(posicionMegatron);
	}
	@Test
	public void combinarYDescombinarTomaDosTurnos() throws Exception{
		jugadorDecepticons.combinarODescombinar();//Pasar de descombinado a combinado
		assertFalse(jugadorDecepticons.puedeJugar());
		jugadorDecepticons.notificar();
		assertFalse(jugadorDecepticons.puedeJugar());
		jugadorDecepticons.notificar();
		assertTrue(jugadorDecepticons.puedeJugar());

		Posicion posicionMenasor=posicionBoneCrusher;//Queda en la posicion del algoformer que se le paso primero
		assertTrue(tablero.estaOcupadoEnPosicion(posicionMenasor));
		assertFalse(tablero.estaOcupadoEnPosicion(posicionFrenzy));
		assertFalse(tablero.estaOcupadoEnPosicion(posicionMegatron));

		jugadorDecepticons.combinarODescombinar();//Pasar de combinado a descombinado
		assertFalse(jugadorDecepticons.puedeJugar());
		jugadorDecepticons.notificar();
		assertFalse(jugadorDecepticons.puedeJugar());
		jugadorDecepticons.notificar();
		assertTrue(jugadorDecepticons.puedeJugar());
	}
	@Test (expected = NoPuedeCombinarPorTenerAlgoFormersMuertos.class)
	public void noSePuedeCombinarSiMurieronRobots()throws Exception{
		ratchet.recibirAtaque(new Ataque(2000));
		assertFalse(ratchet.estaVivo());
		assertTrue(jugadorAutobots.equipovivo());
		jugadorAutobots.combinarODescombinar();//aca deberia salir la excepcion
	}
	@Test(expected = SoloSePuedeMoverUnRobotPorJugada.class)
	public void soloSePuedeMoverUnRobotPorJugada()throws Exception{
		jugadorAutobots.mover(new Posicion(0,0), new Posicion(1,0));
		jugadorAutobots.mover(new Posicion(0,1), new Posicion(1,1));
	}
	@Test(expected = RobotsMuyAlejados.class)
	public void noSePuedenCombinarAlgoFormersSiEstanMuyLejos()throws Exception{
		jugadorDecepticons.transformar(new Posicion(0,7));
		jugadorDecepticons.notificar();
		jugadorDecepticons.mover(new Posicion(0,7),new Posicion(7,7));
		jugadorDecepticons.notificar();
		jugadorDecepticons.combinarODescombinar();//Aca deberia tirar la excepcion
	}
}
