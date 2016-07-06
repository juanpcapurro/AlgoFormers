package modelo.tablero.colocable.robots.autobot;

import modelo.tablero.colocable.robots.NoPuedeTransformarsePorSerCombinado;
import modelo.tablero.colocable.robots.armas.Ataque;
import modelo.tablero.superficie.Superficie;
import modelo.tablero.superficieAerea.Nube;
import modelo.tablero.superficieAerea.TormentaPsionica;
import modelo.tablero.superficieTerrestre.Espinas;
import modelo.tablero.superficieTerrestre.Pantanoso;
import modelo.tablero.superficieTerrestre.Rocoso;

import org.junit.Test;

import static org.junit.Assert.*;

public class RatchetTest {

    Ratchet mauricio = new Ratchet();

    @Test
    public void test01RatchetRecibeAtaqueYSigueConVida() {

        mauricio.recibirAtaque(new Ataque(4));
        assertTrue(mauricio.estaVivo());
    }

    @Test
    public void test02RatchetRecibeAtaqueYMuere() {

        mauricio.recibirAtaque(new Ataque(250));
        assertFalse(mauricio.estaVivo());
    }
	
	@Test
	public void test04StatsModoHumanoide (){
		assertEquals(mauricio.getAtaque(), 5);
		assertEquals(mauricio.getDistanciaDeAtaque(), 5);
		assertEquals(mauricio.getVelocidad(),1 );
	}
	
	@Test
	public void test04StatsModoAlterno()throws NoPuedeTransformarsePorSerCombinado {
		mauricio.transformar();
		assertEquals(mauricio.getAtaque(), 35);
		assertEquals(mauricio.getDistanciaDeAtaque(), 2);
		assertEquals(mauricio.getVelocidad(),8);
	}

	
	
	@Test
	public void test05FrenzyAfectadoAlPasarPorEspinas(){
		Superficie superficieTerrestre =new Espinas();
		Superficie superficieAerea=new Nube();
		int vida=mauricio.getPuntosDeVida();
		mauricio.pasarPor(superficieTerrestre,superficieAerea);
		assertTrue(mauricio.getPuntosDeVida()<vida);
	}
	
	@Test
	public void test06FrenzyAlternoAfectadoAlPasarPorEspinas()throws NoPuedeTransformarsePorSerCombinado{
		Superficie superficieTerrestre =new Espinas();
		Superficie superficieAerea=new Nube();
		int vida=mauricio.getPuntosDeVida();
		mauricio.transformar();
		mauricio.pasarPor(superficieTerrestre,superficieAerea);
		assertTrue(mauricio.getPuntosDeVida()<vida);
	}
	
	@Test
	public void test07FrenzyNoafectadoAlPasarPorTormentaPsionica(){
		Superficie superficieTerrestre =new Rocoso();
		Superficie superficieAerea=new TormentaPsionica();
		int ataque=mauricio.getAtaque();
		mauricio.pasarPor(superficieTerrestre,superficieAerea);
		assertEquals(mauricio.getAtaque(),ataque);
	}
	
	@Test
	public void test08FrenzyAlternoAfectadoAlPasarPorTormentaPsionica()throws NoPuedeTransformarsePorSerCombinado{
		Superficie superficieTerrestre =new Rocoso();
		Superficie superficieAerea=new TormentaPsionica();
		mauricio.transformar();
		int ataque=mauricio.getAtaque();
		mauricio.pasarPor(superficieTerrestre,superficieAerea);
		assertTrue(mauricio.getAtaque()<ataque);
	}
	

	@Test
	public void test09FrenzyAlternoNoAfectadoAlPasarPorPantanoso()throws NoPuedeTransformarsePorSerCombinado{
		Superficie superficieTerrestre =new Pantanoso();
		Superficie superficieAerea=new Nube();
		mauricio.transformar(); 
		int velocidad=mauricio.getVelocidad();
		mauricio.pasarPor(superficieTerrestre,superficieAerea);
		assertEquals(mauricio.getVelocidad(),velocidad);
	}

}
