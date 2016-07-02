package modelo.tablero.colocable.robots.autobot;

import modelo.tablero.colocable.robots.*;

public class Superion extends Autobot{
    private final Autobot optimus;
    private final Autobot bumblebee;
    private final Autobot ratchet;

    public Superion( Autobot optimus, Autobot bumblebee, Autobot ratchet){
        this.optimus = optimus;
        this.bumblebee = bumblebee;
        this.ratchet = ratchet;
        this.ptosDeVida =new Vida(optimus.getPuntosDeVida() + bumblebee.getPuntosDeVida() + ratchet.getPuntosDeVida());
		modoActual=new ContextoModoAlgoformer();
        modoActual.setActual(new ModoHumanoide(ptosDeVida,100,2,3));
        modoActual.setAlternativo(new ModoHumanoide(ptosDeVida,100,2,3));
    }
}
