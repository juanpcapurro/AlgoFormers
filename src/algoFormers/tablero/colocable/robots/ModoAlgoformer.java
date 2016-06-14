package algoFormers.tablero.colocable.robots;

public abstract class ModoAlgoformer {
    EstadoAlgoFormer estado;
    ContextoModoAlgoformer modoActual;
    public ModoAlgoformer(int ataque, int distanciaDeAtaque, int velocidad){
        estado= new EstadoAlgoFormer(ataque,distanciaDeAtaque,velocidad);
    }



    public void getVelocidad(){
        estado.getVelocidad();
    }
    public void getAtaque(){
        estado.getAtaque();
    }
    public EstadoAlgoFormer verEstado(){
        return estado;
    }
}
