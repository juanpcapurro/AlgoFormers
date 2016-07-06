package modelo.tablero.colocable.robots.autobot;

import modelo.tablero.colocable.bonus.DobleCanion;
import modelo.tablero.colocable.robots.NoPuedeTransformarsePorSerCombinado;
import modelo.tablero.colocable.robots.ObjetoInmovible;
import modelo.tablero.colocable.robots.armas.Ataque;
import modelo.tablero.superficie.Superficie;
import modelo.tablero.superficieAerea.Nube;
import modelo.tablero.superficieAerea.TormentaPsionica;
import modelo.tablero.superficieTerrestre.Espinas;
import modelo.tablero.superficieTerrestre.Pantanoso;
import modelo.tablero.superficieTerrestre.Rocoso;
import org.junit.Test;

import static org.junit.Assert.*;

public class BumblebeeTest {

    Bumblebee mauricio = new Bumblebee();

    @Test
    public void test01BumblebeeRecibeAtaqueYSigueConVida() {

        mauricio.recibirAtaque(new Ataque(4));
        assertTrue(mauricio.estaVivo());
    }

    @Test
    public void test02BumblebeeRecibeAtaqueYMuere() {

        mauricio.recibirAtaque(new Ataque(550));
        assertFalse(mauricio.estaVivo());
    }
	
	@Test
	public void test03StatsModoHumanoide (){
		assertEquals(mauricio.getAtaque(), 40);
		assertEquals(mauricio.getDistanciaDeAtaque(), 1);
		assertEquals(mauricio.getVelocidad(),2 );
	}
	
	@Test
	public void test04StatsModoAlterno()throws NoPuedeTransformarsePorSerCombinado{
		mauricio.transformar();
		assertEquals(mauricio.getAtaque(), 20);
		assertEquals(mauricio.getDistanciaDeAtaque(), 3);
		assertEquals(mauricio.getVelocidad(),5);
	}

	@Test
	public void test05BumblebeeAfectadoAlPasarPorEspinas(){
		Superficie superficieTerrestre =new Espinas();
		Superficie superficieAerea=new Nube();
		int vida=mauricio.getPuntosDeVida();
		mauricio.pasarPor(superficieTerrestre,superficieAerea);
		assertTrue(mauricio.getPuntosDeVida()<vida);
	}
	
	@Test
	public void test06BumblebeeAlternoAfectadoAlPasarPorEspinas()throws NoPuedeTransformarsePorSerCombinado{
		Superficie superficieTerrestre =new Espinas();
		Superficie superficieAerea=new Nube();
		int vida=mauricio.getPuntosDeVida();
		mauricio.transformar();
		mauricio.pasarPor(superficieTerrestre,superficieAerea);
		assertTrue(mauricio.getPuntosDeVida()<vida);
	}
	
	@Test
	public void test07BumblebeeNoafectadoAlPasarPorTormentaPsionica(){
		Superficie superficieTerrestre =new Rocoso();
		Superficie superficieAerea=new TormentaPsionica();
		int ataque=mauricio.getAtaque();
		mauricio.pasarPor(superficieTerrestre,superficieAerea);
		assertEquals(mauricio.getAtaque(),ataque);
	}
	
	@Test
	public void test08BumblebeeAlternoNoafectadoAlPasarPorTormentaPsionica()throws NoPuedeTransformarsePorSerCombinado{
		Superficie superficieTerrestre =new Rocoso();
		Superficie superficieAerea=new TormentaPsionica();
		mauricio.transformar();
		int ataque=mauricio.getAtaque();
		mauricio.pasarPor(superficieTerrestre,superficieAerea);
		assertEquals(mauricio.getAtaque(),ataque);
	}
	
	@Test(expected =ObjetoInmovible.class)
	public void test09BumblebeeAfectadoAlPasarPorPantanoso(){
		Superficie superficieTerrestre =new Pantanoso();
		Superficie superficieAerea=new Nube();
		mauricio.pasarPor(superficieTerrestre,superficieAerea);
		mauricio.esMovible();
	}

	@Test
	public void test10BumblebeeAlternoAfectadoAlPasarPorPantanoso()throws NoPuedeTransformarsePorSerCombinado{
		Superficie superficieTerrestre =new Pantanoso();
		Superficie superficieAerea=new Nube();
		mauricio.transformar(); 
		mauricio.pasarPor(superficieTerrestre,superficieAerea);
		assertTrue(mauricio.esMovible());
	}
	
	
	@Test
	public void test11ataqueBonusSeDuplicaEnModoHumanoide(){
		int ataque=mauricio.getAtaque();
		mauricio.recibirColocable(new DobleCanion());
		assertTrue(ataque<mauricio.getAtaque());
	}

	@Test
	public void test12ataqueBonusSeDuplicaEnModoAlterno()throws NoPuedeTransformarsePorSerCombinado{
		mauricio.transformar();
		int ataque=mauricio.getAtaque();
		mauricio.recibirColocable(new DobleCanion());
		assertTrue(ataque<mauricio.getAtaque());
	}
}
