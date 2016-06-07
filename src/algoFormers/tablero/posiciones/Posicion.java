package algoFormers.tablero.posiciones;

public class Posicion {
    private int x;
    private int y;


    public Posicion(int unaPosicionX, int unaPosicionY){
        x=unaPosicionX;
        y=unaPosicionY;
    }

    public boolean compararPosicion(Posicion posicionAComparar){
        return (x==(posicionAComparar.verCoordenadaX()) && y==(posicionAComparar.verCoordenadaY()));
    }

    int verCoordenadaX(){
        return x;
    }

    int verCoordenadaY() {
        return y;
    }
}
