package algoFormers.tablero.colocable.robots.decepticon;

import algoFormers.tablero.colocable.robots.*;

public class BoneCrusher extends Decepticon {
    public BoneCrusher(){
        this.ptosDeVida = 200;
		this.estadoActual = new ModoHumanoide(30,3,1);
    }
	public void pasarAModoAlterno(){
		estadoActual =new ModoAlternoTerrestre(30,3,8);
	}
	public void pasarAModoHumanoide(){
		estadoActual =new ModoHumanoide(30,3,1);
	}
}
