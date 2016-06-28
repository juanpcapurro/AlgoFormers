
package modelo.juego;

import modelo.tablero.Tablero;
import modelo.tablero.colocable.Colocable;
import modelo.tablero.colocable.robots.AlgoFormer;
import modelo.tablero.posiciones.Posicion;

import java.util.ArrayList;

public class Jugador {

	private String nombreDeJugador;
	private Tablero tablero;
	private int turnosAunOcupados;
	private ArrayList<AlgoFormer> robotsJugador = new ArrayList<AlgoFormer>();
	private boolean estaCombinado;//Algun dia hay que hardcodear

	public Jugador(String nuevoNombre, Tablero tablero, AlgoFormer unAlgoformer, AlgoFormer otroAlgoformer, AlgoFormer tercerAlgoformer){
		this.tablero= tablero;
		this.nombreDeJugador = nuevoNombre;
		turnosAunOcupados = 0;
		estaCombinado = false;
		robotsJugador.add(unAlgoformer);
		robotsJugador.add(otroAlgoformer);
		robotsJugador.add(tercerAlgoformer);

		tablero.colocarRandom(unAlgoformer);
		tablero.colocarRandom(otroAlgoformer);
		tablero.colocarRandom(tercerAlgoformer);
	}

	DatosJugador getDatosJugador() {
        ArrayList<DatosAlgoformer> listaDatos = new ArrayList<DatosAlgoformer>();
        for(AlgoFormer actual: robotsJugador)
            listaDatos.add(actual.obtenerDatosAlgoformer());
        return new DatosJugador(nombreDeJugador, listaDatos);
	}

	boolean equipovivo(){
		for (AlgoFormer unAlgoformer: robotsJugador)
			if(unAlgoformer.estaVivo())
				return true;
		return false;
	}

	public void combinarODescombinar() {
		if(!estaCombinado) {
			validarQuePuedeJugar();
			if (robotsJugador.size() < 3)
				throw new NoPuedeCombinarPorTenerAlgoFormersMuertos();
			if(!(robotsJugador.get(0).estaVivo() && robotsJugador.get(1).estaVivo() && robotsJugador.get(2).estaVivo()))
				throw new NoPuedeCombinarPorTenerAlgoFormersMuertos();
			//AlgoFormer combinacion = crearAlgoformerCombinado(robotsJugador.get(0),robotsJugador.get(1),robotsJugador.get(2));

			turnosAunOcupados=2;
			estaCombinado=true;
		}

	}

	public void transformar(Posicion posicionAlgoFormer) {
		validarQuePuedeJugar();
		hayUnAlgoFormerPropioEnPosicion(posicionAlgoFormer);
		AlgoFormer aTransformar = (AlgoFormer)tablero.obtenerCasilleroAsociadoAPosicion(posicionAlgoFormer).getColocable();
		aTransformar.transformar();
	}

	public void mover(Posicion posicionOrigen, Posicion posicionDestino) {
		validarQuePuedeJugar();
        hayUnAlgoFormerPropioEnPosicion(posicionOrigen);
		tablero.recorrer(posicionOrigen, posicionDestino);
	}
	public void atacar(Posicion hostil, Posicion objetivo){
		validarQuePuedeJugar();
		hayUnAlgoFormerPropioEnPosicion(hostil);
		tablero.atacar(hostil, objetivo);
	}
	public void notificar() {
		if(turnosAunOcupados>0)
			turnosAunOcupados--;
		for (AlgoFormer actual: robotsJugador)
			actual.notificar();
	}

	private boolean esAlgoformerPropio(Colocable unColocable){
		for(AlgoFormer actual: robotsJugador)
			if(actual.equals(unColocable))
				return true;
		return false;
	}

    public boolean puedeJugar(){
        return (turnosAunOcupados<=0);
    }

	private void validarQuePuedeJugar(){
		if(!puedeJugar())
			throw new jugadorOcupado();
	}

    private void hayUnAlgoFormerPropioEnPosicion(Posicion posicionOrigen){
        Colocable aMover = tablero.obtenerCasilleroAsociadoAPosicion(posicionOrigen).getColocable();
        if (!esAlgoformerPropio(aMover))
            throw new NoEsAlgoFormerPropio();
    }

}
