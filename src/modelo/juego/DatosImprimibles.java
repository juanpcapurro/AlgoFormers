package modelo.juego;

public class DatosImprimibles {
    public int vida;
    public String nombre;
    public int ataque;

    public DatosImprimibles(int vida, String nombre) {
        this.vida = vida;
        this.nombre = nombre;
    }

    public DatosImprimibles(int vida, int ataque, String nombre) {
        this.vida = vida;
        this.nombre = nombre;
        this.ataque=ataque;
    }

    public String getUpperValue(){
        return String.valueOf(vida);
    }

    public String getLowerValue(){
        return String.valueOf(ataque);
    }
}
