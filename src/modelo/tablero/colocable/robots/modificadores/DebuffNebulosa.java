package modelo.tablero.colocable.robots.modificadores;

public class DebuffNebulosa extends Modificador {
    int contador=1;
    int cantidadTurnos=3;
    int velocidadOriginal;

    @Override
    public void actualizar(){
        if (contador>cantidadTurnos){
            estadoAfectado.setVelocidad(velocidadOriginal);
            modificadores.remove(this);
        }
        contador++;
    }
    @Override
    public void activar(){
        if (yaFueAplicado())
            return;
        modificadores.add(this);
        velocidadOriginal=estadoAfectado.getVelocidad();
        estadoAfectado.setVelocidad(0);
    }

    @Override
    public Modificador copia() {
        return new DebuffNebulosa();
    }
}