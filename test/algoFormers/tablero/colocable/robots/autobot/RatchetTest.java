package algoFormers.tablero.colocable.robots.autobot;

import algoFormers.tablero.colocable.robots.armas.DisparoConvencional;
import org.junit.Test;

import static org.junit.Assert.*;

public class RatchetTest {

    Ratchet mauricio = new Ratchet();

    @Test
    public void test01RatchetRecibeAtaqueYSigueConVida() {

        mauricio.recibirAtaque(new DisparoConvencional(4));
        assertTrue(mauricio.estaVivo());
    }

    @Test
    public void test02RatchetRecibeAtaqueYMuere() {

        mauricio.recibirAtaque(new DisparoConvencional(250));
        assertFalse(mauricio.estaVivo());
    }
	
	@Test
	public void testStatsModoHumanoide (){
		assertEquals(mauricio.getAtaque(), 5);
		assertEquals(mauricio.getDistanciaDeAtaque(), 5);
		assertEquals(mauricio.getVelocidad(),1 );
	}
	
	@Test
	public void testStatsModoAlterno(){
		mauricio.cambiarModo();
		assertEquals(mauricio.getAtaque(), 35);
		assertEquals(mauricio.getDistanciaDeAtaque(), 2);
		assertEquals(mauricio.getVelocidad(),8);
	}
}
