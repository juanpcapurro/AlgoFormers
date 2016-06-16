package algoFormers.tablero.colocable.robots.decepticon;

import algoFormers.tablero.colocable.robots.AlgoFormer;
import algoFormers.tablero.colocable.robots.Equipo;

public class Decepticons extends Equipo {

    private final BoneCrusher boneCrusher;
    private final Frenzy frenzy;
    private final Megatron megatron;

    public Decepticons(){
        this.boneCrusher = new BoneCrusher();
        this.frenzy = new Frenzy();
        this.megatron = new Megatron();
    }

    @Override
    public AlgoFormer combinarme() {
        return new Menasor(megatron,boneCrusher,frenzy);
    }

    @Override
    public boolean estaVivo() {
        return (boneCrusher.estaVivo() || frenzy.estaVivo() || megatron.estaVivo());
    }

    @Override
    public boolean estanTodosAlgoformersVivos() {
        return (boneCrusher.estaVivo() && frenzy.estaVivo() && megatron.estaVivo());
    }

    public BoneCrusher getBoneCrusher() {
        return boneCrusher;
    }

}
