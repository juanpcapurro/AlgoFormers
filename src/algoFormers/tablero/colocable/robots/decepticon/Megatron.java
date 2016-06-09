package algoFormers.tablero.colocable.robots.decepticon;

import algoFormers.tablero.colocable.robots.*;

public class Megatron extends Decepticon {
    public Megatron(){
        this.ptosDeVida = 550;
		this.estadoActual = new ModoHumanoide(10,3,1);
    }
	public void pasarAModoAlterno(){
		estadoActual =new ModoAlternoTerrestre(55,2,8);
	}
	public void pasarAModoHumanoide(){
		estadoActual =new ModoHumanoide(10,3,1);
	}
}
