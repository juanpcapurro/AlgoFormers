package algoFormers.tablero;

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
        assert(tablero.estaTodoVacio());
    }

    @Test
    public void test02colocarYVericarQueCasilleroNoEsteVacio(){
        assert(tablero.colocar(3,4,new EspacioOcupado()));
        assert(!tablero.estaVacioEnPosicion(3,4));
    }

    @Test
    public void test03colocarDosObjetosMismaPosicion(){
        assert(tablero.colocar(3,4,new EspacioOcupado()));
        assert(!tablero.colocar(3,4,new EspacioOcupado()));
    }
}
