package algoFormers.juego.turno;


import algoFormers.juego.JugadaAlgoformersCombinados;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class JugadaAlgoformersCombinadosTest {
    private JugadaAlgoformersCombinados jugadaAlgoformersCombinados;

    @Before
    public void setUp() throws Exception {
        jugadaAlgoformersCombinados = new JugadaAlgoformersCombinados();
    }

    @Test
    public void test01Pasa1Turno() {
        jugadaAlgoformersCombinados.pasoTurno();
        assertTrue(jugadaAlgoformersCombinados.enProcesoDeCombinacion());
    }

    @Test
    public void test02Pasan2Turnos() {
        jugadaAlgoformersCombinados.pasoTurno();
        jugadaAlgoformersCombinados.pasoTurno();
        assertFalse(jugadaAlgoformersCombinados.enProcesoDeCombinacion());
    }


}