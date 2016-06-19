package algoFormers.tablero.colocable.robots.autobot;

import algoFormers.tablero.Tablero;
import algoFormers.tablero.colocable.robots.AlgoFormer;
import algoFormers.tablero.colocable.robots.Equipo;
import algoFormers.tablero.posiciones.Posicion;

public class Autobots extends Equipo {

    private final Optimus optimus;
    private final Bumblebee bumblebee;
    private final Ratchet ratchet;
    private boolean estaCombinado;

    public Autobots(){
        this.optimus = new Optimus();
        this.bumblebee = new Bumblebee();
        this.ratchet = new Ratchet();
        estaCombinado = false;
    }

    public void ubicarUnidades(Tablero tablero){
        Posicion posicion1=new Posicion(3,4);
        Posicion posicion2=new Posicion(4,7);
        Posicion posicion3=new Posicion(1,3);
        tablero.colocarAlgoformer(posicion1,optimus);
        tablero.colocarAlgoformer(posicion2,bumblebee);
        tablero.colocarAlgoformer(posicion3,ratchet);
    }

    @Override
    public void notificar(){
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
