package algoFormers.tablero.colocable;

import algoFormers.tablero.colocable.robots.DisparoConvencional;
import algoFormers.tablero.colocable.robots.Frenzy;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


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

        mauricio.recibirAtaque(new DisparoConvencional(400));
        assertFalse(mauricio.estaVivo());
    }
}
