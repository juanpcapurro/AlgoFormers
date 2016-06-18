package bonus;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import algoFormers.juego.Jugador;
import algoFormers.juego.turno.Turno;
import algoFormers.tablero.colocable.bonus.Flash;
import algoFormers.tablero.colocable.robots.autobot.Autobots;
import algoFormers.tablero.colocable.robots.autobot.Superion;
import algoFormers.tablero.colocable.robots.decepticon.Decepticons;
import algoFormers.tablero.colocable.robots.decepticon.Menasor;
import algoFormers.tablero.posiciones.Posicion;

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
		this.Allen = new Jugador("Oliver");
		this.decepticons = new Decepticons();
		this.autobots = new Autobots();
		
		this.Barry.asignarEquipo(this.autobots);
		this.Allen.asignarEquipo(this.decepticons);
		
		this.turno=new Turno(CANTIDADJUGADORES);
		this.turno.agregarJugador(Barry);
		this.turno.agregarJugador(Allen);
	}

	@Test
	public void test01OptimusTomaFlashYTriplicaVelocidad(){

		this.autobots.getOptimus().recibirColocable(new Flash());
		assertEquals(this.autobots.getOptimus().getVelocidad(),6);
		
		/*assertEquals(this.turno.obtenerJugadorQueDebeJugar(),Barry);
		this.autobots.getOptimus().recibirColocable(new Flash());
		assertEquals(this.autobots.getOptimus().getVelocidad(),6);
		this.turno.avanzarTurno();
		assertEquals(this.turno.obtenerJugadorQueDebeJugar(),Allen);
		this.turno.avanzarTurno();
		assertEquals(this.turno.obtenerJugadorQueDebeJugar(),Barry);
		assertEquals(this.autobots.getOptimus().getVelocidad(),6);
		this.turno.avanzarTurno();
		assertEquals(this.turno.obtenerJugadorQueDebeJugar(),Allen);
		this.turno.avanzarTurno();
		assertEquals(this.turno.obtenerJugadorQueDebeJugar(),Barry);
		assertEquals(this.autobots.getOptimus().getVelocidad(),6);
		this.turno.avanzarTurno();
		assertEquals(this.turno.obtenerJugadorQueDebeJugar(),Allen);
		this.turno.avanzarTurno();
		assertEquals(this.turno.obtenerJugadorQueDebeJugar(),Barry);
		assertEquals(this.autobots.getOptimus().getVelocidad(),2);
		this.turno.finalizar();*/
	}
	
	@Test
	public void test02BumblebeeTomaFlashYTriplicaVelocidad(){
		this.autobots.getBumblebee().recibirColocable(new Flash());
		assertEquals(this.autobots.getBumblebee().getVelocidad(),6);
	}
	
	@Test
	public void test03RatchetTomaFlashYTriplicaVelocidad(){
		this.autobots.getRatchet().recibirColocable(new Flash());
		assertEquals(this.autobots.getRatchet().getVelocidad(),3);
	}
	
	@Test
	public void test04MegatronTomaFlashYTriplicaVelocidad(){
		this.decepticons.getMegatron().recibirColocable(new Flash());
		assertEquals(this.decepticons.getMegatron().getVelocidad(),3);
	}
	
	@Test
	public void test05FrenzyTomaFlashYTriplicaVelocidad(){
		this.decepticons.getFrenzy().recibirColocable(new Flash());
		assertEquals(this.decepticons.getFrenzy().getVelocidad(),6);
	}
	
	@Test
	public void test06BoneCrusherTomaFlashYTriplicaVelocidad(){
		this.decepticons.getBoneCrusher().recibirColocable(new Flash());
		assertEquals(this.decepticons.getBoneCrusher().getVelocidad(),3);
	}
	
	@Test
	public void test07AlternoOptimusTomaFlashYTriplicaVelocidad(){
		this.autobots.getOptimus().transformar();
		this.autobots.getOptimus().recibirColocable(new Flash());
		assertEquals(this.autobots.getOptimus().getVelocidad(),15);
	}
	
	@Test
	public void test08AlternoBumblebeeTomaFlashYTriplicaVelocidad(){
		this.autobots.getBumblebee().transformar();
		this.autobots.getBumblebee().recibirColocable(new Flash());
		assertEquals(this.autobots.getBumblebee().getVelocidad(),15);
	}
	
	@Test
	public void test09AlternoRatchetTomaFlashYTriplicaVelocidad(){
		this.autobots.getRatchet().transformar();
		this.autobots.getRatchet().recibirColocable(new Flash());
		assertEquals(this.autobots.getRatchet().getVelocidad(),24);
	}
	
	@Test
	public void test10AlternoMegatronTomaFlashYTriplicaVelocidad(){
		this.decepticons.getMegatron().transformar();
		this.decepticons.getMegatron().recibirColocable(new Flash());
		assertEquals(this.decepticons.getMegatron().getVelocidad(),24);
	}
	
	@Test
	public void test11AlternoFrenzyTomaFlashYTriplicaVelocidad(){
		this.decepticons.getFrenzy().transformar();
		this.decepticons.getFrenzy().recibirColocable(new Flash());
		assertEquals(this.decepticons.getFrenzy().getVelocidad(),18);
	}
	
	@Test
	public void test12AlternoBoneCrusherTomaFlashYTriplicaVelocidad(){
		this.decepticons.getBoneCrusher().transformar();
		this.decepticons.getBoneCrusher().recibirColocable(new Flash());
		assertEquals(this.decepticons.getBoneCrusher().getVelocidad(),24);
	}
	
	@Test
	public void test13SuperionTomaFlashYTriplicaVelocidad(){
		Superion superion = (Superion) this.autobots.combinarme();
		superion.recibirColocable(new Flash());
		assertEquals(superion.getVelocidad(),9);
	}
	
	@Test
	public void test14MenasorTomaFlashYTriplicaVelocidad(){
		Menasor menasor = (Menasor) this.decepticons.combinarme();
		menasor.recibirColocable(new Flash());
		assertEquals(menasor.getVelocidad(),6);
	}

}
