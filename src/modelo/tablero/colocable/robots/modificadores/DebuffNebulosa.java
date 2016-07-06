package modelo.tablero.colocable.robots.modificadores;

public class DebuffNebulosa extends Modificador {
    int contador=1;
    int cantidadTurnos=3;
    int velocidadOriginal;

    @Override
    public void actualizar(){
        if (contador>cantidadTurnos){
            estadoAfectado.movilizar();
            modificadores.remove(this);
        }
        contador++;
    }
    @Override
    public void activar(){
        if (yaFueAplicado())
            return;
        modificadores.add(this);
        estadoAfectado.inmovilizar();
    }

    @Override
    public Modificador copia() {
        return new DebuffNebulosa();
    }
}
