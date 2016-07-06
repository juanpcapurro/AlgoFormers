package modelo.tablero.colocable.robots.modificadores;

public class BuffBurbujaInmaculada extends Modificador {

    private int vidaOriginal;
    private int contador=0;
    private int cantidadTurnos=6;


    @Override
    public void actualizar(){
        if (contador>=cantidadTurnos){
            modificadores.remove(this);
            estadoAfectado.setDaniable();
        }
        contador++;
    }
    @Override
    public void activar(){
        if (yaFueAplicado())
            return;
        modificadores.add(this);
        estadoAfectado.setIndaniable();
    }

    @Override
    public Modificador copia() {
        return new BuffBurbujaInmaculada();
    }

}
