package modelo.tablero.colocable.robots.autobot;

import modelo.tablero.colocable.robots.*;
public class Optimus extends Autobot {
	
    public Optimus(){
        this.ptosDeVida = new Vida(500);
		contextoModoActual =new ContextoModoAlgoformer();
		contextoModoActual.setActual(new ModoHumanoide(ptosDeVida,50,2,2));
		contextoModoActual.setAlternativo(new ModoAlternoTerrestre(ptosDeVida,15,4,5));
    }
}
