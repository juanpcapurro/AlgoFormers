package modelo.juego.jugador;

import modelo.tablero.Tablero;
import modelo.tablero.colocable.robots.AlgoFormer;
import modelo.tablero.colocable.robots.autobot.*;

public class JugadorAutobots extends Jugador{
    public JugadorAutobots(String nombreJugadorAutobots, Tablero tablero,Autobot unRobot, Autobot otroRobot, Autobot tercerRobot) {
        super(nombreJugadorAutobots, tablero, unRobot, otroRobot, tercerRobot);
    }

    protected AlgoFormer crearAlgoFormerCombinado(AlgoFormer unAlgoformer, AlgoFormer otroAlgoFormer, AlgoFormer tercerAlgoFormer){
        return new Superion((Autobot) unAlgoformer, (Autobot) otroAlgoFormer, (Autobot) tercerAlgoFormer);
    }
}
