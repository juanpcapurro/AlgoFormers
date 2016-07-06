package modelo.tablero.colocable.robots.autobot;

import modelo.tablero.colocable.robots.NoPuedeTransformarsePorSerCombinado;
import modelo.tablero.colocable.robots.armas.Ataque;
import modelo.tablero.superficie.Superficie;
import modelo.tablero.superficieAerea.Nube;
import modelo.tablero.superficieAerea.TormentaPsionica;
import modelo.tablero.superficieTerrestre.Espinas;
import modelo.tablero.superficieTerrestre.Pantanoso;
import modelo.tablero.superficieTerrestre.Rocoso;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OptimusTest {

    Optimus mauricio;

	@Before
		public void Setup(){
		mauricio= new Optimus();
	}
    @Test
    public void test01OptimusRecibeAtaqueYSigueConVida() {

        mauricio.recibirAtaque(new Ataque(4));
        assertTrue(mauricio.estaVivo());
    }

    @Test
    public void test02OptimusRecibeAtaqueYMuere() {

        mauricio.recibirAtaque(new Ataque(550));
        assertFalse(mauricio.estaVivo());
    }
	
	@Test
	public void test04StatsModoHumanoide (){
		assertEquals(mauricio.getAtaque(), 50);
		assertEquals(mauricio.getDistanciaDeAtaque(), 2);
		assertEquals(mauricio.getVelocidad(),2 );
	}
	
	@Test
	public void test04StatsModoAlterno()throws NoPuedeTransformarsePorSerCombinado {
		mauricio.transformar();
		assertEquals(mauricio.getAtaque(), 15);
		assertEquals(mauricio.getDistanciaDeAtaque(), 4);
		assertEquals(mauricio.getVelocidad(),5);
	}

	@Test
	public void test05OptimusAfectadoAlPasarPorEspinas(){
		Superficie superficieTerrestre =new Espinas();
		Superficie superficieAerea=new Nube();
		int vida=mauricio.getPuntosDeVida();
		mauricio.pasarPor(superficieTerrestre,superficieAerea);
		assertTrue(mauricio.getPuntosDeVida()<vida);
	}
	
	@Test
	public void test06OptimusAlternoAfectadoAlPasarPorEspinas()throws NoPuedeTransformarsePorSerCombinado{
		Superficie superficieTerrestre =new Espinas();
		Superficie superficieAerea=new Nube();
		int vida=mauricio.getPuntosDeVida();
		mauricio.transformar();
		mauricio.pasarPor(superficieTerrestre,superficieAerea);
		assertTrue(mauricio.getPuntosDeVida()<vida);
	}
	
	@Test
	public void test07OptimusNoafectadoAlPasarPorTormentaPsionica(){
		Superficie superficieTerrestre =new Rocoso();
		Superficie superficieAerea=new TormentaPsionica();
		int ataque=mauricio.getAtaque();
		mauricio.pasarPor(superficieTerrestre,superficieAerea);
		assertEquals(mauricio.getAtaque(),ataque);
	}
	
	@Test
	public void test08OptimusAlternoNoafectadoAlPasarPorTormentaPsionica()throws NoPuedeTransformarsePorSerCombinado{
		Superficie superficieTerrestre =new Rocoso();
		Superficie superficieAerea=new TormentaPsionica();
		mauricio.transformar();
		int ataque=mauricio.getAtaque();
		mauricio.pasarPor(superficieTerrestre,superficieAerea);
		assertEquals(mauricio.getAtaque(),ataque);
	}
	
	@Test
	public void test09OptimusAfectadoAlPasarPorPantanoso(){
		Superficie superficieTerrestre =new Pantanoso();
		Superficie superficieAerea=new Nube();
		int velocidad=mauricio.getVelocidad();
		mauricio.pasarPor(superficieTerrestre,superficieAerea);
		assertTrue(mauricio.getVelocidad()<velocidad);
	}
	
	@Test
	public void test10OptimusAlternoAfectadoAlPasarPorPantanoso()throws NoPuedeTransformarsePorSerCombinado{
		Superficie superficieTerrestre =new Pantanoso();
		Superficie superficieAerea=new Nube();
		mauricio.transformar(); 
		int velocidad=mauricio.getVelocidad();
		mauricio.pasarPor(superficieTerrestre,superficieAerea);
		assertTrue(mauricio.getVelocidad()<velocidad);
	}
}
