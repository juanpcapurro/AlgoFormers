package algoFormers.juego;

import algoFormers.tablero.colocable.robots.AlgoFormer;
import algoFormers.tablero.colocable.robots.Equipo;
import algoFormers.tablero.posiciones.Posicion;

import java.util.List;

public class JugadaAlgoformerSinCombinar extends TipoDeJugada {
    @Override
    public AlgoFormer combinar(Equipo equipo) {
        throw new EnCursoJugadaDeUnAlgoFormerSinCombinar();
    }

    @Override
    public void atacar(Posicion posicionDestino, AlgoFormer algoFormerDeLaJugada) {
        algoFormerDeLaJugada.atacar(posicionDestino);
    }

    @Override
    public void descombinar(AlgoFormer algoFormerDeLaJugada) {
        throw new AlgoformersNoFueronCombinados();

    }

    @Override
    public void mover(AlgoFormer algoFormerDeLaJugada, Posicion posicionOrigen, Posicion posicionDestino) {
        algoFormerDeLaJugada.mover(posicionOrigen,posicionDestino);
    }

    @Override
    public void transformar(AlgoFormer algoFormerDeLaJugada) {
        algoFormerDeLaJugada.transformar();

    }
    @Override
    public boolean enProcesoDeCombinacion() {
        return false;
    }

    @Override
    public void pasoTurno() {

    }

    @Override
    public boolean esDeCombinacion() {
        return false;
    }
}
