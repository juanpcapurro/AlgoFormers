package algoFormers.juego;

import algoFormers.juego.turno.Turno;
import algoFormers.tablero.Casillero;
import algoFormers.tablero.CasilleroYaOcupado;
import algoFormers.tablero.SinMovimientosDisponibles;
import algoFormers.tablero.Tablero;
import algoFormers.tablero.colocable.Colocable;
import algoFormers.tablero.colocable.robots.Equipo;
import algoFormers.tablero.colocable.robots.autobot.Autobots;
import algoFormers.tablero.colocable.robots.decepticon.Decepticons;
import algoFormers.tablero.posiciones.ControladorPosiciones;
import algoFormers.tablero.posiciones.Posicion;
import algoFormers.tablero.superficie.Superficie;
import java.util.List;

public class Partida {
	
    private Turno turno;
    private Tablero tablero;
    private Jugador jugadorUno;
    private Jugador jugadorDos;
    static final int DOSJUGADORES=2;
    ControladorPosiciones iterador=new ControladorPosiciones(8);
    Posicion posicionIterador=iterador.inicializarPosicion();


    public Partida(String nombreJugadorUno, String nombreJugadorDos, int dimension) {
    	iniciarPartidaDosJugadores(nombreJugadorUno,nombreJugadorDos,dimension);
    }

    private void iniciarPartidaDosJugadores (String nombreJugadorUno,String nombreJugadorDos,int dimension){
        jugadorUno=new Jugador(nombreJugadorUno);
        jugadorDos=new Jugador(nombreJugadorDos);
        this.tablero = new Tablero(dimension);
        crearAutobots(jugadorUno,tablero);
        crearDecepticons(jugadorDos,tablero);

        this.turno = new Turno(DOSJUGADORES);
        turno.agregarJugador(jugadorUno);
        turno.agregarJugador(jugadorDos);
    }

    private void crearAutobots(Jugador jugador,Tablero tablero){
        Equipo equipo=new Autobots();
        equipo.ubicarUnidades(tablero);
        jugador.asignarEquipo(equipo);
    }

    private void crearDecepticons(Jugador jugador,Tablero tablero){
        Equipo equipo=new Decepticons();
        equipo.ubicarUnidades(tablero);
       jugador.asignarEquipo(equipo);
    }

    public Superficie obtenerSuperficieTerrestre() {
        Casillero casillero =tablero.obtenerCasilleroAsociadoAPosicion(posicionIterador);
        return casillero.getSuperficieTerrestre();
    }

    public void setIterador(int x,int y){
        posicionIterador=new Posicion(x,y);
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
    public String getNombreJugador1() {
        return jugadorUno.getNombreDeJugador();
    }

    public String getNombreJugador2() {
        return jugadorDos.getNombreDeJugador();
    }

    public void asignarAutobotsAJugador(int i) {
        if (i==1)
            jugadorUno.asignarEquipo(new Autobots());
        else jugadorUno.asignarEquipo(new Decepticons());
    }

    public void asignarDecepticonsAJugador(int i) {
        if (i==1)
            jugadorDos.asignarEquipo(new Autobots());
        else jugadorDos.asignarEquipo(new Decepticons());
    }

    public void mover(List<Integer> initialCoordinates, List<Integer> finalCoordinates) {
        Posicion posicionInicial=new Posicion(initialCoordinates.get(0),initialCoordinates.get(1));
        Posicion posicionFinal=new Posicion(finalCoordinates.get(0),finalCoordinates.get(1));
        try {
            tablero.recorrer(posicionInicial, posicionFinal);
        }
        catch (SinMovimientosDisponibles e){
            System.out.print("sinMovimientos\n");
        }
        catch(CasilleroYaOcupado e){
            System.out.print("casilleroOcupado\n");
        }
    }

    public void resetIterador() {
    iterador=new ControladorPosiciones(8);
    }
}
