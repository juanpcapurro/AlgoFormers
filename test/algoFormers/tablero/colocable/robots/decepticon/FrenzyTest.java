package algoFormers.tablero.colocable.robots.decepticon;

import algoFormers.tablero.colocable.robots.armas.DisparoConvencional;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FrenzyTest {
    private Frenzy mauricio;
    @Before
    public void setUp() throws Exception {
        mauricio = new Frenzy();
    }
    @Test
    public void  test01FrenzyRecibeAtaqueYSigueConVida() {

        mauricio.recibirAtaque(new DisparoConvencional(4));
        assertTrue(mauricio.estaVivo());
    }
    @Test
    public void  test02FrenzyRecibeAtaqueYMuere() {

        mauricio.recibirAtaque(new DisparoConvencional(550));
        assertFalse(mauricio.estaVivo());
    }
	@Test
	public void testStatsModoHumanoide (){
		assertEquals(mauricio.getAtaque(), 10);
		assertEquals(mauricio.getDistanciaDeAtaque(), 5);
		assertEquals(mauricio.getVelocidad(),2 );
	}
	@Test
	public void testStatsModoAlterno(){
		mauricio.cambiarModo();
		assertEquals(mauricio.getAtaque(), 25);
		assertEquals(mauricio.getDistanciaDeAtaque(), 2);
		assertEquals(mauricio.getVelocidad(),6);
	}
}
