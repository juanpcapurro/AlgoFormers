package algoFormers.tablero.colocable.robots.modificadores;

public class DebuffTormenta extends Modificador {

    static double PORCENTAJE=0.4;
    int ataqueOriginal;

    @Override
    public void activar() {
        if (AfectadosPorTormenta.getInstance().fueAfectado(estadoAfectado))
            return;
        AfectadosPorTormenta.getInstance().agregar(estadoAfectado);
        ataqueOriginal=estadoAfectado.getAtaque();
        estadoAfectado.setAtaque(ataqueOriginal-(int)(ataqueOriginal*PORCENTAJE));
    }
}
