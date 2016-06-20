package bonus;

import algoFormers.juego.Jugador;
import algoFormers.juego.turno.Turno;
import algoFormers.tablero.colocable.bonus.Flash;
import algoFormers.tablero.colocable.robots.autobot.Autobots;
import algoFormers.tablero.colocable.robots.decepticon.Decepticons;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlashTest {
	
	private Jugador Barry;
	private Jugador Allen;
	public Autobots autobots;
	private Decepticons decepticons;
	private Turno turno;
	static final int CANTIDADJUGADORES=2;
	
	@Before
	public void setUp() throws Exception {
		this.Barry = new Jugador("Barry");
		this.Allen = new Jugador("Allen");
		this.decepticons = new Decepticons();
		this.autobots = new Autobots();
		
		this.Barry.asignarEquipo(this.autobots);
		this.Allen.asignarEquipo(this.decepticons);
		
		this.turno=new Turno(CANTIDADJUGADORES);
		this.turno.agregarJugador(Barry);
		this.turno.agregarJugador(Allen);
	}

	@Test
	public void test01OptimusTomaFlashYTriplicaVelocidadPorTresTurnos(){

		//Velocidad pre bonus
		assertEquals(this.autobots.getOptimus().getVelocidad(),2);
		
		//turno de obtencion del flash
		assertEquals(this.turno.obtenerJugadorQueDebeJugar(),Barry);
		this.autobots.getOptimus().recibirColocable(new Flash());
		assertEquals(this.autobots.getOptimus().getVelocidad(),6);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//primer turno con flash
		assertEquals(this.autobots.getOptimus().getVelocidad(),6);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//segundo turno con flash
		assertEquals(this.autobots.getOptimus().getVelocidad(),6);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//tercer turno con flash
		assertEquals(this.autobots.getOptimus().getVelocidad(),6);
		this.turno.avanzarTurno();
		
		//Cuarto turno sin flash
		assertEquals(this.autobots.getOptimus().getVelocidad(),2);
		this.turno.finalizar();
	}
	
	@Test
	public void test02BumblebeeTomaFlashYTriplicaVelocidadPorTresTurnos(){

		//Velocidad pre bonus
		assertEquals(this.autobots.getBumblebee().getVelocidad(),2);
		
		//turno de obtencion del flash
		assertEquals(this.turno.obtenerJugadorQueDebeJugar(),Barry);
		this.autobots.getBumblebee().recibirColocable(new Flash());
		assertEquals(this.autobots.getBumblebee().getVelocidad(),6);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//primer turno con flash
		assertEquals(this.autobots.getBumblebee().getVelocidad(),6);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//segundo turno con flash
		assertEquals(this.autobots.getBumblebee().getVelocidad(),6);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//tercer turno con flash
		assertEquals(this.autobots.getBumblebee().getVelocidad(),6);
		this.turno.avanzarTurno();
		
		//Cuarto turno sin flash
		assertEquals(this.autobots.getBumblebee().getVelocidad(),2);
		this.turno.finalizar();
	}
	
	@Test
	public void test03RatchetTomaFlashYTriplicaVelocidadPorTresTurnos(){
		
		//Velocidad pre bonus
		assertEquals(this.autobots.getRatchet().getVelocidad(),1);
		
		//turno de obtencion del flash
		assertEquals(this.turno.obtenerJugadorQueDebeJugar(),Barry);
		this.autobots.getRatchet().recibirColocable(new Flash());
		assertEquals(this.autobots.getRatchet().getVelocidad(),3);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//primer turno con flash
		assertEquals(this.autobots.getRatchet().getVelocidad(),3);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//segundo turno con flash
		assertEquals(this.autobots.getRatchet().getVelocidad(),3);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//tercer turno con flash
		assertEquals(this.autobots.getRatchet().getVelocidad(),3);
		this.turno.avanzarTurno();
		
		//Cuarto turno sin flash
		assertEquals(this.autobots.getRatchet().getVelocidad(),1);
		this.turno.finalizar();
		
	}
	
	@Test
	public void test04MegatronTomaFlashYTriplicaVelocidadPorTresTurnos(){

		//Velocidad pre bonus
		assertEquals(this.decepticons.getMegatron().getVelocidad(),1);
		
		//turno de obtencion del flash
		this.turno.avanzarTurno();
		assertEquals(this.turno.obtenerJugadorQueDebeJugar(),Allen);
		this.decepticons.getMegatron().recibirColocable(new Flash());
		assertEquals(this.decepticons.getMegatron().getVelocidad(),3);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//primer turno con flash
		assertEquals(this.decepticons.getMegatron().getVelocidad(),3);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//segundo turno con flash
		assertEquals(this.decepticons.getMegatron().getVelocidad(),3);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//tercer turno con flash
		assertEquals(this.decepticons.getMegatron().getVelocidad(),3);
		this.turno.avanzarTurno();
		
		//Cuarto turno sin flash
		assertEquals(this.decepticons.getMegatron().getVelocidad(),1);
		this.turno.finalizar();
	}
	
	@Test
	public void test05FrenzyTomaFlashYTriplicaVelocidadPorTresTurnos(){
		
		//Velocidad pre bonus
		assertEquals(this.decepticons.getFrenzy().getVelocidad(),2);
		
		//turno de obtencion del flash
		this.turno.avanzarTurno();
		assertEquals(this.turno.obtenerJugadorQueDebeJugar(),Allen);
		this.decepticons.getFrenzy().recibirColocable(new Flash());
		assertEquals(this.decepticons.getFrenzy().getVelocidad(),6);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//primer turno con flash
		assertEquals(this.decepticons.getFrenzy().getVelocidad(),6);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//segundo turno con flash
		assertEquals(this.decepticons.getFrenzy().getVelocidad(),6);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//tercer turno con flash
		assertEquals(this.decepticons.getFrenzy().getVelocidad(),6);
		this.turno.avanzarTurno();
		
		//Cuarto turno sin flash
		assertEquals(this.decepticons.getFrenzy().getVelocidad(),2);
		this.turno.finalizar();
	}
	
	@Test
	public void test06BoneCrusherTomaFlashYTriplicaVelocidadPorTresTurnos(){

		//Velocidad pre bonus
		assertEquals(this.decepticons.getBoneCrusher().getVelocidad(),1);
		
		//turno de obtencion del flash
		this.turno.avanzarTurno();
		assertEquals(this.turno.obtenerJugadorQueDebeJugar(),Allen);
		this.decepticons.getBoneCrusher().recibirColocable(new Flash());
		assertEquals(this.decepticons.getBoneCrusher().getVelocidad(),3);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//primer turno con flash
		assertEquals(this.decepticons.getBoneCrusher().getVelocidad(),3);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//segundo turno con flash
		assertEquals(this.decepticons.getBoneCrusher().getVelocidad(),3);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//tercer turno con flash
		assertEquals(this.decepticons.getBoneCrusher().getVelocidad(),3);
		this.turno.avanzarTurno();
		
		//Cuarto turno sin flash
		assertEquals(this.decepticons.getBoneCrusher().getVelocidad(),1);
		this.turno.finalizar();
		
	}
	
	@Test
	public void test07AlternoOptimusTomaFlashYTriplicaVelocidadPorTresTurnos(){
		
		this.autobots.getOptimus().transformar();		
		//Velocidad pre bonus
		assertEquals(this.autobots.getOptimus().getVelocidad(),5);
		
		//turno de obtencion del flash
		assertEquals(this.turno.obtenerJugadorQueDebeJugar(),Barry);
		this.autobots.getOptimus().recibirColocable(new Flash());
		assertEquals(this.autobots.getOptimus().getVelocidad(),15);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//primer turno con flash
		assertEquals(this.autobots.getOptimus().getVelocidad(),15);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//segundo turno con flash
		assertEquals(this.autobots.getOptimus().getVelocidad(),15);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//tercer turno con flash
		assertEquals(this.autobots.getOptimus().getVelocidad(),15);
		this.turno.avanzarTurno();
		
		//Cuarto turno sin flash
		assertEquals(this.autobots.getOptimus().getVelocidad(),5);
		this.turno.finalizar();
	}
	
	@Test
	public void test08AlternoBumblebeeTomaFlashYTriplicaVelocidadPorTresTurnos(){
		
		this.autobots.getBumblebee().transformar();		
		//Velocidad pre bonus
		assertEquals(this.autobots.getBumblebee().getVelocidad(),5);
		
		//turno de obtencion del flash
		assertEquals(this.turno.obtenerJugadorQueDebeJugar(),Barry);
		this.autobots.getBumblebee().recibirColocable(new Flash());
		assertEquals(this.autobots.getBumblebee().getVelocidad(),15);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//primer turno con flash
		assertEquals(this.autobots.getBumblebee().getVelocidad(),15);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//segundo turno con flash
		assertEquals(this.autobots.getBumblebee().getVelocidad(),15);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//tercer turno con flash
		assertEquals(this.autobots.getBumblebee().getVelocidad(),15);
		this.turno.avanzarTurno();
		
		//Cuarto turno sin flash
		assertEquals(this.autobots.getBumblebee().getVelocidad(),5);
		this.turno.finalizar();
	}
	
	@Test
	public void test09AlternoRatchetTomaFlashYTriplicaVelocidadPorTresTurnos(){
		
		this.autobots.getRatchet().transformar();		
		//Velocidad pre bonus
		assertEquals(this.autobots.getRatchet().getVelocidad(),8);
		
		//turno de obtencion del flash
		assertEquals(this.turno.obtenerJugadorQueDebeJugar(),Barry);
		this.autobots.getRatchet().recibirColocable(new Flash());
		assertEquals(this.autobots.getRatchet().getVelocidad(),24);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//primer turno con flash
		assertEquals(this.autobots.getRatchet().getVelocidad(),24);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//segundo turno con flash
		assertEquals(this.autobots.getRatchet().getVelocidad(),24);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//tercer turno con flash
		assertEquals(this.autobots.getRatchet().getVelocidad(),24);
		this.turno.avanzarTurno();
		
		//Cuarto turno sin flash
		assertEquals(this.autobots.getRatchet().getVelocidad(),8);
		this.turno.finalizar();
	}
	
	@Test
	public void test10AlternoMegatronTomaFlashYTriplicaVelocidadPorTresTurnos(){
		
		this.decepticons.getMegatron().transformar();
		//Velocidad pre bonus
		assertEquals(this.decepticons.getMegatron().getVelocidad(),8);
		
		//turno de obtencion del flash
		this.turno.avanzarTurno();
		assertEquals(this.turno.obtenerJugadorQueDebeJugar(),Allen);
		this.decepticons.getMegatron().recibirColocable(new Flash());
		assertEquals(this.decepticons.getMegatron().getVelocidad(),24);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//primer turno con flash
		assertEquals(this.decepticons.getMegatron().getVelocidad(),24);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//segundo turno con flash
		assertEquals(this.decepticons.getMegatron().getVelocidad(),24);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//tercer turno con flash
		assertEquals(this.decepticons.getMegatron().getVelocidad(),24);
		this.turno.avanzarTurno();
		
		//Cuarto turno sin flash
		assertEquals(this.decepticons.getMegatron().getVelocidad(),8);
		this.turno.finalizar();
	}
	
	@Test
	public void test11AlternoFrenzyTomaFlashYTriplicaVelocidadPorTresTurnos(){
		
		this.decepticons.getFrenzy().transformar();
		//Velocidad pre bonus
		assertEquals(this.decepticons.getFrenzy().getVelocidad(),6);
		
		//turno de obtencion del flash
		this.turno.avanzarTurno();
		assertEquals(this.turno.obtenerJugadorQueDebeJugar(),Allen);
		this.decepticons.getFrenzy().recibirColocable(new Flash());
		assertEquals(this.decepticons.getFrenzy().getVelocidad(),18);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//primer turno con flash
		assertEquals(this.decepticons.getFrenzy().getVelocidad(),18);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//segundo turno con flash
		assertEquals(this.decepticons.getFrenzy().getVelocidad(),18);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//tercer turno con flash
		assertEquals(this.decepticons.getFrenzy().getVelocidad(),18);
		this.turno.avanzarTurno();
		
		//Cuarto turno sin flash
		assertEquals(this.decepticons.getFrenzy().getVelocidad(),6);
		this.turno.finalizar();
	}
	
	@Test
	public void test12AlternoBoneCrusherTomaFlashYTriplicaVelocidadPorTresTurnos(){
		
		this.decepticons.getBoneCrusher().transformar();		
		// pre bonus
		assertEquals(this.decepticons.getBoneCrusher().getVelocidad(),8);
		
		//turno de obtencion
		this.turno.avanzarTurno();
		assertEquals(this.turno.obtenerJugadorQueDebeJugar(),Allen);
		this.decepticons.getBoneCrusher().recibirColocable(new Flash());
		assertEquals(this.decepticons.getBoneCrusher().getVelocidad(),24);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//primer turno
		assertEquals(this.decepticons.getBoneCrusher().getVelocidad(),24);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//segundo turno
		assertEquals(this.decepticons.getBoneCrusher().getVelocidad(),24);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//tercer turno
		assertEquals(this.decepticons.getBoneCrusher().getVelocidad(),24);
		this.turno.avanzarTurno();
		
		//Cuarto turno
		assertEquals(this.decepticons.getBoneCrusher().getVelocidad(),8);
		this.turno.finalizar();
	}
	
	@Test
	public void test13SuperionTomaFlashYTriplicaVelocidadPorTresTurnos(){
		
		assertEquals(this.turno.obtenerJugadorQueDebeJugar(),Barry);
		this.turno.combinarAlgoformers();
		
		assertEquals(this.turno.obtenerJugadorQueDebeJugar(),Allen);
		this.turno.finalizar();
		assertEquals(this.turno.obtenerJugadorQueDebeJugar(),Allen);
		this.turno.finalizar();
		assertEquals(this.turno.obtenerJugadorQueDebeJugar(),Allen);
		this.turno.finalizar();
		assertEquals(this.turno.obtenerJugadorQueDebeJugar(),Barry);


		//Velocidad pre bonus
		assertEquals(this.Barry.obtenerJugadaActual().getAlgoformerDeJugada().getVelocidad(),3);
		
		//turno de obtencion del flash
		assertEquals(this.turno.obtenerJugadorQueDebeJugar(),Barry);
		this.Barry.obtenerJugadaActual().getAlgoformerDeJugada().recibirColocable(new Flash());
		assertEquals(this.Barry.obtenerJugadaActual().getAlgoformerDeJugada().getVelocidad(),9);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//primer turno con flash
		assertEquals(this.Barry.obtenerJugadaActual().getAlgoformerDeJugada().getVelocidad(),9);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//segundo turno con flash
		assertEquals(this.Barry.obtenerJugadaActual().getAlgoformerDeJugada().getVelocidad(),9);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//tercer turno con flash
		assertEquals(this.Barry.obtenerJugadaActual().getAlgoformerDeJugada().getVelocidad(),9);
		this.turno.avanzarTurno();
		
		//Cuarto turno sin flash
//		assertEquals(this.Barry.obtenerJugadaActual().getAlgoformerDeJugada().getVelocidad(),3);
		this.turno.finalizar();
		
	}

	

	@Test
	public void test14MenasorTomaFlashYTriplicaVelocidadPorTresTurnos(){
		this.turno.avanzarTurno();
		assertEquals(this.turno.obtenerJugadorQueDebeJugar(),Allen);
		this.turno.combinarAlgoformers();
		
		assertEquals(this.turno.obtenerJugadorQueDebeJugar(),Barry);
		this.turno.finalizar();
		assertEquals(this.turno.obtenerJugadorQueDebeJugar(),Barry);
		this.turno.finalizar();
		assertEquals(this.turno.obtenerJugadorQueDebeJugar(),Barry);
		this.turno.finalizar();
		assertEquals(this.turno.obtenerJugadorQueDebeJugar(),Allen);

		//Velocidad pre bonus
		assertEquals(this.Allen.obtenerJugadaActual().getAlgoformerDeJugada().getVelocidad(),2);
		
		//turno de obtencion del flash
		this.Allen.obtenerJugadaActual().getAlgoformerDeJugada().recibirColocable(new Flash());
		assertEquals(this.Allen.obtenerJugadaActual().getAlgoformerDeJugada().getVelocidad(),6);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//primer turno con flash
		assertEquals(this.Allen.obtenerJugadaActual().getAlgoformerDeJugada().getVelocidad(),6);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//segundo turno con flash
		assertEquals(this.Allen.obtenerJugadaActual().getAlgoformerDeJugada().getVelocidad(),6);
		this.turno.avanzarTurno();
		this.turno.avanzarTurno();
		
		//tercer turno con flash
		assertEquals(this.Allen.obtenerJugadaActual().getAlgoformerDeJugada().getVelocidad(),6);
		this.turno.avanzarTurno();
		
		//Cuarto turno sin flash
//		assertEquals(this.Allen.obtenerJugadaActual().getAlgoformerDeJugada().getVelocidad(),2);
		this.turno.finalizar();
	}

}
