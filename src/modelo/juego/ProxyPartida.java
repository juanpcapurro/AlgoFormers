package modelo.juego;

import modelo.tablero.colocable.Colocable;
import modelo.tablero.posiciones.Posicion;
import modelo.tablero.superficie.Superficie;

public class ProxyPartida {
    Partida partida;

    public ProxyPartida(String nombreJugadorDecepticons, String nombreJugadorAutobots, int dimension) {
        partida = new Partida(nombreJugadorDecepticons, nombreJugadorAutobots, dimension);
    }

   public void saltearTurno(){
       partida.saltearTurno();
   }

   public void mover(Integer coordInicialX,Integer coordInicialY ,Integer coordFinalX, Integer coordFinaLY) {
        Posicion posicionInicial=new Posicion(coordInicialX,coordInicialY);
        Posicion posicionFinal=new Posicion(coordFinalX,coordFinaLY);
        partida.mover(posicionInicial, posicionFinal);
   }
    public void atacar(Integer coordInicialX,Integer coordInicialY ,Integer coordFinalX, Integer coordFinaLY){
        Posicion inicial = new Posicion(coordInicialX,coordInicialY);
        Posicion objetivo = new Posicion(coordFinalX,coordFinaLY);
        partida.atacar(inicial,objetivo);
    }

    public void transformar(Integer coordInicialX,Integer coordInicialY ){
        Posicion posicion = new Posicion(coordInicialX,coordInicialY);
        partida.transformar(posicion);
    }
   public void combinarODescombinar(){
       partida.combinarODescombinar();
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
