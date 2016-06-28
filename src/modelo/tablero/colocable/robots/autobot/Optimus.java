package modelo.tablero.colocable.robots.autobot;

import modelo.tablero.colocable.robots.*;
public class Optimus extends Autobot {
	
    public Optimus(){
        this.ptosDeVida = new Vida(500);
		modoActual=new ContextoModoAlgoformer();
		modoActual.setActual(new ModoHumanoide(ptosDeVida,50,2,2));
		modoActual.setAlternativo(new ModoAlternoTerrestre(ptosDeVida,15,4,5));
    }
}
