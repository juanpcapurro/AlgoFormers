package algoFormers.tablero;

import algoFormers.tablero.posiciones.ControladorPosiciones;
import algoFormers.tablero.posiciones.Posicion;
import algoFormers.tablero.colocable.Colocable;
import algoFormers.tablero.colocable.robots.AlgoFormer;
import algoFormers.tablero.colocable.robots.armas.Ataque;

import java.util.ArrayList;
import java.util.List;

public class Tablero{
	private final int DIMENSION;
	private List<Casillero> listaCasilleros;
    ControladorPosiciones controlador;

	public Tablero(int dimension_pedida){
        controlador= new ControladorPosiciones(dimension_pedida);
		listaCasilleros = new ArrayList<>();
		DIMENSION = dimension_pedida;
		for(int i=0;i<DIMENSION*DIMENSION;i++){
            Posicion posicion=controlador.inicializarPosicion();
			Casillero casillero=new Casillero(posicion);
			listaCasilleros.add(casillero);
		}
	}

    boolean estaTodoVacio(){
        for (Casillero casillero : listaCasilleros)
            if (casillero.estaOcupado())
                return false;
        return true;
    }

	void colocar(Posicion posicion,Colocable aColocar){
        controlador.validarCoordenadas(posicion);
		Casillero casillero= obtenerCasilleroAsociadoAPosicion(posicion);
		casillero.colocar(aColocar);
	}

	public void colocarAlgoformer(Posicion posicion, AlgoFormer algoFormer) {
		this.colocar(posicion, algoFormer);
	}

    public Casillero obtenerCasilleroAsociadoAPosicion(Posicion posicion){
        for (Casillero casillero : listaCasilleros){
            if (casillero.compararPosicion(posicion))
                return casillero;
        }
        return null;
    }


	public void mover(Posicion posicionOrigen, Posicion posicionDestino){
        controlador.validarCoordenadas(posicionOrigen);
        controlador.validarCoordenadas(posicionDestino);
		Casillero casilleroOrigen=obtenerCasilleroAsociadoAPosicion(posicionOrigen);
		Casillero casilleroDestino=obtenerCasilleroAsociadoAPosicion(posicionDestino);
		casilleroOrigen.moverColocable(casilleroDestino);
	}
/*
	Colocable colocableAMover = obtenerCasilleroAsociadoAPosicion(posicionOrigen).obtenerColocado();
	Colocable colocableEndestino=obtenerCasilleroAsociadoAPosicion(posicionDestino).obtenerColocado();
	if (colocableEndestino.ocupaLugar())
			return;
	colocableAMover.recibirColocable(colocableEndestino);
	this.vaciarPosicion(posicionOrigen);
	this.colocar(posicionDestino, colocableAMover);*/

	void recorrer(Posicion posicionOrigen,Posicion posicionDestino){
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

	public void atacar(Posicion posicion,Ataque ataque){
        controlador.validarCoordenadas(posicion);
		(obtenerCasilleroAsociadoAPosicion(posicion)).atacarCasillero(ataque);
	}

	public void colocarEspinas(Posicion posicion){
		Casillero casillero= obtenerCasilleroAsociadoAPosicion(posicion);
		casillero.cambiarAEspinas();
	}


}
