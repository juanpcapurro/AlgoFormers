package algoFormers.tablero;

import algoFormers.tablero.posiciones.Posicion;
import algoFormers.tablero.colocable.Colocable;
import algoFormers.tablero.colocable.EspacioVacio;
import algoFormers.tablero.colocable.robots.armas.Ataque;
import algoFormers.tablero.superficie.*;

public class Casillero {
    private Colocable colocado;
    private Superficie superficieActual;
    private Posicion posicion;

    Casillero(Posicion nuevaPosicion){
        colocado= new EspacioVacio();
        superficieActual= new Superficie();
        posicion=nuevaPosicion;
    }
    Casillero(){
        colocado= new EspacioVacio();
        superficieActual= new Superficie();
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
        superficieActual.recibirAtaque(ataque);
        colocado.recibirAtaque(ataque);
    }

    boolean compararPosicion(Posicion posicionAComparar) {
        return posicion.compararPosicion(posicionAComparar);
    }
}
