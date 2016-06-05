package algoFormers.tablero;

import algoFormers.tablero.colocable.Colocable;
import algoFormers.tablero.colocable.EspacioVacio;
import algoFormers.tablero.colocable.robots.armas.Ataque;
import algoFormers.tablero.superficie.*;

public class Casillero {
    private Colocable colocado;
    private SuperficieConcretaActual superficieActual;

    Casillero(){
        colocado= new EspacioVacio();
        superficieActual= new SuperficieConcretaActual();
    }

    public boolean estaOcupado(){
        return colocado.ocupaLugar();
    }


    public void colocar(Colocable aColocar) {
        if (this.estaOcupado())
                throw new CasilleroYaOcupado();
        colocado=aColocar;
    }

	public void vaciar(){
		colocado = new EspacioVacio();
	}
	
	public Colocable obtenerColocado(){
		return colocado;
	}

    public void atacarCasillero(Ataque ataque) {
        superficieActual.recibirAtaque(ataque);
        colocado.recibirAtaque(ataque);
    }
}
