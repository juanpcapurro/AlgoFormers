package algoFormers.tablero.colocable.robots.autobot;

import algoFormers.tablero.colocable.robots.*;
public class Bumblebee extends AlgoFormer {
	
    public Bumblebee(){
        this.ptosDeVida = 350;
		modoActual= new ContextoModoAlgoformer();
		modoActual.setActual(new ModoHumanoide(40, 1, 2));
		modoActual.setAlternativo(new ModoAlternoTerrestre(20,3,5));
    }

}
