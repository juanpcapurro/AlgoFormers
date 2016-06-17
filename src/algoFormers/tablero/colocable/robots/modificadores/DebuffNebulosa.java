package algoFormers.tablero.colocable.robots.modificadores;

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
        velocidadOriginal=estadoAfectado.getVelocidad();
        estadoAfectado.setVelocidad(0);
    }
}
