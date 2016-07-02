package modelo.juego;

import java.util.ArrayList;

public class DatosJugador {
    public String nombreJugador;
    public ArrayList<DatosAlgoformer> algoformers;
    public DatosJugador(String nombre, ArrayList<DatosAlgoformer> algoformersJugador){
        nombreJugador = nombre;
        algoformers = algoformersJugador;
    }
}
