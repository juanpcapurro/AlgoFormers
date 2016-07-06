package bonus;

import modelo.tablero.colocable.bonus.Flash;

import modelo.tablero.colocable.robots.NoPuedeTransformarsePorSerCombinado;
import modelo.tablero.colocable.robots.autobot.*;
import modelo.tablero.colocable.robots.decepticon.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class FlashTest {
	
	private Bumblebee bumblebee = new Bumblebee();
	private Optimus optimus = new Optimus();
	private Ratchet ratchet = new Ratchet();

	private BoneCrusher boneCrusher = new BoneCrusher();
	private Frenzy frenzy = new Frenzy();
	private Megatron megatron = new Megatron();

	@Test
	public void test01OptimusTomaFlashYTriplicaVelocidadPorTresTurnos(){
		//Velocidad pre bonus
		assertEquals(optimus.getVelocidad(),2);
		
		//turno de obtencion del flash
		optimus.recibirColocable(new Flash());
		assertEquals(optimus.getVelocidad(),6);
		optimus.notificar();
		
		//primer turno con flash
		assertEquals(optimus.getVelocidad(),6);
		optimus.notificar();
		
		//segundo turno con flash
		assertEquals(optimus.getVelocidad(),6);
		optimus.notificar();
		
		//tercer turno con flash
		assertEquals(optimus.getVelocidad(),6);
		optimus.notificar();
		
		//Cuarto turno sin flash
		assertEquals(optimus.getVelocidad(),2);
	}
	
	@Test
	public void test02BumblebeeTomaFlashYTriplicaVelocidadPorTresTurnos(){

		//Velocidad pre bonus
		assertEquals(bumblebee.getVelocidad(),2);
		
		//turno de obtencion del flash
		bumblebee.recibirColocable(new Flash());
		assertEquals(bumblebee.getVelocidad(),6);
		bumblebee.notificar();
		
		//primer turno con flash
		assertEquals(bumblebee.getVelocidad(),6);
		bumblebee.notificar();
		
		//segundo turno con flash
		assertEquals(bumblebee.getVelocidad(),6);
		bumblebee.notificar();
		
		//tercer turno con flash
		assertEquals(bumblebee.getVelocidad(),6);
		bumblebee.notificar();
		
		//Cuarto turno sin flash
		assertEquals(bumblebee.getVelocidad(),2);
	}
	
	@Test
	public void test03RatchetTomaFlashYTriplicaVelocidadPorTresTurnos(){
		
		//Velocidad pre bonus
		assertEquals(ratchet.getVelocidad(),1);
		
		//turno de obtencion del flash
		ratchet.recibirColocable(new Flash());
		assertEquals(ratchet.getVelocidad(),3);
		ratchet.notificar();
		
		//primer turno con flash
		assertEquals(ratchet.getVelocidad(),3);
		ratchet.notificar();
		
		//segundo turno con flash
		assertEquals(ratchet.getVelocidad(),3);
		ratchet.notificar();
		
		//tercer turno con flash
		assertEquals(ratchet.getVelocidad(),3);
		ratchet.notificar();
		
		//Cuarto turno sin flash
		assertEquals(ratchet.getVelocidad(),1);
	}
	
	@Test
	public void test04MegatronTomaFlashYTriplicaVelocidadPorTresTurnos(){

		//Velocidad pre bonus
		assertEquals(megatron.getVelocidad(),1);
		
		//turno de obtencion del flash
		megatron.notificar();
		megatron.recibirColocable(new Flash());
		assertEquals(megatron.getVelocidad(),3);
		megatron.notificar();
		
		//primer turno con flash
		assertEquals(megatron.getVelocidad(),3);
		megatron.notificar();
		
		//segundo turno con flash
		assertEquals(megatron.getVelocidad(),3);
		megatron.notificar();
		
		//tercer turno con flash
		assertEquals(megatron.getVelocidad(),3);
		megatron.notificar();

		//Cuarto turno sin flash
		assertEquals(megatron.getVelocidad(),1);
	}
	
	@Test
	public void test05FrenzyTomaFlashYTriplicaVelocidadPorTresTurnos(){
		
		//Velocidad pre bonus
		assertEquals(frenzy.getVelocidad(),2);
		
		//turno de obtencion del flash
		frenzy.notificar();
		frenzy.recibirColocable(new Flash());
		assertEquals(frenzy.getVelocidad(),6);
		frenzy.notificar();
		
		//primer turno con flash
		assertEquals(frenzy.getVelocidad(),6);
		frenzy.notificar();
		
		//segundo turno con flash
		assertEquals(frenzy.getVelocidad(),6);
		frenzy.notificar();
		
		//tercer turno con flash
		assertEquals(frenzy.getVelocidad(),6);
		frenzy.notificar();
		
		//Cuarto turno sin flash
		assertEquals(frenzy.getVelocidad(),2);
	}
	
	@Test
	public void test06BoneCrusherTomaFlashYTriplicaVelocidadPorTresTurnos(){

		//Velocidad pre bonus
		assertEquals(boneCrusher.getVelocidad(),1);
		
		//turno de obtencion del flash
		boneCrusher.recibirColocable(new Flash());
		assertEquals(boneCrusher.getVelocidad(),3);
		boneCrusher.notificar();
		
		//primer turno con flash
		assertEquals(boneCrusher.getVelocidad(),3);
		boneCrusher.notificar();
		
		//segundo turno con flash
		assertEquals(boneCrusher.getVelocidad(),3);
		boneCrusher.notificar();
		
		//tercer turno con flash
		assertEquals(boneCrusher.getVelocidad(),3);
		boneCrusher.notificar();
		
		//Cuarto turno sin flash
		assertEquals(boneCrusher.getVelocidad(),1);
	}
	
	@Test
	public void test07AlternoOptimusTomaFlashYTriplicaVelocidadPorTresTurnos()throws NoPuedeTransformarsePorSerCombinado {
		optimus.transformar();
		//Velocidad pre bonus
		assertEquals(optimus.getVelocidad(),5);
		
		//turno de obtencion del flash
		optimus.recibirColocable(new Flash());
		assertEquals(optimus.getVelocidad(),15);
		optimus.notificar();
		
		//primer turno con flash
		assertEquals(optimus.getVelocidad(),15);
		optimus.notificar();
		
		//segundo turno con flash
		assertEquals(optimus.getVelocidad(),15);
		optimus.notificar();
		
		//tercer turno con flash
		assertEquals(optimus.getVelocidad(),15);
		optimus.notificar();
		
		//Cuarto turno sin flash
		assertEquals(optimus.getVelocidad(),5);
	}
	
	@Test
	public void test08AlternoBumblebeeTomaFlashYTriplicaVelocidadPorTresTurnos()throws NoPuedeTransformarsePorSerCombinado{
		
		bumblebee.transformar();		
		//Velocidad pre bonus
		assertEquals(bumblebee.getVelocidad(),5);
		
		//turno de obtencion del flash
		bumblebee.recibirColocable(new Flash());
		assertEquals(bumblebee.getVelocidad(),15);
		bumblebee.notificar();
		
		//primer turno con flash
		assertEquals(bumblebee.getVelocidad(),15);
		bumblebee.notificar();
		
		//segundo turno con flash
		assertEquals(bumblebee.getVelocidad(),15);
		bumblebee.notificar();
		
		//tercer turno con flash
		assertEquals(bumblebee.getVelocidad(),15);
		bumblebee.notificar();
		
		//Cuarto turno sin flash
		assertEquals(bumblebee.getVelocidad(),5);
	}
	
	@Test
	public void test09AlternoRatchetTomaFlashYTriplicaVelocidadPorTresTurnos()throws NoPuedeTransformarsePorSerCombinado{
		
		ratchet.transformar();		
		//Velocidad pre bonus
		assertEquals(ratchet.getVelocidad(),8);
		
		//turno de obtencion del flash
		ratchet.recibirColocable(new Flash());
		assertEquals(ratchet.getVelocidad(),24);
		ratchet.notificar();
		
		//primer turno con flash
		assertEquals(ratchet.getVelocidad(),24);
		ratchet.notificar();
		
		//segundo turno con flash
		assertEquals(ratchet.getVelocidad(),24);
		ratchet.notificar();
		
		//tercer turno con flash
		assertEquals(ratchet.getVelocidad(),24);
		ratchet.notificar();
		
		//Cuarto turno sin flash
		assertEquals(ratchet.getVelocidad(),8);
	}
	
	@Test
	public void test10AlternoMegatronTomaFlashYTriplicaVelocidadPorTresTurnos()throws NoPuedeTransformarsePorSerCombinado{
		
		megatron.transformar();
		//Velocidad pre bonus
		assertEquals(megatron.getVelocidad(),8);
		
		//turno de obtencion del flash
		megatron.notificar();
		megatron.recibirColocable(new Flash());
		assertEquals(megatron.getVelocidad(),24);
		megatron.notificar();
		
		//primer turno con flash
		assertEquals(megatron.getVelocidad(),24);
		megatron.notificar();

		//segundo turno con flash
		assertEquals(megatron.getVelocidad(),24);
		megatron.notificar();

		//tercer turno con flash
		assertEquals(megatron.getVelocidad(),24);
		megatron.notificar();
		
		//Cuarto turno sin flash
		assertEquals(megatron.getVelocidad(),8);
	}
	
	@Test
	public void test11AlternoFrenzyTomaFlashYTriplicaVelocidadPorTresTurnos()throws NoPuedeTransformarsePorSerCombinado{
		
		frenzy.transformar();
		//Velocidad pre bonus
		assertEquals(frenzy.getVelocidad(),6);
		
		//turno de obtencion del flash
		frenzy.notificar();
		frenzy.recibirColocable(new Flash());
		assertEquals(frenzy.getVelocidad(),18);
		frenzy.notificar();

		//primer turno con flash
		assertEquals(frenzy.getVelocidad(),18);
		frenzy.notificar();

		//segundo turno con flash
		assertEquals(frenzy.getVelocidad(),18);
		frenzy.notificar();

		//tercer turno con flash
		assertEquals(frenzy.getVelocidad(),18);
		frenzy.notificar();
		
		//Cuarto turno sin flash
		assertEquals(frenzy.getVelocidad(),6);
	}
	
	@Test
	public void test12AlternoBoneCrusherTomaFlashYTriplicaVelocidadPorTresTurnos()throws NoPuedeTransformarsePorSerCombinado{
		
		boneCrusher.transformar();		
		// pre bonus
		assertEquals(boneCrusher.getVelocidad(),8);
		
		//turno de obtencion
		boneCrusher.notificar();
		boneCrusher.recibirColocable(new Flash());
		assertEquals(boneCrusher.getVelocidad(),24);
		boneCrusher.notificar();

		//primer turno
		assertEquals(boneCrusher.getVelocidad(),24);
		boneCrusher.notificar();

		//segundo turno
		assertEquals(boneCrusher.getVelocidad(),24);
		boneCrusher.notificar();

		//tercer turno
		assertEquals(boneCrusher.getVelocidad(),24);
		boneCrusher.notificar();
		
		//Cuarto turno
		assertEquals(boneCrusher.getVelocidad(),8);
	}
	
	@Test
	public void test13SuperionTomaFlashYTriplicaVelocidadPorTresTurnos(){
		Superion superion = new Superion (optimus, bumblebee, ratchet);
		assertEquals(superion.getVelocidad(),3);
		
		//turno de obtencion del flash
		superion.recibirColocable(new Flash());
		assertEquals(superion.getVelocidad(),9);
		superion.notificar();

		//primer turno con flash
		assertEquals(superion.getVelocidad(),9);
		superion.notificar();

		//segundo turno con flash
		assertEquals(superion.getVelocidad(),9);
		superion.notificar();

		//tercer turno con flash
		assertEquals(superion.getVelocidad(),9);
		superion.notificar();
		
		//Cuarto turno sin flash
		assertEquals(superion.getVelocidad(),3);
	}

	@Test
	public void test14MenasorTomaFlashYTriplicaVelocidadPorTresTurnos(){
		Menasor menasor = new Menasor(megatron, boneCrusher,frenzy);
		//Velocidad pre bonus
		assertEquals(menasor.getVelocidad(),2);
		
		//turno de obtencion del flash
		menasor.recibirColocable(new Flash());
		assertEquals(menasor.getVelocidad(),6);
		menasor.notificar();

		//primer turno con flash
		assertEquals(menasor.getVelocidad(),6);
		menasor.notificar();
		
		//segundo turno con flash
		assertEquals(menasor.getVelocidad(),6);
		menasor.notificar();
		
		//tercer turno con flash
		assertEquals(menasor.getVelocidad(),6);
		menasor.notificar();
		
		//Cuarto turno sin flash
		assertEquals(menasor.getVelocidad(),2);
	}

}
