package algoFormers.tablero.colocable;

import algoFormers.tablero.colocable.robots.Bumblebee;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BumblebeeTest {

    Bumblebee mauricio = new Bumblebee();

    @Test
    public void bumblebeeRecibeAtaqueYSigueConVida() {

        mauricio.recibirAtaque(4);
        assertTrue(mauricio.estaVivo());
    }

    @Test
    public void bumblebeeRecibeAtaqueYMuere() {

        mauricio.recibirAtaque(550);
        assertFalse(mauricio.estaVivo());
    }
}