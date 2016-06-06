package algoFormers.tablero.superficie;

import algoFormers.tablero.colocable.robots.armas.Ataque;
import algoFormers.tablero.colocable.robots.armas.Misil;
import org.junit.Before;
import org.junit.Test;


public class SuperficieTest {
    Superficie superficieActual;
    @Before
    public void initialize(){
        superficieActual=new Superficie();
    }
    @Test
    public void test01SuperficieInicialEsLlano(){
    }
    @Test
    public void test02SuperficieLlanaCambiaARocoso(){
        superficieActual.cambiarARocoso();
    }
    @Test
    public void test03SuperficieLlanaCambiaAPantanoso(){
        superficieActual.cambiarAPantanoso();
    }
    
    @Test
    public void test04SuperficieLlanaCambiaALlana(){
        superficieActual.cambiarALlano();
    }
    
    @Test
    public void test05SuperficieRocosaCambiaALlana(){
        superficieActual.cambiarARocoso();
        superficieActual.cambiarALlano();
    }
    
    @Test
    public void test06SuperficieRocosaCambiaAPantanosa(){
        superficieActual.cambiarARocoso();
        superficieActual.cambiarAPantanoso();
    }
    
    @Test
    public void test07SuperficieRocosaCambiaARocosa(){
        superficieActual.cambiarARocoso();
        superficieActual.cambiarARocoso();
    }
    
    @Test
    public void test08SuperficiePantanosaCambiaALlana(){
        superficieActual.cambiarAPantanoso();
        superficieActual.cambiarALlano();
    }
    
    @Test
    public void test09SuperficiePantanosaCambiaAPantanosa(){
    	superficieActual.cambiarAPantanoso();
        superficieActual.cambiarAPantanoso();
    }
    
    @Test
    public void test10SuperficiePantanosaCambiaARocosa(){
    	superficieActual.cambiarAPantanoso();
        superficieActual.cambiarARocoso();
    }
    @Test
    public void test11DisparoSuperficieActualLoHaceLlano(){
        superficieActual.cambiarARocoso();
        Ataque ataque =new Misil(100);
        ataque.atacar(superficieActual);
    }
}
