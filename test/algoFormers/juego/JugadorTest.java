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
	static final int VIDAFRENZY=400;
	static final int VIDARATCHET=150;

	@Before
	public void setUp()  {
		miJugador=new Jugador(NOMBREJUGADOR);
	}

	@Test
	public void test01NombreJugadorCorrecto(){
		assertEquals(miJugador.getNombreDeJugador(),NOMBREJUGADOR);
	}
	@Test
	public void test02equipoVacioNoEstaVivo() {
		assertFalse(miJugador.equipovivo());
	}

	@Test
	public void test03EquipoConUnAlgoformerEstaVivo() {
		miJugador.agregarUnidad(new Bumblebee());
		assertTrue(miJugador.equipovivo());
	}
	
	@Test
	public void test04JugadorEquipoNoMuereConAlgoformersActivos() {
		AlgoFormer bumblebee=new Bumblebee();
		AlgoFormer ratchet=new Ratchet();
		AlgoFormer frenzy=new Frenzy();
		miJugador.agregarUnidad(bumblebee);
		miJugador.agregarUnidad(ratchet);
		miJugador.agregarUnidad(frenzy);

		bumblebee.recibirAtaque(new DisparoConvencional(VIDABUMBLEBEE));
		assertTrue(miJugador.equipovivo());
	}
	@Test
	public void test05JugadorEquipoMuereConAlgoformersInactivos(){
		AlgoFormer bumblebee=new Bumblebee();
		AlgoFormer ratchet=new Ratchet();
		AlgoFormer frenzy=new Frenzy();
		miJugador.agregarUnidad(bumblebee);
		miJugador.agregarUnidad(ratchet);
		miJugador.agregarUnidad(frenzy);

		bumblebee.recibirAtaque(new DisparoConvencional(VIDABUMBLEBEE));
		ratchet.recibirAtaque(new DisparoConvencional(VIDARATCHET));
		frenzy.recibirAtaque(new DisparoConvencional(VIDAFRENZY));

		assertFalse(miJugador.equipovivo());
	}

	@Test
	public void test06JugadorCombinaSusAutobots(){
		miJugador.agregarUnidad(new Bumblebee());
		miJugador.agregarUnidad(new Ratchet());
		miJugador.agregarUnidad(new Optimus());
		//PENDIENTE
		//miJugador.combinarMisAlgoformers();
	}

	@Test
	public void test07JugadorCombinaSusDecepticons(){

	}

	@Test
	public void test08JugadorEligeUnoDeSusAlgoformersEnModoAlternoYLosTranformaAModoHumanoide(){}

	@Test
	public void test08JugadorEligeUnoDeSusAlgoformersEnModoHumaniodeYLosTranformaAModoAlterno(){}
	
}
