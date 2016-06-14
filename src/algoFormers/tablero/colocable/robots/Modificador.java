package algoFormers.tablero.colocable.robots;

import algoFormers.tablero.colocable.robots.armas.DisparoConvencional;

public class Modificador {
    int modificadorAtaque=0;
    int modificadorVelocidad=0;
    int modificadorDistancia=0;
    int modificadorVida=0;
    int duracion=0;
    int tiempoExistencia= (int) Float.POSITIVE_INFINITY;
    AlgoFormer afectado;

    Modificador(){
    }
    Modificador(int unTiempoExistencia){
        tiempoExistencia=unTiempoExistencia;
    }

    void setModificadorAtaque(int nuevoAtaque){
        modificadorAtaque=nuevoAtaque;
    }

    void setModificadorVelocidad(int nuevaVelocidad){
        modificadorVelocidad=nuevaVelocidad;
    }

    void setModificadorDistancia(int nuevaDistancia){
        modificadorDistancia=nuevaDistancia;
    }
    void setModificadorVida(int danio){
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
        if(duracion>=tiempoExistencia)
            afectado.setModificadorDeEstado(new Modificador());
        actualizarVida();
        duracion++;
    }

}
