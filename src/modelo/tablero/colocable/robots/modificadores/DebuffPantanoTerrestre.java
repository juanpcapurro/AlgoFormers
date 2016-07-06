package modelo.tablero.colocable.robots.modificadores;

public class DebuffPantanoTerrestre extends Modificador {
    int velocidadOriginal;
    static double PORCENTAJE=0.5;

    public void actualizar(){
        estadoAfectado.setVelocidad(velocidadOriginal);
        modificadores.remove(this);
    }

    public void activar(){
        if(yaFueAplicado())
            return;
        modificadores.add(this);
        velocidadOriginal=estadoAfectado.getVelocidad();
        estadoAfectado.setVelocidad(velocidadOriginal-(int)(velocidadOriginal*PORCENTAJE));
    }

    @Override
    public Modificador copia() {
        return new DebuffPantanoTerrestre();
    }
}
