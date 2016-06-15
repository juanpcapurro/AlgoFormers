package algoFormers.juego.turno;

public class ContextoTurno {
    ModoTurno actual;
    ContextoTurno(){
        actual=new TurnoDeMovimiento();
    }

    void combinacion(){
        actual=new TurnoDeCombinacion();
    }

    void transformacion(){
        actual=new TurnoDeTransformacion();
    }

    void movimiento(){
        actual=new TurnoDeMovimiento();
    }

    void ataque(){
        actual=new TurnoDeAtaque();
    }

    void jugar(){
        actual.jugar();
    }


}
