package modelo.tablero.colocable.robots;

public class Vida {
    int vidaActual;
    int vidaOriginal;
        public Vida(int unaVida){
            vidaActual =unaVida;
            vidaOriginal=unaVida;
        }
    public int getVidaActual(){
        return vidaActual;
    }
    public void setVidaActual(int unaVida){
        vidaActual =unaVida;
    }

    public int getVidaOriginal(){
        return vidaOriginal;
    }
}
