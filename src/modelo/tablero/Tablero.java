package modelo.tablero;

import modelo.tablero.colocable.Colocable;
import modelo.tablero.colocable.robots.AlgoFormer;
import modelo.tablero.colocable.robots.ObjetoInmovible;
import modelo.tablero.posiciones.ControladorPosiciones;
import modelo.tablero.posiciones.Posicion;

import java.util.ArrayList;
import java.util.List;

public class Tablero{
	private final int DIMENSION;
	private List<Casillero> listaCasilleros;
    ControladorPosiciones controlador;

	public Tablero(int dimension_pedida, boolean debug){
	    controlador= new ControladorPosiciones(dimension_pedida);
		listaCasilleros = new ArrayList<>();
		DIMENSION = dimension_pedida;
		for(int i=0;i<DIMENSION*DIMENSION;i++){
			Casillero casillero;
            Posicion posicion=controlador.inicializarPosicion();
			if(debug)
				casillero=new Casillero(posicion, true);
			else
				casillero = new Casillero(posicion);
			listaCasilleros.add(casillero);
		}
	}

	public Tablero(int dimension_pedida){
		this(dimension_pedida, false);
	}
    boolean estaTodoVacio(){
        for (Casillero casillero : listaCasilleros)
            if (casillero.estaOcupado())
                return false;
        return true;
    }

	public void colocar(Posicion posicion, Colocable aColocar){
        controlador.validarCoordenadas(posicion);
		Casillero casillero= obtenerCasilleroAsociadoAPosicion(posicion);
		casillero.colocar(aColocar);
	}

	public void colocarAlgoformer(Posicion posicion, AlgoFormer algoFormer) {
		this.colocar(posicion, algoFormer);
	}

    public Casillero obtenerCasilleroAsociadoAPosicion(Posicion posicion) {
        for (Casillero casillero : listaCasilleros){
            if (casillero.compararPosicion(posicion))
                return casillero;
        }
		throw new NoEncontradoError();
    }

	public Posicion obtenerPosicionAsociadaAColocable(Colocable unColocable){
		for (Casillero casillero : listaCasilleros)
			if(casillero.getColocable().equals(unColocable))
				return casillero.getPosicion();
		throw new NoEncontradoError();
	}

	private void mover(Posicion posicionOrigen, Posicion posicionDestino)throws SinMovimientosDisponibles, ObjetoInmovible{
        controlador.validarCoordenadas(posicionOrigen);
        controlador.validarCoordenadas(posicionDestino);
		Casillero casilleroOrigen=obtenerCasilleroAsociadoAPosicion(posicionOrigen);
		Casillero casilleroDestino=obtenerCasilleroAsociadoAPosicion(posicionDestino);
		casilleroOrigen.moverColocable(casilleroDestino);
	}


	public void recorrer(Posicion posicionOrigen,Posicion posicionDestino)throws  SinMovimientosDisponibles, ObjetoInmovible{
		Movimiento movimiento= new Movimiento(posicionOrigen,posicionDestino);
		while (movimiento.continuarMovimiento()){
			mover(movimiento.getActual(),movimiento.obtenerSiguiente());
			movimiento.avanzar();
		}
	}
	
	public boolean estaOcupadoEnPosicion(Posicion posicion){
		controlador.validarCoordenadas(posicion);
		Casillero casillero= obtenerCasilleroAsociadoAPosicion(posicion);
		return casillero.estaOcupado();
	}

	public void vaciarPosicion(Posicion posicion){
		controlador.validarCoordenadas(posicion);
		obtenerCasilleroAsociadoAPosicion(posicion).vaciar();
	}

	public void atacar(Posicion hostil, Posicion objetivo){
        controlador.validarCoordenadas(hostil);
		controlador.validarCoordenadas(objetivo);
		AlgoFormer atacante = (AlgoFormer) obtenerCasilleroAsociadoAPosicion(hostil).getColocable();
		Casillero destino=obtenerCasilleroAsociadoAPosicion(objetivo);
		atacante.atacar(destino.getColocable());
		destino.actualizarContenido();
	}

	public void colocarEspinas(Posicion posicion){
		Casillero casillero= obtenerCasilleroAsociadoAPosicion(posicion);
		casillero.cambiarAEspinas();
	}

	public void colocarRandom(Colocable colocable) {
        Posicion posicionRandom=controlador.getRandomPosition();
        try{
            colocar(posicionRandom,colocable);
        }
        catch (CasilleroYaOcupado excepcion){
            colocarRandom(colocable);//esto algun dia termina en stack overflow, Hay más chances de que termine en Stack
        }                            //Overflow por alguna de las otras 20k de atrocidades que hay en este codigo.
	}
	public int getDimension(){
		return this.DIMENSION;
	}
}
