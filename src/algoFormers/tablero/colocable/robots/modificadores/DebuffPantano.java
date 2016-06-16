package algoFormers.tablero.colocable.robots.modificadores;

public class DebuffPantano extends Modificador {
    int velocidadOriginal;
    static double PORCENTAJE=0.5;
    @Override
    public void actualizar(){
        estadoAfectado.setVelocidad(velocidadOriginal);
        notificarOFF();
    }
    @Override
    public void activar(){
        notificarON();
        velocidadOriginal=estadoAfectado.getVelocidad();
        estadoAfectado.setVelocidad(velocidadOriginal-(int)(velocidadOriginal*PORCENTAJE));
    }
}
