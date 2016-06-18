package algoFormers.tablero.colocable.robots.modificadores;

public class DebuffEspinas extends Modificador {
    int contador=0;
    int cantidadTurnos=1;
    static double porcentaje=0.05;

    @Override
    public void actualizar() {
    }

    @Override
    public void activar(){
        int vida=estadoAfectado.getVida();
        estadoAfectado.setVida(vida-(int)(vida*porcentaje));
        modificadores.remove(this);
    }

    @Override
    public Modificador copia() {
        return new DebuffEspinas();
    }
}
