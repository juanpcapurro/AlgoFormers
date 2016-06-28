package modelo.tablero.colocable.robots.armas;

import modelo.tablero.Atacable;

public class Ataque {
    private int danio;
	public Ataque(int conQueDanio){
        danio = conQueDanio;
    }

	void atacar(Atacable target){
        target.recibirAtaque(this);
    }

	public int getDanio(){
        return danio;
    }

}