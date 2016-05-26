package tablero;

import tablero.Tablero;
import org.junit.Before;
import org.junit.Test;

public class TableroTest{
    @Before
    public void initialize(){
        Tablero tablero = new Tablero(8);
    }

    @Test
    public void test01CasilleroDebeEstarVacio(){
        assert(tablero.estaVacio());
    }

	
}
