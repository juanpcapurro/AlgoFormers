package algoFormers.tablero.colocable.robots.autobot;

import algoFormers.tablero.colocable.bonus.DobleCanion;
import algoFormers.tablero.colocable.robots.armas.DisparoConvencional;
import algoFormers.tablero.superficie.Superficie;
import algoFormers.tablero.superficieAerea.Nube;
import algoFormers.tablero.superficieAerea.TormentaPsionica;
import algoFormers.tablero.superficieTerrestre.Espinas;
import algoFormers.tablero.superficieTerrestre.Pantanoso;
import org.junit.Test;

import static org.junit.Assert.*;

public class BumblebeeTest {

    Bumblebee mauricio = new Bumblebee();

    @Test
    public void test01BumblebeeRecibeAtaqueYSigueConVida() {

        mauricio.recibirAtaque(new DisparoConvencional(4));
        assertTrue(mauricio.estaVivo());
    }

    @Test
    public void test02BumblebeeRecibeAtaqueYMuere() {

        mauricio.recibirAtaque(new DisparoConvencional(550));
        assertFalse(mauricio.estaVivo());
    }
	
	@Test
	public void testStatsModoHumanoide (){
		assertEquals(mauricio.getAtaque(), 40);
		assertEquals(mauricio.getDistanciaDeAtaque(), 1);
		assertEquals(mauricio.getVelocidad(),2 );
	}
	
	@Test
	public void testStatsModoAlterno(){
		mauricio.transformar();
		assertEquals(mauricio.getAtaque(), 20);
		assertEquals(mauricio.getDistanciaDeAtaque(), 3);
		assertEquals(mauricio.getVelocidad(),5);
	}

	@Test
	public void unidadTerrestreHumanoideAfectadoAlPasarPorEspinas(){
		Superficie superficieTerrestre =new Espinas();
		Superficie superficieAerea=new Nube();
		int vida=mauricio.getPuntosDeVida();
		mauricio.pasarPor(superficieTerrestre,superficieAerea);
		assertTrue(mauricio.getPuntosDeVida()<vida);
	}
	
	@Test
	public void unidadTerrestreAlternaAfectadoAlPasarPorEspinas(){
		Superficie superficieTerrestre =new Espinas();
		Superficie superficieAerea=new Nube();
		int vida=mauricio.getPuntosDeVida();
		mauricio.pasarPor(superficieTerrestre,superficieAerea);
		assertTrue(mauricio.getPuntosDeVida()<vida);
	}

	
	@Test
	public void unidadTerrestreHumanoideNoafectadoAlPasarPorTormentaPsionica(){
		Superficie superficieTerrestre =new Pantanoso();
		Superficie superficieAerea=new TormentaPsionica();
		mauricio.transformar();
		int velocidad=mauricio.getVelocidad();
		int ataque=mauricio.getAtaque();
		mauricio.pasarPor(superficieTerrestre,superficieAerea);
		assertTrue(mauricio.getVelocidad()<velocidad);
		assertEquals(mauricio.getAtaque(),ataque);
	}
	
	
	@Test
	public void unidadTerrestreAlternaNoafectadoAlPasarPorTormentaPsionica(){
		Superficie superficieTerrestre =new Pantanoso();
		Superficie superficieAerea=new TormentaPsionica();
		mauricio.transformar();
		int velocidad=mauricio.getVelocidad();
		int ataque=mauricio.getAtaque();
		mauricio.pasarPor(superficieTerrestre,superficieAerea);
		assertTrue(mauricio.getVelocidad()<velocidad);
		assertEquals(mauricio.getAtaque(),ataque);
	}

	@Test
	public void ataqueBonusSeDuplicaEnModoHumanoide(){
		int ataque=mauricio.getAtaque();
		mauricio.recibirColocable(new DobleCanion());
		assertTrue(ataque<mauricio.getAtaque());
	}

	@Test
	public void ataqueBonusSeDuplicaEnModoAlterno(){
		mauricio.transformar();
		int ataque=mauricio.getAtaque();
		mauricio.recibirColocable(new DobleCanion());
		assertTrue(ataque<mauricio.getAtaque());
	}


}
