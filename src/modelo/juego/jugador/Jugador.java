
package modelo.juego.jugador;

import modelo.juego.DatosAlgoformer;
import modelo.juego.DatosJugador;
import modelo.tablero.NoEncontradoError;
import modelo.tablero.SinMovimientosDisponibles;
import modelo.tablero.Tablero;
import modelo.tablero.colocable.Colocable;
import modelo.tablero.colocable.robots.AlgoFormer;
import modelo.tablero.colocable.robots.AlgoformerCombinado;
import modelo.tablero.colocable.robots.NoPuedeTransformarsePorSerCombinado;
import modelo.tablero.colocable.robots.ObjetoInmovible;
import modelo.tablero.posiciones.ControladorPosiciones;
import modelo.tablero.posiciones.Posicion;

import java.util.ArrayList;

import static modelo.juego.ProxyPartida.notificarCambio;

public abstract class Jugador {

	private String nombreDeJugador;
	private Tablero tablero;
	private int turnosAunOcupados;
	private ArrayList<AlgoFormer> robotsJugador = new ArrayList<AlgoFormer>();
	private boolean estaCombinado;//Algun dia hay que hardcodear //Ya esta todo hardcodeado que flasha
	private boolean inicioMovimiento;

	public Jugador(String nuevoNombre, Tablero tablero, AlgoFormer unAlgoformer, AlgoFormer otroAlgoformer, AlgoFormer tercerAlgoformer){
		this.tablero= tablero;
		this.nombreDeJugador = nuevoNombre;
		turnosAunOcupados = 0;
		estaCombinado = false;
		inicioMovimiento = false;
		robotsJugador.add(unAlgoformer);
		robotsJugador.add(otroAlgoformer);
		robotsJugador.add(tercerAlgoformer);

		colocarAlgoFormers(tablero, unAlgoformer, otroAlgoformer, tercerAlgoformer);
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

	public void combinarODescombinar()throws NoPuedeCombinarPorTenerAlgoFormersMuertos, YaInicioMovimiento{
		validarQuePuedeJugar();
		if(!estaCombinado)
			combinar();
		else
			descombinar();

		estaCombinado = !estaCombinado;
		turnosAunOcupados = 2;
	}

	public void transformar(Posicion posicionAlgoFormer) throws NoEsAlgoFormerPropio, NoPuedeTransformarsePorSerCombinado, YaInicioMovimiento{
		validarQuePuedeJugar();
		hayUnAlgoFormerPropioEnPosicion(posicionAlgoFormer);
		AlgoFormer aTransformar = (AlgoFormer)tablero.obtenerCasilleroAsociadoAPosicion(posicionAlgoFormer).getColocable();
		aTransformar.transformar();
	}

	public void mover(Posicion posicionOrigen, Posicion posicionDestino) throws NoEsAlgoFormerPropio, ObjetoInmovible, SinMovimientosDisponibles{
		try {
			validarQuePuedeJugar();
		}catch (YaInicioMovimiento e){
			//No hace nada, es la excepcion a la excepcion
		}
        hayUnAlgoFormerPropioEnPosicion(posicionOrigen);
		tablero.recorrer(posicionOrigen, posicionDestino);
		if (algoformerSinMovimientos(posicionDestino)){
			throw new SinMovimientosDisponibles();
		}
	}
	public void atacar(Posicion hostil, Posicion objetivo)throws ObjetivoFueraDeRango, NoEsAlgoFormerPropio, YaInicioMovimiento{
		validarQuePuedeJugar();
		hayUnAlgoFormerPropioEnPosicion(hostil);
		AlgoFormer robot = (AlgoFormer)tablero.obtenerCasilleroAsociadoAPosicion(hostil).getColocable();
		ControladorPosiciones controlador = new ControladorPosiciones(tablero.getDimension());
		if(robot.getDistanciaDeAtaque()< controlador.calcularDistancia(hostil, objetivo))
			throw new ObjetivoFueraDeRango();

		tablero.atacar(hostil, objetivo);
	}
	public void notificar() {
		if(turnosAunOcupados>0)
			turnosAunOcupados--;
		for (AlgoFormer actual: robotsJugador)
			actual.notificar();
		inicioMovimiento=false;
	}

	private boolean algoformerSinMovimientos(Posicion posicion){
		AlgoFormer algoFormer=(AlgoFormer)tablero.obtenerCasilleroAsociadoAPosicion(posicion).getColocable();
		return !algoFormer.consultarMovimientosDisponibles();
	}

	 public boolean esAlgoformerPropio(Colocable unColocable){
		for(AlgoFormer actual: robotsJugador)
			if(actual.equals(unColocable))
				return true;
		return false;
	}

    public boolean puedeJugar(){
        return (turnosAunOcupados<=0);
    }

	private void validarQuePuedeJugar()throws YaInicioMovimiento{
		if(!puedeJugar())
			throw new JugadorOcupado();
		if(inicioMovimiento)
			throw new YaInicioMovimiento();
	}

    private void hayUnAlgoFormerPropioEnPosicion(Posicion posicionOrigen) throws NoEsAlgoFormerPropio{
        Colocable aMover = tablero.obtenerCasilleroAsociadoAPosicion(posicionOrigen).getColocable();
        if (!esAlgoformerPropio(aMover))
            throw new NoEsAlgoFormerPropio();
    }

	protected abstract AlgoFormer crearAlgoFormerCombinado(AlgoFormer unAlgoformer, AlgoFormer otroAlgoformer, AlgoFormer tercerAlgoFormer);

	protected abstract void colocarAlgoFormers(Tablero tablero, AlgoFormer unRobot, AlgoFormer otroRobot, AlgoFormer tercerRobot);
	public DatosAlgoformer obtenerDatos(Colocable colocable){
		if (robotsJugador.contains(colocable)){
			AlgoFormer robot=(AlgoFormer) colocable;
			return new DatosAlgoformer(robot.getPuntosDeVidaOriginal(),robot.getPuntosDeVida(),robot.getAtaque(),robot.getVelocidad(),
					robot.getDistanciaDeAtaque(),robot.getClass().getSimpleName(), robot.getModo().getClass().getSimpleName(), (String) robot.getModo().getModificadorActivo());
		}
		else
			throw new NoEncontradoError();
	}
	private void combinar()throws NoPuedeCombinarPorTenerAlgoFormersMuertos{
		if (robotsJugador.size() < 3)
			throw new NoPuedeCombinarPorTenerAlgoFormersMuertos();
		if(!(robotsJugador.get(0).estaVivo() && robotsJugador.get(1).estaVivo() && robotsJugador.get(2).estaVivo()))
			throw new NoPuedeCombinarPorTenerAlgoFormersMuertos();

		AlgoFormer combinacion = crearAlgoFormerCombinado(robotsJugador.get(0),robotsJugador.get(1),robotsJugador.get(2));
		AlgoFormer algoformerDeReunion=  robotsJugador.get(0);
		Posicion posicionCombinado = tablero.obtenerPosicionAsociadaAColocable(algoformerDeReunion);

		for(AlgoFormer actual : robotsJugador){
			Posicion posicionActual= tablero.obtenerPosicionAsociadaAColocable(actual);
			tablero.vaciarPosicion(posicionActual);
			notificarCambio(posicionActual);
		}
		robotsJugador.clear();

		robotsJugador.add(combinacion);
		tablero.colocarAlgoformer(posicionCombinado, combinacion);
		notificarCambio(posicionCombinado);
	}
	private void descombinar() throws NoPuedeCombinarPorTenerAlgoFormersMuertos{
		if(robotsJugador.size()!=1 || !robotsJugador.get(0).estaVivo())
				throw new NoPuedeCombinarPorTenerAlgoFormersMuertos();
		ControladorPosiciones unControlador = new ControladorPosiciones(tablero.getDimension());
		Posicion posicionRobot = tablero.obtenerPosicionAsociadaAColocable(robotsJugador.get(0));
		tablero.vaciarPosicion(posicionRobot);
		notificarCambio(posicionRobot);
		unControlador.inicializarIteradorDesdePosicion(posicionRobot);
		AlgoformerCombinado combiancion = (AlgoformerCombinado) robotsJugador.get(0);
		robotsJugador = combiancion.descomponer();

		for (AlgoFormer actual : robotsJugador){
			while(tablero.estaOcupadoEnPosicion(posicionRobot))
				posicionRobot=unControlador.inicializarPosicion();
			tablero.colocarAlgoformer(posicionRobot, actual);
			notificarCambio(posicionRobot);
		}
	}
}

