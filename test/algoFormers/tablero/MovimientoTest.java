package algoFormers.tablero;

import algoFormers.tablero.posiciones.Posicion;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MovimientoTest {
    Tablero tablero;

    @Before
    public void initialize(){
        tablero=new Tablero(8);
    }

    @Test
    public void moverPosicion01(){
        Posicion posicionOrigen= new Posicion(3,4);
        Posicion posicionDestino= new Posicion(3,6);
        tablero.colocarAlgoformer(posicionOrigen);
        tablero.recorrer(posicionOrigen,posicionDestino);

        assertTrue(tablero.estaOcupadoEnPosicion(posicionDestino));
        assertFalse(tablero.estaOcupadoEnPosicion(posicionOrigen));
    }

    @Test
    public void moverPosicion02(){
        Posicion posicionOrigen= new Posicion(3,4);
        Posicion posicionDestino= new Posicion(2,6);
        tablero.colocarAlgoformer(posicionOrigen);
        tablero.recorrer(posicionOrigen,posicionDestino);

        assertTrue(tablero.estaOcupadoEnPosicion(posicionDestino));
        assertFalse(tablero.estaOcupadoEnPosicion(posicionOrigen));
    }

    @Test
    public void moverPosicion03(){
        Posicion posicionOrigen= new Posicion(1,7);
        Posicion posicionDestino= new Posicion(4,5);
        tablero.colocarAlgoformer(posicionOrigen);
        tablero.recorrer(posicionOrigen,posicionDestino);

        assertTrue(tablero.estaOcupadoEnPosicion(posicionDestino));
        assertFalse(tablero.estaOcupadoEnPosicion(posicionOrigen));
    }

}
