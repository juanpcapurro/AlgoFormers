package algoFormers.tablero;


public class Casillero {
    private Colocable colocado;
    private Superficie superficie;

    Casillero(){
        Colocable colocable= new EspacioVacio();
        Superficie superficie= new Llano();
    }

    public boolean estaOcupado(){
        return colocado.ocupaLugar();
    }


}
