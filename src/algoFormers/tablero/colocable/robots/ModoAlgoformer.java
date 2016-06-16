package algoFormers.tablero.colocable.robots;

import algoFormers.tablero.colocable.robots.modificadores.Modificador;
import algoFormers.tablero.superficie.Superficie;

public abstract class ModoAlgoformer {
    EstadoAlgoFormer estado;
    public ModoAlgoformer(Vida vida,int ataque, int distanciaDeAtaque, int velocidad) {
        estado = new EstadoAlgoFormer(vida,ataque, distanciaDeAtaque, velocidad);
    }
    public void afectarEstado(Modificador modificador){
        modificador.setEstado(estado);
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
