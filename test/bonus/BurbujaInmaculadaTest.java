package bonus;

import algoFormers.juego.Jugador;
import algoFormers.juego.turno.Turno;
import algoFormers.tablero.colocable.bonus.BurbujaInmaculada;
import algoFormers.tablero.colocable.robots.armas.DisparoConvencional;
import algoFormers.tablero.colocable.robots.autobot.Autobots;
import algoFormers.tablero.colocable.robots.decepticon.Decepticons;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
	
	@Test
	public void test09RatchetConVidaTotalTomaBurbujaYNoPierdeVidaPor2Turnos(){

		//Vida pre bonus
		assertEquals(this.autobots.getRatchet().getPuntosDeVida(),150);
		
		//turno de obtencion
		assertEquals(this.turno.obtenerJugadorQueDebeJugar(),Monica);
		this.autobots.getRatchet().recibirColocable(new BurbujaInmaculada());
		assertEquals(this.autobots.getRatchet().getPuntosDeVida(),150);
		this.autobots.getRatchet().recibirAtaque(new DisparoConvencional(100));
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//primer turno con burbuja
		assertEquals(this.autobots.getRatchet().getPuntosDeVida(),150);
		this.autobots.getRatchet().recibirAtaque(new DisparoConvencional(60));
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//segundo turno con burbuja.Recupero vida perdida antes
		assertEquals(this.autobots.getRatchet().getPuntosDeVida(),150);
		this.autobots.getRatchet().recibirAtaque(new DisparoConvencional(60));
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//tercer turno con burbuja.Recupera vida perdida antes
		assertEquals(this.autobots.getRatchet().getPuntosDeVida(),150);
		this.autobots.getRatchet().recibirAtaque(new DisparoConvencional(60));
		assertEquals(this.autobots.getRatchet().getPuntosDeVida(),90);
		this.turno.avanzarTurno();
		
		//Cuarto turno con burbuja. No recupera vida
		assertEquals(this.autobots.getRatchet().getPuntosDeVida(),90);
		this.turno.finalizar();
	}

	@Test
	public void test10RatchetDaniadoTomaBurbujaYNoPierdeVidaPor2Turnos(){

		//Vida pre bonus
		this.autobots.getRatchet().recibirAtaque(new DisparoConvencional(10));
		assertEquals(this.autobots.getRatchet().getPuntosDeVida(),140);
		
		//turno de obtencion
		assertEquals(this.turno.obtenerJugadorQueDebeJugar(),Monica);
		this.autobots.getRatchet().recibirColocable(new BurbujaInmaculada());
		assertEquals(this.autobots.getRatchet().getPuntosDeVida(),140);
		this.autobots.getRatchet().recibirAtaque(new DisparoConvencional(100));
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//primer turno con burbuja
		assertEquals(this.autobots.getRatchet().getPuntosDeVida(),140);
		this.autobots.getRatchet().recibirAtaque(new DisparoConvencional(60));
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//segundo turno con burbuja.Recupero vida perdida antes
		assertEquals(this.autobots.getRatchet().getPuntosDeVida(),140);
		this.autobots.getRatchet().recibirAtaque(new DisparoConvencional(60));
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//tercer turno con burbuja.Recupera vida perdida antes
		assertEquals(this.autobots.getRatchet().getPuntosDeVida(),140);
		this.autobots.getRatchet().recibirAtaque(new DisparoConvencional(60));
		assertEquals(this.autobots.getRatchet().getPuntosDeVida(),80);
		this.turno.avanzarTurno();
		
		//Cuarto turno con burbuja. No recupera vida
		assertEquals(this.autobots.getRatchet().getPuntosDeVida(),80);
		this.turno.finalizar();
	}
	
	@Test
	public void test11RatchetAlternoConVidaTotalTomaBurbujaYNoPierdeVidaPor2Turnos(){

		//Vida pre bonus
		this.autobots.getRatchet().transformar();
		assertEquals(this.autobots.getRatchet().getPuntosDeVida(),150);
		
		//turno de obtencion
		assertEquals(this.turno.obtenerJugadorQueDebeJugar(),Monica);
		this.autobots.getRatchet().recibirColocable(new BurbujaInmaculada());
		assertEquals(this.autobots.getRatchet().getPuntosDeVida(),150);
		this.autobots.getRatchet().recibirAtaque(new DisparoConvencional(100));
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//primer turno con burbuja
		assertEquals(this.autobots.getRatchet().getPuntosDeVida(),150);
		this.autobots.getRatchet().recibirAtaque(new DisparoConvencional(60));
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//segundo turno con burbuja.Recupero vida perdida antes
		assertEquals(this.autobots.getRatchet().getPuntosDeVida(),150);
		this.autobots.getRatchet().recibirAtaque(new DisparoConvencional(60));
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//tercer turno con burbuja.Recupera vida perdida antes
		assertEquals(this.autobots.getRatchet().getPuntosDeVida(),150);
		this.autobots.getRatchet().recibirAtaque(new DisparoConvencional(60));
		assertEquals(this.autobots.getRatchet().getPuntosDeVida(),90);
		this.turno.avanzarTurno();
		
		//Cuarto turno con burbuja. No recupera vida
		assertEquals(this.autobots.getRatchet().getPuntosDeVida(),90);
		this.turno.finalizar();
	}

	@Test
	public void test12RatchetAlternoDaniadoTomaBurbujaYNoPierdeVidaPor2Turnos(){
		//Vida pre bonus
		this.autobots.getRatchet().transformar();
		this.autobots.getRatchet().recibirAtaque(new DisparoConvencional(10));
		assertEquals(this.autobots.getRatchet().getPuntosDeVida(),140);
		
		//turno de obtencion
		assertEquals(this.turno.obtenerJugadorQueDebeJugar(),Monica);
		this.autobots.getRatchet().recibirColocable(new BurbujaInmaculada());
		assertEquals(this.autobots.getRatchet().getPuntosDeVida(),140);
		this.autobots.getRatchet().recibirAtaque(new DisparoConvencional(100));
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//primer turno con burbuja
		assertEquals(this.autobots.getRatchet().getPuntosDeVida(),140);
		this.autobots.getRatchet().recibirAtaque(new DisparoConvencional(60));
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//segundo turno con burbuja.Recupero vida perdida antes
		assertEquals(this.autobots.getRatchet().getPuntosDeVida(),140);
		this.autobots.getRatchet().recibirAtaque(new DisparoConvencional(60));
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//tercer turno con burbuja.Recupera vida perdida antes
		assertEquals(this.autobots.getRatchet().getPuntosDeVida(),140);
		this.autobots.getRatchet().recibirAtaque(new DisparoConvencional(60));
		assertEquals(this.autobots.getRatchet().getPuntosDeVida(),80);
		this.turno.avanzarTurno();
		
		//Cuarto turno con burbuja. No recupera vida
		assertEquals(this.autobots.getRatchet().getPuntosDeVida(),80);
		this.turno.finalizar();
	}

	@Test
	public void test13MegatronConVidaTotalTomaBurbujaYNoPierdeVidaPor2Turnos(){

		//Vida pre bonus
		this.turno.avanzarTurno();
		assertEquals(this.decepticons.getMegatron().getPuntosDeVida(),550);
		
		//turno de obtencion
		assertEquals(this.turno.obtenerJugadorQueDebeJugar(),Rachel);
		this.decepticons.getMegatron().recibirColocable(new BurbujaInmaculada());
		assertEquals(this.decepticons.getMegatron().getPuntosDeVida(),550);
		this.decepticons.getMegatron().recibirAtaque(new DisparoConvencional(100));
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//primer turno con burbuja
		assertEquals(this.decepticons.getMegatron().getPuntosDeVida(),550);
		this.decepticons.getMegatron().recibirAtaque(new DisparoConvencional(60));
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//segundo turno con burbuja.Recupero vida perdida antes
		assertEquals(this.decepticons.getMegatron().getPuntosDeVida(),550);
		this.decepticons.getMegatron().recibirAtaque(new DisparoConvencional(60));
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//tercer turno con burbuja.Recupera vida perdida antes
		assertEquals(this.decepticons.getMegatron().getPuntosDeVida(),550);
		this.decepticons.getMegatron().recibirAtaque(new DisparoConvencional(60));
		assertEquals(this.decepticons.getMegatron().getPuntosDeVida(),490);
		this.turno.avanzarTurno();
		
		//Cuarto turno con burbuja. No recupera vida
		assertEquals(this.decepticons.getMegatron().getPuntosDeVida(),490);
		this.turno.finalizar();
	}

	@Test
	public void test14MegatronDaniadoTomaBurbujaYNoPierdeVidaPor2Turnos(){
		
		//Vida pre bonus
		this.turno.avanzarTurno();
		this.decepticons.getMegatron().recibirAtaque(new DisparoConvencional(50));
		assertEquals(this.decepticons.getMegatron().getPuntosDeVida(),500);
		
		
		//turno de obtencion
		assertEquals(this.turno.obtenerJugadorQueDebeJugar(),Rachel);
		this.decepticons.getMegatron().recibirColocable(new BurbujaInmaculada());
		assertEquals(this.decepticons.getMegatron().getPuntosDeVida(),500);
		this.decepticons.getMegatron().recibirAtaque(new DisparoConvencional(100));
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//primer turno con burbuja
		assertEquals(this.decepticons.getMegatron().getPuntosDeVida(),500);
		this.decepticons.getMegatron().recibirAtaque(new DisparoConvencional(60));
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//segundo turno con burbuja.Recupero vida perdida antes
		assertEquals(this.decepticons.getMegatron().getPuntosDeVida(),500);
		this.decepticons.getMegatron().recibirAtaque(new DisparoConvencional(60));
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//tercer turno con burbuja.Recupera vida perdida antes
		assertEquals(this.decepticons.getMegatron().getPuntosDeVida(),500);
		this.decepticons.getMegatron().recibirAtaque(new DisparoConvencional(60));
		assertEquals(this.decepticons.getMegatron().getPuntosDeVida(),440);
		this.turno.avanzarTurno();
		
		//Cuarto turno con burbuja. No recupera vida
		assertEquals(this.decepticons.getMegatron().getPuntosDeVida(),440);
		this.turno.finalizar();
	}
	
	@Test
	public void test15MegatronAlternoConVidaTotalTomaBurbujaYNoPierdeVidaPor2Turnos(){
		//Vida pre bonus
		this.turno.avanzarTurno();
		this.decepticons.getMegatron().transformar();
		assertEquals(this.decepticons.getMegatron().getPuntosDeVida(),550);
		
		//turno de obtencion
		assertEquals(this.turno.obtenerJugadorQueDebeJugar(),Rachel);
		this.decepticons.getMegatron().recibirColocable(new BurbujaInmaculada());
		assertEquals(this.decepticons.getMegatron().getPuntosDeVida(),550);
		this.decepticons.getMegatron().recibirAtaque(new DisparoConvencional(100));
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//primer turno con burbuja
		assertEquals(this.decepticons.getMegatron().getPuntosDeVida(),550);
		this.decepticons.getMegatron().recibirAtaque(new DisparoConvencional(60));
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//segundo turno con burbuja.Recupero vida perdida antes
		assertEquals(this.decepticons.getMegatron().getPuntosDeVida(),550);
		this.decepticons.getMegatron().recibirAtaque(new DisparoConvencional(60));
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//tercer turno con burbuja.Recupera vida perdida antes
		assertEquals(this.decepticons.getMegatron().getPuntosDeVida(),550);
		this.decepticons.getMegatron().recibirAtaque(new DisparoConvencional(60));
		assertEquals(this.decepticons.getMegatron().getPuntosDeVida(),490);
		this.turno.avanzarTurno();
		
		//Cuarto turno con burbuja. No recupera vida
		assertEquals(this.decepticons.getMegatron().getPuntosDeVida(),490);
		this.turno.finalizar();
	}

	@Test
	public void test16MegatronAlternoDaniadoTomaBurbujaYNoPierdeVidaPor2Turnos(){
		//Vida pre bonus
		this.turno.avanzarTurno();
		this.decepticons.getMegatron().transformar();
		this.decepticons.getMegatron().recibirAtaque(new DisparoConvencional(50));
		assertEquals(this.decepticons.getMegatron().getPuntosDeVida(),500);
		
		
		//turno de obtencion
		assertEquals(this.turno.obtenerJugadorQueDebeJugar(),Rachel);
		this.decepticons.getMegatron().recibirColocable(new BurbujaInmaculada());
		assertEquals(this.decepticons.getMegatron().getPuntosDeVida(),500);
		this.decepticons.getMegatron().recibirAtaque(new DisparoConvencional(100));
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//primer turno con burbuja
		assertEquals(this.decepticons.getMegatron().getPuntosDeVida(),500);
		this.decepticons.getMegatron().recibirAtaque(new DisparoConvencional(60));
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//segundo turno con burbuja.Recupero vida perdida antes
		assertEquals(this.decepticons.getMegatron().getPuntosDeVida(),500);
		this.decepticons.getMegatron().recibirAtaque(new DisparoConvencional(60));
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//tercer turno con burbuja.Recupera vida perdida antes
		assertEquals(this.decepticons.getMegatron().getPuntosDeVida(),500);
		this.decepticons.getMegatron().recibirAtaque(new DisparoConvencional(60));
		assertEquals(this.decepticons.getMegatron().getPuntosDeVida(),440);
		this.turno.avanzarTurno();
		
		//Cuarto turno con burbuja. No recupera vida
		assertEquals(this.decepticons.getMegatron().getPuntosDeVida(),440);
		this.turno.finalizar();
		
		
		
	}

	@Test
	public void test17BonecrusherConVidaTotalTomaBurbujaYNoPierdeVidaPor2Turnos(){

		//Vida pre bonus
		this.turno.avanzarTurno();
		assertEquals(this.decepticons.getBoneCrusher().getPuntosDeVida(),200);
		
		//turno de obtencion
		assertEquals(this.turno.obtenerJugadorQueDebeJugar(),Rachel);
		this.decepticons.getBoneCrusher().recibirColocable(new BurbujaInmaculada());
		assertEquals(this.decepticons.getBoneCrusher().getPuntosDeVida(),200);
		this.decepticons.getBoneCrusher().recibirAtaque(new DisparoConvencional(100));
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//primer turno con burbuja
		assertEquals(this.decepticons.getBoneCrusher().getPuntosDeVida(),200);
		this.decepticons.getBoneCrusher().recibirAtaque(new DisparoConvencional(60));
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//segundo turno con burbuja.Recupero vida perdida antes
		assertEquals(this.decepticons.getBoneCrusher().getPuntosDeVida(),200);
		this.decepticons.getBoneCrusher().recibirAtaque(new DisparoConvencional(60));
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//tercer turno con burbuja.Recupera vida perdida antes
		assertEquals(this.decepticons.getBoneCrusher().getPuntosDeVida(),200);
		this.decepticons.getBoneCrusher().recibirAtaque(new DisparoConvencional(60));
		assertEquals(this.decepticons.getBoneCrusher().getPuntosDeVida(),140);
		this.turno.avanzarTurno();
		
		//Cuarto turno con burbuja. No recupera vida
		assertEquals(this.decepticons.getBoneCrusher().getPuntosDeVida(),140);
		this.turno.finalizar();
	}

	@Test
	public void test18BonecrusherDaniadoTomaBurbujaYNoPierdeVidaPor2Turnos(){
		//Vida pre bonus
		this.turno.avanzarTurno();
		this.decepticons.getBoneCrusher().recibirAtaque(new DisparoConvencional(100));
		assertEquals(this.decepticons.getBoneCrusher().getPuntosDeVida(),100);
		
		//turno de obtencion
		assertEquals(this.turno.obtenerJugadorQueDebeJugar(),Rachel);
		this.decepticons.getBoneCrusher().recibirColocable(new BurbujaInmaculada());
		assertEquals(this.decepticons.getBoneCrusher().getPuntosDeVida(),100);
		this.decepticons.getBoneCrusher().recibirAtaque(new DisparoConvencional(20));
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
				
		//primer turno con burbuja
		assertEquals(this.decepticons.getBoneCrusher().getPuntosDeVida(),100);
		this.decepticons.getBoneCrusher().recibirAtaque(new DisparoConvencional(20));
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
				
		//segundo turno con burbuja.Recupero vida perdida antes
		assertEquals(this.decepticons.getBoneCrusher().getPuntosDeVida(),100);
		this.decepticons.getBoneCrusher().recibirAtaque(new DisparoConvencional(20));
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
				
		//tercer turno con burbuja.Recupera vida perdida antes
		assertEquals(this.decepticons.getBoneCrusher().getPuntosDeVida(),100);
		this.decepticons.getBoneCrusher().recibirAtaque(new DisparoConvencional(20));
		assertEquals(this.decepticons.getBoneCrusher().getPuntosDeVida(),80);
		this.turno.avanzarTurno();
				
		//Cuarto turno con burbuja. No recupera vida
		assertEquals(this.decepticons.getBoneCrusher().getPuntosDeVida(),80);
		this.turno.finalizar();

	}
	
	@Test
	public void test19BonecrusherAlternoConVidaTotalTomaBurbujaYNoPierdeVidaPor2Turnos(){

		//Vida pre bonus
		this.turno.avanzarTurno();
		this.decepticons.getBoneCrusher().transformar();
		assertEquals(this.decepticons.getBoneCrusher().getPuntosDeVida(),200);
		
		//turno de obtencion
		assertEquals(this.turno.obtenerJugadorQueDebeJugar(),Rachel);
		this.decepticons.getBoneCrusher().recibirColocable(new BurbujaInmaculada());
		assertEquals(this.decepticons.getBoneCrusher().getPuntosDeVida(),200);
		this.decepticons.getBoneCrusher().recibirAtaque(new DisparoConvencional(100));
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//primer turno con burbuja
		assertEquals(this.decepticons.getBoneCrusher().getPuntosDeVida(),200);
		this.decepticons.getBoneCrusher().recibirAtaque(new DisparoConvencional(60));
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//segundo turno con burbuja.Recupero vida perdida antes
		assertEquals(this.decepticons.getBoneCrusher().getPuntosDeVida(),200);
		this.decepticons.getBoneCrusher().recibirAtaque(new DisparoConvencional(60));
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//tercer turno con burbuja.Recupera vida perdida antes
		assertEquals(this.decepticons.getBoneCrusher().getPuntosDeVida(),200);
		this.decepticons.getBoneCrusher().recibirAtaque(new DisparoConvencional(60));
		assertEquals(this.decepticons.getBoneCrusher().getPuntosDeVida(),140);
		this.turno.avanzarTurno();
		
		//Cuarto turno con burbuja. No recupera vida
		assertEquals(this.decepticons.getBoneCrusher().getPuntosDeVida(),140);
		this.turno.finalizar();
	}

	@Test
	public void test20BonecrusherAlternoDaniadoTomaBurbujaYNoPierdeVidaPor2Turnos(){
		
		//Vida pre bonus
		this.decepticons.getBoneCrusher().transformar();
		this.turno.avanzarTurno();
		this.decepticons.getBoneCrusher().recibirAtaque(new DisparoConvencional(100));
		assertEquals(this.decepticons.getBoneCrusher().getPuntosDeVida(),100);
		
		//turno de obtencion
		assertEquals(this.turno.obtenerJugadorQueDebeJugar(),Rachel);
		this.decepticons.getBoneCrusher().recibirColocable(new BurbujaInmaculada());
		assertEquals(this.decepticons.getBoneCrusher().getPuntosDeVida(),100);
		this.decepticons.getBoneCrusher().recibirAtaque(new DisparoConvencional(20));
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
				
		//primer turno con burbuja
		assertEquals(this.decepticons.getBoneCrusher().getPuntosDeVida(),100);
		this.decepticons.getBoneCrusher().recibirAtaque(new DisparoConvencional(20));
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
				
		//segundo turno con burbuja.Recupero vida perdida antes
		assertEquals(this.decepticons.getBoneCrusher().getPuntosDeVida(),100);
		this.decepticons.getBoneCrusher().recibirAtaque(new DisparoConvencional(20));
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
				
		//tercer turno con burbuja.Recupera vida perdida antes
		assertEquals(this.decepticons.getBoneCrusher().getPuntosDeVida(),100);
		this.decepticons.getBoneCrusher().recibirAtaque(new DisparoConvencional(20));
		assertEquals(this.decepticons.getBoneCrusher().getPuntosDeVida(),80);
		this.turno.avanzarTurno();
				
		//Cuarto turno con burbuja. No recupera vida
		assertEquals(this.decepticons.getBoneCrusher().getPuntosDeVida(),80);
		this.turno.finalizar();
	}

	@Test
	public void test21FrenzyConVidaTotalTomaBurbujaYNoPierdeVidaPor2Turnos(){

		//Vida pre bonus
		this.turno.avanzarTurno();
		assertEquals(this.decepticons.getFrenzy().getPuntosDeVida(),400);
		
		//turno de obtencion
		assertEquals(this.turno.obtenerJugadorQueDebeJugar(),Rachel);
		this.decepticons.getFrenzy().recibirColocable(new BurbujaInmaculada());
		assertEquals(this.decepticons.getFrenzy().getPuntosDeVida(),400);
		this.decepticons.getFrenzy().recibirAtaque(new DisparoConvencional(100));
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//primer turno con burbuja
		assertEquals(this.decepticons.getFrenzy().getPuntosDeVida(),400);
		this.decepticons.getFrenzy().recibirAtaque(new DisparoConvencional(60));
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//segundo turno con burbuja.Recupero vida perdida antes
		assertEquals(this.decepticons.getFrenzy().getPuntosDeVida(),400);
		this.decepticons.getFrenzy().recibirAtaque(new DisparoConvencional(60));
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//tercer turno con burbuja.Recupera vida perdida antes
		assertEquals(this.decepticons.getFrenzy().getPuntosDeVida(),400);
		this.decepticons.getFrenzy().recibirAtaque(new DisparoConvencional(60));
		assertEquals(this.decepticons.getFrenzy().getPuntosDeVida(),340);
		this.turno.avanzarTurno();
		
		//Cuarto turno con burbuja. No recupera vida
		assertEquals(this.decepticons.getFrenzy().getPuntosDeVida(),340);
		this.turno.finalizar();
	}

	@Test
	public void test22FrenzyDaniadoTomaBurbujaYNoPierdeVidaPor2Turnos(){
		//Vida pre bonus
		this.turno.avanzarTurno();
		this.decepticons.getFrenzy().recibirAtaque(new DisparoConvencional(100));
		assertEquals(this.decepticons.getFrenzy().getPuntosDeVida(),300);
		
		//turno de obtencion
		assertEquals(this.turno.obtenerJugadorQueDebeJugar(),Rachel);
		this.decepticons.getFrenzy().recibirColocable(new BurbujaInmaculada());
		assertEquals(this.decepticons.getFrenzy().getPuntosDeVida(),300);
		this.decepticons.getFrenzy().recibirAtaque(new DisparoConvencional(100));
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//primer turno con burbuja
		assertEquals(this.decepticons.getFrenzy().getPuntosDeVida(),300);
		this.decepticons.getFrenzy().recibirAtaque(new DisparoConvencional(60));
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//segundo turno con burbuja.Recupero vida perdida antes
		assertEquals(this.decepticons.getFrenzy().getPuntosDeVida(),300);
		this.decepticons.getFrenzy().recibirAtaque(new DisparoConvencional(60));
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//tercer turno con burbuja.Recupera vida perdida antes
		assertEquals(this.decepticons.getFrenzy().getPuntosDeVida(),300);
		this.decepticons.getFrenzy().recibirAtaque(new DisparoConvencional(60));
		assertEquals(this.decepticons.getFrenzy().getPuntosDeVida(),240);
		this.turno.avanzarTurno();
		
		//Cuarto turno con burbuja. No recupera vida
		assertEquals(this.decepticons.getFrenzy().getPuntosDeVida(),240);
		this.turno.finalizar();

	}
	
	@Test
	public void test23FrenzyAlternoConVidaTotalTomaBurbujaYNoPierdeVidaPor2Turnos(){

		//Vida pre bonus
		this.turno.avanzarTurno();
		this.decepticons.getBoneCrusher().transformar();
		assertEquals(this.decepticons.getFrenzy().getPuntosDeVida(),400);
		
		//turno de obtencion
		assertEquals(this.turno.obtenerJugadorQueDebeJugar(),Rachel);
		this.decepticons.getFrenzy().recibirColocable(new BurbujaInmaculada());
		assertEquals(this.decepticons.getFrenzy().getPuntosDeVida(),400);
		this.decepticons.getFrenzy().recibirAtaque(new DisparoConvencional(100));
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//primer turno con burbuja
		assertEquals(this.decepticons.getFrenzy().getPuntosDeVida(),400);
		this.decepticons.getFrenzy().recibirAtaque(new DisparoConvencional(60));
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//segundo turno con burbuja.Recupero vida perdida antes
		assertEquals(this.decepticons.getFrenzy().getPuntosDeVida(),400);
		this.decepticons.getFrenzy().recibirAtaque(new DisparoConvencional(60));
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//tercer turno con burbuja.Recupera vida perdida antes
		assertEquals(this.decepticons.getFrenzy().getPuntosDeVida(),400);
		this.decepticons.getFrenzy().recibirAtaque(new DisparoConvencional(60));
		assertEquals(this.decepticons.getFrenzy().getPuntosDeVida(),340);
		this.turno.avanzarTurno();
		
		//Cuarto turno con burbuja. No recupera vida
		assertEquals(this.decepticons.getFrenzy().getPuntosDeVida(),340);
		this.turno.finalizar();
	}

	@Test
	public void test24FrenzyAlternoDaniadoTomaBurbujaYNoPierdeVidaPor2Turnos(){
	
		//Vida pre bonus
		this.turno.avanzarTurno();
		this.decepticons.getFrenzy().transformar();
		this.decepticons.getFrenzy().recibirAtaque(new DisparoConvencional(100));
		assertEquals(this.decepticons.getFrenzy().getPuntosDeVida(),300);
		
		//turno de obtencion
		assertEquals(this.turno.obtenerJugadorQueDebeJugar(),Rachel);
		this.decepticons.getFrenzy().recibirColocable(new BurbujaInmaculada());
		assertEquals(this.decepticons.getFrenzy().getPuntosDeVida(),300);
		this.decepticons.getFrenzy().recibirAtaque(new DisparoConvencional(100));
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//primer turno con burbuja
		assertEquals(this.decepticons.getFrenzy().getPuntosDeVida(),300);
		this.decepticons.getFrenzy().recibirAtaque(new DisparoConvencional(60));
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//segundo turno con burbuja.Recupero vida perdida antes
		assertEquals(this.decepticons.getFrenzy().getPuntosDeVida(),300);
		this.decepticons.getFrenzy().recibirAtaque(new DisparoConvencional(60));
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//tercer turno con burbuja.Recupera vida perdida antes
		assertEquals(this.decepticons.getFrenzy().getPuntosDeVida(),300);
		this.decepticons.getFrenzy().recibirAtaque(new DisparoConvencional(60));
		assertEquals(this.decepticons.getFrenzy().getPuntosDeVida(),240);
		this.turno.avanzarTurno();
		
		//Cuarto turno con burbuja. No recupera vida
		assertEquals(this.decepticons.getFrenzy().getPuntosDeVida(),240);
		this.turno.finalizar();
	}

}

