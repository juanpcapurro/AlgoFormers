package modelo.juego;

import java.util.ArrayList;

public class DatosJugador {
    public String nombreJugador;
    public ArrayList<DatosImprimibles> algoformers;
    public DatosJugador(String nombre, ArrayList<DatosImprimibles> algoformersJugador){
        nombreJugador = nombre;
        algoformers = algoformersJugador;
    }

}
