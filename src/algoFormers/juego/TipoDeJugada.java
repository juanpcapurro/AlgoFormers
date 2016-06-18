package algoFormers.juego;

import algoFormers.tablero.colocable.robots.AlgoFormer;
import algoFormers.tablero.colocable.robots.Equipo;
import algoFormers.tablero.posiciones.Posicion;

import java.util.List;


public abstract class TipoDeJugada {

    public abstract AlgoFormer combinar(Equipo equipo);

    public  abstract void atacar(Posicion posicionDestino, AlgoFormer algoFormerDeLaJugada);

    public abstract void descombinar(AlgoFormer algoFormerDeLaJugada) ;

    public abstract void mover(AlgoFormer algoFormerDeLaJugada, Posicion posicionOrigen, Posicion posicionDestino);

    public abstract void transformar(AlgoFormer algoFormerDeLaJugada);

    public abstract boolean enProcesoDeCombinacion();

    public abstract void pasoTurno();

    public abstract boolean esDeCombinacion();
}
