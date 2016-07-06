package modelo.tablero.colocable.robots.autobot;

import modelo.tablero.colocable.robots.*;
public class Ratchet extends Autobot{
	
    public Ratchet(){
        this.ptosDeVida =new Vida(150);
		contextoModoActual =new ContextoModoAlgoformer();
		contextoModoActual.setActual(new ModoHumanoide(ptosDeVida,5,5,1));
		contextoModoActual.setAlternativo(new ModoAlternoAereo(ptosDeVida,35,2,8));
    }
}
