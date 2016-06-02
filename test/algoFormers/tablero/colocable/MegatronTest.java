package algoFormers.tablero.colocable;

import algoFormers.tablero.colocable.robots.DisparoConvencional;
import algoFormers.tablero.colocable.robots.Megatron;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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

        mauricio.recibirAtaque(new DisparoConvencional(550));
        assertFalse(mauricio.estaVivo());
    }
}

