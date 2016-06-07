package algoFormers.tablero;

public class Posicion {
    int x;
    int y;

    Posicion(){
        ControladorPosiciones controlador=ControladorPosiciones.getInstance();
        x=controlador.getUltimaPosicionX();
        y=controlador.getUltimaPosicionY();
        controlador.aumentarPosicionesCreadas();
    }

    Posicion(int unaPosicionX, int unaPosicionY){
        this.validarCoordenadas();
        x=unaPosicionX;
        y=unaPosicionY;
    }

    public void validarCoordenadas(){
        ControladorPosiciones controlador=ControladorPosiciones.getInstance();
        if (x>controlador.getUltimaPosicionX() || y > controlador.getUltimaPosicionY() || x<0 || y<0)
            throw new CoordenadasInvalidas();
    }

    boolean compararPosicion(Posicion posicionAComparar){
        return (x==(posicionAComparar.verCoordenadaX()) && y==(posicionAComparar.verCoordenadaY()));
    }

    private int verCoordenadaX(){
        return x;
    }

    private int verCoordenadaY(){
        return y;
    }
}
