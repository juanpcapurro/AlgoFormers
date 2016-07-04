package modelo.tablero.posiciones;

public class Posicion {
    private int x;
    private int y;

    public Posicion(int unaPosicionX, int unaPosicionY){
        x=unaPosicionX;
        y=unaPosicionY;
    }

    public boolean compararPosicion(Posicion posicionAComparar){
        return (this.x==posicionAComparar.x & this.y==posicionAComparar.y);
    }

    public int verCoordenadaX(){
        return x;
    }

    public int verCoordenadaY() {
        return y;
    }

    public Posicion obtenerSiguiente(Posicion posicionDestino) {
        int diferencia=x-posicionDestino.verCoordenadaX();
        if (diferencia<0)
            return new Posicion(x+1,y);
        if(diferencia>0)
            return new Posicion(x-1,y);
        diferencia=y-posicionDestino.verCoordenadaY();
        if(diferencia<0)
            return new Posicion(x,y+1);
        if(diferencia>0)
            return new Posicion(x,y-1);
        return this;
    }
}
