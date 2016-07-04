package modelo.juego.jugador;

import modelo.tablero.Tablero;
import modelo.tablero.colocable.robots.AlgoFormer;
import modelo.tablero.colocable.robots.autobot.*;
import modelo.tablero.posiciones.Posicion;

public class JugadorAutobots extends Jugador{
    public JugadorAutobots(String nombreJugadorAutobots, Tablero tablero,Autobot unRobot, Autobot otroRobot, Autobot tercerRobot) {
        super(nombreJugadorAutobots, tablero, unRobot, otroRobot, tercerRobot);
    }

    protected AlgoFormer crearAlgoFormerCombinado(AlgoFormer unAlgoformer, AlgoFormer otroAlgoFormer, AlgoFormer tercerAlgoFormer){
        return new Superion((Autobot) unAlgoformer, (Autobot) otroAlgoFormer, (Autobot) tercerAlgoFormer);
    }
    protected void colocarAlgoFormers(Tablero tablero, AlgoFormer unRobot, AlgoFormer otroRobot, AlgoFormer tercerRobot) {
        Posicion unaPosicon = new Posicion(0,0);
        Posicion otraPosicion = new Posicion(0,1);
        Posicion tercerPosicion = new Posicion(0,2);

        tablero.vaciarPosicion(unaPosicon);
        tablero.vaciarPosicion(otraPosicion);
        tablero.vaciarPosicion(tercerPosicion);

        tablero.colocarAlgoformer(unaPosicon, unRobot);
        tablero.colocarAlgoformer(otraPosicion, otroRobot);
        tablero.colocarAlgoformer(tercerPosicion, tercerRobot);
    }
}
