package modelo.tablero.colocable.robots;

public class Vida {
    int vidaActual;
    int vidaOriginal;
    boolean indaniable=false;
        public Vida(int unaVida){
            vidaActual =unaVida;
            vidaOriginal=unaVida;
        }
    public int getVidaActual(){
        return vidaActual;
    }
    public void setVidaActual(int unaVida){
        if (indaniable)
            return;
        vidaActual =unaVida;
    }

    public int getVidaOriginal(){
        return vidaOriginal;
    }

    public void setIndaniable(){
         indaniable = true;
    }
    public void setDaniable(){
        indaniable=false;
    }

}
