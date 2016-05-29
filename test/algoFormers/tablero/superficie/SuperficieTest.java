package algoFormers.tablero.superficie;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Charly on 5/29/16.
 */
public class SuperficieTest {
    SuperficieConcretaActual superficieActual;
    @Before
    public void initialize(){
        superficieActual=new SuperficieConcretaActual();
    }
    @Test
    public void test01SuperficieInicialEsLlano(){
        assertSame(Llano.getInstance(),superficieActual.verActual());
    }
    @Test
    public void test02SuperficieCambiaARocoso(){
        superficieActual.cambiarARocoso();
        assertSame(Rocoso.getInstance(),superficieActual.verActual());
    }
    @Test
    public void test03SuperficieCambiaAPantanoso(){
        superficieActual.cambiarAPantanoso();
        assertSame(Pantanoso.getInstance(),superficieActual.verActual());
    }
}
