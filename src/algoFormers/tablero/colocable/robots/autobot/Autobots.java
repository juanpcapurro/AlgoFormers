package algoFormers.tablero.colocable.robots.autobot;

import algoFormers.tablero.Tablero;
import algoFormers.tablero.colocable.robots.AlgoFormer;
import algoFormers.tablero.colocable.robots.Equipo;

public class Autobots extends Equipo {

    private final Optimus optimus;
    private final Bumblebee bumblebee;
    private final Ratchet ratchet;
    private boolean estaCombinado;
    private Superion superion=null;

    public Autobots(){
        this.optimus = new Optimus();
        this.bumblebee = new Bumblebee();
        this.ratchet = new Ratchet();
        estaCombinado = false;
    }

    public void ubicarUnidades(Tablero tablero){
        tablero.colocarRandom(optimus);
        tablero.colocarRandom(bumblebee);
        tablero.colocarRandom(ratchet);
    }

    @Override
    public void notificar(){
        if(estaCombinado())
            superion.notificar();
        optimus.notificar();
        bumblebee.notificar();
        ratchet.notificar();
    }

    @Override
    public boolean estaCombinado() {
        return estaCombinado;
    }

    @Override
    public AlgoFormer combinarme() {
        estaCombinado = true;
        superion=new Superion(optimus,bumblebee,ratchet);
        return superion;

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
