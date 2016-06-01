package algoFormers.tablero.colocable.robot.equipos;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;



public class EquiposTest {

	public EquipoDeAutobots equipoAutobots;
	public EquipoDeDecepticons equipoDecepticons;

	@Before
	public void setUp() throws Exception {
		this.equipoAutobots = new EquipoDeAutobots();
		this.equipoDecepticons = new EquipoDeDecepticons();
	}

	@Test
	public void test01EquipoDecepticonsSeGeneraVivo() {
		assertTrue(this.equipoDecepticons.equipoSigueConVida());
	}
	
	@Test
	public void test02EquipoAutobotsSeGeneraVivo() {
		assertTrue(this.equipoAutobots.equipoSigueConVida());
	}
	
	@Test
	public void test03EquiposSiguenVivoSiMuereUnoODosDeSusMiembros() {
		this.equipoAutobots.getMiOptimus().recibirAtaque(500);
		this.equipoAutobots.getMiRatchet().recibirAtaque(150);
		assertTrue(this.equipoAutobots.equipoSigueConVida());
		
		this.equipoDecepticons.getMiBonecrusher().recibirAtaque(400);
		assertTrue(this.equipoDecepticons.equipoSigueConVida());
	}
	
	@Test
	public void test04EquiposMuerenSiMuerenTodosSusMiembros() {
		this.equipoAutobots.getMiOptimus().recibirAtaque(500);
		this.equipoAutobots.getMiRatchet().recibirAtaque(150);
		this.equipoAutobots.getMiBumblebee().recibirAtaque(350);
		assertFalse(this.equipoAutobots.equipoSigueConVida());
		
		this.equipoDecepticons.getMiMegatron().recibirAtaque(550);
		this.equipoDecepticons.getMiFrenzy().recibirAtaque(400);		
		this.equipoDecepticons.getMiBonecrusher().recibirAtaque(200);
		assertFalse(this.equipoDecepticons.equipoSigueConVida());
	}
	
	@Test
	public void test05EquiposActivaModoCombinado() {
		this.equipoAutobots.activarModoCombinado();
		this.equipoDecepticons.activarModoCombinado();
		assertTrue(this.equipoAutobots.estaEnModoCombinado());
		assertNotNull(this.equipoAutobots.getSuperion());
		assertNotNull(this.equipoDecepticons.getMenasor());
	}
	
	@Test
	public void test05EquiposDesactivaModoCombinado() {
		this.equipoAutobots.activarModoCombinado();
		this.equipoDecepticons.activarModoCombinado();
		assertTrue(this.equipoAutobots.estaEnModoCombinado());
		assertTrue(this.equipoDecepticons.estaEnModoCombinado());

		this.equipoAutobots.desactivarModoCombinado();
		this.equipoDecepticons.desactivarModoCombinado();
		assertFalse(this.equipoAutobots.estaEnModoCombinado());
		assertFalse(this.equipoDecepticons.estaEnModoCombinado());
		assertNull(this.equipoAutobots.getSuperion());
		assertNull(this.equipoDecepticons.getMenasor());
		
	}
	

	

}
