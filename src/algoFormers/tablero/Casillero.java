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


    public void colocar(Colocable aColocar) {
        if (this.estaOcupado())
                throw new CasilleroYaOcupado();
        colocado=aColocar;
    }
}
