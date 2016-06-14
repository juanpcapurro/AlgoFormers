package algoFormers.tablero.colocable.robots;

public class ContextoModoAlgoformer {
    ModoAlgoformer modoActual;
    ModoAlgoformer modoAlternativo;

    public void setActual(ModoAlgoformer actual){
        modoActual=actual;
    }
    public void setAlternativo(ModoAlgoformer alternativo){
        modoAlternativo=alternativo;
    }

    public void cambiarModo(){
        ModoAlgoformer aux=modoActual;
        modoActual=modoAlternativo;
        modoAlternativo=aux;
    }

    ModoAlgoformer verModoActual(){
        return modoActual;
    }

    public EstadoAlgoFormer verEstadoActual(){
        return modoActual.verEstado();
    }
}
