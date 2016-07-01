
package modelo.juego.jugador;

import modelo.juego.DatosAlgoformer;
import modelo.juego.DatosJugador;
import modelo.tablero.Tablero;
import modelo.tablero.colocable.Colocable;
import modelo.tablero.colocable.robots.AlgoFormer;
import modelo.tablero.posiciones.Posicion;

import java.util.ArrayList;
import java.util.Random;

public abstract class Jugador {

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

	public DatosJugador getDatosJugador() {
        ArrayList<DatosAlgoformer> listaDatos = new ArrayList<DatosAlgoformer>();
        for(AlgoFormer actual: robotsJugador)
            listaDatos.add(actual.obtenerDatosAlgoformer());
        return new DatosJugador(nombreDeJugador, listaDatos);
	}

	public boolean equipovivo(){
		for (AlgoFormer unAlgoformer: robotsJugador)
			if(unAlgoformer.estaVivo())
				return true;
		return false;
	}

	public void combinarODescombinar() {
		validarQuePuedeJugar();
		if(!estaCombinado) {
			if (robotsJugador.size() < 3)
				throw new NoPuedeCombinarPorTenerAlgoFormersMuertos();
			if(!(robotsJugador.get(0).estaVivo() && robotsJugador.get(1).estaVivo() && robotsJugador.get(2).estaVivo()))
				throw new NoPuedeCombinarPorTenerAlgoFormersMuertos();

			AlgoFormer combinacion = crearAlgoFormerCombinado(robotsJugador.get(0),robotsJugador.get(1),robotsJugador.get(2));
			Random randomizer = new Random();
			AlgoFormer algoformerAlAzar =  robotsJugador.get(randomizer.nextInt(robotsJugador.size()));
			Posicion posicionCombinado = tablero.obtenerPosicionAsociadaAColocable(algoformerAlAzar);
			robotsJugador.clear();
			robotsJugador.add(combinacion);
			tablero.vaciarPosicion(posicionCombinado);
			tablero.colocarAlgoformer(posicionCombinado, combinacion);
		}
		else{
			if(robotsJugador.size()!=1 || !robotsJugador.get(0).estaVivo())
				throw new NoPuedeCombinarPorTenerAlgoFormersMuertos();
			//useful stuff here
		}
		estaCombinado = !estaCombinado;
		turnosAunOcupados = 2;
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

	protected abstract AlgoFormer crearAlgoFormerCombinado(AlgoFormer unAlgoformer, AlgoFormer otroAlgoformer, AlgoFormer tercerAlgoFormer);
}
