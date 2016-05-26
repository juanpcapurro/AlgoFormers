package algoFormers.tablero;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TableroTest{
    Tablero tablero;

    @Before
    public void initialize(){
        tablero = new Tablero(8);
    }

    @Test
    public void test01CasilleroDebeEstarVacio(){
        assertTrue(tablero.estaTodoVacio());
    }

    @Test
    public void test02colocarYVericarQueCasilleroNoEsteVacio(){
        tablero.colocarAlgoformer(3,4);
        assertTrue(tablero.estaOcupadoEnPosicion(3,4));
    }

    @Test(expected= CasilleroYaOcupado.class)
    public void test03colocarDosObjetosMismaPosicionTiraExcepcion(){
        tablero.colocarAlgoformer(3,4);
        tablero.colocarAlgoformer(3,4);
    }

    @Test(expected = CoordenadasInvalidas.class)
    public void test04ColocarCoordenadaInvalidaNumeroNegativo(){
        tablero.colocarAlgoformer(-3,4);
    }
    @Test(expected = CoordenadasInvalidas.class)
    public void test05ColocarCoordenadaInvalidaExcedeTamanio(){
        tablero.colocarAlgoformer(17,23);
    }

}
