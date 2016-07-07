package modelo.tablero.colocable.robots;

import modelo.tablero.colocable.robots.modificadores.Modificador;
import modelo.tablero.superficie.Superficie;

import java.util.ArrayList;
import java.util.List;

public abstract class ModoAlgoformer {
    private EstadoAlgoFormer estado;
    private List <Modificador> modificadores;
    private int movimientosRealizados;
    boolean activado=false;

    public ModoAlgoformer(Vida vida,int ataque, int distanciaDeAtaque, int velocidad) {
        estado = new EstadoAlgoFormer(vida,ataque, distanciaDeAtaque, velocidad);
        modificadores=new ArrayList<>();
        movimientosRealizados=0;
    }
    public void afectarEstado(Modificador modificador){
        modificador.setEstado(estado,modificadores);
    }

    void notificar(){
        movimientosRealizados=0;
        for (int i=0; i<modificadores.size();i++)
            (modificadores.get(i)).actualizar();//No intentes hacerlo bien, alma incauta.
    }
    EstadoAlgoFormer verEstado(){
        return estado;
    }
    public abstract void pasarPor(Superficie superficieTerrestre,Superficie superficieAerea);
    public abstract boolean esHumanoide();
    public void activar(){
        activado=true;
    }
    public void desactivar(){
        activado=false;
    }

    public abstract boolean estaEnModoAlterno();
    public boolean estaActivado(){
        return activado;
    }
    public int getAtaque() {
        return estado.getAtaque();
    }

    public int getVelocidad() {
        return estado.getVelocidad();
    }

    int getDistancia() {
        return estado.getDistanciaDeAtaque();
    }

    boolean tieneMovimientosDisponibles()throws  ObjetoInmovible{
        if (estado.inmovilizado) {
            throw new ObjetoInmovible();
        }
        movimientosRealizados++;
        return movimientosRealizados<=estado.getVelocidad();
    }

    boolean consultarMovimientosDisponibles(){
        return movimientosRealizados<estado.getVelocidad();
    }


    public String getModificadorActivo() {
        if (modificadores.size()>0){
            return modificadores.get(modificadores.size()-1).getClass().getSimpleName();
        }
        return "";
    }
}
