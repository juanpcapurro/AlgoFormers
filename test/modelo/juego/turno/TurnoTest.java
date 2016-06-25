package modelo.juego.turno;

import modelo.juego.Jugador;
import modelo.juego.Turno;
import modelo.juego.YaUtilizoPasosDisponibles;
import modelo.tablero.colocable.robots.autobot.Autobots;
import modelo.tablero.colocable.robots.autobot.Bumblebee;
import modelo.tablero.colocable.robots.autobot.Optimus;
import modelo.tablero.colocable.robots.autobot.Ratchet;
import modelo.tablero.colocable.robots.decepticon.BoneCrusher;
import modelo.tablero.colocable.robots.decepticon.Decepticons;
import modelo.tablero.colocable.robots.decepticon.Frenzy;
import modelo.tablero.colocable.robots.decepticon.Megatron;
import modelo.tablero.posiciones.Posicion;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class  TurnoTest {
	
	private Jugador miJugador1;
	private Jugador miJugador2;
	private Turno turno;
	static final int CANTIDADJUGADORES=2;
	
	@Before
	public void setUp() throws Exception {
		this.miJugador1 = new Jugador("Barry");
		this.miJugador2 = new Jugador("Oliver");
		turno=new Turno(CANTIDADJUGADORES);
		turno.agregarJugador(miJugador1);
		turno.agregarJugador(miJugador2);
	}
	
	@Test
	public void test01TurnoArrancaEn1(){
		assertEquals(turno.avanzarTurno(),miJugador1);
	}
	
	@Test
	public void test02TurnoSeIncrementa(){
		turno.avanzarTurno();
		assertEquals(turno.avanzarTurno(),miJugador2);

	}
	@Test
	public void test03TercerTurnoEsDelPrimeroJugador(){
		assertEquals(turno.avanzarTurno(),miJugador1);
	}
	@Test
	public void test04CuartoTurnoEsDelSegundoJugador(){
		turno.avanzarTurno();
		turno.avanzarTurno();
		turno.avanzarTurno();
		assertEquals(turno.avanzarTurno(),miJugador2);
	}

	@Test
	public void test05Jugador1EligeCombinarYNoJuegaProximos2Turnos(){
		Jugador jugadorActual = turno.obtenerJugadorQueDebeJugar();
		assertEquals(jugadorActual,miJugador1);

		jugadorActual.asignarEquipo(new Autobots());

		turno.deCombinacion();
		turno.combinarAlgoformers(); // combina y se finaliza el turno

		jugadorActual = turno.obtenerJugadorQueDebeJugar();
		assertEquals(jugadorActual,miJugador2);
		turno.finalizar();
		jugadorActual = turno.obtenerJugadorQueDebeJugar();
		assertEquals(jugadorActual,miJugador2);
		turno.finalizar();
		jugadorActual = turno.obtenerJugadorQueDebeJugar();
		assertEquals(jugadorActual,miJugador2);
		turno.finalizar();
		assertEquals(turno.obtenerJugadorQueDebeJugar(),miJugador1);


	}

	@Test
	public void test06JugadoresUsanSuTurnoParaTransformarUnoDeSusAlgoformers(){
		Jugador jugadorActual = turno.obtenerJugadorQueDebeJugar();
		Autobots equipo = new Autobots();
		jugadorActual.asignarEquipo(equipo);

		Optimus optimus = equipo.getOptimus();
		assertTrue(optimus.estaEnModoHumanoide());


		turno.deTransformacion();
		turno.jugarCon(optimus);
		turno.transformar();

		assertTrue(optimus.estaEnModoAlterno());

		Jugador jugadorSiguiente = turno.obtenerJugadorQueDebeJugar();
		Decepticons decepticons = new Decepticons();
		jugadorSiguiente.asignarEquipo(decepticons);

		BoneCrusher boneCrusher = decepticons.getBoneCrusher();
		assertTrue(boneCrusher.estaEnModoHumanoide());
		turno.deTransformacion();
		turno.jugarCon(boneCrusher);
		turno.transformar();

		assertTrue(boneCrusher.estaEnModoAlterno());


	}

	@Test
	public void test07JugadorUsaElTurnoParaMoverOptimusUsaTodaDistanciaValida(){
		Jugador jugadorActual = turno.obtenerJugadorQueDebeJugar();
		Autobots equipo = new Autobots();
		jugadorActual.asignarEquipo(equipo);
		Optimus optimus = equipo.getOptimus();

		turno.deMovimiento();
		turno.jugarCon(optimus);
		//optimus en modo humanoide puede moverse hasta 2 casilleros de distancia = 2 pasos.
		//se supone cada movimiento es de paso por paso.

		Posicion posicionOrigen = new Posicion(0,1);
		Posicion posicionDestino = new Posicion(1,1);
		turno.mover(posicionOrigen,posicionDestino);

		assertFalse(turno.finalizado()); //le queda un paso disponible.

		posicionOrigen = posicionDestino;
		posicionDestino = new Posicion(2,1);
		turno.mover(posicionOrigen,posicionDestino);  //se queda sin pasos.

		assertTrue(turno.finalizado());

	}

	@Test
	public void test08JugadorUsaElTurnoParaMoverOptimusUsaMediaDistanciaValidaYFinalizaTurno(){

		Jugador jugadorActual = turno.obtenerJugadorQueDebeJugar();
		Autobots equipo = new Autobots();
		jugadorActual.asignarEquipo(equipo);
		Optimus optimus = equipo.getOptimus();

		turno.deMovimiento();
		turno.jugarCon(optimus);


		Posicion posicionOrigen = new Posicion(0,1);
		Posicion posicionDestino = new Posicion(1,1);
		turno.mover(posicionOrigen,posicionDestino);

		assertFalse(turno.finalizado()); //le queda un paso disponible.

		//decide no moverse mas.
		turno.finalizar();

		assertTrue(turno.finalizado());

	}

	@Test
	public void test09JugadorUsaElTurnoParaMoverRatchetUsaTodaDistanciaValida(){
		Jugador jugadorActual = turno.obtenerJugadorQueDebeJugar();
		Autobots equipo = new Autobots();
		jugadorActual.asignarEquipo(equipo);
		Ratchet ratchet = equipo.getRatchet();

		turno.deMovimiento();
		turno.jugarCon(ratchet);

		Posicion posicionOrigen = new Posicion(0,1);
		Posicion posicionDestino = new Posicion(1,1);
		turno.mover(posicionOrigen,posicionDestino);

		assertTrue(turno.finalizado());
	}

	@Test
	public void test10JugadorDecidePasarElTurno(){
		Jugador jugadorActual = turno.obtenerJugadorQueDebeJugar();

		turno.finalizar();

		assertTrue(turno.finalizado());
	}

	@Test
	public void test11JugadorUsaElTurnoParaMoverBumblebeeUsaTodaDistanciaValida(){
		Jugador jugadorActual = turno.obtenerJugadorQueDebeJugar();
		Autobots equipo = new Autobots();
		jugadorActual.asignarEquipo(equipo);
		Bumblebee bumblebee = equipo.getBumblebee();

		turno.deMovimiento();
		turno.jugarCon(bumblebee);


		Posicion posicionOrigen = new Posicion(0,1);
		Posicion posicionDestino = new Posicion(1,1);
		turno.mover(posicionOrigen,posicionDestino);

		assertFalse(turno.finalizado()); //le queda un paso disponible.

		posicionOrigen = posicionDestino;
		posicionDestino = new Posicion(2,1);
		turno.mover(posicionOrigen,posicionDestino);  //se queda sin pasos.

		assertTrue(turno.finalizado());
	}

	@Test
	public void test12JugadorUsaElTurnoParaMoverBumblebeeUsaMediaDistanciaValidaYFinalizaTurno(){

		Jugador jugadorActual = turno.obtenerJugadorQueDebeJugar();
		Autobots equipo = new Autobots();
		jugadorActual.asignarEquipo(equipo);
		Bumblebee bumblebee = equipo.getBumblebee();

		turno.deMovimiento();
		turno.jugarCon(bumblebee);


		Posicion posicionOrigen = new Posicion(0,1);
		Posicion posicionDestino = new Posicion(1,1);
		turno.mover(posicionOrigen,posicionDestino);

		assertFalse(turno.finalizado()); //le queda un paso disponible.

		//decide no moverse mas.
		turno.finalizar();

		assertTrue(turno.finalizado());

	}

	@Test
	public void test13JugadorUsaElTurnoParaMoverBoneCrusherUsaTodaDistanciaValida(){
		Jugador jugadorActual = turno.obtenerJugadorQueDebeJugar();
		Decepticons equipo = new Decepticons();
		jugadorActual.asignarEquipo(equipo);
		BoneCrusher boneCrusher = equipo.getBoneCrusher();

		turno.jugarCon(boneCrusher);

		Posicion posicionOrigen = new Posicion(0,1);
		Posicion posicionDestino = new Posicion(1,1);
		turno.mover(posicionOrigen,posicionDestino);

		assertTrue(turno.finalizado());

	}

	@Test
	public void test14JugadorUsaElTurnoParaMoverBoneCrusherEnModoAlterno(){
		Jugador jugadorActual = turno.obtenerJugadorQueDebeJugar();
		Decepticons equipo = new Decepticons();
		jugadorActual.asignarEquipo(equipo);
		BoneCrusher boneCrusher = equipo.getBoneCrusher();
		boneCrusher.transformar();

		turno.jugarCon(boneCrusher);

		Posicion posicionOrigen = new Posicion(0,1);
		Posicion posicionDestino = new Posicion(1,1);
		turno.mover(posicionOrigen,posicionDestino);

		assertFalse(turno.finalizado());

		posicionOrigen = posicionDestino;
		posicionDestino = new Posicion(2,1);
		turno.mover(posicionOrigen,posicionDestino);

		assertFalse(turno.finalizado());
	}

	@Test
	public void test15JugadorUsaElTurnoParaMoverFrenzyUsaTodaDistanciaValida(){
		Jugador jugadorActual = turno.obtenerJugadorQueDebeJugar();
		Decepticons equipo = new Decepticons();
		jugadorActual.asignarEquipo(equipo);
		Frenzy frenzy = equipo.getFrenzy();


		turno.jugarCon(frenzy);

		Posicion posicionOrigen = new Posicion(0,1);
		Posicion posicionDestino = new Posicion(1,1);
		turno.mover(posicionOrigen,posicionDestino);

		assertFalse(turno.finalizado());

		posicionOrigen = posicionDestino;
		posicionDestino = new Posicion(2,1);
		turno.mover(posicionOrigen,posicionDestino);

		assertTrue(turno.finalizado());
	}

	@Test
	public void test16JugadorUsaElTurnoParaMoverFrenzyUsaMediaDistanciaValidaYFinalizaTurno(){
		Jugador jugadorActual = turno.obtenerJugadorQueDebeJugar();
		Decepticons equipo = new Decepticons();
		jugadorActual.asignarEquipo(equipo);
		Frenzy frenzy = equipo.getFrenzy();


		turno.jugarCon(frenzy);

		Posicion posicionOrigen = new Posicion(0,1);
		Posicion posicionDestino = new Posicion(1,1);
		turno.mover(posicionOrigen,posicionDestino);

		assertFalse(turno.finalizado());

		turno.finalizar();
		assertTrue(turno.finalizado());
	}

	@Test
	public void test17JugadorUsaElTurnoParaMoverMegatronUsaTodaDistanciaValida(){
		Jugador jugadorActual = turno.obtenerJugadorQueDebeJugar();
		Decepticons equipo = new Decepticons();
		jugadorActual.asignarEquipo(equipo);
		Megatron megatron = equipo.getMegatron();

		turno.jugarCon(megatro		if(equipoTotalmentevivo()){
			jugadaEnCurso.vaASerDeCombinacion();
			jugadaEnCurso.combinar(equipo);
		}
		else if(jugadaEnCurso.esDeCombinacion()){
			throw new JugadaEnCursoNoEsDeCombinacion();
		}
		else{
			throw new AlgoformersDeSuEquipoHanMuerto("Solo puede combinar sus algoformers si los 3 permanecen con vida");
		}n);

		Posicion posicionOrigen = new Posicion(0,1);
		Posicion posicionDestino = new Posicion(1,1);
		turno.mover(posicionOrigen,posicionDestino);

		assertTrue(turno.finalizado());
	}

	@Test
	public void test18JugadorUsaElTurnoParaMoverMegatronEnModoAlterno(){
		Jugador jugadorActual = turno.obtenerJugadorQueDebeJugar();
		Decepticons equipo = new Decepticons();
		jugadorActual.asignarEquipo(equipo);
		Megatron megatron = equipo.getMegatron();
		megatron.transformar();

		turno.jugarCon(megatron);

		Posicion posicionOrigen = new Posicion(0,1);
		Posicion posicionDestino = new Posicion(1,1);
		turno.mover(posicionOrigen,posicionDestino);

		assertFalse(turno.finalizado());
	}

	@Test
	public void test19JugadorUsaElTurnoTransformarElSuperion(){
		Jugador jugadorActual = turno.obtenerJugadorQueDebeJugar();
		Autobots equipo = new Autobots();
		jugadorActual.asignarEquipo(equipo);

		turno.combinarAlgoformers();

		assertEquals(turno.obtenerJugadorQueDebeJugar(),miJugador2);
		turno.finalizar();
		assertEquals(turno.obtenerJugadorQueDebeJugar(),miJugador2);
		turno.finalizar();
		assertEquals(turno.obtenerJugadorQueDebeJugar(),miJugador2);
		turno.finalizar();

		turno.transformar();

		assertTrue(equipo.estaCombinado());

	}

	@Test
	public void test20JugadorUsaElTurnoParaMoverSuperion(){
		Jugador jugadorActual = turno.obtenerJugadorQueDebeJugar();
		Autobots equipo = new Autobots();
		jugadorActual.asignarEquipo(equipo);

		turno.combinarAlgoformers();

		assertEquals(turno.obtenerJugadorQueDebeJugar(),miJugador2);
		turno.finalizar();
		assertEquals(turno.obtenerJugadorQueDebeJugar(),miJugador2);
		turno.finalizar();
		assertEquals(turno.obtenerJugadorQueDebeJugar(),miJugador2);
		turno.finalizar();

		Posicion posicionOrigen = new Posicion(0,1);
		Posicion posicionDestino = new Posicion(1,1);
		turno.mover(posicionOrigen,posicionDestino);
		posicionOrigen = new Posicion(1,1);
		posicionDestino = new Posicion(1,2);
		turno.mover(posicionOrigen,posicionDestino);
		posicionOrigen = new Posicion(1,2);
		posicionDestino = new Posicion(1,3);
		turno.mover(posicionOrigen,posicionDestino);

		assertEquals(turno.obtenerJugadorQueDebeJugar(),miJugador2);

	}

	@Test
	public void test21JugadorUsaElTurnoParaMoverSuperionUsaParteDistanciaValidaYFinalizaTurno(){
		Jugador jugadorActual = turno.obtenerJugadorQueDebeJugar();
		Autobots equipo = new Autobots();
		jugadorActual.asignarEquipo(equipo);

		turno.combinarAlgoformers();

		assertEquals(turno.obtenerJugadorQueDebeJugar(),miJugador2);
		turno.finalizar();
		assertEquals(turno.obtenerJugadorQueDebeJugar(),miJugador2);
		turno.finalizar();
		assertEquals(turno.obtenerJugadorQueDebeJugar(),miJugador2);
		turno.finalizar();

		Posicion posicionOrigen = new Posicion(0,1);
		Posicion posicionDestino = new Posicion(1,1);
		turno.mover(posicionOrigen,posicionDestino);
		posicionOrigen = new Posicion(1,1);
		posicionDestino = new Posicion(1,2);
		turno.mover(posicionOrigen,posicionDestino);
		turno.finalizar();

		assertEquals(turno.obtenerJugadorQueDebeJugar(),miJugador2);

	}

	@Test
	public void test22JugadorUsaElTurnoParaMoverMenasor(){
		Jugador jugadorActual = turno.obtenerJugadorQueDebeJugar();
		Decepticons equipo = new Decepticons();
		jugadorActual.asignarEquipo(equipo);

		turno.combinarAlgoformers();

		assertEquals(turno.obtenerJugadorQueDebeJugar(),miJugador2);
		turno.finalizar();
		assertEquals(turno.obtenerJugadorQueDebeJugar(),miJugador2);
		turno.finalizar();
		assertEquals(turno.obtenerJugadorQueDebeJugar(),miJugador2);
		turno.finalizar();

		Posicion posicionOrigen = new Posicion(0,1);
		Posicion posicionDestino = new Posicion(1,1);
		turno.mover(posicionOrigen,posicionDestino);
		posicionOrigen = new Posicion(1,1);
		posicionDestino = new Posicion(1,2);
		turno.mover(posicionOrigen,posicionDestino);

		assertEquals(turno.obtenerJugadorQueDebeJugar(),miJugador2);
	}

	@Test
	public void test23JugadorUsaElTurnoParaAtacar(){
		Jugador jugadorActual = turno.obtenerJugadorQueDebeJugar();
		Autobots equipo = new Autobots();
		jugadorActual.asignarEquipo(equipo);

		Optimus optimus = equipo.getOptimus();

		turno.deAtaque();
		turno.jugarCon(optimus);

		Posicion posicionDestino = new Posicion(1,1);
		turno.atacar(posicionDestino); //ataca y finaliza su turno.

		assertTrue(turno.finalizado());

	}


	@Test (expected= YaUtilizoPasosDisponibles.class)
	public void test24JugadorUsaElTurnoParaMoverMenasorYExcedePasosDisponibles() {
		Jugador jugadorActual = turno.obtenerJugadorQueDebeJugar();
		Decepticons equipo = new Decepticons();
		jugadorActual.asignarEquipo(equipo);

		turno.combinarAlgoformers();

		assertEquals(turno.obtenerJugadorQueDebeJugar(), miJugador2);
		turno.finalizar();
		assertEquals(turno.obtenerJugadorQueDebeJugar(), miJugador2);
		turno.finalizar();
		assertEquals(turno.obtenerJugadorQueDebeJugar(), miJugador2);
		turno.finalizar();

		Posicion posicionOrigen = new Posicion(0, 1);
		Posicion posicionDestino = new Posicion(1, 1);
		turno.mover(posicionOrigen, posicionDestino);
		posicionOrigen = new Posicion(1, 1);
		posicionDestino = new Posicion(1, 2);
		turno.mover(posicionOrigen, posicionDestino);
		posicionOrigen = new Posicion(1, 2);
		posicionDestino = new Posicion(1, 3);
		turno.mover(posicionOrigen, posicionDestino);
	}



}
