package algoFormers.tablero.colocable.robots.modificadores;

import algoFormers.juego.NotificableTurno;
import algoFormers.tablero.colocable.robots.EstadoAlgoFormer;

public class Modificador extends NotificableTurno {
    EstadoAlgoFormer estadoAfectado;
    @Override
    public void actualizar() {
    }

    public void setEstado(EstadoAlgoFormer estado) {
        this.estadoAfectado = estado;
        this.activar();
    }

    public void activar(){

    }
}
