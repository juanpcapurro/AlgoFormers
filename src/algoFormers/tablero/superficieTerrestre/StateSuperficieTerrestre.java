package algoFormers.tablero.superficieTerrestre;
import algoFormers.tablero.colocable.robots.armas.Ataque;
import algoFormers.tablero.superficie.StateSuperficie;
import algoFormers.tablero.superficieTerrestre.Llano;
import algoFormers.tablero.superficieTerrestre.Pantanoso;
import algoFormers.tablero.superficieTerrestre.Rocoso;
import algoFormers.tablero.superficieTerrestre.SuperficieTerrestre;

abstract class StateSuperficieTerrestre extends StateSuperficie {

    void cambiarALlano(SuperficieTerrestre superficieActual){
        superficieActual.cambiarActual(new Llano());
    }
    void cambiarARocoso(SuperficieTerrestre superficieActual){
        superficieActual.cambiarActual(new Rocoso());
    }
    void cambiarAPantanoso(SuperficieTerrestre superficieActual){
        superficieActual.cambiarActual(new Pantanoso());
    }

    public abstract void recibirAtaque(SuperficieTerrestre superficieActual, Ataque ataque);
}