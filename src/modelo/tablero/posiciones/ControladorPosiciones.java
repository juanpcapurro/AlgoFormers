package modelo.tablero.posiciones;

import java.util.Random;

public class ControladorPosiciones {
    int ultimaPosicionX;
    int ultimaPosicionY;
    int dimension;

    public ControladorPosiciones(int unaDimension){
        dimension=unaDimension;
        ultimaPosicionX=0;
        ultimaPosicionY=0;
    }
    
    void incrementarPosiciones(){
        if (ultimaPosicionX >= dimension-1) {
            ultimaPosicionX = 0;
            ultimaPosicionY++;
        }
        else
            ultimaPosicionX++;
    }

    public Posicion inicializarPosicion() {
        Posicion posicion=new Posicion(ultimaPosicionX,ultimaPosicionY);
        incrementarPosiciones();
        return posicion;
    }

    public void validarCoordenadas(Posicion posicion) {
        int posicionX=posicion.verCoordenadaX();
        int posicionY=posicion.verCoordenadaY();
        if (posicionX>=dimension || posicionY>=dimension || posicionX<0 || posicionY<0)
            throw new CoordenadasInvalidas();
    }

    public Posicion getRandomPosition() {
        Posicion posicion=new Posicion((new Random()).nextInt(Integer.MAX_VALUE)%dimension,new Random().nextInt(Integer.MAX_VALUE)%dimension);
        return posicion;
    }
    public void inicializarIteradorDesdePosicion(Posicion unaPosicion){
        ultimaPosicionX=unaPosicion.verCoordenadaX();
        ultimaPosicionY=unaPosicion.verCoordenadaY();
    }
    public int calcularDistancia(Posicion unaPosicion, Posicion otraPosicion){
        int distanciaX = valorAbsoluto(unaPosicion.verCoordenadaX() - otraPosicion.verCoordenadaX());
        int distanciaY = valorAbsoluto(unaPosicion.verCoordenadaY() - otraPosicion.verCoordenadaY());
        return distanciaX + distanciaY;
    }
    private int valorAbsoluto(int entrada){
        if(entrada<=0)
            return (-1)*entrada;
        else
            return entrada;
    }
}
