package algoFormers.juego;

public class EnProcesoDeCombinacion extends RuntimeException  {
    private final String mensaje;

    public EnProcesoDeCombinacion(String mensaje) {
        this.mensaje = mensaje;
    }
}
