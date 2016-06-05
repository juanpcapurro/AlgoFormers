package algoFormers.tablero.colocable.robots.decepticon;

import algoFormers.tablero.colocable.robots.armas.*;
import algoFormers.tablero.colocable.robots.AlgoFormer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class BoneCrusherTest {

    private BoneCrusher mauricio;
    @Before
    public void setUp() throws Exception {
        mauricio = new BoneCrusher();
    }



    @Test
    public void test01BoneCrusherRecibeAtaqueYSigueConVida() {

        mauricio.recibirAtaque(new DisparoConvencional(4));
        assertTrue(mauricio.estaVivo());
    }

    @Test
    public void test02BoneCrusherRecibeAtaqueYMuere() {

        mauricio.recibirAtaque(new DisparoConvencional(200));
        assertFalse(mauricio.estaVivo());
    }
}
