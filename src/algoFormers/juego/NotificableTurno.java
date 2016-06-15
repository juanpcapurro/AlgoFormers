package algoFormers.juego;

public abstract class NotificableTurno {

    protected void notificarON(){
        NotificadorTurno.getInstance().agregarNotificable(this);
    }
    protected void notificarOFF(){
        NotificadorTurno.getInstance().eliminarNotificable(this);
    }
    public abstract void actualizar();

}
