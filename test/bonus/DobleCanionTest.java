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
	
	
	private Jugador Neal;
	private Jugador Peter;
	public Autobots autobots;
	private Decepticons decepticons;
	private Turno turno;
	static final int CANTIDADJUGADORES=2;
	
	@Before
	public void setUp() throws Exception {
		this.Neal = new Jugador("Neal");
		this.Peter = new Jugador("Peter");
		this.decepticons = new Decepticons();
		this.autobots = new Autobots();
		
		this.Neal.asignarEquipo(this.autobots);
		this.Peter.asignarEquipo(this.decepticons);
		
		this.turno=new Turno(CANTIDADJUGADORES);
		this.turno.agregarJugador(Neal);
		this.turno.agregarJugador(Peter);
	}

	@Test
	public void test01OptimusTomaDobleCanionYDuplicaAtaque(){
		this.autobots.getOptimus().recibirColocable(new DobleCanion());
		assertEquals(this.autobots.getOptimus().getAtaque(),100);
	}
	
	@Test
	public void test02BumblebeeTomaDobleCanionYDuplicaAtaque(){
		this.autobots.getBumblebee().recibirColocable(new DobleCanion());
		assertEquals(this.autobots.getBumblebee().getAtaque(),80);
	}
	
	@Test
	public void test03RatchetTomaDobleCanionYDuplicaAtaque(){
		this.autobots.getRatchet().recibirColocable(new DobleCanion());
		assertEquals(this.autobots.getRatchet().getAtaque(),10);
	}
	
	@Test
	public void test04MegatronTomaDobleCanionYDuplicaAtaque(){
		this.decepticons.getMegatron().recibirColocable(new DobleCanion());
		assertEquals(this.decepticons.getMegatron().getAtaque(),20);
	}
	
	@Test
	public void test05FrenzyTomaDobleCanionYDuplicaAtaque(){
		this.decepticons.getFrenzy().recibirColocable(new DobleCanion());
		assertEquals(this.decepticons.getFrenzy().getAtaque(),20);
	}
	
	@Test
	public void test06BoneCrusherTomaDobleCanionYDuplicaAtaque(){
		this.decepticons.getBoneCrusher().recibirColocable(new DobleCanion());
		assertEquals(this.decepticons.getBoneCrusher().getAtaque(),60);
	}
	
	@Test
	public void test07AlternoOptimusTomaDobleCanionYDuplicaAtaque(){
		this.autobots.getOptimus().transformar();
		this.autobots.getOptimus().recibirColocable(new DobleCanion());
		assertEquals(this.autobots.getOptimus().getAtaque(),30);
	}
	
	@Test
	public void test08AlternoBumblebeeTomaDobleCanionYDuplicaAtaque(){
		this.autobots.getBumblebee().transformar();
		this.autobots.getBumblebee().recibirColocable(new DobleCanion());
		assertEquals(this.autobots.getBumblebee().getAtaque(),40);
	}
	
	@Test
	public void test09AlternoRatchetTomaDobleCanionYDuplicaAtaque(){
		this.autobots.getRatchet().transformar();
		this.autobots.getRatchet().recibirColocable(new DobleCanion());
		assertEquals(this.autobots.getRatchet().getAtaque(),70);
	}
	
	@Test
	public void test10AlternoMegatronTomaDobleCanionYDuplicaAtaque(){
		this.decepticons.getMegatron().transformar();
		this.decepticons.getMegatron().recibirColocable(new DobleCanion());
		assertEquals(this.decepticons.getMegatron().getAtaque(),110);
	}
	
	@Test
	public void test11AlternoFrenzyTomaDobleCanionYDuplicaAtaque(){
		this.decepticons.getFrenzy().transformar();
		this.decepticons.getFrenzy().recibirColocable(new DobleCanion());
		assertEquals(this.decepticons.getFrenzy().getAtaque(),50);
	}
	
	@Test
	public void test12AlternoBoneCrusherTomaDobleCanionYDuplicaAtaque(){
		this.decepticons.getBoneCrusher().transformar();
		this.decepticons.getBoneCrusher().recibirColocable(new DobleCanion());
		assertEquals(this.decepticons.getBoneCrusher().getAtaque(),60);
	}
	
	@Test
	public void test13SuperionTomaDobleCanionYDuplicaAtaque(){
		Superion superion = (Superion) this.autobots.combinarme();
		superion.recibirColocable(new DobleCanion());
		assertEquals(superion.getAtaque(),200);
	}
	
	@Test
	public void test14MenasorTomaDobleCanionYDuplicaAtaque(){
		Menasor menasor = (Menasor) this.decepticons.combinarme();
		menasor.recibirColocable(new DobleCanion());
		assertEquals(menasor.getAtaque(),230);
	}

}
