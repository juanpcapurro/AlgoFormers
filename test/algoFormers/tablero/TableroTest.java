package algoFormers.tablero;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

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
}
