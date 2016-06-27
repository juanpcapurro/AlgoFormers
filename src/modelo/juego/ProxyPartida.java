package modelo.juego;

import modelo.tablero.Casillero;
import modelo.tablero.colocable.Colocable;
import modelo.tablero.posiciones.Posicion;
import modelo.tablero.superficie.Superficie;

import java.util.List;

public class ProxyPartida {
    Partida partida;

    public ProxyPartida(String nombreJugadorDecepticons, String nombreJugadorAutobots, int dimension) {
        partida = new Partida(nombreJugadorDecepticons, nombreJugadorAutobots, dimension);
    }

   public void saltearTurno(){
       partida.saltearTurno();
   }

   public void mover(List<Integer> initialCoordinates, List<Integer> finalCoordinates) {
        Posicion posicionInicial=new Posicion(initialCoordinates.get(0),initialCoordinates.get(1));
        Posicion posicionFinal=new Posicion(finalCoordinates.get(0),finalCoordinates.get(1));
        partida.mover(posicionInicial, posicionFinal);
   }
   public Superficie obtenerSuperficieTerrestre() {
       return partida.obtenerSuperficieTerrestre();
   }

   public DatosJugador getDatosJugadorActual() {
       return partida.getDatosJugadorActual();
   }
   public Superficie obtenerSuperficieAerea() {
       return partida.obtenerSuperficieAerea();
   }

   public Colocable obtenerColocable(){
       return partida.obtenerColocable();
   }

   public void avanzarIterador(){
       partida.avanzarIterador();
   }

   public void setIterador(int x,int y){
       partida.setIterador(new Posicion(x, y));
   }

   public void resetIterador() {
       partida.resetIterador();
   }
}
