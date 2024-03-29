package modelo.tablero.colocable.robots.modificadores;

public class BuffDobleCanion extends Modificador{
    static double PORCENTAJE= 2;
    int ataqueOriginal;
    int contador=0;
    int cantidadTurnos=3;


    @Override
    public void actualizar(){
        if (contador>=cantidadTurnos){
            modificadores.remove(this);
            estadoAfectado.setAtaque(ataqueOriginal);
        }
        contador++;
    }
    @Override
    public void activar(){
        if (yaFueAplicado())
            return;
        modificadores.add(this);
        ataqueOriginal= estadoAfectado.getAtaque();
        estadoAfectado.setAtaque((int)(ataqueOriginal*PORCENTAJE));
    }

    @Override
    public Modificador copia() {
        return new BuffDobleCanion();
    }
}
