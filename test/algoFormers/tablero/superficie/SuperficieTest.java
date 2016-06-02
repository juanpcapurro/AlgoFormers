package algoFormers.tablero.superficie;

import algoFormers.tablero.colocable.robots.Ataque;
import algoFormers.tablero.colocable.robots.Misil;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertSame;

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
    public void test02SuperficieLlanaCambiaARocoso(){
        superficieActual.cambiarARocoso();
        assertSame(Rocoso.getInstance(),superficieActual.verActual());
    }
    @Test
    public void test03SuperficieLlanaCambiaAPantanoso(){
        superficieActual.cambiarAPantanoso();
        assertSame(Pantanoso.getInstance(),superficieActual.verActual());
    }
    
    @Test
    public void test04SuperficieLlanaCambiaALlana(){
        superficieActual.cambiarALlano();
        assertSame(Llano.getInstance(),superficieActual.verActual());
    }
    
    @Test
    public void test05SuperficieRocosaCambiaALlana(){
        superficieActual.cambiarARocoso();
        assertSame(Rocoso.getInstance(),superficieActual.verActual());
        superficieActual.cambiarALlano();
        assertSame(Llano.getInstance(),superficieActual.verActual());
    }
    
    @Test
    public void test06SuperficieRocosaCambiaAPantanosa(){
        superficieActual.cambiarARocoso();
        assertSame(Rocoso.getInstance(),superficieActual.verActual());
        superficieActual.cambiarAPantanoso();
        assertSame(Pantanoso.getInstance(),superficieActual.verActual());
    }
    
    @Test
    public void test07SuperficieRocosaCambiaARocosa(){
        superficieActual.cambiarARocoso();
        assertSame(Rocoso.getInstance(),superficieActual.verActual());
        superficieActual.cambiarARocoso();
        assertSame(Rocoso.getInstance(),superficieActual.verActual());
    }
    
    @Test
    public void test08SuperficiePantanosaCambiaALlana(){
        superficieActual.cambiarAPantanoso();
        assertSame(Pantanoso.getInstance(),superficieActual.verActual());
        superficieActual.cambiarALlano();
        assertSame(Llano.getInstance(),superficieActual.verActual());
    }
    
    @Test
    public void test09SuperficiePantanosaCambiaAPantanosa(){
    	superficieActual.cambiarAPantanoso();
    	assertSame(Pantanoso.getInstance(),superficieActual.verActual());
        superficieActual.cambiarAPantanoso();
        assertSame(Pantanoso.getInstance(),superficieActual.verActual());
    }
    
    @Test
    public void test10SuperficiePantanosaCambiaARocosa(){
    	superficieActual.cambiarAPantanoso();
    	assertSame(Pantanoso.getInstance(),superficieActual.verActual());
        superficieActual.cambiarARocoso();
        assertSame(Rocoso.getInstance(),superficieActual.verActual());
    }
    @Test
    public void test11DisparoSuperficieActualLoHaceLlano(){
        superficieActual.cambiarARocoso();
        Ataque ataque =new Misil(100);
        ataque.atacar(superficieActual);
        assertSame(Llano.getInstance(),superficieActual.verActual());

    }
}
