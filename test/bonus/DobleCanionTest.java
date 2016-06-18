package bonus;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import algoFormers.juego.Jugador;
import algoFormers.juego.turno.Turno;
import algoFormers.tablero.colocable.bonus.DobleCanion;
import algoFormers.tablero.colocable.robots.autobot.Autobots;
import algoFormers.tablero.colocable.robots.autobot.Superion;
import algoFormers.tablero.colocable.robots.decepticon.Decepticons;
import algoFormers.tablero.colocable.robots.decepticon.Menasor;

public class DobleCanionTest {
	
	
	private Jugador Joey;
	private Jugador Chandler;
	public Autobots autobots;
	private Decepticons decepticons;
	private Turno turno;
	static final int CANTIDADJUGADORES=2;
	
	@Before
	public void setUp() throws Exception {
		this.Joey = new Jugador("Joey");
		this.Chandler = new Jugador("Chandler");
		this.decepticons = new Decepticons();
		this.autobots = new Autobots();
		
		this.Joey.asignarEquipo(this.autobots);
		this.Chandler.asignarEquipo(this.decepticons);
		
		this.turno=new Turno(CANTIDADJUGADORES);
		this.turno.agregarJugador(Joey);
		this.turno.agregarJugador(Chandler);
	}

	@Test
	public void test01OptimusTomaDobleCanionYDuplicaAtaquePorTresTurnos(){

		//pre bonus
		assertEquals(this.autobots.getOptimus().getAtaque(),50);
		
		//turno de obtencion
		assertEquals(this.turno.obtenerJugadorQueDebeJugar(),Joey);
		this.autobots.getOptimus().recibirColocable(new DobleCanion());
		assertEquals(this.autobots.getOptimus().getAtaque(),100);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//primer turno
		assertEquals(this.autobots.getOptimus().getAtaque(),100);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//segundo turno
		assertEquals(this.autobots.getOptimus().getAtaque(),100);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//tercer turno
		assertEquals(this.autobots.getOptimus().getAtaque(),100);
		this.turno.avanzarTurno();
		
		//Cuarto turno
		assertEquals(this.autobots.getOptimus().getAtaque(),50);
		this.turno.finalizar();
	}
	
	@Test
	public void test02BumblebeeTomaDobleCanionYDuplicaAtaquePorTresTurnos(){

		//pre bonus
		assertEquals(this.autobots.getBumblebee().getAtaque(),40);
		
		//turno de obtencion
		assertEquals(this.turno.obtenerJugadorQueDebeJugar(),Joey);
		this.autobots.getBumblebee().recibirColocable(new DobleCanion());
		assertEquals(this.autobots.getBumblebee().getAtaque(),80);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//primer turno
		assertEquals(this.autobots.getBumblebee().getAtaque(),80);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//segundo turno
		assertEquals(this.autobots.getBumblebee().getAtaque(),80);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//tercer turno
		assertEquals(this.autobots.getBumblebee().getAtaque(),80);
		this.turno.avanzarTurno();
		
		//Cuarto turno
		assertEquals(this.autobots.getBumblebee().getAtaque(),40);
		this.turno.finalizar();
	}
	
	@Test
	public void test03RatchetTomaDobleCanionYDuplicaAtaquePorTresTurnos(){
		
		//pre bonus
		assertEquals(this.autobots.getRatchet().getAtaque(),5);
		
		//turno de obtencion
		assertEquals(this.turno.obtenerJugadorQueDebeJugar(),Joey);
		this.autobots.getRatchet().recibirColocable(new DobleCanion());
		assertEquals(this.autobots.getRatchet().getAtaque(),10);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//primer turno
		assertEquals(this.autobots.getRatchet().getAtaque(),10);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//segundo turno
		assertEquals(this.autobots.getRatchet().getAtaque(),10);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//tercer turno
		assertEquals(this.autobots.getRatchet().getAtaque(),10);
		this.turno.avanzarTurno();
		
		//Cuarto turno
		assertEquals(this.autobots.getRatchet().getAtaque(),5);
		this.turno.finalizar();
		
	}
	
	@Test
	public void test04MegatronTomaDobleCanionYDuplicaAtaquePorTresTurnos(){

		//pre bonus
		assertEquals(this.decepticons.getMegatron().getAtaque(),10);
		
		//turno de obtencion
		this.turno.avanzarTurno();
		assertEquals(this.turno.obtenerJugadorQueDebeJugar(),Chandler);
		this.decepticons.getMegatron().recibirColocable(new DobleCanion());
		assertEquals(this.decepticons.getMegatron().getAtaque(),20);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//primer turno
		assertEquals(this.decepticons.getMegatron().getAtaque(),20);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//segundo turno
		assertEquals(this.decepticons.getMegatron().getAtaque(),20);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//tercer turno
		assertEquals(this.decepticons.getMegatron().getAtaque(),20);
		this.turno.avanzarTurno();
		
		//Cuarto turno
		assertEquals(this.decepticons.getMegatron().getAtaque(),10);
		this.turno.finalizar();
	}
	
	@Test
	public void test05FrenzyTomaDobleCanionYDuplicaAtaquePorTresTurnos(){
		
		//Pre bonus
		assertEquals(this.decepticons.getFrenzy().getAtaque(),10);
		
		//turno de obtencion
		this.turno.avanzarTurno();
		assertEquals(this.turno.obtenerJugadorQueDebeJugar(),Chandler);
		this.decepticons.getFrenzy().recibirColocable(new DobleCanion());
		assertEquals(this.decepticons.getFrenzy().getAtaque(),20);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//primer turno
		assertEquals(this.decepticons.getFrenzy().getAtaque(),20);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//segundo turno
		assertEquals(this.decepticons.getFrenzy().getAtaque(),20);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//tercer turno
		assertEquals(this.decepticons.getFrenzy().getAtaque(),20);
		this.turno.avanzarTurno();
		
		//Cuarto turno
		assertEquals(this.decepticons.getFrenzy().getAtaque(),10);
		this.turno.finalizar();
	}
	
	@Test
	public void test06BoneCrusherTomaDobleCanionYDuplicaAtaquePorTresTurnos(){

		//pre bonus
		assertEquals(this.decepticons.getBoneCrusher().getAtaque(),30);
		
		//turno de obtencion
		this.turno.avanzarTurno();
		assertEquals(this.turno.obtenerJugadorQueDebeJugar(),Chandler);
		this.decepticons.getBoneCrusher().recibirColocable(new DobleCanion());
		assertEquals(this.decepticons.getBoneCrusher().getAtaque(),60);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//primer turno
		assertEquals(this.decepticons.getBoneCrusher().getAtaque(),60);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//segundo turno
		assertEquals(this.decepticons.getBoneCrusher().getAtaque(),60);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//tercer turno
		assertEquals(this.decepticons.getBoneCrusher().getAtaque(),60);
		this.turno.avanzarTurno();
		
		//Cuarto turno
		assertEquals(this.decepticons.getBoneCrusher().getAtaque(),30);
		this.turno.finalizar();
		
	}
	
	@Test
	public void test07AlternoOptimusTomaDobleCanionYDuplicaAtaquePorTresTurnos(){
		
		this.autobots.getOptimus().transformar();		
		//pre bonus
		assertEquals(this.autobots.getOptimus().getAtaque(),15);
		
		//turno de obtencion
		assertEquals(this.turno.obtenerJugadorQueDebeJugar(),Joey);
		this.autobots.getOptimus().recibirColocable(new DobleCanion());
		assertEquals(this.autobots.getOptimus().getAtaque(),30);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//primer turno
		assertEquals(this.autobots.getOptimus().getAtaque(),30);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//segundo turno
		assertEquals(this.autobots.getOptimus().getAtaque(),30);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//tercer turno
		assertEquals(this.autobots.getOptimus().getAtaque(),30);
		this.turno.avanzarTurno();
		
		//Cuarto turno
		assertEquals(this.autobots.getOptimus().getAtaque(),15);
		this.turno.finalizar();
	}
	
	@Test
	public void test08AlternoBumblebeeTomaDobleCanionYDuplicaAtaquePorTresTurnos(){
		
		this.autobots.getBumblebee().transformar();		
		// pre bonus
		assertEquals(this.autobots.getBumblebee().getAtaque(),20);
		
		//turno de obtencion
		assertEquals(this.turno.obtenerJugadorQueDebeJugar(),Joey);
		this.autobots.getBumblebee().recibirColocable(new DobleCanion());
		assertEquals(this.autobots.getBumblebee().getAtaque(),40);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//primer turno
		assertEquals(this.autobots.getBumblebee().getAtaque(),40);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//segundo turno
		assertEquals(this.autobots.getBumblebee().getAtaque(),40);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//tercer turno
		assertEquals(this.autobots.getBumblebee().getAtaque(),40);
		this.turno.avanzarTurno();
		
		//Cuarto turno
		assertEquals(this.autobots.getBumblebee().getAtaque(),20);
		this.turno.finalizar();
	}
	
	@Test
	public void test09AlternoRatchetTomaDobleCanionYDuplicaAtaquePorTresTurnos(){
		
		this.autobots.getRatchet().transformar();		
		// pre bonus
		assertEquals(this.autobots.getRatchet().getAtaque(),35);
		
		//turno de obtencion
		assertEquals(this.turno.obtenerJugadorQueDebeJugar(),Joey);
		this.autobots.getRatchet().recibirColocable(new DobleCanion());
		assertEquals(this.autobots.getRatchet().getAtaque(),70);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//primer turno
		assertEquals(this.autobots.getRatchet().getAtaque(),70);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//segundo turno
		assertEquals(this.autobots.getRatchet().getAtaque(),70);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//tercer turno
		assertEquals(this.autobots.getRatchet().getAtaque(),70);
		this.turno.avanzarTurno();
		
		//Cuarto turno
		assertEquals(this.autobots.getRatchet().getAtaque(),35);
		this.turno.finalizar();
	}
	
	@Test
	public void test10AlternoMegatronTomaDobleCanionYDuplicaAtaquePorTresTurnos(){
		
		this.decepticons.getMegatron().transformar();
		//pre bonus
		assertEquals(this.decepticons.getMegatron().getAtaque(),55);
		
		//turno de obtencion
		this.turno.avanzarTurno();
		assertEquals(this.turno.obtenerJugadorQueDebeJugar(),Chandler);
		this.decepticons.getMegatron().recibirColocable(new DobleCanion());
		assertEquals(this.decepticons.getMegatron().getAtaque(),110);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//primer turno
		assertEquals(this.decepticons.getMegatron().getAtaque(),110);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//segundo turno
		assertEquals(this.decepticons.getMegatron().getAtaque(),110);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//tercer turno
		assertEquals(this.decepticons.getMegatron().getAtaque(),110);
		this.turno.avanzarTurno();
		
		//Cuarto turno
		assertEquals(this.decepticons.getMegatron().getAtaque(),55);
		this.turno.finalizar();
	}
	
	@Test
	public void test11AlternoFrenzyTomaDobleCanionYDuplicaAtaquePorTresTurnos(){
		
		this.decepticons.getFrenzy().transformar();
		//pre bonus
		assertEquals(this.decepticons.getFrenzy().getAtaque(),25);
		
		//turno de obtencion
		this.turno.avanzarTurno();
		assertEquals(this.turno.obtenerJugadorQueDebeJugar(),Chandler);
		this.decepticons.getFrenzy().recibirColocable(new DobleCanion());
		assertEquals(this.decepticons.getFrenzy().getAtaque(),50);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//primer turno
		assertEquals(this.decepticons.getFrenzy().getAtaque(),50);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//segundo turno
		assertEquals(this.decepticons.getFrenzy().getAtaque(),50);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//tercer turno
		assertEquals(this.decepticons.getFrenzy().getAtaque(),50);
		this.turno.avanzarTurno();
		
		//Cuarto turno
		assertEquals(this.decepticons.getFrenzy().getAtaque(),25);
		this.turno.finalizar();
	}
	
	@Test
	public void test12AlternoBoneCrusherTomaDobleCanionYDuplicaAtaquePorTresTurnos(){
		
		this.decepticons.getBoneCrusher().transformar();		
		//pre bonus
		assertEquals(this.decepticons.getBoneCrusher().getAtaque(),30);
		
		//turno de obtencion
		this.turno.avanzarTurno();
		assertEquals(this.turno.obtenerJugadorQueDebeJugar(),Chandler);
		this.decepticons.getBoneCrusher().recibirColocable(new DobleCanion());
		assertEquals(this.decepticons.getBoneCrusher().getAtaque(),60);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//primer turno
		assertEquals(this.decepticons.getBoneCrusher().getAtaque(),60);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//segundo turno
		assertEquals(this.decepticons.getBoneCrusher().getAtaque(),60);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//tercer turno
		assertEquals(this.decepticons.getBoneCrusher().getAtaque(),60);
		this.turno.avanzarTurno();
		
		//Cuarto turno
		assertEquals(this.decepticons.getBoneCrusher().getAtaque(),30);
		this.turno.finalizar();
	}

/*
	@Test
	public void test13SuperionTomaDobleCanionYDuplicaAtaquePorTresTurnos(){
		
		assertEquals(this.turno.obtenerJugadorQueDebeJugar(),Joey);
		this.turno.combinarAlgoformers();
		
		assertEquals(this.turno.obtenerJugadorQueDebeJugar(),Chandler);
		this.turno.finalizar();
		assertEquals(this.turno.obtenerJugadorQueDebeJugar(),Chandler);
		this.turno.finalizar();
		assertEquals(this.turno.obtenerJugadorQueDebeJugar(),Chandler);
		this.turno.finalizar();
		assertEquals(this.turno.obtenerJugadorQueDebeJugar(),Joey);

		//pre bonus
		assertEquals(this.Joey.obtenerJugadaActual().getAlgoformerDeJugada().getAtaque(),100);
		
		//turno de obtencion
		assertEquals(this.turno.obtenerJugadorQueDebeJugar(),Joey);
		this.Joey.obtenerJugadaActual().getAlgoformerDeJugada().recibirColocable(new DobleCanion());
		assertEquals(this.Joey.obtenerJugadaActual().getAlgoformerDeJugada().getAtaque(),200);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//primer turno
		assertEquals(this.Joey.obtenerJugadaActual().getAlgoformerDeJugada().getAtaque(),200);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//segundo turno
		assertEquals(this.Joey.obtenerJugadaActual().getAlgoformerDeJugada().getAtaque(),200);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//tercer turno
		assertEquals(this.Joey.obtenerJugadaActual().getAlgoformerDeJugada().getAtaque(),200);
		this.turno.avanzarTurno();
		
		//Cuarto turno
		assertEquals(this.Joey.obtenerJugadaActual().getAlgoformerDeJugada().getAtaque(),200);
		this.turno.finalizar();
		
		assertEquals(this.Joey.obtenerJugadaActual().getAlgoformerDeJugada().getAtaque(),100);
		this.turno.finalizar();
		
	}

	
	
	@Test
	public void test14MenasorTomaDobleCanionYDuplicaAtaquePorTresTurnos(){

		this.turno.avanzarTurno();
		assertEquals(this.turno.obtenerJugadorQueDebeJugar(),Chandler);
		this.turno.combinarAlgoformers();
		
		assertEquals(this.turno.obtenerJugadorQueDebeJugar(),Joey);
		this.turno.finalizar();
		assertEquals(this.turno.obtenerJugadorQueDebeJugar(),Joey);
		this.turno.finalizar();
		assertEquals(this.turno.obtenerJugadorQueDebeJugar(),Joey);
		this.turno.finalizar();
		assertEquals(this.turno.obtenerJugadorQueDebeJugar(),Chandler);

		//pre bonus
		assertEquals(this.Chandler.obtenerJugadaActual().getAlgoformerDeJugada().getAtaque(),115);
		
		//turno de obtencion
		this.Chandler.obtenerJugadaActual().getAlgoformerDeJugada().recibirColocable(new DobleCanion());
		assertEquals(this.Chandler.obtenerJugadaActual().getAlgoformerDeJugada().getAtaque(),230);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//primer turno
		assertEquals(this.Chandler.obtenerJugadaActual().getAlgoformerDeJugada().getAtaque(),230);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//segundo turno
		assertEquals(this.Chandler.obtenerJugadaActual().getAlgoformerDeJugada().getAtaque(),230);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//tercer turno
		assertEquals(this.Chandler.obtenerJugadaActual().getAlgoformerDeJugada().getAtaque(),230);
		this.turno.avanzarTurno();
		
		//Cuarto turno
		assertEquals(this.Chandler.obtenerJugadaActual().getAlgoformerDeJugada().getAtaque(),115);
		this.turno.finalizar();
	}
*/
}
