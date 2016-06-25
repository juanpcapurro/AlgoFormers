package modelo.tablero.colocable.robots.modificadores;

public class BuffFlash extends Modificador{
    static double PORCENTAJE= 3;
    int velocidadOriginal;
    int contador=0;
    int cantidadTurnos=6;

    public BuffFlash(){
        super();
    }
    @Override
    public void actualizar(){
        if (contador>=cantidadTurnos){
            modificadores.remove(this);
            estadoAfectado.setVelocidad(velocidadOriginal);
        }
        contador++;
    }
    @Override
    public void activar(){
        if (yaFueAplicado())
            return;
        modificadores.add(this);
        velocidadOriginal= estadoAfectado.getVelocidad();
        estadoAfectado.setVelocidad((int)(velocidadOriginal*PORCENTAJE));
    }

    @Override
    public Modificador copia() {
        return new BuffFlash();
    }
}
