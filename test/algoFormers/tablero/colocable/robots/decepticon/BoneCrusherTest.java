package algoFormers.tablero.colocable.robots.decepticon;

import algoFormers.tablero.colocable.robots.armas.DisparoConvencional;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoneCrusherTest {
    private BoneCrusher mauricio;
    @Before
    public void setUp() throws Exception {
        mauricio = new BoneCrusher();
    }
    @Test
    public void  test01BoneCrusherRecibeAtaqueYSigueConVida() {

        mauricio.recibirAtaque(new DisparoConvencional(4));
        assertTrue(mauricio.estaVivo());
    }
    @Test
    public void  test02BoneCrusherRecibeAtaqueYMuere() {

        mauricio.recibirAtaque(new DisparoConvencional(550));
        assertFalse(mauricio.estaVivo());
    }
	@Test
	public void testStatsModoHumanoide (){
		assertEquals(mauricio.getAtaque(), 30);
		assertEquals(mauricio.getDistanciaDeAtaque(), 3);
		assertEquals(mauricio.getVelocidad(),1 );
	}
	@Test
	public void testStatsModoAlterno(){
		mauricio.cambiarModo();
		assertEquals(mauricio.getAtaque(), 30);
		assertEquals(mauricio.getDistanciaDeAtaque(), 3);
		assertEquals(mauricio.getVelocidad(),8);
	}
}
