package bonus;

import static org.junit.Assert.*;

import modelo.tablero.colocable.robots.NoPuedeTransformarsePorSerCombinado;
import org.junit.Test;

import modelo.tablero.colocable.bonus.DobleCanion;
import modelo.tablero.colocable.robots.autobot.*;
import modelo.tablero.colocable.robots.decepticon.*;

public class DobleCanionTest {
	private Bumblebee bumblebee = new Bumblebee();
	private Optimus optimus = new Optimus();
	private Ratchet ratchet = new Ratchet();

	private BoneCrusher boneCrusher = new BoneCrusher();
	private Frenzy frenzy = new Frenzy();
	private Megatron megatron = new Megatron();


	@Test
	public void test01OptimusTomaDobleCanionYDuplicaAtaquePorTresTurnos(){

		//pre bonus
		assertEquals(optimus.getAtaque(),50);
		
		//turno de obtencion
		optimus.recibirColocable(new DobleCanion());
		assertEquals(optimus.getAtaque(),100);
		optimus.notificar();;
		
		//primer turno
		assertEquals(optimus.getAtaque(),100);
		optimus.notificar();;
		
		//segundo turno
		assertEquals(optimus.getAtaque(),100);
		optimus.notificar();;
		
		//tercer turno
		assertEquals(optimus.getAtaque(),100);
		optimus.notificar();
		
		//Cuarto turno
		assertEquals(optimus.getAtaque(),50);
	}
	
	@Test
	public void test02BumblebeeTomaDobleCanionYDuplicaAtaquePorTresTurnos(){

		//pre bonus
		assertEquals(bumblebee.getAtaque(),40);
		
		//turno de obtencion
		bumblebee.recibirColocable(new DobleCanion());
		assertEquals(bumblebee.getAtaque(),80);
		bumblebee.notificar();
		
		//primer turno
		assertEquals(bumblebee.getAtaque(),80);
		bumblebee.notificar();

		//segundo turno
		assertEquals(bumblebee.getAtaque(),80);
		bumblebee.notificar();

		//tercer turno
		assertEquals(bumblebee.getAtaque(),80);
		bumblebee.notificar();
		
		//Cuarto turno
		assertEquals(bumblebee.getAtaque(),40);
	}
	
	@Test
	public void test03RatchetTomaDobleCanionYDuplicaAtaquePorTresTurnos(){
		
		//pre bonus
		assertEquals(ratchet.getAtaque(),5);
		
		//turno de obtencion
		ratchet.recibirColocable(new DobleCanion());
		assertEquals(ratchet.getAtaque(),10);
		ratchet.notificar();
		
		//primer turno
		assertEquals(ratchet.getAtaque(),10);
		ratchet.notificar();
		
		//segundo turno
		assertEquals(ratchet.getAtaque(),10);
		ratchet.notificar();

		//tercer turno
		assertEquals(ratchet.getAtaque(),10);
		ratchet.notificar();
		
		//Cuarto turno
		assertEquals(ratchet.getAtaque(),5);
	}
	
	@Test
	public void test04MegatronTomaDobleCanionYDuplicaAtaquePorTresTurnos(){

		//pre bonus
		assertEquals(megatron.getAtaque(),10);
		
		//turno de obtencion
		megatron.notificar();
		megatron.recibirColocable(new DobleCanion());
		assertEquals(megatron.getAtaque(),20);
		megatron.notificar();

		//primer turno
		assertEquals(megatron.getAtaque(),20);
		megatron.notificar();

		//segundo turno
		assertEquals(megatron.getAtaque(),20);
		megatron.notificar();

		//tercer turno
		assertEquals(megatron.getAtaque(),20);
		megatron.notificar();
		
		//Cuarto turno
		assertEquals(megatron.getAtaque(),10);
	}
	
	@Test
	public void test05FrenzyTomaDobleCanionYDuplicaAtaquePorTresTurnos(){
		
		//Pre bonus
		assertEquals(frenzy.getAtaque(),10);
		
		//turno de obtencion
		frenzy.recibirColocable(new DobleCanion());
		assertEquals(frenzy.getAtaque(),20);
		frenzy.notificar();
		
		//primer turno
		assertEquals(frenzy.getAtaque(),20);
		frenzy.notificar();
		
		//segundo turno
		assertEquals(frenzy.getAtaque(),20);
		frenzy.notificar();

		//tercer turno
		assertEquals(frenzy.getAtaque(),20);
		frenzy.notificar();
		
		//Cuarto turno
		assertEquals(frenzy.getAtaque(),10);
	}
	
	@Test
	public void test06BoneCrusherTomaDobleCanionYDuplicaAtaquePorTresTurnos(){

		//pre bonus
		assertEquals(boneCrusher.getAtaque(),30);
		
		//turno de obtencion
		boneCrusher.recibirColocable(new DobleCanion());
		assertEquals(boneCrusher.getAtaque(),60);
		boneCrusher.notificar();
		
		//primer turno
		assertEquals(boneCrusher.getAtaque(),60);
		boneCrusher.notificar();
		
		//segundo turno
		assertEquals(boneCrusher.getAtaque(),60);
		boneCrusher.notificar();
		
		//tercer turno
		assertEquals(boneCrusher.getAtaque(),60);
		boneCrusher.notificar();
		
		//Cuarto turno
		assertEquals(boneCrusher.getAtaque(),30);
	}
	
	@Test
	public void test07AlternoOptimusTomaDobleCanionYDuplicaAtaquePorTresTurnos()throws NoPuedeTransformarsePorSerCombinado {
		
		optimus.transformar();		
		//pre bonus
		assertEquals(optimus.getAtaque(),15);
		
		//turno de obtencion
		optimus.recibirColocable(new DobleCanion());
		assertEquals(optimus.getAtaque(),30);
		optimus.notificar();
		
		//primer turno
		assertEquals(optimus.getAtaque(),30);
		optimus.notificar();
		
		//segundo turno
		assertEquals(optimus.getAtaque(),30);
		optimus.notificar();

		//tercer turno
		assertEquals(optimus.getAtaque(),30);
		optimus.notificar();
		
		//Cuarto turno
		assertEquals(optimus.getAtaque(),15);
	}
	
	@Test
	public void test08AlternoBumblebeeTomaDobleCanionYDuplicaAtaquePorTresTurnos()throws NoPuedeTransformarsePorSerCombinado{
		
		bumblebee.transformar();		
		// pre bonus
		assertEquals(bumblebee.getAtaque(),20);
		
		//turno de obtencion
		bumblebee.recibirColocable(new DobleCanion());
		assertEquals(bumblebee.getAtaque(),40);
		bumblebee.notificar();
		
		//primer turno
		assertEquals(bumblebee.getAtaque(),40);
		bumblebee.notificar();
		
		//segundo turno
		assertEquals(bumblebee.getAtaque(),40);
		bumblebee.notificar();
		
		//tercer turno
		assertEquals(bumblebee.getAtaque(),40);
		bumblebee.notificar();
		
		//Cuarto turno
		assertEquals(bumblebee.getAtaque(),20);
	}
	
	@Test
	public void test09AlternoRatchetTomaDobleCanionYDuplicaAtaquePorTresTurnos()throws NoPuedeTransformarsePorSerCombinado{
		
		ratchet.transformar();		
		// pre bonus
		assertEquals(ratchet.getAtaque(),35);
		
		//turno de obtencion
		ratchet.recibirColocable(new DobleCanion());
		assertEquals(ratchet.getAtaque(),70);
		ratchet.notificar();
		
		//primer turno
		assertEquals(ratchet.getAtaque(),70);
		ratchet.notificar();
		
		//segundo turno
		assertEquals(ratchet.getAtaque(),70);
		ratchet.notificar();
		
		//tercer turno
		assertEquals(ratchet.getAtaque(),70);
		ratchet.notificar();
		
		//Cuarto turno
		assertEquals(ratchet.getAtaque(),35);
	}
	
	@Test
	public void test10AlternoMegatronTomaDobleCanionYDuplicaAtaquePorTresTurnos()throws NoPuedeTransformarsePorSerCombinado{
		
		megatron.transformar();
		//pre bonus
		assertEquals(megatron.getAtaque(),55);
		
		//turno de obtencion
		megatron.notificar();
		megatron.recibirColocable(new DobleCanion());
		assertEquals(megatron.getAtaque(),110);
		megatron.notificar();

		//primer turno
		assertEquals(megatron.getAtaque(),110);
		megatron.notificar();
		
		//segundo turno
		assertEquals(megatron.getAtaque(),110);
		megatron.notificar();

		//tercer turno
		assertEquals(megatron.getAtaque(),110);
		megatron.notificar();
		
		//Cuarto turno
		assertEquals(megatron.getAtaque(),55);
	}
	
	@Test
	public void test11AlternoFrenzyTomaDobleCanionYDuplicaAtaquePorTresTurnos()throws NoPuedeTransformarsePorSerCombinado{
		
		frenzy.transformar();
		//pre bonus
		assertEquals(frenzy.getAtaque(),25);
		
		//turno de obtencion
		frenzy.recibirColocable(new DobleCanion());
		assertEquals(frenzy.getAtaque(),50);
		frenzy.notificar();
		
		//primer turno
		assertEquals(frenzy.getAtaque(),50);
		frenzy.notificar();
		
		//segundo turno
		assertEquals(frenzy.getAtaque(),50);
		frenzy.notificar();
		
		//tercer turno
		assertEquals(frenzy.getAtaque(),50);
		frenzy.notificar();
		
		//Cuarto turno
		assertEquals(frenzy.getAtaque(),25);
	}
	
	@Test
	public void test12AlternoBoneCrusherTomaDobleCanionYDuplicaAtaquePorTresTurnos()throws NoPuedeTransformarsePorSerCombinado{
		
		boneCrusher.transformar();		
		//pre bonus
		assertEquals(boneCrusher.getAtaque(),30);
		
		//turno de obtencion
		boneCrusher.notificar();
		boneCrusher.recibirColocable(new DobleCanion());
		assertEquals(boneCrusher.getAtaque(),60);
		boneCrusher.notificar();
		
		//primer turno
		assertEquals(boneCrusher.getAtaque(),60);
		boneCrusher.notificar();
		
		//segundo turno
		assertEquals(boneCrusher.getAtaque(),60);
		boneCrusher.notificar();
		
		//tercer turno
		assertEquals(boneCrusher.getAtaque(),60);
		boneCrusher.notificar();
		
		//Cuarto turno
		assertEquals(boneCrusher.getAtaque(),30);
	}

	@Test
	public void test13SuperionTomaDobleCanionYDuplicaAtaquePorTresTurnos(){
		Superion superion = new Superion(optimus, bumblebee, ratchet);
		//pre bonus
		assertEquals(superion.getAtaque(),100);
		
		//turno de obtencion
		superion.recibirColocable(new DobleCanion());
		assertEquals(superion.getAtaque(),200);
		superion.notificar();
		
		//primer turno
		assertEquals(superion.getAtaque(),200);
		superion.notificar();
		
		//segundo turno
		assertEquals(superion.getAtaque(),200);
		superion.notificar();
		
		//tercer turno
		assertEquals(superion.getAtaque(),200);
		superion.notificar();
		
		//Cuarto turno
		assertEquals(superion.getAtaque(),100);
	}

	@Test
	public void test14MenasorTomaDobleCanionYDuplicaAtaquePorTresTurnos(){
		Menasor menasor = new Menasor(megatron, boneCrusher, frenzy);
		//pre bonus
		assertEquals(menasor.getAtaque(),115);
		
		//turno de obtencion
		menasor.recibirColocable(new DobleCanion());
		assertEquals(menasor.getAtaque(),230);
		menasor.notificar();
		
		//primer turno
		assertEquals(menasor.getAtaque(),230);
		menasor.notificar();
		
		//segundo turno
		assertEquals(menasor.getAtaque(),230);
		menasor.notificar();
		
		//tercer turno
		assertEquals(menasor.getAtaque(),230);
		menasor.notificar();
		
		//Cuarto turno
		assertEquals(menasor.getAtaque(),115);
	}
	
	
	@Test
	public void test15OptimusTomaDobleCanionYNoAcumulaElSegundo(){

		//pre bonus
		assertEquals(optimus.getAtaque(),50);
		
		//turno de obtencion
		optimus.recibirColocable(new DobleCanion());
		assertEquals(optimus.getAtaque(),100);
		optimus.notificar();;
		
		//primer turno
		assertEquals(optimus.getAtaque(),100);
		optimus.notificar();;
		
		//segundo turno

		optimus.recibirColocable(new DobleCanion());
		assertEquals(optimus.getAtaque(),100);
		optimus.notificar();;
		
		//tercer turno
		assertEquals(optimus.getAtaque(),100);
		optimus.notificar();
		
		//Cuarto turno
		assertEquals(optimus.getAtaque(),50);
	}
	
	@Test
	public void test16BumblebeeTomaDobleCanionYNoAcumulaElSegundo(){

		//pre bonus
		assertEquals(bumblebee.getAtaque(),40);
		
		//turno de obtencion
		bumblebee.recibirColocable(new DobleCanion());
		assertEquals(bumblebee.getAtaque(),80);
		bumblebee.notificar();
		
		//primer turno
		assertEquals(bumblebee.getAtaque(),80);
		bumblebee.notificar();

		//segundo turno
		assertEquals(bumblebee.getAtaque(),80);
		bumblebee.notificar();

		//tercer turno

		bumblebee.recibirColocable(new DobleCanion());
		assertEquals(bumblebee.getAtaque(),80);
		bumblebee.notificar();
		
		//Cuarto turno
		assertEquals(bumblebee.getAtaque(),40);
	}
	
	@Test
	public void test17RatchetTomaDobleCanionYNoAcumulaElSegundo(){
		
		//pre bonus
		assertEquals(ratchet.getAtaque(),5);
		
		//turno de obtencion
		ratchet.recibirColocable(new DobleCanion());
		assertEquals(ratchet.getAtaque(),10);
		ratchet.notificar();
		
		//primer turno
		assertEquals(ratchet.getAtaque(),10);
		ratchet.notificar();
		
		//segundo turno

		ratchet.recibirColocable(new DobleCanion());
		assertEquals(ratchet.getAtaque(),10);
		ratchet.notificar();

		//tercer turno
		assertEquals(ratchet.getAtaque(),10);
		ratchet.notificar();
		
		//Cuarto turno
		assertEquals(ratchet.getAtaque(),5);
	}
	
	@Test
	public void test18MegatronTomaDobleCanionYNoAcumulaElSegundo(){

		//pre bonus
		assertEquals(megatron.getAtaque(),10);
		
		//turno de obtencion
		megatron.notificar();
		megatron.recibirColocable(new DobleCanion());
		assertEquals(megatron.getAtaque(),20);
		megatron.notificar();

		//primer turno
		assertEquals(megatron.getAtaque(),20);
		megatron.notificar();

		//segundo turno

		megatron.recibirColocable(new DobleCanion());
		assertEquals(megatron.getAtaque(),20);
		megatron.notificar();

		//tercer turno
		assertEquals(megatron.getAtaque(),20);
		megatron.notificar();
		
		//Cuarto turno
		assertEquals(megatron.getAtaque(),10);
	}
	
	@Test
	public void test19FrenzyTomaDobleCanionYNoAcumulaElSegundo(){
		
		//Pre bonus
		assertEquals(frenzy.getAtaque(),10);
		
		//turno de obtencion
		frenzy.recibirColocable(new DobleCanion());
		assertEquals(frenzy.getAtaque(),20);
		frenzy.notificar();
		
		//primer turno
		assertEquals(frenzy.getAtaque(),20);
		frenzy.notificar();
		
		//segundo turno
		assertEquals(frenzy.getAtaque(),20);
		frenzy.notificar();

		//tercer turno

		frenzy.recibirColocable(new DobleCanion());
		assertEquals(frenzy.getAtaque(),20);
		frenzy.notificar();
		
		//Cuarto turno
		assertEquals(frenzy.getAtaque(),10);
	}
	
	@Test
	public void test20BoneCrusherTomaDobleCanionYNoAcumulaElSegundo(){

		//pre bonus
		assertEquals(boneCrusher.getAtaque(),30);
		
		//turno de obtencion
		boneCrusher.recibirColocable(new DobleCanion());
		assertEquals(boneCrusher.getAtaque(),60);
		boneCrusher.notificar();
		
		//primer turno
		assertEquals(boneCrusher.getAtaque(),60);
		boneCrusher.notificar();
		
		//segundo turno

		boneCrusher.recibirColocable(new DobleCanion());
		assertEquals(boneCrusher.getAtaque(),60);
		boneCrusher.notificar();
		
		//tercer turno
		assertEquals(boneCrusher.getAtaque(),60);
		boneCrusher.notificar();
		
		//Cuarto turno
		assertEquals(boneCrusher.getAtaque(),30);
	}
	
	@Test
	public void test21AlternoOptimusTomaDobleCanionYNoAcumulaElSegundo()throws NoPuedeTransformarsePorSerCombinado {
		
		optimus.transformar();		
		//pre bonus
		assertEquals(optimus.getAtaque(),15);
		
		//turno de obtencion
		optimus.recibirColocable(new DobleCanion());
		assertEquals(optimus.getAtaque(),30);
		optimus.notificar();
		
		//primer turno

		optimus.recibirColocable(new DobleCanion());
		assertEquals(optimus.getAtaque(),30);
		optimus.notificar();
		
		//segundo turno
		assertEquals(optimus.getAtaque(),30);
		optimus.notificar();

		//tercer turno
		assertEquals(optimus.getAtaque(),30);
		optimus.notificar();
		
		//Cuarto turno
		assertEquals(optimus.getAtaque(),15);
	}
	
	@Test
	public void test22AlternoBumblebeeTomaDobleCanionYNoAcumulaElSegundo()throws NoPuedeTransformarsePorSerCombinado{
		
		bumblebee.transformar();		
		// pre bonus
		assertEquals(bumblebee.getAtaque(),20);
		
		//turno de obtencion
		bumblebee.recibirColocable(new DobleCanion());
		assertEquals(bumblebee.getAtaque(),40);
		bumblebee.notificar();
		
		//primer turno
		assertEquals(bumblebee.getAtaque(),40);
		bumblebee.notificar();
		
		//segundo turno y lo agarra otra vez
		bumblebee.recibirColocable(new DobleCanion());
		assertEquals(bumblebee.getAtaque(),40);
		bumblebee.notificar();
		
		//tercer turno
		assertEquals(bumblebee.getAtaque(),40);
		bumblebee.notificar();
		
		//Cuarto turno
		assertEquals(bumblebee.getAtaque(),20);
	}
	
	@Test
	public void test23AlternoRatchetTomaDobleCanionYNoAcumulaElSegundo()throws NoPuedeTransformarsePorSerCombinado{
		
		ratchet.transformar();		
		// pre bonus
		assertEquals(ratchet.getAtaque(),35);
		
		//turno de obtencion
		ratchet.recibirColocable(new DobleCanion());
		assertEquals(ratchet.getAtaque(),70);
		ratchet.notificar();
		
		//primer turno. vuelve a tomarlo
		ratchet.recibirColocable(new DobleCanion());
		assertEquals(ratchet.getAtaque(),70);
		ratchet.notificar();
		
		//segundo turno
		assertEquals(ratchet.getAtaque(),70);
		ratchet.notificar();
		
		//tercer turno
		assertEquals(ratchet.getAtaque(),70);
		ratchet.notificar();
		
		//Cuarto turno
		assertEquals(ratchet.getAtaque(),35);
	}
	
	@Test
	public void test24AlternoMegatronTomaDobleCanionYNoAcumulaElSegundo()throws NoPuedeTransformarsePorSerCombinado{
		
		megatron.transformar();
		//pre bonus
		assertEquals(megatron.getAtaque(),55);
		
		//turno de obtencion
		megatron.notificar();
		megatron.recibirColocable(new DobleCanion());
		assertEquals(megatron.getAtaque(),110);
		megatron.notificar();

		//primer turno
		assertEquals(megatron.getAtaque(),110);
		megatron.notificar();
		
		//segundo turno
		assertEquals(megatron.getAtaque(),110);
		megatron.notificar();

		//tercer turno y vuelve a agarrarlo
		megatron.recibirColocable(new DobleCanion());
		assertEquals(megatron.getAtaque(),110);
		megatron.notificar();
		
		//Cuarto turno
		assertEquals(megatron.getAtaque(),55);
	}
	
	@Test
	public void test25AlternoFrenzyTomaDobleCanionYNoAcumulaElSegundo()throws NoPuedeTransformarsePorSerCombinado{
		
		frenzy.transformar();
		//pre bonus
		assertEquals(frenzy.getAtaque(),25);
		
		//turno de obtencion
		frenzy.recibirColocable(new DobleCanion());
		assertEquals(frenzy.getAtaque(),50);
		frenzy.notificar();
		
		//primer turno
		assertEquals(frenzy.getAtaque(),50);
		frenzy.notificar();
		
		//segundo turno y vuelve a tomarlo
		frenzy.recibirColocable(new DobleCanion());
		assertEquals(frenzy.getAtaque(),50);
		frenzy.notificar();
		
		//tercer turno
		assertEquals(frenzy.getAtaque(),50);
		frenzy.notificar();
		
		//Cuarto turno
		assertEquals(frenzy.getAtaque(),25);
	}
	
	@Test
	public void test26AlternoBoneCrusherTomaDobleCanionYNoAcumulaElSegundo()throws NoPuedeTransformarsePorSerCombinado{
		
		boneCrusher.transformar();		
		//pre bonus
		assertEquals(boneCrusher.getAtaque(),30);
		
		//turno de obtencion
		boneCrusher.notificar();
		boneCrusher.recibirColocable(new DobleCanion());
		assertEquals(boneCrusher.getAtaque(),60);
		boneCrusher.notificar();
		
		//primer turno y vuelve a tomarlo
		boneCrusher.recibirColocable(new DobleCanion());
		assertEquals(boneCrusher.getAtaque(),60);
		boneCrusher.notificar();
		
		//segundo turno
		assertEquals(boneCrusher.getAtaque(),60);
		boneCrusher.notificar();
		
		//tercer turno
		assertEquals(boneCrusher.getAtaque(),60);
		boneCrusher.notificar();
		
		//Cuarto turno
		assertEquals(boneCrusher.getAtaque(),30);
	}

	@Test
	public void test27SuperionTomaDobleCanionYNoAcumulaElSegundo(){
		Superion superion = new Superion(optimus, bumblebee, ratchet);
		//pre bonus
		assertEquals(superion.getAtaque(),100);
		
		//turno de obtencion
		superion.recibirColocable(new DobleCanion());
		assertEquals(superion.getAtaque(),200);
		superion.notificar();
		
		//primer turno
		assertEquals(superion.getAtaque(),200);
		superion.notificar();
		
		//segundo turno
		assertEquals(superion.getAtaque(),200);
		superion.notificar();
		
		//tercer turno y toma nuevo canion
		superion.recibirColocable(new DobleCanion());
		assertEquals(superion.getAtaque(),200);
		superion.notificar();
		
		//Cuarto turno
		assertEquals(superion.getAtaque(),100);
	}

	
	@Test
	public void test28MenasorTomaDobleCanionYNoAcumulaElSegundo(){
		Menasor menasor = new Menasor(megatron, boneCrusher, frenzy);
		//pre bonus
		assertEquals(menasor.getAtaque(),115);
		
		//turno de obtencion
		menasor.recibirColocable(new DobleCanion());
		assertEquals(menasor.getAtaque(),230);
		menasor.notificar();
		
		//primer turno
		assertEquals(menasor.getAtaque(),230);
		menasor.notificar();
		
		//segundo turno y toma nuevo canion
		menasor.recibirColocable(new DobleCanion());
		assertEquals(menasor.getAtaque(),230);
		menasor.notificar();
		
		//tercer turno
		assertEquals(menasor.getAtaque(),230);
		menasor.notificar();
		
		//Cuarto turno
		assertEquals(menasor.getAtaque(),115);
	}
	
}
