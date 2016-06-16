package algoFormers.juego;

import algoFormers.tablero.colocable.robots.AlgoFormer;
import algoFormers.tablero.colocable.robots.Equipo;
import algoFormers.tablero.posiciones.Posicion;


import java.util.List;

public class Jugada {

    protected AlgoFormer algoFormerDeLaJugada;
    private TipoDeJugada tipoDeJugada;
    private int movimientosDisponibles;

    public Jugada(){
        tipoDeJugada = new JugadaAlgoformerSinCombinar();
    }

    public void transformar() {
        tipoDeJugada.transformar(algoFormerDeLaJugada);
    }

    public void combinar(Equipo equipo) {
        algoFormerDeLaJugada = tipoDeJugada.combinar(equipo);
    }

    public void descombinar(){
        tipoDeJugada.descombinar(algoFormerDeLaJugada);
    }

    public void atacar(Posicion posicionDestino) {
        tipoDeJugada.atacar(posicionDestino,algoFormerDeLaJugada);
    }

    public void jugarCon(AlgoFormer algoFormerDeLaJugada) {

        this.tipoDeJugada = new JugadaAlgoformerSinCombinar();
        this.algoFormerDeLaJugada = algoFormerDeLaJugada;
        this.movimientosDisponibles = algoFormerDeLaJugada.getVelocidad();
    }

    public void mover(Posicion posicionOrigen, Posicion posicionDestino) {
        if (movimientosDisponibles > 0) {
            this.tipoDeJugada.mover(algoFormerDeLaJugada, posicionOrigen, posicionDestino);
            movimientosDisponibles -= 1;
        } else {
            throw new YaUtilizoPasosDisponibles();
        }
    }

    public void vaASerDeCombinacion() {
        tipoDeJugada = new JugadaAlgoformersCombinados(algoFormerDeLaJugada);
    }

    public boolean enProcesoDeCombinacion() {
        return tipoDeJugada.enProcesoDeCombinacion();
    }

    public void pasoTurno() {
        tipoDeJugada.pasoTurno();
    }


    public int getMovimientosDisponibles() {
        return movimientosDisponibles;
    }
}
