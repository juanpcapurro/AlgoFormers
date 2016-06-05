package algoFormers.tablero.colocable.robots.decepticon;

import algoFormers.tablero.colocable.robots.AlgoFormer;

public class Menasor extends AlgoFormer {

    private final Megatron megatron;
    private final BoneCrusher boneCrusher;
    private final Frenzy frenzy;

    public Menasor(Megatron megatron, BoneCrusher boneCrusher, Frenzy frenzy) {
        this.megatron = megatron;
        this.boneCrusher = boneCrusher;
        this.frenzy = frenzy;
        this.ptosDeVida = megatron.getPuntosDeVida() + boneCrusher.getPuntosDeVida() + frenzy.getPuntosDeVida();
    }
    
}
