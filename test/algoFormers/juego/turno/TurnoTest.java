package algoFormers.juego.turno;

import algoFormers.juego.Jugador;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
	/*
	@Test
	public void test05Jugador1EligeCombinarYNoJuegaProximos2Turnos(){
		Jugador jugadorActual = turno.obtenerJugadorQueDebeJugar();
		jugadorActual.agregarUnidad(new Bumblebee());
		jugadorActual.agregarUnidad(new Ratchet());
		jugadorActual.agregarUnidad(new Optimus());
		turno.deCombinacion();
		turno.combinarAlgoformers(); // combina y se finaliza el turno

		assertEquals(turno.obtenerJugadorQueDebeJugar(),miJugador2);
		turno.finalizar();
		assertEquals(turno.obtenerJugadorQueDebeJugar(),miJugador2);
		turno.finalizar();
		assertEquals(turno.obtenerJugadorQueDebeJugar(),miJugador2);
		turno.finalizar();
		assertEquals(turno.obtenerJugadorQueDebeJugar(),miJugador1);

	}

	@Test
	public void test06JugadoresUsanSuTurnoParaTransformarUnoDeSusAlgoformers(){

		Optimus optimus = new Optimus();
		assertTrue(optimus.estaEnModoHumanoide());

		turno.obtenerJugadorQueDebeJugar().agregarUnidad(optimus);
		turno.deTransformacion();
		turno.jugarCon("OPTIMUS");
		turno.transformar(); //post transformacion finaliza su turno, no puede hacer nada mas.

		assertTrue(optimus.estaEnModoAlterno());
		assertTrue(turno.finalizado());

		BoneCrusher boneCrusher = new BoneCrusher();
		assertTrue(boneCrusher.estaEnModoHumanoide());

		turno.obtenerJugadorQueDebeJugar().agregarUnidad(boneCrusher);
		turno.deTransformacion();
		turno.jugarCon("BONECRUSHER");
		turno.transformar();

		assertTrue(boneCrusher.estaEnModoAlterno());
		assertTrue(turno.finalizado());


	}



	@Test
	public void test07JugadorUsaElTurnoParaMoverOptimusUsaTodaDistanciaValida(){
		turno.obtenerJugadorQueDebeJugar().agregarUnidad(new Optimus());
		turno.deMovimiento();
		turno.jugarCon("OPTIMUS");
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
		turno.obtenerJugadorQueDebeJugar().agregarUnidad(new Optimus());
		turno.deMovimiento();
		turno.jugarCon("OPTIMUS");


		Posicion posicionOrigen = new Posicion(0,1);
		Posicion posicionDestino = new Posicion(1,1);
		turno.mover(posicionOrigen,posicionDestino);

		assertFalse(turno.finalizado()); //le queda un paso disponible.

		//decide no moverse mas.
		turno.finalizar();

		assertTrue(turno.finalizado());

	}

	@Test
	public void test09JugadorUsaElTurnoParaMoverRatchetUsaTodaDistanciaValida(){}

	@Test
	public void test10JugadorUsaElTurnoParaMoverRatchetUsaMediaDistanciaValidaYFinalizaTurno(){}

	@Test
	public void test11JugadorUsaElTurnoParaMoverBumblebeeUsaTodaDistanciaValida(){}

	@Test
	public void test12JugadorUsaElTurnoParaMoverBumblebeeUsaMediaDistanciaValidaYFinalizaTurno(){}

	@Test
	public void test13JugadorUsaElTurnoParaMoverBoneCrusherUsaTodaDistanciaValida(){}

	@Test
	public void test14JugadorUsaElTurnoParaMoverBoneCrusherUsaMediaDistanciaValidaYFinalizaTurno(){}

	@Test
	public void test15JugadorUsaElTurnoParaMoverFrenzyUsaTodaDistanciaValida(){}

	@Test
	public void test16JugadorUsaElTurnoParaMoverFrenzyUsaMediaDistanciaValidaYFinalizaTurno(){}

	@Test
	public void test17JugadorUsaElTurnoParaMoverMegatronUsaTodaDistanciaValida(){}

	@Test
	public void test18JugadorUsaElTurnoParaMoverMegatronUsaMediaDistanciaValidaYFinalizaTurno(){}

	@Test
	public void test19JugadorUsaElTurnoParaMoverSuperionUsaTodaDistanciaValida(){}

	@Test
	public void test20JugadorUsaElTurnoParaMoverSuperionUsaMediaDistanciaValidaYFinalizaTurno(){}

	@Test
	public void test21JugadorUsaElTurnoParaMoverMenasorUsaTodaDistanciaValida(){}

	@Test
	public void test22JugadorUsaElTurnoParaMoverMenasorUsaMediaDistanciaValidaYFinalizaTurno(){}

	@Test
	public void test23JugadorUsaElTurnoParaAtacar(){

		turno.obtenerJugadorQueDebeJugar().agregarUnidad(new Optimus());
		turno.deAtaque();
		turno.jugarCon("OPTIMUS");

		Posicion posicionDestino = new Posicion(1,1);
		turno.atacar(posicionDestino); //ataca y finaliza su turno.

		assertTrue(turno.finalizado());

	}

*/


}
