package algoFormers.juego;

import algoFormers.tablero.colocable.robots.AlgoFormer;
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
    
    public AlgoFormer combinar(List<AlgoFormer> equipo) {
        return this.crearCombinado(equipo.get(0),equipo.get(1),equipo.get(2));
    }

    private AlgoFormer crearCombinado(AlgoFormer algoFormer, AlgoFormer algoFormer1, AlgoFormer algoFormer2) {
        return new Optimus(); //esto no sirve falta, SI O SI BORRAR
    }

    private AlgoFormer crearCombinado(Bumblebee bumblebee, Ratchet ratchet, Optimus optimus ) {
        return new Superion(optimus, bumblebee, ratchet);
    }

    private AlgoFormer crearCombinado(BoneCrusher boneCrusher, Frenzy frenzy, Megatron megatron ) {
        return new Menasor(megatron, boneCrusher, frenzy);
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
