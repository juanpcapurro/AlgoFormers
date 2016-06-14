package algoFormers.tablero.colocable.robots.autobot;

import algoFormers.tablero.colocable.robots.armas.DisparoConvencional;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OptimusTest {

    Optimus mauricio;

	@Before
		public void Setup(){
		mauricio= new Optimus();
	}
    @Test
    public void test01OptimusRecibeAtaqueYSigueConVida() {

        mauricio.recibirAtaque(new DisparoConvencional(4));
        assertTrue(mauricio.estaVivo());
    }

    @Test
    public void test02OptimusRecibeAtaqueYMuere() {

        mauricio.recibirAtaque(new DisparoConvencional(550));
        assertFalse(mauricio.estaVivo());
    }
	
	@Test
	public void testStatsModoHumanoide (){
		assertEquals(mauricio.getAtaque(), 50);
		assertEquals(mauricio.getDistanciaDeAtaque(), 2);
		assertEquals(mauricio.getVelocidad(),2 );
	}
	
	@Test
	public void testStatsModoAlterno(){
		mauricio.cambiarModo();
		assertEquals(mauricio.getAtaque(), 15);
		assertEquals(mauricio.getDistanciaDeAtaque(), 4);
		assertEquals(mauricio.getVelocidad(),5);
	}
}
