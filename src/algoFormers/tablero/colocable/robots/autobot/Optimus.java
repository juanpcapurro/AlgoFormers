package algoFormers.tablero.colocable.robots.autobot;

import algoFormers.tablero.colocable.robots.*;
public class Optimus extends Autobot {
	
    public Optimus(){
        this.ptosDeVida = 500;
		modoActual=new ContextoModoAlgoformer();
		modoActual.setActual(new ModoHumanoide(50,2,2));
		modoActual.setAlternativo(new ModoAlternoTerrestre(15,4,5));
    }
}
