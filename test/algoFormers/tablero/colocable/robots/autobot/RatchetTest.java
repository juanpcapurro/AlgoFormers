package algoFormers.tablero.colocable.robots.autobot;

import algoFormers.tablero.colocable.robots.armas.DisparoConvencional;
import algoFormers.tablero.superficie.Superficie;
import algoFormers.tablero.superficieAerea.Nube;
import algoFormers.tablero.superficieAerea.TormentaPsionica;
import algoFormers.tablero.superficieTerrestre.Espinas;
import algoFormers.tablero.superficieTerrestre.Pantanoso;
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
	public void testStatsModoHumanoide (){
		assertEquals(mauricio.getAtaque(), 5);
		assertEquals(mauricio.getDistanciaDeAtaque(), 5);
		assertEquals(mauricio.getVelocidad(),1 );
	}
	
	@Test
	public void testStatsModoAlterno(){
		mauricio.transformar();
		assertEquals(mauricio.getAtaque(), 35);
		assertEquals(mauricio.getDistanciaDeAtaque(), 2);
		assertEquals(mauricio.getVelocidad(),8);
	}

	
	@Test
	public void unidadAereaAlternaAfectadaAlPasarPorTormentaPsionica(){
		Superficie superficieTerrestre =new Pantanoso();
		Superficie superficieAerea=new TormentaPsionica();
		mauricio.transformar();
		int velocidad=mauricio.getVelocidad();
		int ataque=mauricio.getAtaque();
		mauricio.pasarPor(superficieTerrestre,superficieAerea);
		assertEquals(velocidad,mauricio.getVelocidad());
		assertTrue(mauricio.getAtaque()<ataque);
	}
	
	@Test
	public void unidadAereaNoAfectadaAlPasarPorNube(){
		Superficie superficieTerrestre =new Pantanoso();
		Superficie superficieAerea=new Nube();
		mauricio.transformar();
		int vida=mauricio.getPuntosDeVida();
		mauricio.pasarPor(superficieTerrestre,superficieAerea);
		assertEquals(mauricio.getPuntosDeVida(),vida);
	}

}
