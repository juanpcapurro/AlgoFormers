package algoFormers.tablero;

class ControladorPosiciones {
    private static ControladorPosiciones ourInstance = new ControladorPosiciones();

    public static ControladorPosiciones getInstance() {
        return ourInstance;
    }
    int ultimaPosicionX;
    int ultimaPosicionY;

    private ControladorPosiciones() {
        ultimaPosicionX=0;
        ultimaPosicionY=0;
    }
    void aumentarPosicionesCreadas(){
        if (ultimaPosicionY>=7 && ultimaPosicionX>=7)
            return;
        if (ultimaPosicionX >= 7) {
            ultimaPosicionX = 0;
            ultimaPosicionY++;
        }
        else
            ultimaPosicionX++;
     }

    int getUltimaPosicionX(){
         return ultimaPosicionX;
     }
    int getUltimaPosicionY(){
        return ultimaPosicionY;
    }
    void resetPosiciones(){
        ultimaPosicionY=0;
        ultimaPosicionX=0;
    }
}
