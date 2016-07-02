package modelo.tablero.colocable.robots.autobot;

import modelo.tablero.colocable.robots.*;
public class Ratchet extends Autobot{
	
    public Ratchet(){
        this.ptosDeVida =new Vida(150);
		modoActual=new ContextoModoAlgoformer();
		modoActual.setActual(new ModoHumanoide(ptosDeVida,5,5,1));
		modoActual.setAlternativo(new ModoAlternoAereo(ptosDeVida,35,2,8));
    }
}
