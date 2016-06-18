package algoFormers.tablero.colocable.robots.modificadores;

public class DebuffTormenta extends Modificador {

    static double PORCENTAJE=0.4;
    int ataqueOriginal;

    @Override
    public void actualizar() {

    }

    @Override
    public void activar() {
        if (yaFueAplicado())
            return;
        modificadores.add(this);
        ataqueOriginal=estadoAfectado.getAtaque();
        estadoAfectado.setAtaque(ataqueOriginal-(int)(ataqueOriginal*PORCENTAJE));
    }

    @Override
    public Modificador copia() {
        return new DebuffTormenta();
    }
}
