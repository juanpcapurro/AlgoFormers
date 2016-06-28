package modelo.tablero.colocable.robots.autobot;

import modelo.tablero.colocable.robots.*;

public class Superion extends Autobot{
    private final Optimus optimus;
    private final Bumblebee bumblebee;
    private final Ratchet ratchet;

    public Superion(Optimus optimus, Bumblebee bumblebee, Ratchet ratchet){
        this.optimus = optimus;
        this.bumblebee = bumblebee;
        this.ratchet = ratchet;
        this.ptosDeVida =new Vida(optimus.getPuntosDeVida() + bumblebee.getPuntosDeVida() + ratchet.getPuntosDeVida());
		modoActual=new ContextoModoAlgoformer();
        modoActual.setActual(new ModoHumanoide(ptosDeVida,100,2,3));
        modoActual.setAlternativo(new ModoHumanoide(ptosDeVida,100,2,3));
    }
}
