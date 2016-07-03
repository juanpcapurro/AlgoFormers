package modelo.juego;

public class DatosAlgoformer {
    public int vida;
    public String nombre;
    public int ataque;
    public int velocidad;
    public int alcance;

    public DatosAlgoformer(int vida, String nombre) {
        this.vida = vida;
        this.nombre = nombre;
    }

    public DatosAlgoformer(int vida, int ataque,int velocidad, int alcance, String nombre) {
        this.vida = vida;
        this.nombre = nombre;
        this.ataque=ataque;
        this.alcance=alcance;
        this.velocidad=velocidad;
    }

    public String getVida(){
        return String.valueOf(vida);
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

}
