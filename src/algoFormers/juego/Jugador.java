
package algoFormers.juego;

import algoFormers.tablero.colocable.robots.AlgoFormer;
import algoFormers.tablero.posiciones.Posicion;

import java.util.ArrayList;
import java.util.List;

public class Jugador {



	private String nombreDeJugador;
	List<AlgoFormer> equipo;
	Jugada jugadaEnCurso;


	public Jugador(String nuevoNombre){
		this.nombreDeJugador = nuevoNombre;
		equipo= new ArrayList<>();
		jugadaEnCurso = new Jugada();
	}

	
	String getNombreDeJugador() {
		return this.nombreDeJugador;
	}


	public void agregarUnidad(AlgoFormer nuevoAlgoBot) {
		equipo.add(nuevoAlgoBot);
	}

	boolean equipovivo(){
		for (AlgoFormer algoformer : equipo)
			if (algoformer.estaVivo())
				return true;
		return false;
	}

	public void combinarAlgoformers() {
		if(equipovivo()){
			jugadaEnCurso.vaASerDeCombinacion();
			jugadaEnCurso.combinar(equipo);
		}
		else{
			throw new AlgoformersDeSuEquipoHanMuerto("Solo puede combinar sus algoformers si los 3 permanecen con vida");
		}
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
}
