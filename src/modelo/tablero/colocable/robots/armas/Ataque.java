package modelo.tablero.colocable.robots.armas;

import modelo.tablero.Atacable;

public class Ataque {
    private int danio;
	public Ataque(int conQueDanio){
        danio = conQueDanio;
    }

	public int getDanio(){
        return danio;
    }

}
