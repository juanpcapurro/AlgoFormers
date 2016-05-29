package algoFormers.tablero.colocable;

import algoFormers.tablero.colocable.robots.Optimus;
import org.junit.Test;
import static org.junit.Assert.*;


public class OptimusTest {

    Optimus mauricio = new Optimus();

    @Test
    public void optimusRecibeAtaqueYSigueConVida() {

        mauricio.recibirAtaque(4);
        assertTrue(mauricio.estaVivo());
    }

    @Test
    public void optimusRecibeAtaqueYMuere() {

        mauricio.recibirAtaque(500);
        assertFalse(mauricio.estaVivo());
    }
}