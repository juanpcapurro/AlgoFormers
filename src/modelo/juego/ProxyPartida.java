package modelo.juego;

import modelo.juego.jugador.NoEsAlgoFormerPropio;
import modelo.juego.jugador.NoPuedeCombinarPorTenerAlgoFormersMuertos;
import modelo.juego.jugador.ObjetivoFueraDeRango;
import modelo.tablero.colocable.Colocable;
import modelo.tablero.colocable.robots.NoPuedeTransformarsePorSerCombinado;
import modelo.tablero.posiciones.Posicion;
import modelo.tablero.superficie.Superficie;

import static vista.controladores.SelectionController.actualizarCasillero;

public class ProxyPartida {
    Partida partida;
    static boolean notificarVista=false;

    public ProxyPartida(String nombreJugadorDecepticons, String nombreJugadorAutobots, int dimension) {
        partida = new Partida(nombreJugadorDecepticons, nombreJugadorAutobots, dimension);
    }

   public void saltearTurno(){
       partida.saltearTurno();
   }

   public void mover(Integer coordInicialX,Integer coordInicialY ,Integer coordFinalX, Integer coordFinaLY) throws NoEsAlgoFormerPropio {
        Posicion posicionInicial=new Posicion(coordInicialX,coordInicialY);
        Posicion posicionFinal=new Posicion(coordFinalX,coordFinaLY);
        partida.mover(posicionInicial, posicionFinal);
   }
    public void atacar(Integer coordInicialX,Integer coordInicialY ,Integer coordFinalX, Integer coordFinaLY) throws NoEsAlgoFormerPropio, ObjetivoFueraDeRango{
        Posicion inicial = new Posicion(coordInicialX,coordInicialY);
        Posicion objetivo = new Posicion(coordFinalX,coordFinaLY);
        partida.atacar(inicial,objetivo);
    }

    public void transformar(Integer coordInicialX,Integer coordInicialY )throws NoEsAlgoFormerPropio, NoPuedeTransformarsePorSerCombinado{
        Posicion posicion = new Posicion(coordInicialX,coordInicialY);
        partida.transformar(posicion);
    }
   public void combinarODescombinar()throws NoPuedeCombinarPorTenerAlgoFormersMuertos{
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

    public Object getEstado (){
        return partida.getEstado();
    }

    public DatosAlgoformer getDatos(){
        return partida.getDatos();
    }

    public static void setNotificarVista(){
        notificarVista=true;
    }

    public static void notificarMovimiento(Posicion posicionOrigen,Posicion posicionDestino) {
        notificarCambio(posicionOrigen);
        notificarCambio(posicionDestino);

    }

    static public void notificarCambio(Posicion posicion){
        int x = posicion.verCoordenadaX();
        int y = posicion.verCoordenadaY();
        if(notificarVista)
            actualizarCasillero(x,y);
    }

    public boolean esJugable(int x, int y) {
        Posicion posicion=new Posicion(x,y);
        return partida.esJugable(posicion);
    }
}
