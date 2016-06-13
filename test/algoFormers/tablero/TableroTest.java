package algoFormers.tablero;

import algoFormers.tablero.posiciones.CoordenadasInvalidas;
import algoFormers.tablero.posiciones.Posicion;
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
        Posicion posicion=new Posicion(3,4);
        tablero.colocarAlgoformer(posicion);
        assertTrue(tablero.estaOcupadoEnPosicion(posicion));
    }

    @Test(expected= CasilleroYaOcupado.class)
    public void test03colocarDosObjetosMismaPosicionTiraExcepcion(){
        Posicion posicion=new Posicion(3,4);
        tablero.colocarAlgoformer(posicion);
        tablero.colocarAlgoformer(posicion);
    }

    @Test(expected = CoordenadasInvalidas.class)
    public void test04ColocarCoordenadaInvalidaNumeroNegativo(){
        Posicion posicion= new Posicion(-3,4);
        tablero.colocarAlgoformer(posicion);
    }
    @Test(expected = CoordenadasInvalidas.class)
    public void test05ColocarCoordenadaInvalidaExcedeTamanio(){
        Posicion posicion= new Posicion(17,23);
        tablero.colocarAlgoformer(posicion);
    }
	
	@Test
	public void test06sacarUnAlgoformer (){
        Posicion posicion=new Posicion(2,5);
		tablero.colocarAlgoformer(posicion);
		assertTrue(tablero.estaOcupadoEnPosicion(posicion));
		assertFalse(tablero.estaTodoVacio());

		tablero.vaciarPosicion(posicion);
		assertFalse(tablero.estaOcupadoEnPosicion(posicion));
		assertTrue(tablero.estaTodoVacio());
	}

    @Test
    public void test07VaciarUnEspacioVacio(){
        Posicion posicion= new Posicion(3,4);
        tablero.vaciarPosicion(posicion);
        assertFalse(tablero.estaOcupadoEnPosicion(posicion));
    }

    @Test
    public void test08colocarEnPosicionLuegoDeVaciar(){
        Posicion posicion= new Posicion(3,4);
        tablero.colocarAlgoformer(posicion);
        tablero.vaciarPosicion(posicion);
        assertFalse(tablero.estaOcupadoEnPosicion(posicion));
        tablero.colocarAlgoformer(posicion);
        assertTrue(tablero.estaOcupadoEnPosicion(posicion));
    }
    
    @Test
    public void test09MoverColocable(){
        Posicion posicion=new Posicion(3,4);
        Posicion posicionDesocupada=new Posicion(4,4);
        tablero.colocarAlgoformer(posicion);
        assertTrue(tablero.estaOcupadoEnPosicion(posicion));
        assertFalse(tablero.estaOcupadoEnPosicion(posicionDesocupada));
        tablero.mover(posicion, posicionDesocupada);

        assertTrue(tablero.estaOcupadoEnPosicion(posicionDesocupada));
        assertFalse(tablero.estaOcupadoEnPosicion(posicion));
    }
    
    @Test
    public void test10MoverColocableAMismaPosicion(){
        Posicion posicion=new Posicion(3,4);
        tablero.colocarAlgoformer(posicion);
        assertTrue(tablero.estaOcupadoEnPosicion(posicion));
        
        tablero.mover(posicion,posicion);
        assertTrue(tablero.estaOcupadoEnPosicion(posicion));
    }
    



}
