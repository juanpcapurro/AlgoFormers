package algoFormers.juego;

import algoFormers.tablero.colocable.robots.Modificador;

import java.util.ArrayList;
import java.util.List;

public class Modificadores {
    private static Modificadores ourInstance = new Modificadores();

    public static Modificadores getInstance() {
        return ourInstance;
    }
    static List<Modificador> modificadores=new ArrayList<>();
    private Modificadores(){
    }

    void agregarModificador(Modificador modificador){
        modificadores.add(modificador);
    }

    void eliminarModificador(Modificador modificador){
        modificadores.remove(modificador);
    }

    public static void notificar(){
        for(Modificador modificador : modificadores)
            modificador.actualizar();
    }

}
