package algoFormers.tablero.colocable.robots.modificadores;

import algoFormers.tablero.colocable.robots.EstadoAlgoFormer;

import java.util.List;

public abstract class Modificador {
    EstadoAlgoFormer estadoAfectado;
    List<Modificador> modificadores;
    public void setEstado(EstadoAlgoFormer estado,List<Modificador> listaModificadores){
        estadoAfectado=estado;
        modificadores=listaModificadores;
        activar();
    }

    public abstract void actualizar();

    public abstract void activar();


}
