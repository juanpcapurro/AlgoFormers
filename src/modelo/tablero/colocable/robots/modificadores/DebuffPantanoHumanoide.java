package modelo.tablero.colocable.robots.modificadores;

import modelo.tablero.colocable.robots.ModoAlgoformer;

public class DebuffPantanoHumanoide extends Modificador {
    int velocidadOriginal;
    ModoAlgoformer modoAfectado;
    public DebuffPantanoHumanoide(ModoAlgoformer modo){
        modoAfectado=modo;
    }

    @Override
    public void actualizar() {
        if(!modoAfectado.estaActivado()) {
            estadoAfectado.movilizar();
        }
    }

    @Override
    public void activar() {
        modificadores.add(this);
        velocidadOriginal=estadoAfectado.getVelocidad();
        estadoAfectado.inmovilizar();
    }

    @Override
    public Modificador copia() {
        return new DebuffPantanoHumanoide(modoAfectado);
    }


}
