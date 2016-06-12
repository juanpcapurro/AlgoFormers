package algoFormers.tablero;

import algoFormers.tablero.posiciones.Posicion;

public class Movimiento {
    Posicion posicionActual;
    Posicion posicionDestino;

    Movimiento (Posicion actual, Posicion destino){
        posicionActual=actual;
        posicionDestino=destino;
    }

    boolean continuarMovimiento(){
        return !posicionActual.compararPosicion(posicionDestino);
    }

    Posicion getActual(){
        return posicionActual;
    }
    Posicion obtenerSiguiente(){
        return posicionActual.obtenerSiguiente(posicionDestino);
    }
    void avanzar(){
        posicionActual=posicionActual.obtenerSiguiente(posicionDestino);
    }
}
