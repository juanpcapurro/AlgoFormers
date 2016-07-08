package modelo.juego;

import modelo.juego.jugador.*;
import modelo.tablero.Casillero;
import modelo.tablero.SinMovimientosDisponibles;
import modelo.tablero.Tablero;
import modelo.tablero.colocable.Chispa;
import modelo.tablero.colocable.Colocable;
import modelo.tablero.colocable.bonus.BurbujaInmaculada;
import modelo.tablero.colocable.bonus.DobleCanion;
import modelo.tablero.colocable.bonus.Flash;
import modelo.tablero.colocable.robots.NoPuedeTransformarsePorSerCombinado;
import modelo.tablero.colocable.robots.ObjetoInmovible;
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
        tablero.colocar(new Posicion(tablero.getDimension()/2,tablero.getDimension()/2),new Chispa());
        this.turno = new Turno(jugadorDos,jugadorUno);
    }

   public void saltearTurno(){
        turno.avanzarTurno();
   }

   public void mover(Posicion posicionInicial, Posicion posicionFinal) throws ObjetoInmovible, NoEsAlgoFormerPropio, JuegoFinalizado{//Esto hay que debatirlo con sharles
       try {
           turno.jugadorActual().mover(posicionInicial, posicionFinal);
       }catch (SinMovimientosDisponibles error) {
           turno.avanzarTurno();
       }
   }
   public void atacar(Posicion hostil, Posicion objetivo) throws NoEsAlgoFormerPropio, ObjetivoFueraDeRango, JuegoFinalizado, YaInicioMovimiento{
        turno.jugadorActual().atacar(hostil, objetivo);
        turno.avanzarTurno();
        if (!turno.jugadorActual().equipovivo())
            throw new JuegoFinalizado();
    }
   public void transformar(Posicion posicion)throws NoEsAlgoFormerPropio, NoPuedeTransformarsePorSerCombinado, YaInicioMovimiento{
       turno.jugadorActual().transformar(posicion);
       turno.avanzarTurno();
   }

   public void combinarODescombinar()throws NoPuedeCombinarPorTenerAlgoFormersMuertos, YaInicioMovimiento{
        turno.jugadorActual().combinarODescombinar();
       //No avanzo el turno porque en este caso el turno se avanza solo.
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
        return casillero.getColocable().getModo();
    }

   public void avanzarPosicionador(){
        posicionIterador=iterador.inicializarPosicion();
   }

   public void setPosicionador(Posicion unaPosicion){
        posicionIterador=unaPosicion;
   }

   public void resetPosicionador() {
        iterador=new ControladorPosiciones(8);
   }

   public DatosAlgoformer getDatos(){//Turbio af pero los quiero igual
        Casillero casillero=tablero.obtenerCasilleroAsociadoAPosicion(posicionIterador);
        if (jugadorUno.esAlgoformerPropio(casillero.getColocable()))
            return jugadorUno.obtenerDatos(casillero.getColocable());
        if (jugadorDos.esAlgoformerPropio(casillero.getColocable()))
            return jugadorDos.obtenerDatos(casillero.getColocable());
        return new DatosAlgoformer(1,0,0,0,0,"",null,null);
    }

    public boolean esJugable(Posicion posicion) {
        Colocable colocable=tablero.obtenerCasilleroAsociadoAPosicion(posicion).getColocable();
        if (jugadorUno.esAlgoformerPropio(colocable) || jugadorDos.esAlgoformerPropio(colocable))
            return true;
        return false;

    }
}
