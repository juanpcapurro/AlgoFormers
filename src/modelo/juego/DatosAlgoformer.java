package modelo.juego;

public class DatosAlgoformer {
    public int vidaActual;
    public int vidaOriginal;
    public String nombre;
    public int ataque;
    public int velocidad;
    public int alcance;

    public DatosAlgoformer(int vida, String nombre) {
        this.vidaActual = vida;
        this.nombre = nombre;
    }

    public DatosAlgoformer(int vidaOriginal,int vidaActual, int ataque,int velocidad, int alcance, String nombre) {
        this.vidaActual = vidaActual;
        this.vidaOriginal=vidaOriginal;
        this.nombre = nombre;
        this.ataque=ataque;
        this.alcance=alcance;
        this.velocidad=velocidad;
    }

    public String getVidaActual(){
        return String.valueOf(vidaActual);
    }

    public String getAtaque(){
        return String.valueOf(ataque);
    }
    public String getVelocidad(){
        return String.valueOf(velocidad);
    }
    public String getAlcance(){
        return String.valueOf(alcance);
    }

    public String getVidaOriginal(){
        return String.valueOf(vidaOriginal);
    }

}
