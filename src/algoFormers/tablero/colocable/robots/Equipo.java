package algoFormers.tablero.colocable.robots;

import algoFormers.tablero.Tablero;

public abstract class Equipo {

    public abstract AlgoFormer combinarme();

    public abstract boolean estaVivo();

    public abstract boolean estanTodosAlgoformersVivos();

    public abstract void notificar();

    public abstract boolean estaCombinado();

    public abstract void ubicarUnidades(Tablero tablero);
}
