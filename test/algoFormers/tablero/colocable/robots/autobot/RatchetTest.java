package algoFormers.tablero.colocable.robots.autobot;

import algoFormers.tablero.colocable.robots.armas.DisparoConvencional;
import algoFormers.tablero.superficie.Superficie;
import algoFormers.tablero.superficieAerea.Nube;
import algoFormers.tablero.superficieAerea.TormentaPsionica;
import algoFormers.tablero.superficieTerrestre.Espinas;
import algoFormers.tablero.superficieTerrestre.Pantanoso;
import algoFormers.tablero.superficieTerrestre.Rocoso;

import org.junit.Test;

import static org.junit.Assert.*;

public class RatchetTest {

    Ratchet mauricio = new Ratchet();

    @Test
    public void test01RatchetRecibeAtaqueYSigueConVida() {

        mauricio.recibirAtaque(new DisparoConvencional(4));
        assertTrue(mauricio.estaVivo());
    }

    @Test
    public void test02RatchetRecibeAtaqueYMuere() {

        mauricio.recibirAtaque(new DisparoConvencional(250));
        assertFalse(mauricio.estaVivo());
    }
	
	@Test
	public void test03StatsModoHumanoide (){
		assertEquals(mauricio.getAtaque(), 5);
		assertEquals(mauricio.getDistanciaDeAtaque(), 5);
		assertEquals(mauricio.getVelocidad(),1 );
	}
	
	@Test
	public void test04StatsModoAlterno(){
		mauricio.transformar();
		assertEquals(mauricio.getAtaque(), 35);
		assertEquals(mauricio.getDistanciaDeAtaque(), 2);
		assertEquals(mauricio.getVelocidad(),8);
	}

	
	@Test
	public void test05RatchetAlternoAfectadoAlPasarPorTormentaPsionica(){
		Superficie superficieTerrestre =new Rocoso();
		Superficie superficieAerea=new TormentaPsionica();
		mauricio.transformar();
		int ataque=mauricio.getAtaque();
		mauricio.pasarPor(superficieTerrestre,superficieAerea);
		assertTrue(mauricio.getAtaque()<ataque);
	}
	
	@Test
	public void test06RatchetNoafectadoAlPasarPorTormentaPsionica(){
		Superficie superficieTerrestre =new Rocoso();
		Superficie superficieAerea=new TormentaPsionica();
		int ataque=mauricio.getAtaque();
		mauricio.pasarPor(superficieTerrestre,superficieAerea);
		assertEquals(mauricio.getAtaque(),ataque);
	}
	
	@Test
	public void test06RatchetAlternoNoAfectadoAlPasarPorNube(){
		Superficie superficieTerrestre =new Pantanoso();
		Superficie superficieAerea=new Nube();
		mauricio.transformar();
		int vida=mauricio.getPuntosDeVida();
		mauricio.pasarPor(superficieTerrestre,superficieAerea);
		assertEquals(mauricio.getPuntosDeVida(),vida);
	}

	@Test
	public void test07RatchetAlternoAfectadoAlPasarPorEspinas(){
		Superficie superficieTerrestre =new Espinas();
		Superficie superficieAerea=new Nube();
		mauricio.transformar();
		int vida=mauricio.getPuntosDeVida();
		mauricio.pasarPor(superficieTerrestre,superficieAerea);
		assertTrue(mauricio.getPuntosDeVida()<vida);
	}
	
	@Test
	public void test08RatchetAfectadoAlPasarPorEspinas(){
		Superficie superficieTerrestre =new Espinas();
		Superficie superficieAerea=new Nube();
		int vida=mauricio.getPuntosDeVida();
		mauricio.pasarPor(superficieTerrestre,superficieAerea);
		assertTrue(mauricio.getPuntosDeVida()<vida);
	}
	
	/*@Test
	public void test09RatchetAfectadoAlPasarPorPantano(){
		Superficie superficieTerrestre =new Pantanoso();
		Superficie superficieAerea=new Nube();
		int velocidad=mauricio.getVelocidad();
		mauricio.pasarPor(superficieTerrestre,superficieAerea);
		assertTrue(mauricio.getVelocidad() < velocidad);
	}*/
	
	/*@Test
	public void test10RatchetAlternoNoAfectadoAlPasarPorPantano(){
		Superficie superficieTerrestre =new Pantanoso();
		Superficie superficieAerea=new Nube();
		int velocidad=mauricio.getVelocidad();
		mauricio.transformar();
		mauricio.pasarPor(superficieTerrestre,superficieAerea);
		assertEquals(mauricio.getVelocidad(),velocidad);
	}*/
	

	
}
