package algoFormers.tablero.colocable.robots.decepticon;

import algoFormers.tablero.colocable.robots.*;

public class Frenzy extends Decepticon {
    public Frenzy(){
        this.ptosDeVida = 400;
		this.estadoActual = new ModoHumanoide(10, 5, 2);
    }
	public void pasarAModoAlterno(){
		estadoActual =new ModoAlternoTerrestre(25,2,6);
	}
	public void pasarAModoHumanoide(){
		estadoActual =new ModoHumanoide(10,5,2);
	}
}
