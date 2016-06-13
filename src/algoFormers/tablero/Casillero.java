package algoFormers.tablero;

import algoFormers.tablero.colocable.Colocable;
import algoFormers.tablero.colocable.EspacioVacio;
import algoFormers.tablero.colocable.robots.armas.Ataque;
import algoFormers.tablero.posiciones.Posicion;
import algoFormers.tablero.superficieAerea.ContextoSuperficieArea;
import algoFormers.tablero.superficieTerrestre.ContextoSuperficieTerrestre;

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

    Casillero(){
        colocado=new EspacioVacio();
    }
    


    boolean estaOcupado(){
        return colocado.ocupaLugar();
    }


    void colocar(Colocable aColocar) {
        if (this.estaOcupado())
                throw new CasilleroYaOcupado();
        colocado=aColocar;
    }

	void vaciar(){
		colocado = new EspacioVacio();
	}
	
	Colocable obtenerColocado(){
		return colocado;
	}

    void atacarCasillero(Ataque ataque) {
        superficieTerrestreActual.recibirAtaque(ataque);
        colocado.recibirAtaque(ataque);
    }

    boolean compararPosicion(Posicion posicionAComparar) {
        return posicion.compararPosicion(posicionAComparar);
    }
}
