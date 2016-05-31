package algoFormers.tablero.colocable;

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
    public void frenzyRecibeAtaqueYSigueConVida() {

        mauricio.recibirAtaque(4);
        assertTrue(mauricio.estaVivo());
    }

    @Test
    public void frenzyRecibeAtaqueYMuere() {

        mauricio.recibirAtaque(400);
        assertFalse(mauricio.estaVivo());
    }
}
