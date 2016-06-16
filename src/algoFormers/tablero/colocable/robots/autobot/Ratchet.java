package algoFormers.tablero.colocable.robots.autobot;

import algoFormers.tablero.colocable.robots.*;
public class Ratchet extends AlgoFormer {
	
    public Ratchet(){
        this.ptosDeVida = 150;
		modoActual=new ContextoModoAlgoformer();
		modoActual.setActual(new ModoHumanoide(5,5,1));
		modoActual.setAlternativo(new ModoAlternoAereo(35,2,8));
    }
}
