package algoFormers.tablero.colocable.robots.modificadores;

import algoFormers.tablero.colocable.robots.EstadoAlgoFormer;

import java.util.List;

public abstract class Modificador {
    protected EstadoAlgoFormer estadoAfectado;
    protected List<Modificador> modificadores;

    public void setEstado(EstadoAlgoFormer estado,List<Modificador> listaModificadores){
        estadoAfectado=estado;
        modificadores=listaModificadores;
        activar();
    }

    public abstract void actualizar();

    public abstract void activar();

    public abstract Modificador copia();

    boolean yaFueAplicado(){
        for (Modificador modificador : modificadores)
            if ((modificador.getClass()).equals(this.getClass()))//wut?
                return true;
        return false;
    }
}
