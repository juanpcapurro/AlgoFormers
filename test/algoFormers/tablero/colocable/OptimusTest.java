package algoFormers.tablero.colocable;

import algoFormers.tablero.colocable.robots.DisparoConvencional;
import algoFormers.tablero.colocable.robots.Optimus;
import org.junit.Test;
import static org.junit.Assert.*;


public class OptimusTest {

    Optimus mauricio = new Optimus();

    @Test
    public void  test01OptimusRecibeAtaqueYSigueConVida() {

        mauricio.recibirAtaque(new DisparoConvencional(4));
        assertTrue(mauricio.estaVivo());
    }

    @Test
    public void  test02OptimusRecibeAtaqueYMuere() {

        mauricio.recibirAtaque(new DisparoConvencional(500));
        assertFalse(mauricio.estaVivo());
    }
}