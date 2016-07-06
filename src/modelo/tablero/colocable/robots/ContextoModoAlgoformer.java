package modelo.tablero.colocable.robots;

import modelo.tablero.colocable.robots.modificadores.Modificador;
import modelo.tablero.superficie.Superficie;

public class ContextoModoAlgoformer {
    ModoAlgoformer actual;
    ModoAlgoformer alternativo;
    public void setActual(ModoAlgoformer actual){
        this.actual =actual;
        actual.activar();
    }
    public void setAlternativo(ModoAlgoformer alternativo){
        this.alternativo =alternativo;
    }

    public void cambiarModo(){
        ModoAlgoformer aux= actual;
        actual = alternativo;
        alternativo =aux;
        actual.activar();
        alternativo.desactivar();
    }

    ModoAlgoformer verModoActual(){
        return actual;
    }

    public EstadoAlgoFormer verEstadoActual(){
        return actual.verEstado();
    }


    public boolean esHumanoide() {
        return actual.esHumanoide();
    }

    public boolean estaEnModoAlterno() {
        return (actual.estaEnModoAlterno());
    }

    public void pasarPor(Superficie superficieTerrestre, Superficie superficieAerea) {
        actual.pasarPor(superficieTerrestre,superficieAerea);
    }
    public int getAtaque(){
        return actual.getAtaque();
    }
    public int getVelocidad(){
        return actual.getVelocidad();
    }
    public int getDistanciaDeAtaque(){
        return actual.getDistancia();
    }
    public void afectarEstado(Modificador modificador){
        actual.afectarEstado(modificador);
        alternativo.afectarEstado(modificador.copia());
    }
    public void notificar(){
        actual.notificar();
        alternativo.notificar();
    }
    public boolean consultarMovimientoDisponibles(){
        return actual.consultarMovimientosDisponibles();
    }
    public boolean tieneMovimientosDisponibles() {
        return actual.tieneMovimientosDisponibles();
    }
}
