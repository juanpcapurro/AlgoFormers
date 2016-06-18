package algoFormers.juego;

import algoFormers.tablero.colocable.robots.AlgoFormer;
import algoFormers.tablero.colocable.robots.Equipo;
import algoFormers.tablero.posiciones.Posicion;


public class Jugada {

    protected AlgoFormer algoFormerDeLaJugada;
    private TipoDeJugada tipoDeJugada;
    private int movimientosDisponibles;

    public Jugada(){
        tipoDeJugada = new JugadaAlgoformerSinCombinar();
    }

    public void transformar() {
        tipoDeJugada.transformar(algoFormerDeLaJugada);
    }

    public void vaASerDeCombinacion() {
        tipoDeJugada = new JugadaAlgoformersCombinados();
    }

    public void combinar(Equipo equipo) {
        algoFormerDeLaJugada = tipoDeJugada.combinar(equipo);
        movimientosDisponibles = algoFormerDeLaJugada.getVelocidad();
    }

    public void descombinar(){
        tipoDeJugada.descombinar(algoFormerDeLaJugada);
        tipoDeJugada = new JugadaAlgoformerSinCombinar();
    }

    public void atacar(Posicion posicionDestino) {
        tipoDeJugada.atacar(posicionDestino,algoFormerDeLaJugada);
    }

    public void jugarCon(AlgoFormer algoFormerDeLaJugada) {

        this.tipoDeJugada = new JugadaAlgoformerSinCombinar();
        this.algoFormerDeLaJugada = algoFormerDeLaJugada;
        this.movimientosDisponibles = algoFormerDeLaJugada.getVelocidad();
    }

    public void mover(Posicion posicionOrigen, Posicion posicionDestino) {
        if (movimientosDisponibles > 0) {
            this.tipoDeJugada.mover(algoFormerDeLaJugada, posicionOrigen, posicionDestino);
            movimientosDisponibles -= 1;
//            if(movimientosDisponibles == 0){ throw new YaUtilizoPasosDisponibles();}
        } else if(movimientosDisponibles <= 0) {
            throw new YaUtilizoPasosDisponibles();
        }

    }

    public boolean enProcesoDeCombinacion() {
        return tipoDeJugada.enProcesoDeCombinacion();
    }

    public void pasoTurno() {
        tipoDeJugada.pasoTurno();
    }


    public int getMovimientosDisponibles() {
        return movimientosDisponibles;
    }

    public boolean esDeCombinacion() {
        return tipoDeJugada.esDeCombinacion();
    }

	public AlgoFormer getAlgoformerDeJugada() {
		// TODO Auto-generated method stub
		return algoFormerDeLaJugada;
	}
}
