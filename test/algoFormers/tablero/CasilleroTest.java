package algoFormers.tablero;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import algoFormers.tablero.colocable.robots.AlgoFormer;

public class CasilleroTest {
	Casillero casillero;
	
	@Before
	public void setUp() throws Exception {
		casillero = new Casillero();
	}

	@Test
	public void test01CasilleroSeCreaVacio() {
		assertFalse(casillero.estaOcupado());
	}
	
	@Test
	public void test02CasilleroAgregaColocable() {
		casillero.colocar(new AlgoFormer());
		assertTrue(casillero.estaOcupado());
	}
	
	@Test
	public void test03CasilleroQuedaVacio() {
		casillero.colocar(new AlgoFormer());
		assertTrue(casillero.estaOcupado());
		casillero.vaciar();
		assertFalse(casillero.estaOcupado());
	}
	
	@Test (expected= CasilleroYaOcupado.class)
	public void test04CasilleroLanzaExcepcionSiEstaOcupadoYQuieroColocar() {
		casillero.colocar(new AlgoFormer());
		assertTrue(casillero.estaOcupado());
		casillero.colocar(new AlgoFormer());
	}

}
