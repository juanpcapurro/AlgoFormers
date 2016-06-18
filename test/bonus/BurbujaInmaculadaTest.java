package bonus;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import algoFormers.juego.Jugador;
import algoFormers.juego.turno.Turno;
import algoFormers.tablero.colocable.bonus.BurbujaInmaculada;
import algoFormers.tablero.colocable.bonus.Flash;
import algoFormers.tablero.colocable.robots.armas.DisparoConvencional;
import algoFormers.tablero.colocable.robots.autobot.Autobots;
import algoFormers.tablero.colocable.robots.decepticon.Decepticons;

public class BurbujaInmaculadaTest {
	
	private Jugador Monica;
	private Jugador Rachel;
	public Autobots autobots;
	private Decepticons decepticons;
	private Turno turno;
	static final int CANTIDADJUGADORES=2;
	
	@Before
	public void setUp() throws Exception {
		this.Monica = new Jugador("Monica");
		this.Rachel = new Jugador("Rachel");
		this.decepticons = new Decepticons();
		this.autobots = new Autobots();
		
		this.Monica.asignarEquipo(this.autobots);
		this.Rachel.asignarEquipo(this.decepticons);
		
		this.turno=new Turno(CANTIDADJUGADORES);
		this.turno.agregarJugador(Monica);
		this.turno.agregarJugador(Rachel);
	}
	
	@Test
	public void test01OptimusConVidaTotalTomaBurbujaYNoPierdeVidaPor2Turnos(){

		//Vida pre bonus
		assertEquals(this.autobots.getOptimus().getPuntosDeVida(),500);
		
		//turno de obtencion
		assertEquals(this.turno.obtenerJugadorQueDebeJugar(),Monica);
		this.autobots.getOptimus().recibirColocable(new BurbujaInmaculada());
		assertEquals(this.autobots.getOptimus().getPuntosDeVida(),500);
		this.autobots.getOptimus().recibirAtaque(new DisparoConvencional(100));
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//primer turno con burbuja
		assertEquals(this.autobots.getOptimus().getPuntosDeVida(),500);
		this.autobots.getOptimus().recibirAtaque(new DisparoConvencional(200));
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//segundo turno con burbuja.Recupero vida perdida antes
		assertEquals(this.autobots.getOptimus().getPuntosDeVida(),500);
		this.autobots.getOptimus().recibirAtaque(new DisparoConvencional(200));
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//tercer turno con burbuja.Recupera vida perdida antes
		assertEquals(this.autobots.getOptimus().getPuntosDeVida(),500);
		this.autobots.getOptimus().recibirAtaque(new DisparoConvencional(200));
		assertEquals(this.autobots.getOptimus().getPuntosDeVida(),300);
		this.turno.avanzarTurno();
		
		//Cuarto turno con burbuja. No recupera vida
		assertEquals(this.autobots.getOptimus().getPuntosDeVida(),300);
		this.turno.finalizar();
	}

	@Test
	public void test02OptimusDaniadoTomaBurbujaYNoPierdeVidaPor2Turnos(){

		//Vida pre bonus
		this.autobots.getOptimus().recibirAtaque(new DisparoConvencional(100));
		assertEquals(this.autobots.getOptimus().getPuntosDeVida(),400);
		
		//turno de obtencion
		assertEquals(this.turno.obtenerJugadorQueDebeJugar(),Monica);
		this.autobots.getOptimus().recibirColocable(new BurbujaInmaculada());
		assertEquals(this.autobots.getOptimus().getPuntosDeVida(),400);
		this.autobots.getOptimus().recibirAtaque(new DisparoConvencional(100));
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//primer turno con burbuja
		assertEquals(this.autobots.getOptimus().getPuntosDeVida(),400);
		this.autobots.getOptimus().recibirAtaque(new DisparoConvencional(200));
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//segundo turno con burbuja.Recupero vida perdida antes
		assertEquals(this.autobots.getOptimus().getPuntosDeVida(),400);
		this.autobots.getOptimus().recibirAtaque(new DisparoConvencional(200));
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//tercer turno con burbuja.Recupera vida perdida antes
		assertEquals(this.autobots.getOptimus().getPuntosDeVida(),400);
		this.autobots.getOptimus().recibirAtaque(new DisparoConvencional(200));
		assertEquals(this.autobots.getOptimus().getPuntosDeVida(),200);
		this.turno.avanzarTurno();
		
		//Cuarto turno con burbuja. No recupera vida
		assertEquals(this.autobots.getOptimus().getPuntosDeVida(),200);
		this.turno.finalizar();
	}
	
	@Test
	public void test03OptimusAlternoConVidaTotalTomaBurbujaYNoPierdeVidaPor2Turnos(){

		//Vida pre bonus
		this.autobots.getOptimus().transformar();
		assertEquals(this.autobots.getOptimus().getPuntosDeVida(),500);
		
		//turno de obtencion
		assertEquals(this.turno.obtenerJugadorQueDebeJugar(),Monica);
		this.autobots.getOptimus().recibirColocable(new BurbujaInmaculada());
		assertEquals(this.autobots.getOptimus().getPuntosDeVida(),500);
		this.autobots.getOptimus().recibirAtaque(new DisparoConvencional(100));
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//primer turno con burbuja
		assertEquals(this.autobots.getOptimus().getPuntosDeVida(),500);
		this.autobots.getOptimus().recibirAtaque(new DisparoConvencional(200));
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//segundo turno con burbuja.Recupero vida perdida antes
		assertEquals(this.autobots.getOptimus().getPuntosDeVida(),500);
		this.autobots.getOptimus().recibirAtaque(new DisparoConvencional(200));
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//tercer turno con burbuja.Recupera vida perdida antes
		assertEquals(this.autobots.getOptimus().getPuntosDeVida(),500);
		this.autobots.getOptimus().recibirAtaque(new DisparoConvencional(200));
		assertEquals(this.autobots.getOptimus().getPuntosDeVida(),300);
		this.turno.avanzarTurno();
		
		//Cuarto turno con burbuja. No recupera vida
		assertEquals(this.autobots.getOptimus().getPuntosDeVida(),300);
		this.turno.finalizar();
	}

	@Test
	public void test04OptimusAlternoDaniadoTomaBurbujaYNoPierdeVidaPor2Turnos(){

		//Vida pre bonus
		this.autobots.getOptimus().transformar();
		this.autobots.getOptimus().recibirAtaque(new DisparoConvencional(100));
		assertEquals(this.autobots.getOptimus().getPuntosDeVida(),400);
		
		//turno de obtencion
		assertEquals(this.turno.obtenerJugadorQueDebeJugar(),Monica);
		this.autobots.getOptimus().recibirColocable(new BurbujaInmaculada());
		assertEquals(this.autobots.getOptimus().getPuntosDeVida(),400);
		this.autobots.getOptimus().recibirAtaque(new DisparoConvencional(100));
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//primer turno con burbuja
		assertEquals(this.autobots.getOptimus().getPuntosDeVida(),400);
		this.autobots.getOptimus().recibirAtaque(new DisparoConvencional(200));
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//segundo turno con burbuja.Recupero vida perdida antes
		assertEquals(this.autobots.getOptimus().getPuntosDeVida(),400);
		this.autobots.getOptimus().recibirAtaque(new DisparoConvencional(200));
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//tercer turno con burbuja.Recupera vida perdida antes
		assertEquals(this.autobots.getOptimus().getPuntosDeVida(),400);
		this.autobots.getOptimus().recibirAtaque(new DisparoConvencional(200));
		assertEquals(this.autobots.getOptimus().getPuntosDeVida(),200);
		this.turno.avanzarTurno();
		
		//Cuarto turno con burbuja. No recupera vida
		assertEquals(this.autobots.getOptimus().getPuntosDeVida(),200);
		this.turno.finalizar();
	}

	@Test
	public void test05BumblebeeConVidaTotalTomaBurbujaYNoPierdeVidaPor2Turnos(){

		//Vida pre bonus
		assertEquals(this.autobots.getBumblebee().getPuntosDeVida(),350);
		
		//turno de obtencion
		assertEquals(this.turno.obtenerJugadorQueDebeJugar(),Monica);
		this.autobots.getBumblebee().recibirColocable(new BurbujaInmaculada());
		assertEquals(this.autobots.getBumblebee().getPuntosDeVida(),350);
		this.autobots.getBumblebee().recibirAtaque(new DisparoConvencional(100));
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//primer turno con burbuja
		assertEquals(this.autobots.getBumblebee().getPuntosDeVida(),350);
		this.autobots.getBumblebee().recibirAtaque(new DisparoConvencional(200));
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//segundo turno con burbuja.Recupero vida perdida antes
		assertEquals(this.autobots.getBumblebee().getPuntosDeVida(),350);
		this.autobots.getBumblebee().recibirAtaque(new DisparoConvencional(200));
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//tercer turno con burbuja.Recupera vida perdida antes
		assertEquals(this.autobots.getBumblebee().getPuntosDeVida(),350);
		this.autobots.getBumblebee().recibirAtaque(new DisparoConvencional(200));
		assertEquals(this.autobots.getBumblebee().getPuntosDeVida(),150);
		this.turno.avanzarTurno();
		
		//Cuarto turno con burbuja. No recupera vida
		assertEquals(this.autobots.getBumblebee().getPuntosDeVida(),150);
		this.turno.finalizar();
	}

	@Test
	public void test06BumblebeeDaniadoTomaBurbujaYNoPierdeVidaPor2Turnos(){

		//Vida pre bonus
		assertEquals(this.autobots.getBumblebee().getPuntosDeVida(),350);
		this.autobots.getBumblebee().recibirAtaque(new DisparoConvencional(100));
		
		//turno de obtencion
		assertEquals(this.turno.obtenerJugadorQueDebeJugar(),Monica);
		this.autobots.getBumblebee().recibirColocable(new BurbujaInmaculada());
		assertEquals(this.autobots.getBumblebee().getPuntosDeVida(),250);
		this.autobots.getBumblebee().recibirAtaque(new DisparoConvencional(100));
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//primer turno con burbuja
		assertEquals(this.autobots.getBumblebee().getPuntosDeVida(),250);
		this.autobots.getBumblebee().recibirAtaque(new DisparoConvencional(200));
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//segundo turno con burbuja.Recupero vida perdida antes
		assertEquals(this.autobots.getBumblebee().getPuntosDeVida(),250);
		this.autobots.getBumblebee().recibirAtaque(new DisparoConvencional(200));
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//tercer turno con burbuja.Recupera vida perdida antes
		assertEquals(this.autobots.getBumblebee().getPuntosDeVida(),250);
		this.autobots.getBumblebee().recibirAtaque(new DisparoConvencional(200));
		assertEquals(this.autobots.getBumblebee().getPuntosDeVida(),50);
		this.turno.avanzarTurno();
		
		//Cuarto turno con burbuja. No recupera vida
		assertEquals(this.autobots.getBumblebee().getPuntosDeVida(),50);
		this.turno.finalizar();
	}
	
	@Test
	public void test07BumblebeeAlternoConVidaTotalTomaBurbujaYNoPierdeVidaPor2Turnos(){

		this.autobots.getOptimus().transformar();
		//Vida pre bonus
		assertEquals(this.autobots.getBumblebee().getPuntosDeVida(),350);
		
		//turno de obtencion
		assertEquals(this.turno.obtenerJugadorQueDebeJugar(),Monica);
		this.autobots.getBumblebee().recibirColocable(new BurbujaInmaculada());
		assertEquals(this.autobots.getBumblebee().getPuntosDeVida(),350);
		this.autobots.getBumblebee().recibirAtaque(new DisparoConvencional(100));
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//primer turno con burbuja
		assertEquals(this.autobots.getBumblebee().getPuntosDeVida(),350);
		this.autobots.getBumblebee().recibirAtaque(new DisparoConvencional(200));
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//segundo turno con burbuja.Recupero vida perdida antes
		assertEquals(this.autobots.getBumblebee().getPuntosDeVida(),350);
		this.autobots.getBumblebee().recibirAtaque(new DisparoConvencional(200));
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//tercer turno con burbuja.Recupera vida perdida antes
		assertEquals(this.autobots.getBumblebee().getPuntosDeVida(),350);
		this.autobots.getBumblebee().recibirAtaque(new DisparoConvencional(200));
		assertEquals(this.autobots.getBumblebee().getPuntosDeVida(),150);
		this.turno.avanzarTurno();
		
		//Cuarto turno con burbuja. No recupera vida
		assertEquals(this.autobots.getBumblebee().getPuntosDeVida(),150);
		this.turno.finalizar();
	}

	@Test
	public void test08BumblebeeAlternoDaniadoTomaBurbujaYNoPierdeVidaPor2Turnos(){

		this.autobots.getBumblebee().transformar();
		//Vida pre bonus
		assertEquals(this.autobots.getBumblebee().getPuntosDeVida(),350);
		this.autobots.getBumblebee().recibirAtaque(new DisparoConvencional(100));
		
		//turno de obtencion
		assertEquals(this.turno.obtenerJugadorQueDebeJugar(),Monica);
		this.autobots.getBumblebee().recibirColocable(new BurbujaInmaculada());
		assertEquals(this.autobots.getBumblebee().getPuntosDeVida(),250);
		this.autobots.getBumblebee().recibirAtaque(new DisparoConvencional(100));
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//primer turno con burbuja
		assertEquals(this.autobots.getBumblebee().getPuntosDeVida(),250);
		this.autobots.getBumblebee().recibirAtaque(new DisparoConvencional(200));
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//segundo turno con burbuja.Recupero vida perdida antes
		assertEquals(this.autobots.getBumblebee().getPuntosDeVida(),250);
		this.autobots.getBumblebee().recibirAtaque(new DisparoConvencional(200));
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//tercer turno con burbuja.Recupera vida perdida antes
		assertEquals(this.autobots.getBumblebee().getPuntosDeVida(),250);
		this.autobots.getBumblebee().recibirAtaque(new DisparoConvencional(200));
		assertEquals(this.autobots.getBumblebee().getPuntosDeVida(),50);
		this.turno.avanzarTurno();
		
		//Cuarto turno con burbuja. No recupera vida
		assertEquals(this.autobots.getBumblebee().getPuntosDeVida(),50);
		this.turno.finalizar();
	}
		
}

