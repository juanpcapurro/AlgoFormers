package algoFormers.tablero.colocable.robots.decepticon;

import algoFormers.tablero.colocable.robots.armas.DisparoConvencional;
import algoFormers.tablero.superficie.Superficie;
import algoFormers.tablero.superficieAerea.Nube;
import algoFormers.tablero.superficieAerea.TormentaPsionica;
import algoFormers.tablero.superficieTerrestre.Espinas;
import algoFormers.tablero.superficieTerrestre.Pantanoso;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FrenzyTest {
    private Frenzy mauricio;
    @Before
    public void setUp() throws Exception {
        mauricio = new Frenzy();
    }
    @Test
    public void  test01FrenzyRecibeAtaqueYSigueConVida() {

        mauricio.recibirAtaque(new DisparoConvencional(4));
        assertTrue(mauricio.estaVivo());
    }
    @Test
    public void  test02FrenzyRecibeAtaqueYMuere() {

        mauricio.recibirAtaque(new DisparoConvencional(550));
        assertFalse(mauricio.estaVivo());
    }
	@Test
	public void testStatsModoHumanoide (){
		assertEquals(mauricio.getAtaque(), 10);
		assertEquals(mauricio.getDistanciaDeAtaque(), 5);
		assertEquals(mauricio.getVelocidad(),2 );
	}
	@Test
	public void testStatsModoAlterno(){
		mauricio.transformar();
		assertEquals(mauricio.getAtaque(), 25);
		assertEquals(mauricio.getDistanciaDeAtaque(), 2);
		assertEquals(mauricio.getVelocidad(),6);
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
}
