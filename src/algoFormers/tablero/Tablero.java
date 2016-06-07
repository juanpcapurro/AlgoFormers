package algoFormers.tablero;

import algoFormers.tablero.colocable.Colocable;
import algoFormers.tablero.colocable.robots.AlgoFormer;
import algoFormers.tablero.colocable.robots.armas.Ataque;

import java.util.ArrayList;
import java.util.List;

public class Tablero{
	private final int DIMENSION;
	private List<Casillero> listaCasilleros;

	public Tablero(int dimension_pedida){
        ControladorPosiciones.getInstance().resetPosiciones();
		listaCasilleros = new ArrayList<>();
		DIMENSION = dimension_pedida;
		for(int i=0;i<DIMENSION*DIMENSION;i++){
			Casillero casillero=new Casillero(new Posicion());
			listaCasilleros.add(casillero);
		}
	}

    public boolean estaTodoVacio(){
        for (Casillero casillero : listaCasilleros)
            if (casillero.estaOcupado())
                return false;
        return true;
    }

	public void colocar(Posicion posicion,Colocable aColocar){
        posicion.validarCoordenadas();
		Casillero casillero= obtenerCasilleroAsociadoAPosicion(posicion);
		casillero.colocar(aColocar);
	}

    private Casillero obtenerCasilleroAsociadoAPosicion(Posicion posicion){
        for (Casillero casillero : listaCasilleros){
            if (casillero.compararPosicion(posicion))
                return casillero;
        }
        return null;
    }

	public void colocarAlgoformer(Posicion posicion){

		this.colocar(posicion, new AlgoFormer());
	}

	public void mover(Posicion posicionOrigen, Posicion posicionDestino){
		/*MOVER DEBE SER MEJORADO PARA CONSIDERAR:
		 * -Distancias permitidas de los algoformers
		 * -Posibilidad de elegir paso a paso el casillero siguiente
		 * -En cada eleccion, el tablero validaria si es posible o no.*/
        posicionOrigen.validarCoordenadas();
        posicionDestino.validarCoordenadas();
		
		Colocable colocableAMover = obtenerCasilleroAsociadoAPosicion(posicionOrigen).obtenerColocado();
		this.vaciarPosicion(posicionOrigen);
		this.colocar(posicionDestino, colocableAMover);
	}
	
	public boolean estaOcupadoEnPosicion(Posicion posicion){
		posicion.validarCoordenadas();
		Casillero casillero= obtenerCasilleroAsociadoAPosicion(posicion);
		return casillero.estaOcupado();
	}


	public void vaciarPosicion(Posicion posicion){
		posicion.validarCoordenadas();
		obtenerCasilleroAsociadoAPosicion(posicion).vaciar();
	}

	public void atacar(Posicion posicion,Ataque ataque){
		posicion.validarCoordenadas();
		(obtenerCasilleroAsociadoAPosicion(posicion)).atacarCasillero(ataque);
	}
}
