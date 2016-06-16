package algoFormers.tablero.colocable.robots.autobot;

import algoFormers.tablero.colocable.robots.armas.DisparoConvencional;
import algoFormers.tablero.superficie.Superficie;
import algoFormers.tablero.superficieAerea.Nube;
import algoFormers.tablero.superficieTerrestre.Espinas;
import algoFormers.tablero.superficieTerrestre.Rocoso;

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
	public void afectadoAlPasarPorEspinas(){
		Superficie superficieTerrestre =new Espinas();
		Superficie superficieAerea=new Nube();
		int vida=mauricio.getPuntosDeVida();
		mauricio.pasarPor(superficieTerrestre,superficieAerea);
		assertTrue(mauricio.getPuntosDeVida()<vida);
	}

	@Test
	public void noafectadoAlPasarPorRocoso(){
		Superficie superficieTerrestre =new Rocoso();
		Superficie superficieAerea=new Nube();
		int vida=mauricio.getPuntosDeVida();
		mauricio.pasarPor(superficieTerrestre,superficieAerea);
		assertTrue(mauricio.getPuntosDeVida()==vida);
	}
}
