package algoFormers.tablero.colocable.robots;

import algoFormers.tablero.superficie.Superficie;

public abstract class ModoAlgoformer {
    EstadoAlgoFormer estado;
    Modificador modificador;
    public ModoAlgoformer(int ataque, int distanciaDeAtaque, int velocidad){
        estado= new EstadoAlgoFormer(ataque,distanciaDeAtaque,velocidad);
        modificador=new Modificador();
        modificador.setEstado(estado,this);
    }

    public void setModificador(Modificador unModificador){
        modificador=unModificador;
        modificador.setEstado(estado,this);
    }

    public int getVelocidad(){
        return modificador.ModificadorVelocidad();
    }

    public int getAtaque(){
        return modificador.ModificadorAtaque();
    }

    public int getDistancia(){
        return modificador.ModificadorDistancia();
    }

    public EstadoAlgoFormer verEstado(){
        return estado;
    }
    public abstract void pasarPor(Superficie superficieTerrestre,Superficie superficieAerea);
    public abstract boolean esHumanoide();

    public abstract boolean estaEnModoAlterno();
}
