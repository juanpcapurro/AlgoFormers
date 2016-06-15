package algoFormers.juego;

import java.util.ArrayList;
import java.util.List;

public class NotificadorTurno {
    private static NotificadorTurno ourInstance = new NotificadorTurno();

    public static NotificadorTurno getInstance() {
        return ourInstance;
    }
    static List<NotificableTurno> notificables=new ArrayList<>();
    private NotificadorTurno(){
    }

    public void agregarNotificable(NotificableTurno notificable){
        notificables.add(notificable);
    }

    public void eliminarNotificable(NotificableTurno notificable){
        notificables.remove(notificable);
    }

    public static void notificar(){
        for(NotificableTurno notificable : notificables)
            notificable.actualizar();
    }
    public static void reset(){
        notificables=new ArrayList<>();
    }

}
