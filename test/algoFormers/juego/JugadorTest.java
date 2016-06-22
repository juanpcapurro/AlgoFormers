package algoFormers.juego;

import algoFormers.tablero.colocable.robots.decepticon.*;
import algoFormers.tablero.colocable.robots.autobot.*;
import algoFormers.tablero.colocable.robots.AlgoFormer;
import algoFormers.tablero.colocable.robots.armas.*;
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

	@Test
	public void test01NombreJugadorCorrecto(){
		assertEquals(miJugador.getNombreDeJugador(),NOMBREJUGADOR);
	}
	@Test
	public void test02equipoAutobotsEstaVivo() {
		miJugador.asignarEquipo(new Autobots());
		assertTrue(miJugador.equipovivo());
	}

	@Test
	public void test03EquipoAutobotsEstaVivo() {

		miJugador.asignarEquipo(new Autobots());
		assertTrue(miJugador.equipovivo());
	}
	
	@Test
	public void test04JugadorEquipoNoMuereConAlgoformersActivos() {

		Autobots autobots = new Autobots();
		miJugador.asignarEquipo(autobots);

		Bumblebee bumblebee = autobots.getBumblebee();

		bumblebee.recibirAtaque(new Ataque(VIDABUMBLEBEE));
		assertTrue(miJugador.equipovivo());
	}
	@Test
	public void test05JugadorEquipoMuereConAlgoformersInactivos(){
		Autobots autobots = new Autobots();
		miJugador.asignarEquipo(autobots);

		Bumblebee bumblebee = autobots.getBumblebee();
		Ratchet ratchet = autobots.getRatchet();
		Optimus optimus = autobots.getOptimus();

		bumblebee.recibirAtaque(new Ataque(VIDABUMBLEBEE));
		ratchet.recibirAtaque(new Ataque(VIDARATCHET));
		optimus.recibirAtaque(new Ataque(VIDAOPTIMUS));

		assertFalse(miJugador.equipovivo());
	}

	@Test (expected = AlgoformersDeSuEquipoHanMuerto.class)
	public void test06JugadorNoPuedeCombinarSusAutobotsSiUnoMurio(){
		Autobots autobots = new Autobots();
		miJugador.asignarEquipo(autobots);

		Bumblebee bumblebee = autobots.getBumblebee();
		bumblebee.recibirAtaque(new Ataque(VIDABUMBLEBEE));

		miJugador.combinarAlgoformers();

	}

	@Test (expected = AlgoformersDeSuEquipoHanMuerto.class)
	public void test07JugadorNoPuedeCombinaSusDecepticonsSiUnoMurio(){
		Decepticons decepticons = new Decepticons();
		miJugador.asignarEquipo(decepticons);

		BoneCrusher boneCrusher = decepticons.getBoneCrusher();
		boneCrusher.recibirAtaque(new Ataque(VIDABONECRUSHER));

		miJugador.combinarAlgoformers();


	}

	@Test
	public void test08JugadorEligeUnoDeSusAlgoformersEnModoAlternoYLosTranformaAModoHumanoide(){
		Decepticons decepticons = new Decepticons();
		miJugador.asignarEquipo(decepticons);

		BoneCrusher boneCrusher = decepticons.getBoneCrusher();

		assertTrue(boneCrusher.estaEnModoHumanoide());

		miJugador.jugarCon(boneCrusher);
		miJugador.transformar();

		assertTrue(boneCrusher.estaEnModoAlterno());
	}

	@Test
	public void test08JugadorEligeUnoDeSusAlgoformersEnModoHumaniodeYLosTranformaAModoAlterno(){
		Decepticons decepticons = new Decepticons();
		miJugador.asignarEquipo(decepticons);

		BoneCrusher boneCrusher = decepticons.getBoneCrusher();
		assertTrue(boneCrusher.estaEnModoHumanoide());

		boneCrusher.transformar();
		assertTrue(boneCrusher.estaEnModoAlterno());

		miJugador.jugarCon(boneCrusher);
		miJugador.transformar();
		assertTrue(boneCrusher.estaEnModoHumanoide());

	}
	
}
