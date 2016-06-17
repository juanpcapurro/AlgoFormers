package algoFormers.tablero.colocable.robots.modificadores;

public class BuffFlash extends Modificador{
    static double PORCENTAJE= 1.5;
    int velocidadOriginal;
    int contador=0;
    int cantidadTurnos=6;

    @Override
    public void actualizar(){
        if (contador>=cantidadTurnos){
           modificadores.remove(this);
            estadoAfectado.setAtaque(velocidadOriginal);
        }
        contador++;
    }
    @Override
    public void activar(){
        velocidadOriginal= estadoAfectado.getVelocidad();
        estadoAfectado.setVelocidad((int)(velocidadOriginal*PORCENTAJE));
    }
}
