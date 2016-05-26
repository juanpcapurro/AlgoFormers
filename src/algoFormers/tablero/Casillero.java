package algoFormers.tablero;


public class Casillero {
    private Colocable colocado;
    private Superficie superficie;

    Casillero(){
        colocado= new EspacioVacio();
        superficie= new Llano();
    }

    public boolean estaOcupado(){
        return colocado.ocupaLugar();
    }


    public boolean colocar(Colocable aColocar) {
        if (this.estaOcupado())
                return false;
        colocado=aColocar;
        return true;
    }
}
