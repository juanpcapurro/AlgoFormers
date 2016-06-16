package algoFormers.juego;

import algoFormers.tablero.colocable.robots.AlgoFormer;
import algoFormers.tablero.colocable.robots.Equipo;
import algoFormers.tablero.colocable.robots.autobot.Bumblebee;
import algoFormers.tablero.colocable.robots.autobot.Optimus;
import algoFormers.tablero.colocable.robots.autobot.Ratchet;
import algoFormers.tablero.colocable.robots.autobot.Superion;
import algoFormers.tablero.colocable.robots.decepticon.BoneCrusher;
import algoFormers.tablero.colocable.robots.decepticon.Frenzy;
import algoFormers.tablero.colocable.robots.decepticon.Megatron;
import algoFormers.tablero.colocable.robots.decepticon.Menasor;
import algoFormers.tablero.posiciones.Posicion;

import java.util.List;

public class JugadaAlgoformersCombinados extends TipoDeJugada {


    private int turnosRestantesParaFinalizarLaCombinacion;


    public JugadaAlgoformersCombinados(AlgoFormer algoFormerDeLaJugada){
        this.turnosRestantesParaFinalizarLaCombinacion = 2;

    }
    
    public AlgoFormer combinar(Equipo equipo) {
        return equipo.combinarme();
    }

    @Override
    public void atacar(Posicion posicionDestino,AlgoFormer algoFormerDeLaJugada) {
        if(turnosRestantesParaFinalizarLaCombinacion > 0){
            throw new EnProcesoDeCombinacion("restan "+ turnosRestantesParaFinalizarLaCombinacion + "para finalizar la combinacion de sus algoformers," +
                    "\n pierde su turno, procede el siguiente Jugador");
        }
        else{
            algoFormerDeLaJugada.atacar(posicionDestino);
        }

    }

    @Override
    public void descombinar(AlgoFormer algoFormerDeLaJugada) {
        if(turnosRestantesParaFinalizarLaCombinacion > 0){
            throw new EnProcesoDeCombinacion("restan "+ turnosRestantesParaFinalizarLaCombinacion + "para finalizar la combinacion de sus algoformers" +
                    "\n pierde su turno, procede el siguiente Jugador");
        }
        else{
            algoFormerDeLaJugada.descombinar();
        }

    }

    @Override
    public void mover(AlgoFormer algoFormerDeLaJugada, Posicion posicionOrigen, Posicion posicionDestino) {
        if(turnosRestantesParaFinalizarLaCombinacion > 0){
            throw new EnProcesoDeCombinacion("restan "+ turnosRestantesParaFinalizarLaCombinacion + "para finalizar la combinacion de sus algoformers" +
                    "\n pierde su turno, procede el siguiente Jugador");
        }
        else{
            algoFormerDeLaJugada.mover(posicionOrigen,posicionDestino);
        }
    }

    @Override
    public void transformar(AlgoFormer algoFormerDeLaJugada){
        if(turnosRestantesParaFinalizarLaCombinacion > 0){
            throw new EnProcesoDeCombinacion("restan "+ turnosRestantesParaFinalizarLaCombinacion + "para finalizar la combinacion de sus algoformers" +
                    "\n pierde su turno, procede el siguiente Jugador");
        }
        else{
            algoFormerDeLaJugada.transformar();
        }
    }

    @Override
    public boolean enProcesoDeCombinacion() {
        return (turnosRestantesParaFinalizarLaCombinacion>0);
    }

    @Override
    public void pasoTurno() {
        turnosRestantesParaFinalizarLaCombinacion-=1;
    }

    public void combinar(){
        throw new algoformersYaCombinados();
    }

}
