package modelo.juego.jugador;

import modelo.tablero.Tablero;
import modelo.tablero.colocable.robots.AlgoFormer;
import modelo.tablero.colocable.robots.decepticon.Decepticon;
import modelo.tablero.colocable.robots.decepticon.Menasor;

public class JugadorDecepticons extends Jugador{
    public JugadorDecepticons(String nuevoNombre, Tablero tablero, Decepticon unRobot, Decepticon otroRobot, Decepticon tercerRobot){
        super(nuevoNombre, tablero, unRobot, otroRobot, tercerRobot);
    }
    protected AlgoFormer crearAlgoFormerCombinado(AlgoFormer unAlgoformer, AlgoFormer otroAlgoFormer, AlgoFormer tercerAlgoFormer){
        return new Menasor((Decepticon) unAlgoformer, (Decepticon) otroAlgoFormer, (Decepticon) tercerAlgoFormer);
    }
}
