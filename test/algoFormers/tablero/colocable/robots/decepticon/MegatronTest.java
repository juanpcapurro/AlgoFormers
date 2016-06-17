package algoFormers.tablero.colocable.robots.decepticon;

import algoFormers.tablero.colocable.robots.armas.DisparoConvencional;
import algoFormers.tablero.superficie.Superficie;
import algoFormers.tablero.superficieAerea.Nube;
import algoFormers.tablero.superficieAerea.TormentaPsionica;
import algoFormers.tablero.superficieTerrestre.Pantanoso;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MegatronTest {
    private Megatron mauricio;
    @Before
    public void setUp() throws Exception {
        mauricio = new Megatron();
    }
    @Test
    public void test01MegatronRecibeAtaqueYSigueConVida() {

        mauricio.recibirAtaque(new DisparoConvencional(4));
        assertTrue(mauricio.estaVivo());
    }
    @Test
    public void test02MegatronRecibeAtaqueYMuere() {

        mauricio.recibirAtaque(new DisparoConvencional(650));
        assertFalse(mauricio.estaVivo());
    }
	@Test
	public void test03MegatronStatsModoHumanoide (){
		assertEquals(mauricio.getAtaque(), 10);
		assertEquals(mauricio.getDistanciaDeAtaque(), 3);
		assertEquals(mauricio.getVelocidad(),1 );
	}
	@Test
	public void test04MegatronStatsModoAlterno(){
		mauricio.transformar();
		assertEquals(mauricio.getAtaque(), 55);
		assertEquals(mauricio.getDistanciaDeAtaque(), 2);
		assertEquals(mauricio.getVelocidad(),8);
	}
	
	
	@Test
	public void test05MegatronAlternoAfectadoAlPasarPorTormentaPsionica(){
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

