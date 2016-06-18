package algoFormers.tablero.colocable.robots.modificadores;

public class BuffDobleCanion extends Modificador{
    static double PORCENTAJE= 2;
    int ataqueOriginal;
    int contador=0;
    int cantidadTurnos=6;


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
        ataqueOriginal= estadoAfectado.getAtaque();
        estadoAfectado.setAtaque((int)(ataqueOriginal*PORCENTAJE));
    }

    @Override
    public Modificador copia() {
        return new BuffDobleCanion();
    }
}
