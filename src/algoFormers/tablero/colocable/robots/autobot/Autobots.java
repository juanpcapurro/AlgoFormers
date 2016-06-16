package algoFormers.tablero.colocable.robots.autobot;

import algoFormers.tablero.colocable.robots.AlgoFormer;
import algoFormers.tablero.colocable.robots.Equipo;

public class Autobots extends Equipo {

    private final Optimus optimus;
    private final Bumblebee bumblebee;
    private final Ratchet ratchet;

    public Autobots(){
        this.optimus = new Optimus();
        this.bumblebee = new Bumblebee();
        this.ratchet = new Ratchet();
    }

    @Override
    public AlgoFormer combinarme() {
        return new Superion(optimus,bumblebee,ratchet);
    }

    @Override
    public boolean estaVivo() {
        return (optimus.estaVivo() || bumblebee.estaVivo() || ratchet.estaVivo());
    }

    @Override
    public boolean estanTodosAlgoformersVivos() {
        return (optimus.estaVivo() && bumblebee.estaVivo() && ratchet.estaVivo());

    }

    public Bumblebee getBumblebee() {
        return bumblebee;
    }

    public Optimus getOptimus() {
        return optimus;
    }

    public Ratchet getRatchet() {
        return ratchet;
    }
}
