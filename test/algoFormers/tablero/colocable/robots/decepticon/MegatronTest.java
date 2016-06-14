package algoFormers.tablero.colocable.robots.decepticon;

import algoFormers.tablero.colocable.robots.armas.DisparoConvencional;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MegatronTest {
    private Megatron mauricio;
    @Before
    public void setUp() throws Exception {
        mauricio = new Megatron();
    }
    @Test
    public void  test01MegatronRecibeAtaqueYSigueConVida() {

        mauricio.recibirAtaque(new DisparoConvencional(4));
        assertTrue(mauricio.estaVivo());
    }
    @Test
    public void  test02MegatronRecibeAtaqueYMuere() {

        mauricio.recibirAtaque(new DisparoConvencional(650));
        assertFalse(mauricio.estaVivo());
    }
	@Test
	public void testStatsModoHumanoide (){
		assertEquals(mauricio.getAtaque(), 10);
		assertEquals(mauricio.getDistanciaDeAtaque(), 3);
		assertEquals(mauricio.getVelocidad(),1 );
	}
	@Test
	public void testStatsModoAlterno(){
		mauricio.cambiarModo();
		assertEquals(mauricio.getAtaque(), 55);
		assertEquals(mauricio.getDistanciaDeAtaque(), 2);
		assertEquals(mauricio.getVelocidad(),8);
	}
}

