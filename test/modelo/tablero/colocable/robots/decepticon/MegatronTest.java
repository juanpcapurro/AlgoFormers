package modelo.tablero.colocable.robots.decepticon;

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

public class MegatronTest {
    private Megatron mauricio;
    @Before
    public void setUp() throws Exception {
        mauricio = new Megatron();
    }
    @Test
    public void  test01MegatronRecibeAtaqueYSigueConVida() {

        mauricio.recibirAtaque(new Ataque(4));
        assertTrue(mauricio.estaVivo());
    }
    @Test
    public void  test02MegatronRecibeAtaqueYMuere() {

        mauricio.recibirAtaque(new Ataque(650));
        assertFalse(mauricio.estaVivo());
    }
	@Test
	public void test03StatsModoHumanoide (){
		assertEquals(mauricio.getAtaque(), 10);
		assertEquals(mauricio.getDistanciaDeAtaque(), 3);
		assertEquals(mauricio.getVelocidad(),1 );
	}
	@Test
	public void test04StatsModoAlterno()throws NoPuedeTransformarsePorSerCombinado{
		mauricio.transformar();
		assertEquals(mauricio.getAtaque(), 55);
		assertEquals(mauricio.getDistanciaDeAtaque(), 2);
		assertEquals(mauricio.getVelocidad(),8);
	}
	
	
	@Test
	public void test05MegatronAfectadoAlPasarPorEspinas(){
		Superficie superficieTerrestre =new Espinas();
		Superficie superficieAerea=new Nube();
		int vida=mauricio.getPuntosDeVida();
		mauricio.pasarPor(superficieTerrestre,superficieAerea);
		assertTrue(mauricio.getPuntosDeVida()<vida);
	}
	
	@Test
	public void test06MegatronAlternoAfectadoAlPasarPorEspinas()throws NoPuedeTransformarsePorSerCombinado{
		Superficie superficieTerrestre =new Espinas();
		Superficie superficieAerea=new Nube();
		int vida=mauricio.getPuntosDeVida();
		mauricio.transformar();
		mauricio.pasarPor(superficieTerrestre,superficieAerea);
		assertTrue(mauricio.getPuntosDeVida()<vida);
	}
	
	@Test
	public void test07MegatronNoafectadoAlPasarPorTormentaPsionica(){
		Superficie superficieTerrestre =new Rocoso();
		Superficie superficieAerea=new TormentaPsionica();
		int ataque=mauricio.getAtaque();
		mauricio.pasarPor(superficieTerrestre,superficieAerea);
		assertEquals(mauricio.getAtaque(),ataque);
	}
	
	@Test
	public void test08MegatronAlternoAfectadoAlPasarPorTormentaPsionica()throws NoPuedeTransformarsePorSerCombinado {
		Superficie superficieTerrestre =new Rocoso();
		Superficie superficieAerea=new TormentaPsionica();
		mauricio.transformar();
		int ataque=mauricio.getAtaque();
		mauricio.pasarPor(superficieTerrestre,superficieAerea);
		assertTrue(mauricio.getAtaque()<ataque);
	}
	

	@Test
	public void test09MegatronAlternoNoAfectadoAlPasarPorPantanoso()throws NoPuedeTransformarsePorSerCombinado{
		Superficie superficieTerrestre =new Pantanoso();
		Superficie superficieAerea=new Nube();
		mauricio.transformar(); 
		int velocidad=mauricio.getVelocidad();
		mauricio.pasarPor(superficieTerrestre,superficieAerea);
		assertEquals(mauricio.getVelocidad(),velocidad);
	}
}

