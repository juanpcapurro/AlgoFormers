package modelo.tablero.colocable.robots.decepticon;

import modelo.tablero.colocable.robots.*;

public class Menasor extends Decepticon{

    private final Decepticon megatron;
    private final Decepticon boneCrusher;
    private final Decepticon frenzy;

    public Menasor(Decepticon megatron, Decepticon boneCrusher, Decepticon frenzy) {
        this.megatron = megatron;
        this.boneCrusher = boneCrusher;
        this.frenzy = frenzy;
        this.ptosDeVida = new Vida(megatron.getPuntosDeVida() + boneCrusher.getPuntosDeVida() + frenzy.getPuntosDeVida());
        modoActual=new ContextoModoAlgoformer();
		modoActual.setActual(new ModoHumanoide(ptosDeVida,115,2,2));
        modoActual.setAlternativo(new ModoHumanoide(ptosDeVida,115,2,2));
    }

}
