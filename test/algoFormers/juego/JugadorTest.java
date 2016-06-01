package algoFormers.juego;

import algoFormers.tablero.colocable.robots.AlgoFormer;
import algoFormers.tablero.colocable.robots.Bumblebee;
import algoFormers.tablero.colocable.robots.Frenzy;
import algoFormers.tablero.colocable.robots.Ratchet;
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
		miJugador.agregarAlgoFormer(new Bumblebee());
		assertTrue(miJugador.equipovivo());
	}
	
	@Test
	public void test04JugadorEquipoNoMuereConAlgoformersActivos() {
		AlgoFormer bumblebee=new Bumblebee();
		AlgoFormer ratchet=new Ratchet();
		AlgoFormer frenzy=new Frenzy();
		miJugador.agregarAlgoFormer(bumblebee);
		miJugador.agregarAlgoFormer(ratchet);
		miJugador.agregarAlgoFormer(frenzy);

		bumblebee.recibirAtaque(VIDABUMBLEBEE);
		assertTrue(miJugador.equipovivo());
	}
	@Test
	public void test05JugadorEquipoMuereConAlgoformersInactivos(){
		AlgoFormer bumblebee=new Bumblebee();
		AlgoFormer ratchet=new Ratchet();
		AlgoFormer frenzy=new Frenzy();
		miJugador.agregarAlgoFormer(bumblebee);
		miJugador.agregarAlgoFormer(ratchet);
		miJugador.agregarAlgoFormer(frenzy);

		bumblebee.recibirAtaque(VIDABUMBLEBEE);
		ratchet.recibirAtaque(VIDARATCHET);
		frenzy.recibirAtaque(VIDAFRENZY);

		assertFalse(miJugador.equipovivo());
	}
	
	
}
