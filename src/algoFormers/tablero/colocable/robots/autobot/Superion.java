package algoFormers.tablero.colocable.robots.autobot;

import algoFormers.tablero.colocable.robots.*;

public class Superion extends AlgoFormer {
    private final Optimus optimus;
    private final Bumblebee bumblebee;
    private final Ratchet ratchet;

    public Superion(Optimus optimus, Bumblebee bumblebee, Ratchet ratchet){
        this.optimus = optimus;
        this.bumblebee = bumblebee;
        this.ratchet = ratchet;
        this.ptosDeVida = optimus.getPuntosDeVida() + bumblebee.getPuntosDeVida() + ratchet.getPuntosDeVida();
		modoActual=new ContextoModoAlgoformer();
        modoActual.setActual(new ModoHumanoide(100,2,3));
        modoActual.setAlternativo(new ModoHumanoide(100,2,3));
    }
}
