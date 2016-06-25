package modelo.juego;

import modelo.tablero.Casillero;
import modelo.tablero.Tablero;
import modelo.tablero.colocable.Colocable;
import modelo.tablero.colocable.robots.autobot.Bumblebee;
import modelo.tablero.colocable.robots.autobot.Optimus;
import modelo.tablero.colocable.robots.autobot.Ratchet;
import modelo.tablero.colocable.robots.decepticon.BoneCrusher;
import modelo.tablero.colocable.robots.decepticon.Frenzy;
import modelo.tablero.colocable.robots.decepticon.Megatron;
import modelo.tablero.posiciones.ControladorPosiciones;
import modelo.tablero.posiciones.Posicion;
import modelo.tablero.superficie.Superficie;
import java.util.List;

public class Partida {
	
    private Turno turno;
    private Tablero tablero;
    static final int DOSJUGADORES=2;
    ControladorPosiciones iterador=new ControladorPosiciones(8);
    Posicion posicionIterador=iterador.inicializarPosicion();

    public Partida(String nombreJugadorDecepticons, String nombreJugadorAutobots, int dimension) {
    	this.tablero = new Tablero(dimension);

        Jugador jugadorDecepticons=new Jugador(nombreJugadorDecepticons, tablero, new BoneCrusher(), new Frenzy(), new Megatron());
        Jugador jugadorAutobots=new Jugador(nombreJugadorAutobots, tablero, new Bumblebee(), new Optimus(), new Ratchet());

        this.turno = new Turno(jugadorAutobots, jugadorDecepticons);
    }

   public void saltearTurno(){
        turno.avanzarTurno();
   }

   public void mover(List<Integer> initialCoordinates, List<Integer> finalCoordinates) {
        Posicion posicionInicial=new Posicion(initialCoordinates.get(0),initialCoordinates.get(1));
        Posicion posicionFinal=new Posicion(finalCoordinates.get(0),finalCoordinates.get(1));
        turno.jugadorActual().mover(posicionInicial, posicionFinal);
        turno.avanzarTurno();
   }
   public Superficie obtenerSuperficieTerrestre() {
        Casillero casillero =tablero.obtenerCasilleroAsociadoAPosicion(posicionIterador);
        return casillero.getSuperficieTerrestre();
   }

   public DatosJugador getDatosJugadorActual() {
        return turno.jugadorActual().getDatosJugador();
   }
   public Superficie obtenerSuperficieAerea() {
        Casillero casillero =tablero.obtenerCasilleroAsociadoAPosicion(posicionIterador);
        return casillero.getSuperficieAerea();
   }

   public Colocable obtenerColocable(){
        Casillero casillero=tablero.obtenerCasilleroAsociadoAPosicion(posicionIterador);
        return casillero.getColocable();
   }

   public void avanzarIterador(){
        posicionIterador=iterador.inicializarPosicion();
   }

   public void setIterador(int x,int y){
        posicionIterador=new Posicion(x,y);
   }

   public void resetIterador() {
        iterador=new ControladorPosiciones(8);
   }
}
