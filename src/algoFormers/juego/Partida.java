package algoFormers.juego;

import algoFormers.juego.turno.Turno;
import algoFormers.tablero.Tablero;
import algoFormers.tablero.colocable.robots.decepticon.*;
import algoFormers.tablero.colocable.robots.autobot.*;


public class Partida {
	
    private Turno turno;
    private Tablero tablero;
    private Jugador jugadorUno;
    private Jugador jugadorDos;
    static final int DOSJUGADORES=2;
    public Partida(String nombreJugadorUno, String nombreJugadorDos, int dimension) {
    	iniciarPartidaDosJugadores(nombreJugadorUno,nombreJugadorDos,dimension);

    }

    private void iniciarPartidaDosJugadores (String nombreJugadorUno,String nombreJugadorDos,int dimension){
        jugadorUno=new Jugador(nombreJugadorUno);
        jugadorDos=new Jugador(nombreJugadorDos);
        crearAutobots(jugadorUno);
        crearDecepticons(jugadorDos);

        this.turno = new Turno(DOSJUGADORES);
        turno.agregarJugador(jugadorUno);
        turno.agregarJugador(jugadorDos);

        this.tablero = new Tablero(dimension);
        jugar(tablero,turno);
    }

    private void jugar(Tablero tablero, Turno turno){
        Jugador jugadorActual=turno.obtenerJugadorQueDebeJugar();
        while (jugadorActual.equipovivo()){
            pedirJugada(tablero,jugadorActual);
        }
    }

    private void pedirJugada(Tablero tablero, Jugador jugador){
        //falta implementar esto
    }

    private void crearAutobots(Jugador jugador){
        jugador.agregarUnidad(new Bumblebee());
        jugador.agregarUnidad(new Ratchet());
        jugador.agregarUnidad(new Optimus());
    }

    private void crearDecepticons(Jugador jugador){
        jugador.agregarUnidad(new BoneCrusher());
        jugador.agregarUnidad(new Frenzy());
        jugador.agregarUnidad(new Megatron());
    }


}
