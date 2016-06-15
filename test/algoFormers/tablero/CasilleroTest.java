package algoFormers.tablero;

import algoFormers.tablero.colocable.robots.AlgoFormer;
import algoFormers.tablero.colocable.robots.decepticon.Frenzy;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CasilleroTest {
	Casillero casillero;
	AlgoFormer algoFormerDePrueba;
	
	@Before
	public void setUp(){
		casillero = new Casillero();
		algoFormerDePrueba = new Frenzy();
	}

	@Test
	public void test01CasilleroSeCreaVacio() {
		assertFalse(casillero.estaOcupado());
	}
	
	@Test
	public void test02CasilleroAgregaColocable() {
		casillero.colocar(algoFormerDePrueba);
		assertTrue(casillero.estaOcupado());
	}
	
	@Test
	public void test03CasilleroQuedaVacio() {
		casillero.colocar(algoFormerDePrueba);
		assertTrue(casillero.estaOcupado());
		casillero.vaciar();
		assertFalse(casillero.estaOcupado());
	}
	
	@Test (expected= CasilleroYaOcupado.class)
	public void test04CasilleroLanzaExcepcionSiEstaOcupadoYQuieroColocar() {
		casillero.colocar(algoFormerDePrueba);
		assertTrue(casillero.estaOcupado());
		casillero.colocar(algoFormerDePrueba);
	}

}
