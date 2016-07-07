package modelo.tablero;

import modelo.tablero.colocable.robots.AlgoFormer;
import modelo.tablero.colocable.robots.NoPuedeTransformarsePorSerCombinado;
import modelo.tablero.colocable.robots.ObjetoInmovible;
import modelo.tablero.colocable.robots.autobot.Optimus;
import modelo.tablero.posiciones.Posicion;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MovimientoTest {
    Tablero tablero;
    AlgoFormer algoFormerDePrueba;

    @Before
    public void initialize(){
        tablero=new Tablero(8);
        algoFormerDePrueba = new Optimus();
    }

    @Test
    public void moverPosicion01() throws NoPuedeTransformarsePorSerCombinado, SinMovimientosDisponibles, ObjetoInmovible{
        Posicion posicionOrigen= new Posicion(3,4);
        Posicion posicionDestino= new Posicion(3,5);
        algoFormerDePrueba.transformar();
        tablero.colocarAlgoformer(posicionOrigen,algoFormerDePrueba);
        tablero.recorrer(posicionOrigen,posicionDestino);

        assertTrue(tablero.estaOcupadoEnPosicion(posicionDestino));
        assertFalse(tablero.estaOcupadoEnPosicion(posicionOrigen));
    }

    @Test
    public void moverPosicion02() throws NoPuedeTransformarsePorSerCombinado, SinMovimientosDisponibles, ObjetoInmovible{
        Posicion posicionOrigen= new Posicion(3,5);
        Posicion posicionDestino= new Posicion(3,4);
        algoFormerDePrueba.transformar();
        tablero.colocarAlgoformer(posicionOrigen,algoFormerDePrueba);
        tablero.recorrer(posicionOrigen,posicionDestino);

        assertTrue(tablero.estaOcupadoEnPosicion(posicionDestino));
        assertFalse(tablero.estaOcupadoEnPosicion(posicionOrigen));
    }

    @Test
    public void moverPosicion03() throws NoPuedeTransformarsePorSerCombinado, SinMovimientosDisponibles, ObjetoInmovible{
        Posicion posicionOrigen= new Posicion(1,7);
        Posicion posicionDestino= new Posicion(1,6);
        algoFormerDePrueba.transformar();
        tablero.colocarAlgoformer(posicionOrigen,algoFormerDePrueba);
        tablero.recorrer(posicionOrigen,posicionDestino);

        assertTrue(tablero.estaOcupadoEnPosicion(posicionDestino));
        assertFalse(tablero.estaOcupadoEnPosicion(posicionOrigen));
    }

}
