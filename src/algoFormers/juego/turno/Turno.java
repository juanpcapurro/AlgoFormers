package algoFormers.juego.turno;

import algoFormers.juego.Jugador;
import algoFormers.juego.NotificadorTurno;
import algoFormers.juego.Modificadores;
import algoFormers.tablero.colocable.robots.AlgoFormer;
import algoFormers.tablero.posiciones.Posicion;

import java.util.ArrayList;
import java.util.List;

public class Turno {

    private int turno;
    private List<Jugador> jugadores;
    private int cantidadDeJugadores;
    private ContextoTurno tipoTurno;
    private boolean finalizado;

    public Turno( int cantJugadores) {
        this.cantidadDeJugadores=cantJugadores;
        jugadores=new ArrayList<>();
        turno=0;
        tipoTurno = new ContextoTurno();
    }
    
	public Jugador avanzarTurno() {
        NotificadorTurno.notificar();
        return jugadores.get( turno++ % cantidadDeJugadores);
    }


    public void agregarJugador(Jugador nuevoJugador){
        jugadores.add(nuevoJugador);
    }


    public void deCombinacion() {
        tipoTurno.combinacion();
    }


    public void deTransformacion() {
        tipoTurno.transformacion();
    }


    public void deMovimiento() {
        tipoTurno.movimiento();
    }


    public void deAtaque() {
        tipoTurno.ataque();
    }

    public Jugador obtenerJugadorQueDebeJugar(){

        this.finalizado = false;
        if (jugadores.get(turno % cantidadDeJugadores).enProcesoDeCombinacion()) {
            jugadores.get(turno % cantidadDeJugadores).pasoTurno();
            return this.avanzarTurno();
        }
        else{
            return jugadores.get(turno % cantidadDeJugadores);
        }
    }

    public void jugarCon(AlgoFormer algoFormer) {

        this.obtenerJugadorQueDebeJugar().jugarCon(algoFormer);
    }

    public void atacar(Posicion posicionDestino) {

        Jugador jugadorActual = this.obtenerJugadorQueDebeJugar();
        jugadorActual.atacar(posicionDestino);
        this.finalizar();

    }

    public void mover(Posicion posicionOrigen, Posicion posicionDestino) {
        Jugador jugadorActual = this.obtenerJugadorQueDebeJugar();
        jugadorActual.mover(posicionOrigen, posicionDestino);
        if(jugadorActual.seQuedoSinMovimientos()){
            this.finalizar();
        }
    }

    public void transformar() {
        Jugador jugadorActual = this.obtenerJugadorQueDebeJugar();
        jugadorActual.transformar();
        this.finalizar();
    }


    public void combinarAlgoformers() {
        Jugador jugadorActual = this.obtenerJugadorQueDebeJugar();
        jugadorActual.combinarAlgoformers();
        this.finalizar();
    }

    public void finalizar() {
        this.finalizado = true;
        this.avanzarTurno();
    }

    public boolean finalizado() {
        return this.finalizado;
    }
}
