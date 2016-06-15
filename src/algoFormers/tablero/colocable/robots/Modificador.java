package algoFormers.tablero.colocable.robots;

import algoFormers.juego.NotificableTurno;

public class Modificador extends NotificableTurno {
    float modificadorAtaque=0;
    float modificadorVelocidad=0;
    float modificadorAlcance=0;
    int modificadorVida=0;
    float duracion=0;
    static final int PORCENTAJE=100;
    static final int INFINITO=(int)Float.POSITIVE_INFINITY;
    int tiempoExistencia=INFINITO;
    EstadoAlgoFormer estado;
    ModoAlgoformer modoAfectado;

    public Modificador(int unTope){
        tiempoExistencia=unTope;
        notificarON();
    }
    public Modificador(){
        estado=new EstadoAlgoFormer(0,0,0);
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

    public void setEstado(EstadoAlgoFormer unEstado,ModoAlgoformer unModo){
        estado=unEstado;
        modoAfectado=unModo;
    }

    int ModificadorVelocidad(){
        return estado.getVelocidad()-(int)(estado.getVelocidad()*modificadorVelocidad);
    }
    int ModificadorDistancia(){
        return (estado.getDistanciaDeAtaque()-(int)(estado.getDistanciaDeAtaque()*modificadorAlcance));
    }
    int ModificadorAtaque(){
        return estado.getAtaque()-(int)(estado.getAtaque()*modificadorAtaque);
    }


    void actualizarVida(){

    }

    private void resetModificador(){
        modoAfectado.setModificador(new Modificador());
        notificarOFF();
    }

    public void actualizar(){
        if(duracion>=tiempoExistencia)
            resetModificador();
        actualizarVida();
        duracion++;
    }

}
