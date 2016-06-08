package algoFormers.tablero.colocable.robots.autobot;

import algoFormers.tablero.colocable.robots.*;
public class Ratchet extends Autobot {
	
    public Ratchet(){
        this.ptosDeVida = 150;
		this.estadoActual = new ModoHumanoide(5,5,1);
    }
	public void pasarAModoAlterno(){
		estadoActual =new ModoAlternoAereo(35,2,8);
	}
	public void pasarAModoHumanoide(){
		estadoActual =new ModoHumanoide(5,5,1);
	}
}
