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

class Partida {
	
    private Turno turno;
    private Tablero tablero;
    private ControladorPosiciones iterador=new ControladorPosiciones(8);
    private Posicion posicionIterador=iterador.inicializarPosicion();

   public Partida(String nombreJugadorDecepticons, String nombreJugadorAutobots, int dimension) {
    	this.tablero = new Tablero(dimension);

        Jugador jugadorDecepticons=new Jugador(nombreJugadorDecepticons, tablero, new BoneCrusher(), new Frenzy(), new Megatron());
        Jugador jugadorAutobots=new Jugador(nombreJugadorAutobots, tablero, new Bumblebee(), new Optimus(), new Ratchet());

        this.turno = new Turno(jugadorAutobots, jugadorDecepticons);
    }

   public void saltearTurno(){
        turno.avanzarTurno();
   }

   public void mover(Posicion posicionInicial, Posicion posicionFinal) {
        turno.jugadorActual().mover(posicionInicial, posicionFinal);
        turno.avanzarTurno();
   }
    public void atacar(Posicion hostil, Posicion objetivo){
        turno.jugadorActual().atacar(hostil, objetivo);
        turno.avanzarTurno();
    }
    public void transformar(Posicion posicion){
        turno.jugadorActual().transformar(posicion);
        turno.avanzarTurno();
    }
    public void combinarODescombinar(){
        turno.jugadorActual().combinarODescombinar();
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

   public void setIterador(Posicion unaPosicion){
        posicionIterador=unaPosicion;
   }

   public void resetIterador() {
        iterador=new ControladorPosiciones(8);
   }
}
