package algoFormers.tablero.colocable.robots;

import algoFormers.juego.NotificableTurno;
import algoFormers.tablero.colocable.robots.armas.DisparoConvencional;

public class Modificador extends NotificableTurno {
    int modificadorAtaque=0;
    int modificadorVelocidad=0;
    int modificadorDistancia=0;
    int modificadorVida=0;
    int duracion=0;
    int tiempoExistencia=(int) Float.POSITIVE_INFINITY;
    AlgoFormer afectado;

    public Modificador(int unTope){
        tiempoExistencia=unTope;
        notificarON();
    }
    public Modificador(){
    }

    public void setModificadorAtaque(int nuevoAtaque){
        modificadorAtaque=nuevoAtaque;
    }

    public void setModificadorVelocidad(int nuevaVelocidad){
        modificadorVelocidad=nuevaVelocidad;
    }

    public void setModificadorDistancia(int nuevaDistancia){
        modificadorDistancia=nuevaDistancia;
    }
    public void setModificadorVida(int danio){
        modificadorVida=danio;
    }

    void setAfectado(AlgoFormer algoFormer){
        afectado=algoFormer;
    }

    int ModificadorVelocidad(EstadoAlgoFormer estado){
        return estado.getVelocidad()-modificadorVelocidad;
    }
    int ModificadorDistancia(EstadoAlgoFormer estado){
        return estado.getDistanciaDeAtaque()-modificadorDistancia;
    }
    int ModificadorAtaque(EstadoAlgoFormer estado){
        return estado.getAtaque()-modificadorAtaque;
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
