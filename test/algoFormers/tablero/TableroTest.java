package algoFormers.tablero;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

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
	
	@Test
	public void test06sacarUnAlgoformer (){
		tablero.colocarAlgoformer(2,5);
		assertTrue(tablero.estaOcupadoEnPosicion(2,5));
		assertFalse(tablero.estaTodoVacio());

		tablero.vaciarPosicion(2,5);
		assertFalse(tablero.estaOcupadoEnPosicion(2,5));
		assertTrue(tablero.estaTodoVacio());
	}

    @Test
    public void test07VaciarUnEspacioVacio(){
        tablero.vaciarPosicion(3,4);
        assertFalse(tablero.estaOcupadoEnPosicion(3,4));
    }

    @Test
    public void test08colocarEnPosicionLuegoDeVaciar(){
        tablero.colocarAlgoformer(3,4);
        tablero.vaciarPosicion(3,4);
        assertFalse(tablero.estaOcupadoEnPosicion(3,4));
        tablero.colocarAlgoformer(3,4);
        assertTrue(tablero.estaOcupadoEnPosicion(3,4));
    }
    
    @Test
    public void test09MoverColocable(){
        tablero.colocarAlgoformer(3,4);
        assertTrue(tablero.estaOcupadoEnPosicion(3,4));
        assertFalse(tablero.estaOcupadoEnPosicion(4,4));
        tablero.mover(3, 4, 4, 4);

        assertTrue(tablero.estaOcupadoEnPosicion(4,4));
        assertFalse(tablero.estaOcupadoEnPosicion(3,4));
    }
    
    @Test
    public void test10MoverColocableAMismaPosicion(){
        tablero.colocarAlgoformer(3,4);
        assertTrue(tablero.estaOcupadoEnPosicion(3,4));
        
        tablero.mover(3, 4, 3, 4);
        assertTrue(tablero.estaOcupadoEnPosicion(3,4));
    }
    


}
