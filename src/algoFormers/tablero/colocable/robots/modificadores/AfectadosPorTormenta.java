package algoFormers.tablero.colocable.robots.modificadores;

import algoFormers.tablero.colocable.robots.EstadoAlgoFormer;

import java.util.ArrayList;
import java.util.List;

public class AfectadosPorTormenta {
    private static AfectadosPorTormenta ourInstance = new AfectadosPorTormenta();

    public static AfectadosPorTormenta getInstance() {
        return ourInstance;
    }

    List<EstadoAlgoFormer> afectados;
    private AfectadosPorTormenta() {
        afectados=new ArrayList<>();
    }
    void agregar(EstadoAlgoFormer nuevoAfectado){
        afectados.add(nuevoAfectado);
    }

    boolean fueAfectado(EstadoAlgoFormer estado){
        for (EstadoAlgoFormer afectado : afectados)
            if (afectado.equals(estado))
                return true;
        return false;
    }
}
