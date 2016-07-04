package modelo.juego.jugador;

import modelo.tablero.Tablero;
import modelo.tablero.colocable.robots.AlgoFormer;
import modelo.tablero.colocable.robots.decepticon.Decepticon;
import modelo.tablero.colocable.robots.decepticon.Menasor;
import modelo.tablero.posiciones.Posicion;

public class JugadorDecepticons extends Jugador{
    public JugadorDecepticons(String nuevoNombre, Tablero tablero, Decepticon unRobot, Decepticon otroRobot, Decepticon tercerRobot){
        super(nuevoNombre, tablero, unRobot, otroRobot, tercerRobot);
    }
    protected AlgoFormer crearAlgoFormerCombinado(AlgoFormer unAlgoformer, AlgoFormer otroAlgoFormer, AlgoFormer tercerAlgoFormer){
        return new Menasor((Decepticon) unAlgoformer, (Decepticon) otroAlgoFormer, (Decepticon) tercerAlgoFormer);
    }

    @Override
    protected void colocarAlgoFormers(Tablero tablero, AlgoFormer unRobot, AlgoFormer otroRobot, AlgoFormer tercerRobot) {
        int dimension = tablero.getDimension();
        Posicion unaPosicon = new Posicion(0, dimension-1);
        Posicion otraPosicion = new Posicion(0, dimension-2);
        Posicion tercerPosicion = new Posicion(0, dimension-3);

        tablero.vaciarPosicion(unaPosicon);
        tablero.vaciarPosicion(otraPosicion);
        tablero.vaciarPosicion(tercerPosicion);

        tablero.colocarAlgoformer(unaPosicon, unRobot);
        tablero.colocarAlgoformer(otraPosicion, otroRobot);
        tablero.colocarAlgoformer(tercerPosicion, tercerRobot);
    }
}
