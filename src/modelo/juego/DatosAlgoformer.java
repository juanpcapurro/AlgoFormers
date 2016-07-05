package modelo.juego;

public class DatosAlgoformer {
    public int vidaActual;
    public int vidaOriginal;
    public String nombre;
    public String modo;
    public int ataque;
    public int velocidad;
    public int alcance;

    public DatosAlgoformer(int vida, String nombre,String modo) {
        this.vidaActual = vida;
        this.nombre = nombre;
        this.modo=modo;
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
    public String getModo(){
        return modo;
    }
    public String getNombre(){
        return nombre;
    }

}
