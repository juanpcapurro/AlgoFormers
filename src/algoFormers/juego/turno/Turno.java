package algoFormers.juego.turno;

import algoFormers.juego.Jugador;

import java.util.ArrayList;
import java.util.List;

public class Turno {

    private int turno;
    private List<Jugador> jugadores;
    private int cantidadDeJugadores;
    private boolean turnoFinalizado;
    private ContextoTurno tipoTurno;  //definir State.

    public Turno( int cantJugadores) {
        this.cantidadDeJugadores=cantJugadores;
        jugadores=new ArrayList<>();
        turno=0;
        turnoFinalizado = false;
    }
    
	public Jugador obtenerJugadorQueDebeJugar() {
        turnoFinalizado = false;
        return jugadores.get( turno % cantidadDeJugadores);
    }

    void finalizar(){
        turno++;
        turnoFinalizado = true;
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

    public boolean finalizado() {
        return turnoFinalizado;
    }

    /*
    public void jugarCon(String algoFormer) {

        Jugador jugadorActual = this.obtenerJugadorQueDebeJugar();
        jugadorActual.jugarCon(algoFormer);
    }

    public void atacar(Posicion posicionDestino) {

        Jugador jugadorActual = this.obtenerJugadorQueDebeJugar();
        jugadorActual.atacar(posicionDestino);
        this.finalizar();

    }

    public void mover(Posicion posicionOrigen, Posicion posicionDestino) {
        Jugador jugadorActual = this.obtenerJugadorQueDebeJugar();
        jugadorActual.mover(posicionOrigen, posicionDestino);
        // el jugador deberia poder pedirle al tablero los casilleros que va a necesitar.
        this.modoTurno.restarUnPaso(); //el modo estaria seteado en movimiento

    }

    public void transformar() {
        Jugador jugadorActual = this.obtenerJugadorQueDebeJugar();
        jugadorActual.transformar();
        this.finalizar();
    }


    public void combinarAlgoformers() {
        Jugador jugadorActual = this.obtenerJugadorQueDebeJugar();
        jugadorActual.combinarAlgoformers();
    }*/
}
