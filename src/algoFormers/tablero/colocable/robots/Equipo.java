package algoFormers.tablero.colocable.robots;

public abstract class Equipo {

    public abstract AlgoFormer combinarme();

    public abstract boolean estaVivo();

    public abstract boolean estanTodosAlgoformersVivos();

    public abstract void notificar();
}
