package algoFormers.tablero.colocable.robots.autobot;

import algoFormers.tablero.colocable.robots.*;
public class Optimus extends Autobot {
	
    public Optimus(){
        this.ptosDeVida = 500;
		this.estadoActual = new ModoHumanoide(50,2,2);
    }
	public void pasarAModoAlterno(){
		estadoActual =new ModoAlternoTerrestre(15,4,5);
	}
	public void pasarAModoHumanoide(){
		estadoActual =new ModoHumanoide(50,2,2);
	}
}
