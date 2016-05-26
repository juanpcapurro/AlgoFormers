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
        tablero.colocar(3,4,new EspacioOcupado());
        assertTrue(tablero.estaOcupadoEnPosicion(3,4));
    }

    @Test(expected= CasilleroYaOcupado.class)
    public void test03colocarDosObjetosMismaPosicionTiraExcepcion(){
        tablero.colocar(3,4,new EspacioOcupado());
        tablero.colocar(3,4,new EspacioOcupado());
    }

    @Test(expected = CoordenadasInvalidas.class)
    public void test04ColocarCoordenadaInvalidaNumeroNegativo(){
        tablero.colocar(-3,4, new EspacioVacio());
    }
    @Test(expected = CoordenadasInvalidas.class)
    public void test05ColocarCoordenadaInvalidaExcedeTamanio(){
        tablero.colocar(17,23, new EspacioVacio());
    }
}
