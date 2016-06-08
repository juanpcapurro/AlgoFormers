package algoFormers.tablero.colocable.robots.autobot;

import algoFormers.tablero.colocable.robots.*;
public class Bumblebee extends Autobot {
	
    public Bumblebee(){
        this.ptosDeVida = 350;
		this.estadoActual = new ModoHumanoide(40, 1, 2);
    }
	public void pasarAModoAlterno(){
		estadoActual =new ModoAlternoTerrestre(20,3,5);
	}
	public void pasarAModoHumanoide(){
		estadoActual =new ModoHumanoide(40,1,2);
	}
}
