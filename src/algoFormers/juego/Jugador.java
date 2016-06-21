
package algoFormers.juego;

import algoFormers.tablero.colocable.robots.AlgoFormer;
import algoFormers.tablero.colocable.robots.Equipo;
import algoFormers.tablero.posiciones.Posicion;

public class Jugador {



	private String nombreDeJugador;
	Equipo equipo=null;
	Jugada jugadaEnCurso;


	public Jugador(String nuevoNombre){
		this.nombreDeJugador = nuevoNombre;
		jugadaEnCurso = new Jugada();
	}

	
	String getNombreDeJugador() {
		return this.nombreDeJugador;
	}


	boolean equipovivo(){
		return equipo.estaVivo();
	}

	public void combinarAlgoformers() {
		if(equipoTotalmentevivo()){
			jugadaEnCurso.vaASerDeCombinacion();
			jugadaEnCurso.combinar(equipo);
		}
		else if(jugadaEnCurso.esDeCombinacion()){
			throw new JugadaEnCursoNoEsDeCombinacion();
		}
		else{
			throw new AlgoformersDeSuEquipoHanMuerto("Solo puede combinar sus algoformers si los 3 permanecen con vida");
		}
	}

	private boolean equipoTotalmentevivo() {
		return equipo.estanTodosAlgoformersVivos();
	}

	public void transformar() {
		jugadaEnCurso.transformar();
	}

	public void jugarCon(AlgoFormer algoFormerDelTurno){
		jugadaEnCurso.jugarCon(algoFormerDelTurno);
	}

	public void atacar(Posicion posicionDestino) {
		this.jugadaEnCurso.atacar(posicionDestino);
	}

	public void mover(Posicion posicionOrigen, Posicion posicionDestino) {
		this.jugadaEnCurso.mover(posicionOrigen,posicionDestino);
	}

	public boolean enProcesoDeCombinacion() {
		return jugadaEnCurso.enProcesoDeCombinacion();
	}

	public void pasoTurno() {
		jugadaEnCurso.pasoTurno();
	}

	public boolean seQuedoSinMovimientos() {
		return (jugadaEnCurso.getMovimientosDisponibles()==0);
	}

	public void asignarEquipo(Equipo equipo) {
		this.equipo = equipo;


	}

	public void notificar() {
		if(equipo!=null)
		equipo.notificar();
	}


	public Jugada obtenerJugadaActual() {
		// TODO Auto-generated method stub
		return jugadaEnCurso;
	}
}
