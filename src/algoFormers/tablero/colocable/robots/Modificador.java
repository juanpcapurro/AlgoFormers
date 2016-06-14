package algoFormers.tablero.colocable.robots;

import algoFormers.juego.NotificableTurno;
import algoFormers.tablero.colocable.robots.armas.DisparoConvencional;

public class Modificador extends NotificableTurno {
    float modificadorAtaque=0;
    float modificadorVelocidad=0;
    float modificadorAlcance=0;
    int modificadorVida=0;
    float duracion=0;
    float tiempoExistencia=(int) Float.POSITIVE_INFINITY;
    static final int PORCENTAJE=100;
    AlgoFormer afectado;

    public Modificador(int unTope){
        tiempoExistencia=unTope;
        notificarON();
    }
    public Modificador(){
    }

    public void setModificadorAtaque(int porcentajeAtaque){
        modificadorAtaque=(float)(porcentajeAtaque)/PORCENTAJE;
    }

    public void setModificadorVelocidad(int porcentajeVelocidad){
        modificadorVelocidad=(float)(porcentajeVelocidad)/PORCENTAJE;
    }

    public void setModificadorDistancia(int porcentajeAlcance){
        modificadorAlcance=(float)(porcentajeAlcance)/PORCENTAJE;
    }
    public void setModificadorVida(int danio){
        modificadorVida=danio;
    }

    void setAfectado(AlgoFormer algoFormer){
        afectado=algoFormer;
    }

    int ModificadorVelocidad(EstadoAlgoFormer estado){
        return estado.getVelocidad()-(int)(estado.getVelocidad()*modificadorVelocidad);
    }
    int ModificadorDistancia(EstadoAlgoFormer estado){
        return (estado.getDistanciaDeAtaque()-(int)(estado.getDistanciaDeAtaque()*modificadorAlcance));
    }
    int ModificadorAtaque(EstadoAlgoFormer estado){
        return estado.getAtaque()-(int)(estado.getAtaque()*modificadorAtaque);
    }


    void actualizarVida(){
        afectado.recibirAtaque(new DisparoConvencional(modificadorVida));
    }

    public void actualizar(){
        if(duracion>=tiempoExistencia) {
            afectado.setModificadorDeEstado(new Modificador());
            notificarOFF();
        }
        actualizarVida();
        duracion++;
    }

}
