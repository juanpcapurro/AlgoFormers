package bonus;

import modelo.tablero.colocable.bonus.BurbujaInmaculada;
import modelo.tablero.colocable.robots.armas.Ataque;
import modelo.tablero.colocable.robots.autobot.*;
import modelo.tablero.colocable.robots.decepticon.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class BurbujaInmaculadaTest {
	
	private Bumblebee bumblebee = new Bumblebee();
	private Optimus optimus = new Optimus();
	private Ratchet ratchet = new Ratchet();

	private BoneCrusher boneCrusher = new BoneCrusher();
	private Frenzy frenzy = new Frenzy();
	private Megatron megatron = new Megatron();

	@Test
	public void test01OptimusConVidaTotalTomaBurbujaYNoPierdeVidaPor2Turnos(){
		
		//Vida pre bonus
		assertEquals(optimus.getPuntosDeVida(),500);
		
		//turno de obtencion
		optimus.recibirColocable(new BurbujaInmaculada());
		assertEquals(optimus.getPuntosDeVida(),500);
		optimus.recibirAtaque(new Ataque(100));
		optimus.notificar();
		//primer turno con burbuja
		assertEquals(optimus.getPuntosDeVida(),500);
		optimus.recibirAtaque(new Ataque(200));
		optimus.notificar();
		
		//segundo turno con burbuja.Recupero vidaActual perdida antes
		assertEquals(optimus.getPuntosDeVida(),500);
		optimus.recibirAtaque(new Ataque(200));
		optimus.notificar();

		//tercer turno con burbuja.Recupera vidaActual perdida antes
		assertEquals(optimus.getPuntosDeVida(),500);
		optimus.recibirAtaque(new Ataque(200));
		assertEquals(optimus.getPuntosDeVida(),300);
		optimus.notificar();
		
		//Cuarto turno con burbuja. No recupera vidaActual
		assertEquals(optimus.getPuntosDeVida(),300);
	}

	@Test
	public void test02OptimusDaniadoTomaBurbujaYNoPierdeVidaPor2Turnos(){

		//Vida pre bonus
		optimus.recibirAtaque(new Ataque(100));
		assertEquals(optimus.getPuntosDeVida(),400);
		
		//turno de obtencion
		optimus.recibirColocable(new BurbujaInmaculada());
		assertEquals(optimus.getPuntosDeVida(),400);
		optimus.recibirAtaque(new Ataque(100));
		optimus.notificar();
		
		//primer turno con burbuja
		assertEquals(optimus.getPuntosDeVida(),400);
		optimus.recibirAtaque(new Ataque(200));
		optimus.notificar();
		
		//segundo turno con burbuja.Recupero vidaActual perdida antes
		assertEquals(optimus.getPuntosDeVida(),400);
		optimus.recibirAtaque(new Ataque(200));
		optimus.notificar();
		
		//tercer turno con burbuja.Recupera vidaActual perdida antes
		assertEquals(optimus.getPuntosDeVida(),400);
		optimus.recibirAtaque(new Ataque(200));
		assertEquals(optimus.getPuntosDeVida(),200);
		optimus.notificar();
		
		//Cuarto turno con burbuja. No recupera vidaActual
		assertEquals(optimus.getPuntosDeVida(),200);
	}
	
	@Test
	public void test03OptimusAlternoConVidaTotalTomaBurbujaYNoPierdeVidaPor2Turnos(){

		//Vida pre bonus
		optimus.transformar();
		assertEquals(optimus.getPuntosDeVida(),500);
		
		//turno de obtencion
		optimus.recibirColocable(new BurbujaInmaculada());
		assertEquals(optimus.getPuntosDeVida(),500);
		optimus.recibirAtaque(new Ataque(100));
		optimus.notificar();
		
		//primer turno con burbuja
		assertEquals(optimus.getPuntosDeVida(),500);
		optimus.recibirAtaque(new Ataque(200));
		optimus.notificar();
		
		//segundo turno con burbuja.Recupero vidaActual perdida antes
		assertEquals(optimus.getPuntosDeVida(),500);
		optimus.recibirAtaque(new Ataque(200));
		optimus.notificar();
		
		//tercer turno con burbuja.Recupera vidaActual perdida antes
		assertEquals(optimus.getPuntosDeVida(),500);
		optimus.recibirAtaque(new Ataque(200));
		assertEquals(optimus.getPuntosDeVida(),300);
		optimus.notificar();
		
		//Cuarto turno con burbuja. No recupera vidaActual
		assertEquals(optimus.getPuntosDeVida(),300);
	}

	@Test
	public void test04OptimusAlternoDaniadoTomaBurbujaYNoPierdeVidaPor2Turnos(){
		//Vida pre bonus
		optimus.transformar();
		optimus.recibirAtaque(new Ataque(100));
		assertEquals(optimus.getPuntosDeVida(),400);
		
		//turno de obtencion
		optimus.recibirColocable(new BurbujaInmaculada());
		assertEquals(optimus.getPuntosDeVida(),400);
		optimus.recibirAtaque(new Ataque(100));
		optimus.notificar();
		
		//primer turno con burbuja
		assertEquals(optimus.getPuntosDeVida(),400);
		optimus.recibirAtaque(new Ataque(200));
		optimus.notificar();
		
		//segundo turno con burbuja.Recupero vidaActual perdida antes
		assertEquals(optimus.getPuntosDeVida(),400);
		optimus.recibirAtaque(new Ataque(200));
		optimus.notificar();
		
		//tercer turno con burbuja.Recupera vidaActual perdida antes
		assertEquals(optimus.getPuntosDeVida(),400);
		optimus.recibirAtaque(new Ataque(200));
		assertEquals(optimus.getPuntosDeVida(),200);
		optimus.notificar();
		
		//Cuarto turno con burbuja. No recupera vidaActual
		assertEquals(optimus.getPuntosDeVida(),200);
	}

	@Test
	public void test05BumblebeeConVidaTotalTomaBurbujaYNoPierdeVidaPor2Turnos(){

		//Vida pre bonus
		assertEquals(bumblebee.getPuntosDeVida(),350);
		
		//turno de obtencion
		bumblebee.recibirColocable(new BurbujaInmaculada());
		assertEquals(bumblebee.getPuntosDeVida(),350);
		bumblebee.recibirAtaque(new Ataque(100));
		bumblebee.notificar();
		
		//primer turno con burbuja
		assertEquals(bumblebee.getPuntosDeVida(),350);
		bumblebee.recibirAtaque(new Ataque(200));
		bumblebee.notificar();
		
		//segundo turno con burbuja.Recupero vidaActual perdida antes
		assertEquals(bumblebee.getPuntosDeVida(),350);
		bumblebee.recibirAtaque(new Ataque(200));
		bumblebee.notificar();
		
		//tercer turno con burbuja.Recupera vidaActual perdida antes
		assertEquals(bumblebee.getPuntosDeVida(),350);
		bumblebee.recibirAtaque(new Ataque(200));
		assertEquals(bumblebee.getPuntosDeVida(),150);
		bumblebee.notificar();
		
		//Cuarto turno con burbuja. No recupera vidaActual
		assertEquals(bumblebee.getPuntosDeVida(),150);
	}

	@Test
	public void test06BumblebeeDaniadoTomaBurbujaYNoPierdeVidaPor2Turnos(){

		//Vida pre bonus
		assertEquals(bumblebee.getPuntosDeVida(),350);
		bumblebee.recibirAtaque(new Ataque(100));
		
		//turno de obtencion
		bumblebee.recibirColocable(new BurbujaInmaculada());
		assertEquals(bumblebee.getPuntosDeVida(),250);
		bumblebee.recibirAtaque(new Ataque(100));
		bumblebee.notificar();
		
		//primer turno con burbuja
		assertEquals(bumblebee.getPuntosDeVida(),250);
		bumblebee.recibirAtaque(new Ataque(200));
		bumblebee.notificar();
		
		//segundo turno con burbuja.Recupero vidaActual perdida antes
		assertEquals(bumblebee.getPuntosDeVida(),250);
		bumblebee.recibirAtaque(new Ataque(200));
		bumblebee.notificar();
		
		//tercer turno con burbuja.Recupera vidaActual perdida antes
		assertEquals(bumblebee.getPuntosDeVida(),250);
		bumblebee.recibirAtaque(new Ataque(200));
		assertEquals(bumblebee.getPuntosDeVida(),50);
		bumblebee.notificar();
		
		//Cuarto turno con burbuja. No recupera vidaActual
		assertEquals(bumblebee.getPuntosDeVida(),50);
	}
	
	@Test
	public void test07BumblebeeAlternoConVidaTotalTomaBurbujaYNoPierdeVidaPor2Turnos(){

		optimus.transformar();
		//Vida pre bonus
		assertEquals(bumblebee.getPuntosDeVida(),350);
		
		//turno de obtencion
		bumblebee.recibirColocable(new BurbujaInmaculada());
		assertEquals(bumblebee.getPuntosDeVida(),350);
		bumblebee.recibirAtaque(new Ataque(100));
		bumblebee.notificar();
		
		//primer turno con burbuja
		assertEquals(bumblebee.getPuntosDeVida(),350);
		bumblebee.recibirAtaque(new Ataque(200));
		bumblebee.notificar();
		
		//segundo turno con burbuja.Recupero vidaActual perdida antes
		assertEquals(bumblebee.getPuntosDeVida(),350);
		bumblebee.recibirAtaque(new Ataque(200));
		bumblebee.notificar();
		
		//tercer turno con burbuja.Recupera vidaActual perdida antes
		assertEquals(bumblebee.getPuntosDeVida(),350);
		bumblebee.recibirAtaque(new Ataque(200));
		assertEquals(bumblebee.getPuntosDeVida(),150);
		bumblebee.notificar();
		
		//Cuarto turno con burbuja. No recupera vidaActual
		assertEquals(bumblebee.getPuntosDeVida(),150);
	}

	@Test
	public void test08BumblebeeAlternoDaniadoTomaBurbujaYNoPierdeVidaPor2Turnos(){

		bumblebee.transformar();
		//Vida pre bonus
		assertEquals(bumblebee.getPuntosDeVida(),350);
		bumblebee.recibirAtaque(new Ataque(100));
		
		//turno de obtencion
		bumblebee.recibirColocable(new BurbujaInmaculada());
		assertEquals(bumblebee.getPuntosDeVida(),250);
		bumblebee.recibirAtaque(new Ataque(100));
		bumblebee.notificar();
		
		//primer turno con burbuja
		assertEquals(bumblebee.getPuntosDeVida(),250);
		bumblebee.recibirAtaque(new Ataque(200));
		bumblebee.notificar();
		
		//segundo turno con burbuja.Recupero vidaActual perdida antes
		assertEquals(bumblebee.getPuntosDeVida(),250);
		bumblebee.recibirAtaque(new Ataque(200));
		bumblebee.notificar();
		
		//tercer turno con burbuja.Recupera vidaActual perdida antes
		assertEquals(bumblebee.getPuntosDeVida(),250);
		bumblebee.recibirAtaque(new Ataque(200));
		assertEquals(bumblebee.getPuntosDeVida(),50);
		bumblebee.notificar();
		
		//Cuarto turno con burbuja. No recupera vidaActual
		assertEquals(bumblebee.getPuntosDeVida(),50);
	}
	
	@Test
	public void test09RatchetConVidaTotalTomaBurbujaYNoPierdeVidaPor2Turnos(){

		//Vida pre bonus
		assertEquals(ratchet.getPuntosDeVida(),150);
		
		//turno de obtencion
		ratchet.recibirColocable(new BurbujaInmaculada());
		assertEquals(ratchet.getPuntosDeVida(),150);
		ratchet.recibirAtaque(new Ataque(100));
		ratchet.notificar();
		
		//primer turno con burbuja
		assertEquals(ratchet.getPuntosDeVida(),150);
		ratchet.recibirAtaque(new Ataque(60));
		ratchet.notificar();
		
		//segundo turno con burbuja.Recupero vidaActual perdida antes
		assertEquals(ratchet.getPuntosDeVida(),150);
		ratchet.recibirAtaque(new Ataque(60));
		ratchet.notificar();
		
		//tercer turno con burbuja.Recupera vidaActual perdida antes
		assertEquals(ratchet.getPuntosDeVida(),150);
		ratchet.recibirAtaque(new Ataque(60));
		assertEquals(ratchet.getPuntosDeVida(),90);
		ratchet.notificar();
		
		//Cuarto turno con burbuja. No recupera vidaActual
		assertEquals(ratchet.getPuntosDeVida(),90);
	}

	@Test
	public void test10RatchetDaniadoTomaBurbujaYNoPierdeVidaPor2Turnos(){

		//Vida pre bonus
		ratchet.recibirAtaque(new Ataque(10));
		assertEquals(ratchet.getPuntosDeVida(),140);
		
		//turno de obtencion
		ratchet.recibirColocable(new BurbujaInmaculada());
		assertEquals(ratchet.getPuntosDeVida(),140);
		ratchet.recibirAtaque(new Ataque(100));
		ratchet.notificar();
		
		//primer turno con burbuja
		assertEquals(ratchet.getPuntosDeVida(),140);
		ratchet.recibirAtaque(new Ataque(60));
		ratchet.notificar();
		
		//segundo turno con burbuja.Recupero vidaActual perdida antes
		assertEquals(ratchet.getPuntosDeVida(),140);
		ratchet.recibirAtaque(new Ataque(60));
		ratchet.notificar();
		
		//tercer turno con burbuja.Recupera vidaActual perdida antes
		assertEquals(ratchet.getPuntosDeVida(),140);
		ratchet.recibirAtaque(new Ataque(60));
		assertEquals(ratchet.getPuntosDeVida(),80);
		ratchet.notificar();
		
		//Cuarto turno con burbuja. No recupera vidaActual
		assertEquals(ratchet.getPuntosDeVida(),80);
	}
	
	@Test
	public void test11RatchetAlternoConVidaTotalTomaBurbujaYNoPierdeVidaPor2Turnos(){

		//Vida pre bonus
		ratchet.transformar();
		assertEquals(ratchet.getPuntosDeVida(),150);
		
		//turno de obtencion
		ratchet.recibirColocable(new BurbujaInmaculada());
		assertEquals(ratchet.getPuntosDeVida(),150);
		ratchet.recibirAtaque(new Ataque(100));
		ratchet.notificar();
		
		//primer turno con burbuja
		assertEquals(ratchet.getPuntosDeVida(),150);
		ratchet.recibirAtaque(new Ataque(60));
		ratchet.notificar();
		
		//segundo turno con burbuja.Recupero vidaActual perdida antes
		assertEquals(ratchet.getPuntosDeVida(),150);
		ratchet.recibirAtaque(new Ataque(60));
		ratchet.notificar();
		
		//tercer turno con burbuja.Recupera vidaActual perdida antes
		assertEquals(ratchet.getPuntosDeVida(),150);
		ratchet.recibirAtaque(new Ataque(60));
		assertEquals(ratchet.getPuntosDeVida(),90);
		ratchet.notificar();
		
		//Cuarto turno con burbuja. No recupera vidaActual
		assertEquals(ratchet.getPuntosDeVida(),90);
	}

	@Test
	public void test12RatchetAlternoDaniadoTomaBurbujaYNoPierdeVidaPor2Turnos(){
		//Vida pre bonus
		ratchet.transformar();
		ratchet.recibirAtaque(new Ataque(10));
		assertEquals(ratchet.getPuntosDeVida(),140);
		
		//turno de obtencion
		ratchet.recibirColocable(new BurbujaInmaculada());
		assertEquals(ratchet.getPuntosDeVida(),140);
		ratchet.recibirAtaque(new Ataque(100));
		ratchet.notificar();
		
		//primer turno con burbuja
		assertEquals(ratchet.getPuntosDeVida(),140);
		ratchet.recibirAtaque(new Ataque(60));
		ratchet.notificar();
		
		//segundo turno con burbuja.Recupero vidaActual perdida antes
		assertEquals(ratchet.getPuntosDeVida(),140);
		ratchet.recibirAtaque(new Ataque(60));
		ratchet.notificar();
		
		//tercer turno con burbuja.Recupera vidaActual perdida antes
		assertEquals(ratchet.getPuntosDeVida(),140);
		ratchet.recibirAtaque(new Ataque(60));
		assertEquals(ratchet.getPuntosDeVida(),80);
		ratchet.notificar();
		
		//Cuarto turno con burbuja. No recupera vidaActual
		assertEquals(ratchet.getPuntosDeVida(),80);
	}

	@Test
	public void test13MegatronConVidaTotalTomaBurbujaYNoPierdeVidaPor2Turnos(){

		//Vida pre bonus
		assertEquals(megatron.getPuntosDeVida(),550);
		
		//turno de obtencion
		megatron.recibirColocable(new BurbujaInmaculada());
		assertEquals(megatron.getPuntosDeVida(),550);
		megatron.recibirAtaque(new Ataque(100));
		megatron.notificar();
		
		//primer turno con burbuja
		assertEquals(megatron.getPuntosDeVida(),550);
		megatron.recibirAtaque(new Ataque(60));
		megatron.notificar();
		
		//segundo turno con burbuja.Recupero vidaActual perdida antes
		assertEquals(megatron.getPuntosDeVida(),550);
		megatron.recibirAtaque(new Ataque(60));
		megatron.notificar();
		
		//tercer turno con burbuja.Recupera vidaActual perdida antes
		assertEquals(megatron.getPuntosDeVida(),550);
		megatron.recibirAtaque(new Ataque(60));
		assertEquals(megatron.getPuntosDeVida(),490);
		megatron.notificar();
		
		//Cuarto turno con burbuja. No recupera vidaActual
		assertEquals(megatron.getPuntosDeVida(),490);
	}

	@Test
	public void test14MegatronDaniadoTomaBurbujaYNoPierdeVidaPor2Turnos(){
		
		//Vida pre bonus
		megatron.recibirAtaque(new Ataque(50));
		assertEquals(megatron.getPuntosDeVida(),500);
		
		
		//turno de obtencion
		megatron.recibirColocable(new BurbujaInmaculada());
		assertEquals(megatron.getPuntosDeVida(),500);
		megatron.recibirAtaque(new Ataque(100));
		megatron.notificar();
		
		//primer turno con burbuja
		assertEquals(megatron.getPuntosDeVida(),500);
		megatron.recibirAtaque(new Ataque(60));
		megatron.notificar();
		
		//segundo turno con burbuja.Recupero vidaActual perdida antes
		assertEquals(megatron.getPuntosDeVida(),500);
		megatron.recibirAtaque(new Ataque(60));
		megatron.notificar();
		
		//tercer turno con burbuja.Recupera vidaActual perdida antes
		assertEquals(megatron.getPuntosDeVida(),500);
		megatron.recibirAtaque(new Ataque(60));
		assertEquals(megatron.getPuntosDeVida(),440);
		megatron.notificar();
		
		//Cuarto turno con burbuja. No recupera vidaActual
		assertEquals(megatron.getPuntosDeVida(),440);
	}
	
	@Test
	public void test15MegatronAlternoConVidaTotalTomaBurbujaYNoPierdeVidaPor2Turnos(){
		//Vida pre bonus
		megatron.transformar();
		assertEquals(megatron.getPuntosDeVida(),550);
		
		//turno de obtencion
		megatron.recibirColocable(new BurbujaInmaculada());
		assertEquals(megatron.getPuntosDeVida(),550);
		megatron.recibirAtaque(new Ataque(100));
		megatron.notificar();
		
		//primer turno con burbuja
		assertEquals(megatron.getPuntosDeVida(),550);
		megatron.recibirAtaque(new Ataque(60));
		megatron.notificar();
		
		//segundo turno con burbuja.Recupero vidaActual perdida antes
		assertEquals(megatron.getPuntosDeVida(),550);
		megatron.recibirAtaque(new Ataque(60));
		megatron.notificar();
		
		//tercer turno con burbuja.Recupera vidaActual perdida antes
		assertEquals(megatron.getPuntosDeVida(),550);
		megatron.recibirAtaque(new Ataque(60));
		assertEquals(megatron.getPuntosDeVida(),490);
		megatron.notificar();
		
		//Cuarto turno con burbuja. No recupera vidaActual
		assertEquals(megatron.getPuntosDeVida(),490);
	}

	@Test
	public void test16MegatronAlternoDaniadoTomaBurbujaYNoPierdeVidaPor2Turnos(){
		//Vida pre bonus
		megatron.transformar();
		megatron.recibirAtaque(new Ataque(50));
		assertEquals(megatron.getPuntosDeVida(),500);
		
		//turno de obtencion
		megatron.recibirColocable(new BurbujaInmaculada());
		assertEquals(megatron.getPuntosDeVida(),500);
		megatron.recibirAtaque(new Ataque(100));
		megatron.notificar();
		
		//primer turno con burbuja
		assertEquals(megatron.getPuntosDeVida(),500);
		megatron.recibirAtaque(new Ataque(60));
		megatron.notificar();
		
		//segundo turno con burbuja.Recupero vidaActual perdida antes
		assertEquals(megatron.getPuntosDeVida(),500);
		megatron.recibirAtaque(new Ataque(60));
		megatron.notificar();
		
		//tercer turno con burbuja.Recupera vidaActual perdida antes
		assertEquals(megatron.getPuntosDeVida(),500);
		megatron.recibirAtaque(new Ataque(60));
		assertEquals(megatron.getPuntosDeVida(),440);
		megatron.notificar();
		
		//Cuarto turno con burbuja. No recupera vidaActual
		assertEquals(megatron.getPuntosDeVida(),440);
	}

	@Test
	public void test17BonecrusherConVidaTotalTomaBurbujaYNoPierdeVidaPor2Turnos(){

		//Vida pre bonus
		assertEquals(boneCrusher.getPuntosDeVida(),200);
		
		//turno de obtencion
		boneCrusher.recibirColocable(new BurbujaInmaculada());
		assertEquals(boneCrusher.getPuntosDeVida(),200);
		boneCrusher.recibirAtaque(new Ataque(100));
		boneCrusher.notificar();
		
		//primer turno con burbuja
		assertEquals(boneCrusher.getPuntosDeVida(),200);
		boneCrusher.recibirAtaque(new Ataque(60));
		boneCrusher.notificar();
		
		//segundo turno con burbuja.Recupero vidaActual perdida antes
		assertEquals(boneCrusher.getPuntosDeVida(),200);
		boneCrusher.recibirAtaque(new Ataque(60));
		boneCrusher.notificar();
		
		//tercer turno con burbuja.Recupera vidaActual perdida antes
		assertEquals(boneCrusher.getPuntosDeVida(),200);
		boneCrusher.recibirAtaque(new Ataque(60));
		assertEquals(boneCrusher.getPuntosDeVida(),140);
		boneCrusher.notificar();
		
		//Cuarto turno con burbuja. No recupera vidaActual
		assertEquals(boneCrusher.getPuntosDeVida(),140);
	}

	@Test
	public void test18BonecrusherDaniadoTomaBurbujaYNoPierdeVidaPor2Turnos(){
		//Vida pre bonus
		boneCrusher.recibirAtaque(new Ataque(100));
		assertEquals(boneCrusher.getPuntosDeVida(),100);
		
		//turno de obtencion
		boneCrusher.recibirColocable(new BurbujaInmaculada());
		assertEquals(boneCrusher.getPuntosDeVida(),100);
		boneCrusher.recibirAtaque(new Ataque(20));
		boneCrusher.notificar();
				
		//primer turno con burbuja
		assertEquals(boneCrusher.getPuntosDeVida(),100);
		boneCrusher.recibirAtaque(new Ataque(20));
		boneCrusher.notificar();
				
		//segundo turno con burbuja.Recupero vidaActual perdida antes
		assertEquals(boneCrusher.getPuntosDeVida(),100);
		boneCrusher.recibirAtaque(new Ataque(20));
		boneCrusher.notificar();
				
		//tercer turno con burbuja.Recupera vidaActual perdida antes
		assertEquals(boneCrusher.getPuntosDeVida(),100);
		boneCrusher.recibirAtaque(new Ataque(20));
		assertEquals(boneCrusher.getPuntosDeVida(),80);
		boneCrusher.notificar();
				
		//Cuarto turno con burbuja. No recupera vidaActual
		assertEquals(boneCrusher.getPuntosDeVida(),80);

	}
	
	@Test
	public void test19BonecrusherAlternoConVidaTotalTomaBurbujaYNoPierdeVidaPor2Turnos(){

		//Vida pre bonus
		boneCrusher.transformar();
		assertEquals(boneCrusher.getPuntosDeVida(),200);
		
		//turno de obtencion
		boneCrusher.recibirColocable(new BurbujaInmaculada());
		assertEquals(boneCrusher.getPuntosDeVida(),200);
		boneCrusher.recibirAtaque(new Ataque(100));
		boneCrusher.notificar();
		
		//primer turno con burbuja
		assertEquals(boneCrusher.getPuntosDeVida(),200);
		boneCrusher.recibirAtaque(new Ataque(60));
		boneCrusher.notificar();
		
		//segundo turno con burbuja.Recupero vidaActual perdida antes
		assertEquals(boneCrusher.getPuntosDeVida(),200);
		boneCrusher.recibirAtaque(new Ataque(60));
		boneCrusher.notificar();
		
		//tercer turno con burbuja.Recupera vidaActual perdida antes
		assertEquals(boneCrusher.getPuntosDeVida(),200);
		boneCrusher.recibirAtaque(new Ataque(60));
		assertEquals(boneCrusher.getPuntosDeVida(),140);
		boneCrusher.notificar();
		
		//Cuarto turno con burbuja. No recupera vidaActual
		assertEquals(boneCrusher.getPuntosDeVida(),140);
	}

	@Test
	public void test20BonecrusherAlternoDaniadoTomaBurbujaYNoPierdeVidaPor2Turnos(){
		
		//Vida pre bonus
		boneCrusher.transformar();
		boneCrusher.recibirAtaque(new Ataque(100));
		assertEquals(boneCrusher.getPuntosDeVida(),100);
		
		//turno de obtencion
		boneCrusher.recibirColocable(new BurbujaInmaculada());
		assertEquals(boneCrusher.getPuntosDeVida(),100);
		boneCrusher.recibirAtaque(new Ataque(20));
		boneCrusher.notificar();
				
		//primer turno con burbuja
		assertEquals(boneCrusher.getPuntosDeVida(),100);
		boneCrusher.recibirAtaque(new Ataque(20));
		boneCrusher.notificar();
				
		//segundo turno con burbuja.Recupero vidaActual perdida antes
		assertEquals(boneCrusher.getPuntosDeVida(),100);
		boneCrusher.recibirAtaque(new Ataque(20));
		boneCrusher.notificar();
				
		//tercer turno con burbuja.Recupera vidaActual perdida antes
		assertEquals(boneCrusher.getPuntosDeVida(),100);
		boneCrusher.recibirAtaque(new Ataque(20));
		assertEquals(boneCrusher.getPuntosDeVida(),80);
		boneCrusher.notificar();
				
		//Cuarto turno con burbuja. No recupera vidaActual
		assertEquals(boneCrusher.getPuntosDeVida(),80);
	}

	@Test
	public void test21FrenzyConVidaTotalTomaBurbujaYNoPierdeVidaPor2Turnos(){

		//Vida pre bonus
		assertEquals(frenzy.getPuntosDeVida(),400);
		
		//turno de obtencion
		frenzy.recibirColocable(new BurbujaInmaculada());
		assertEquals(frenzy.getPuntosDeVida(),400);
		frenzy.recibirAtaque(new Ataque(100));
		frenzy.notificar();
		
		//primer turno con burbuja
		assertEquals(frenzy.getPuntosDeVida(),400);
		frenzy.recibirAtaque(new Ataque(60));
		frenzy.notificar();
		
		//segundo turno con burbuja.Recupero vidaActual perdida antes
		assertEquals(frenzy.getPuntosDeVida(),400);
		frenzy.recibirAtaque(new Ataque(60));
		frenzy.notificar();
		
		//tercer turno con burbuja.Recupera vidaActual perdida antes
		assertEquals(frenzy.getPuntosDeVida(),400);
		frenzy.recibirAtaque(new Ataque(60));
		assertEquals(frenzy.getPuntosDeVida(),340);
		frenzy.notificar();
		
		//Cuarto turno con burbuja. No recupera vidaActual
		assertEquals(frenzy.getPuntosDeVida(),340);
	}

	@Test
	public void test22FrenzyDaniadoTomaBurbujaYNoPierdeVidaPor2Turnos(){
		//Vida pre bonus
		frenzy.recibirAtaque(new Ataque(100));
		assertEquals(frenzy.getPuntosDeVida(),300);
		
		//turno de obtencion
		frenzy.recibirColocable(new BurbujaInmaculada());
		assertEquals(frenzy.getPuntosDeVida(),300);
		frenzy.recibirAtaque(new Ataque(100));
		frenzy.notificar();
		
		//primer turno con burbuja
		assertEquals(frenzy.getPuntosDeVida(),300);
		frenzy.recibirAtaque(new Ataque(60));
		frenzy.notificar();
		
		//segundo turno con burbuja.Recupero vidaActual perdida antes
		assertEquals(frenzy.getPuntosDeVida(),300);
		frenzy.recibirAtaque(new Ataque(60));
		frenzy.notificar();
		
		//tercer turno con burbuja.Recupera vidaActual perdida antes
		assertEquals(frenzy.getPuntosDeVida(),300);
		frenzy.recibirAtaque(new Ataque(60));
		assertEquals(frenzy.getPuntosDeVida(),240);
		frenzy.notificar();
		
		//Cuarto turno con burbuja. No recupera vidaActual
		assertEquals(frenzy.getPuntosDeVida(),240);

	}
	
	@Test
	public void test23FrenzyAlternoConVidaTotalTomaBurbujaYNoPierdeVidaPor2Turnos(){

		//Vida pre bonus
		boneCrusher.transformar();
		assertEquals(frenzy.getPuntosDeVida(),400);
		
		//turno de obtencion
		frenzy.recibirColocable(new BurbujaInmaculada());
		assertEquals(frenzy.getPuntosDeVida(),400);
		frenzy.recibirAtaque(new Ataque(100));
		frenzy.notificar();
		
		//primer turno con burbuja
		assertEquals(frenzy.getPuntosDeVida(),400);
		frenzy.recibirAtaque(new Ataque(60));
		frenzy.notificar();
		
		//segundo turno con burbuja.Recupero vidaActual perdida antes
		assertEquals(frenzy.getPuntosDeVida(),400);
		frenzy.recibirAtaque(new Ataque(60));
		frenzy.notificar();
		
		//tercer turno con burbuja.Recupera vidaActual perdida antes
		assertEquals(frenzy.getPuntosDeVida(),400);
		frenzy.recibirAtaque(new Ataque(60));
		assertEquals(frenzy.getPuntosDeVida(),340);
		frenzy.notificar();
		
		//Cuarto turno con burbuja. No recupera vidaActual
		assertEquals(frenzy.getPuntosDeVida(),340);
	}

	@Test
	public void test24FrenzyAlternoDaniadoTomaBurbujaYNoPierdeVidaPor2Turnos(){
	
		//Vida pre bonus
		frenzy.notificar();
		frenzy.transformar();
		frenzy.recibirAtaque(new Ataque(100));
		assertEquals(frenzy.getPuntosDeVida(),300);
		
		//turno de obtencion
		frenzy.recibirColocable(new BurbujaInmaculada());
		assertEquals(frenzy.getPuntosDeVida(),300);
		frenzy.recibirAtaque(new Ataque(100));
		frenzy.notificar();
		
		//primer turno con burbuja
		assertEquals(frenzy.getPuntosDeVida(),300);
		frenzy.recibirAtaque(new Ataque(60));
		frenzy.notificar();
		
		//segundo turno con burbuja.Recupero vidaActual perdida antes
		assertEquals(frenzy.getPuntosDeVida(),300);
		frenzy.recibirAtaque(new Ataque(60));
		frenzy.notificar();
		
		//tercer turno con burbuja.Recupera vidaActual perdida antes
		assertEquals(frenzy.getPuntosDeVida(),300);
		frenzy.recibirAtaque(new Ataque(60));
		assertEquals(frenzy.getPuntosDeVida(),240);
		frenzy.notificar();
		
		//Cuarto turno con burbuja. No recupera vidaActual
		assertEquals(frenzy.getPuntosDeVida(),240);
	}

}

