package algoFormers.tablero.colocable.robots.autobot;


import algoFormers.tablero.colocable.robots.AlgoFormer;
import algoFormers.tablero.colocable.robots.armas.*;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RatchetTest {

    Ratchet mauricio = new Ratchet();

    @Test
    public void  test01RatchetRecibeAtaqueYSigueConVida() {

        mauricio.recibirAtaque(new DisparoConvencional(4));

        assertTrue(mauricio.estaVivo());
    }

    @Test
    public void  test02RatchetRecibeAtaqueYMuere() {

        mauricio.recibirAtaque(new DisparoConvencional(150));
        assertFalse(mauricio.estaVivo());
    }
}
