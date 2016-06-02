package algoFormers.tablero.colocable;

import algoFormers.tablero.colocable.robots.Bumblebee;
import algoFormers.tablero.colocable.robots.DisparoConvencional;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BumblebeeTest {

    Bumblebee mauricio = new Bumblebee();

    @Test
    public void test01BumblebeeRecibeAtaqueYSigueConVida() {

        mauricio.recibirAtaque(new DisparoConvencional(4));
        assertTrue(mauricio.estaVivo());
    }

    @Test
    public void test02BumblebeeRecibeAtaqueYMuere() {

        mauricio.recibirAtaque(new DisparoConvencional(550));
        assertFalse(mauricio.estaVivo());
    }
}