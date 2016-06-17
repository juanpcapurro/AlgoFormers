package algoFormers.tablero.colocable.robots.modificadores;

public class DebuffPantano extends Modificador {
    int velocidadOriginal;
    static double PORCENTAJE=0.5;

    public void actualizar(){
        estadoAfectado.setVelocidad(velocidadOriginal);
        modificadores.remove(this);
    }

    public void activar(){
        velocidadOriginal=estadoAfectado.getVelocidad();
        estadoAfectado.setVelocidad(velocidadOriginal-(int)(velocidadOriginal*PORCENTAJE));
    }
}
