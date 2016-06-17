package algoFormers.tablero.colocable.robots;

import algoFormers.tablero.colocable.robots.modificadores.Modificador;
import algoFormers.tablero.superficie.Superficie;

import java.util.ArrayList;
import java.util.List;

public abstract class ModoAlgoformer {
    EstadoAlgoFormer estado;
    List <Modificador> modificadores;

    public ModoAlgoformer(Vida vida,int ataque, int distanciaDeAtaque, int velocidad) {
        estado = new EstadoAlgoFormer(vida,ataque, distanciaDeAtaque, velocidad);
        modificadores=new ArrayList<>();
    }
    public void afectarEstado(Modificador modificador){
        modificadores.add(modificador);
        modificador.setEstado(estado,modificadores);
    }

    public void notificar(){
        for (Modificador modificador : modificadores)
            modificador.actualizar();
    }
    public EstadoAlgoFormer verEstado(){
        return estado;
    }
    public abstract void pasarPor(Superficie superficieTerrestre,Superficie superficieAerea);
    public abstract boolean esHumanoide();

    public abstract boolean estaEnModoAlterno();

    public int getAtaque() {
        return estado.getAtaque();
    }

    public int getVelocidad() {
        return estado.getVelocidad();
    }

    public int getDistancia() {
        return estado.getDistanciaDeAtaque();
    }
}
