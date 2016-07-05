package modelo.tablero;

import modelo.tablero.colocable.bonus.DobleCanion;
import modelo.tablero.colocable.robots.AlgoFormer;
import modelo.tablero.colocable.robots.autobot.Bumblebee;
import modelo.tablero.posiciones.CoordenadasInvalidas;
import modelo.tablero.posiciones.Posicion;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TableroTest{
    Tablero tablero;
    AlgoFormer algoFormerDePrueba;

    @Before
    public void initialize(){
        tablero = new Tablero(8);
        algoFormerDePrueba = new Bumblebee();
    }

    @Test
    public void test01CasilleroDebeEstarVacio(){
        assertTrue(tablero.estaTodoVacio());
    }

    @Test
    public void test02colocarYVericarQueCasilleroNoEsteVacio(){
        Posicion posicion=new Posicion(3,4);
        tablero.colocarAlgoformer(posicion,algoFormerDePrueba);
        assertTrue(tablero.estaOcupadoEnPosicion(posicion));
    }

    @Test(expected= CasilleroYaOcupado.class)
    public void test03colocarDosObjetosMismaPosicionTiraExcepcion(){
        Posicion posicion=new Posicion(3,4);
        tablero.colocarAlgoformer(posicion,algoFormerDePrueba);
        tablero.colocarAlgoformer(posicion,algoFormerDePrueba);
    }

    @Test(expected = CoordenadasInvalidas.class)
    public void test04ColocarCoordenadaInvalidaNumeroNegativo(){
        Posicion posicion= new Posicion(-3,4);
        tablero.colocarAlgoformer(posicion,algoFormerDePrueba);
    }
    @Test(expected = CoordenadasInvalidas.class)
    public void test05ColocarCoordenadaInvalidaExcedeTamanio(){
        Posicion posicion= new Posicion(17,23);
        tablero.colocarAlgoformer(posicion,algoFormerDePrueba);
    }
	
	@Test
	public void test06sacarUnAlgoformer (){
        Posicion posicion=new Posicion(2,5);
		tablero.colocarAlgoformer(posicion,algoFormerDePrueba);
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
        tablero.colocarAlgoformer(posicion,algoFormerDePrueba);
        tablero.vaciarPosicion(posicion);
        assertFalse(tablero.estaOcupadoEnPosicion(posicion));
        tablero.colocarAlgoformer(posicion,algoFormerDePrueba);
        assertTrue(tablero.estaOcupadoEnPosicion(posicion));
    }
    
    @Test
    public void test09MoverColocable(){
        Posicion posicion=new Posicion(3,4);
        Posicion posicionDesocupada=new Posicion(4,4);
        tablero.colocarAlgoformer(posicion,algoFormerDePrueba);
        assertTrue(tablero.estaOcupadoEnPosicion(posicion));
        assertFalse(tablero.estaOcupadoEnPosicion(posicionDesocupada));
        tablero.recorrer(posicion, posicionDesocupada);

        assertTrue(tablero.estaOcupadoEnPosicion(posicionDesocupada));
        assertFalse(tablero.estaOcupadoEnPosicion(posicion));
    }
    

    @Test
    public void test10MoverAlgoformerPasaPorEspinasYEsDaniado(){
        Posicion posicionEspinas= new Posicion(2,4);
        Posicion posicionBumble=new Posicion(1,4);
        Posicion posicionDestino=new Posicion(2,4);
        Bumblebee bumblebee=new Bumblebee();
        int vidaAntesDeEspinas=bumblebee.getPuntosDeVida();
        tablero.colocarEspinas(posicionEspinas);
        tablero.colocarAlgoformer(posicionBumble,bumblebee);
        tablero.recorrer(posicionBumble,posicionDestino);
        assertTrue(bumblebee.getPuntosDeVida()<vidaAntesDeEspinas);
    }

    @Test
    public void test11MoverAlgoformerPasaPorBonusYEsAumentaAtaque(){
        Posicion posicionBonus= new Posicion(2,3);
        Posicion posicionBumble=new Posicion(2,2);
        DobleCanion dobleCanion=new DobleCanion();
        Posicion posicionDestino=new Posicion(2,4);
        Bumblebee bumblebee=new Bumblebee();
        int ataqueAntesDeBonus=bumblebee.getAtaque();
        tablero.colocar(posicionBonus,dobleCanion);
        tablero.colocarAlgoformer(posicionBumble,bumblebee);
        tablero.recorrer(posicionBumble,posicionDestino);
        assertTrue(bumblebee.getAtaque()>ataqueAntesDeBonus);
    }

}
