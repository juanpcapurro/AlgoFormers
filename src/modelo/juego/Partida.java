package modelo.juego;

import modelo.juego.jugador.Jugador;
import modelo.juego.jugador.JugadorAutobots;
import modelo.juego.jugador.JugadorDecepticons;
import modelo.juego.jugador.NoEsAlgoFormerPropio;
import modelo.tablero.Casillero;
import modelo.tablero.CasilleroYaOcupado;
import modelo.tablero.SinMovimientosDisponibles;
import modelo.tablero.Tablero;
import modelo.tablero.colocable.Colocable;
import modelo.tablero.colocable.bonus.BurbujaInmaculada;
import modelo.tablero.colocable.bonus.DobleCanion;
import modelo.tablero.colocable.bonus.Flash;
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
    Jugador jugadorUno;
    Jugador jugadorDos;

   public Partida(String nombreJugadorDecepticons, String nombreJugadorAutobots, int dimension) {
    	this.tablero = new Tablero(dimension);

        jugadorUno=new JugadorDecepticons(nombreJugadorDecepticons, tablero, new BoneCrusher(), new Frenzy(), new Megatron());
        jugadorDos=new JugadorAutobots(nombreJugadorAutobots, tablero, new Bumblebee(), new Optimus(), new Ratchet());
        tablero.colocarRandom(new Flash());
        tablero.colocarRandom(new BurbujaInmaculada());
        tablero.colocarRandom(new DobleCanion());
        this.turno = new Turno(jugadorDos,jugadorUno);
    }

   public void saltearTurno(){
        turno.avanzarTurno();
   }

   public void mover(Posicion posicionInicial, Posicion posicionFinal) {
       try {
           turno.jugadorActual().mover(posicionInicial, posicionFinal);
       }catch (CasilleroYaOcupado|NoEsAlgoFormerPropio e){
        return;
       }catch (SinMovimientosDisponibles e){
           turno.avanzarTurno();
           return;
       }
   }
    public void atacar(Posicion hostil, Posicion objetivo){
        turno.jugadorActual().atacar(hostil, objetivo);
        turno.avanzarTurno();
        if (!turno.jugadorActual().equipovivo())
            throw new JuegoFinalizado();
    }
    public void transformar(Posicion posicion){
        try{
        turno.jugadorActual().transformar(posicion);
    }catch (NoEsAlgoFormerPropio e){
        return;
    }
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

    public Object getEstado(){
        Casillero casillero=tablero.obtenerCasilleroAsociadoAPosicion(posicionIterador);
        return casillero.getColocable().getEstado();
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

    public DatosAlgoformer getDatos(){
        Casillero casillero=tablero.obtenerCasilleroAsociadoAPosicion(posicionIterador);
        if (jugadorUno.esAlgoformerPropio(casillero.getColocable()))
            return jugadorUno.obtenerDatos(casillero.getColocable());
        if (jugadorDos.esAlgoformerPropio(casillero.getColocable()))
            return jugadorDos.obtenerDatos(casillero.getColocable());
        return new DatosAlgoformer(1,0,0,0,0,"");
    }
}
