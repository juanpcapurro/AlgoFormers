package modelo.tablero.posiciones;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ControladorPosicionesTest {
    private Posicion esquinaSuperiorDerecha;
    private Posicion esquinaSuperiorIzquierda;
    private Posicion esquinaInferiorIzquierda;
    private Posicion esquinaInferiorDerecha;
    private ControladorPosiciones controlador;
    private final int DIMENSION = 8;


    @Before
    public void setUp() throws Exception {
        esquinaInferiorDerecha = new Posicion(DIMENSION-1, DIMENSION-1);
        esquinaSuperiorDerecha = new Posicion(0, DIMENSION-1);
        esquinaInferiorIzquierda = new Posicion(DIMENSION-1, 0);
        esquinaSuperiorIzquierda = new Posicion(0,0);
        controlador = new ControladorPosiciones(DIMENSION);
    }
    @Test
    public void iteradorFuncionaAlComienzo(){
        assertEquals(esquinaSuperiorIzquierda, controlador.inicializarPosicion());
        assertEquals(new Posicion(1,0), controlador.inicializarPosicion());
        controlador.inicializarIteradorDesdePosicion(esquinaSuperiorIzquierda);
        assertEquals(esquinaSuperiorIzquierda, controlador.inicializarPosicion());
        assertEquals(new Posicion(1,0), controlador.inicializarPosicion());
    }
    @Test
    public void iteradorFuncionaEnLimiteX(){
        controlador.inicializarIteradorDesdePosicion(esquinaInferiorIzquierda);
        assertEquals(esquinaInferiorIzquierda, controlador.inicializarPosicion());
        assertEquals(new Posicion(0,1), controlador.inicializarPosicion());
        assertEquals(new Posicion(1,1), controlador.inicializarPosicion());
    }
    @Test
    public void iteradorFuncionaEnLimiteXY(){
        controlador.inicializarIteradorDesdePosicion(new Posicion(DIMENSION-2, DIMENSION-1));
        assertEquals(new Posicion(DIMENSION-2,DIMENSION-1), controlador.inicializarPosicion());
        assertEquals(esquinaInferiorDerecha, controlador.inicializarPosicion());

    }
    @Test
    public void testDistancia(){

    }
}