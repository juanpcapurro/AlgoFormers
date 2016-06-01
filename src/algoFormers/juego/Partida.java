package algoFormers.juego;

import algoFormers.tablero.Tablero;
import algoFormers.tablero.colocable.robots.*;


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
        Jugador jugadorActual=turno.obtenerTurnoActual();
        while (jugadorActual.equipovivo()){
            pedirJugada(tablero,jugadorActual);
            jugadorActual=turno.obtenerTurnoActual();
        }
    }

    private void pedirJugada(Tablero tablero, Jugador jugador){

    }

    private void crearAutobots(Jugador jugador){
        jugador.agregarAlgoFormer(new Bumblebee());
        jugador.agregarAlgoFormer(new Ratchet());
        jugador.agregarAlgoFormer(new Optimus());
    }

    private void crearDecepticons(Jugador jugador){
        jugador.agregarAlgoFormer(new BoneCrusher());
        jugador.agregarAlgoFormer(new Frenzy());
        jugador.agregarAlgoFormer(new Megatron());
    }


}
