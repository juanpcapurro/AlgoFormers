package algoFormers.tablero.colocable.robots.modificadores;

public class BuffBurbujaInmaculada extends Modificador {

    int vidaOriginal;
    int contador=0;
    int cantidadTurnos=4;


    @Override
    public void actualizar(){
        if (contador>=cantidadTurnos){
            modificadores.remove(this);
        }
        estadoAfectado.setVida(vidaOriginal);
        contador++;
    }
    @Override
    public void activar(){
        if (yaFueAplicado())
            return;
        modificadores.add(this);
        vidaOriginal= estadoAfectado.getVida();
        estadoAfectado.setVida((int)(vidaOriginal));
    }

    @Override
    public Modificador copia() {
        return new BuffBurbujaInmaculada();
    }

}
