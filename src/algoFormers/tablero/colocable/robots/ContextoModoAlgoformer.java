package algoFormers.tablero.colocable.robots;

import algoFormers.tablero.superficie.Superficie;

public class ContextoModoAlgoformer {
    ModoAlgoformer modoActual;
    ModoAlgoformer modoAlternativo;

    public void setActual(ModoAlgoformer actual){
        modoActual=actual;
    }
    public void setAlternativo(ModoAlgoformer alternativo){
        modoAlternativo=alternativo;
    }

    public void cambiarModo(){
        ModoAlgoformer aux=modoActual;
        modoActual=modoAlternativo;
        modoAlternativo=aux;
    }

    ModoAlgoformer verModoActual(){
        return modoActual;
    }

    public EstadoAlgoFormer verEstadoActual(){
        return modoActual.verEstado();
    }


    public boolean esHumanoide() {
        return modoActual.esHumanoide();
    }

    public boolean estaEnModoAlterno() {
        return (modoActual.estaEnModoAlterno());
    }

    public void pasarPor(Superficie superficieTerrestre, Superficie superficieAerea) {
        modoActual.pasarPor(superficieTerrestre,superficieAerea);
    }
    public int getAtaque(){
        return modoActual.getAtaque();
    }
    public int getVelocidad(){
        return modoActual.getVelocidad();
    }
    public int getDistanciaDeAtaque(){
        return modoActual.getDistancia();
    }

    public void setModificador(Modificador modificador){
        modoActual.setModificador(modificador);
    }
}
