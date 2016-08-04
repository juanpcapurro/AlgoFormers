package modelo.tablero;

import modelo.tablero.colocable.Colocable;
import modelo.tablero.colocable.EspacioVacio;
import modelo.tablero.colocable.robots.ObjetoInmovible;
import modelo.tablero.posiciones.Posicion;
import modelo.tablero.superficie.Superficie;
import modelo.tablero.superficieAerea.ContextoSuperficieArea;
import modelo.tablero.superficieTerrestre.ContextoSuperficieTerrestre;

import static modelo.juego.AdaptadorPartida.notificarMovimiento;

public class Casillero {
    private Colocable colocado;
    private ContextoSuperficieTerrestre superficieTerrestreActual;
    private ContextoSuperficieArea superficieAereaActual;
    private Posicion posicion;

    Casillero(Posicion nuevaPosicion){
        colocado= new EspacioVacio();
        superficieAereaActual= new ContextoSuperficieArea();
        superficieTerrestreActual=new ContextoSuperficieTerrestre();
        posicion=nuevaPosicion;
    }
    Casillero(Posicion nuevaPosicion, boolean debug){
        colocado= new EspacioVacio();
        superficieAereaActual= new ContextoSuperficieArea(debug);
        superficieTerrestreActual=new ContextoSuperficieTerrestre(debug);
        posicion=nuevaPosicion;
    }
    Casillero(){
        colocado=new EspacioVacio();
        superficieAereaActual= new ContextoSuperficieArea();
        superficieTerrestreActual=new ContextoSuperficieTerrestre();
    }

    boolean estaOcupado(){
        return colocado.ocupaLugar();
    }

    void colocar(Colocable aColocar) {
        if (this.estaOcupado())
                throw new CasilleroYaOcupado();
        colocado=aColocar;
        aColocar.pasarPor(superficieTerrestreActual.getActual(),superficieAereaActual.getActual());
    }

	void vaciar(){
		colocado = new EspacioVacio();
	}
	
	private Colocable obtenerColocado(){
		return colocado;
	}

    boolean compararPosicion(Posicion posicionAComparar) {
        return posicion.compararPosicion(posicionAComparar);
    }

    public Posicion getPosicion(){
        return this.posicion;
    }
    void cambiarAEspinas() {
        superficieTerrestreActual.cambiarEspinas();
    }

    void moverColocable(Casillero casilleroDestino) throws CasilleroYaOcupado, SinMovimientosDisponibles, ObjetoInmovible{
        Colocable colocableEndestino=casilleroDestino.obtenerColocado();
        if (colocableEndestino.ocupaLugar())
            throw new CasilleroYaOcupado();
        if (!colocado.esMovible())
            throw new SinMovimientosDisponibles();
        colocado.recibirColocable(colocableEndestino);
        casilleroDestino.colocar(colocado);
        colocado=new EspacioVacio();
        notificarMovimiento(posicion,casilleroDestino.posicion);
    }

    public Superficie getSuperficieTerrestre() {
        return superficieTerrestreActual.getActual();
    }

    public Superficie getSuperficieAerea() {
        return superficieAereaActual.getActual();
    }

    public Colocable getColocable() {
        return colocado;
    }


    public void actualizarContenido() {
        if (colocado.retirar())
            vaciar();
    }
}
