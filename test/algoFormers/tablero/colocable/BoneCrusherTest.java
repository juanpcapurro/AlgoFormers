package algoFormers.tablero.colocable;
import algoFormers.tablero.colocable.robots.BoneCrusher;
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
    public void boneCrusherRecibeAtaqueYSigueConVida() {

        mauricio.recibirAtaque(4);
        assertTrue(mauricio.estaVivo());
    }

    @Test
    public void boneCrusherRecibeAtaqueYMuere() {

        mauricio.recibirAtaque(200);
        assertFalse(mauricio.estaVivo());
    }
}
