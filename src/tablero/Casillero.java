package tablero;


public class Casillero {
    private Colocable colocado;
    private Superficie superficie;

    Casillero(){
        Colocable colocable= new EspacioVacio();
        Superficie superficie= new SuperficieVacia();
    }

    public boolean estaOcupado(){
        return colocado.ocupaLugar();
    }


}
