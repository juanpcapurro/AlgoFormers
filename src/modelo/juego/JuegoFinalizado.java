package modelo.juego;

public class JuegoFinalizado extends RuntimeException {
    JuegoFinalizado(String message){
        super(message);
    }
    public JuegoFinalizado(){

    }
}
