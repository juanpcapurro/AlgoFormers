package algoFormers.tablero.colocable;

import algoFormers.tablero.colocable.robots.Ratchet;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RatchetTest {

    Ratchet mauricio = new Ratchet();

    @Test
    public void ratchetRecibeAtaqueYSigueConVida() {

        mauricio.recibirAtaque(4);

        assertTrue(mauricio.estaVivo());
    }

    @Test
    public void ratchetRecibeAtaqueYMuere() {

        mauricio.recibirAtaque(150);
        assertFalse(mauricio.estaVivo());
    }
}