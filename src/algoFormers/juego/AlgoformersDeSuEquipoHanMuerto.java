package algoFormers.juego;

public class AlgoformersDeSuEquipoHanMuerto extends RuntimeException {

    private final String mensaje;

    public AlgoformersDeSuEquipoHanMuerto(String mensaje) {
        this.mensaje = mensaje;
    }
}
