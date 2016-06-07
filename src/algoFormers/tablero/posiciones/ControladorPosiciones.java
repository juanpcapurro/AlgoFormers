package algoFormers.tablero.posiciones;

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
        if (ultimaPosicionY>=dimension-1 && ultimaPosicionX>=dimension-1)
            return;
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
        if (posicionX>dimension || posicionY>dimension || posicionX<0 || posicionY<0)
            throw new CoordenadasInvalidas();
    }
}
