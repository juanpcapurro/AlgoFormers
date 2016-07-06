package modelo.tablero.colocable.robots.autobot;

import modelo.tablero.colocable.bonus.DobleCanion;
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

public class SuperionTest {
    private Optimus optimus;
    private Bumblebee bumblebee;
    private Ratchet ratchet;
    private Superion superion;
    private Superion superionAutobotsHeridos;

    @Before
    public void setUp() throws Exception {
        optimus = new Optimus();
        bumblebee = new Bumblebee();
        ratchet = new Ratchet();

        superion = new Superion(optimus, bumblebee, ratchet);

    }

    @Test
    public void  test01SuperionCreadoConUnOptimusUnBumblebeeYUnRatchet() {
        assertTrue(superion.estaVivo());

    }
    @Test
    public void  test02SuperionSusPuntosDeVidaEsLaSumaDeLosAutobosQueLoForman() {
        assertTrue(superion.getPuntosDeVida() == 1000);

    }
    @Test
    public void  test03SuperionRecibeAtaqueYSigueConVida() {
        superion.recibirAtaque(new Ataque(100));

        assertTrue(superion.estaVivo());
        assertTrue(superion.getPuntosDeVida() == 900);
    }

    @Test
    public void  test04SuperionRecibeAtaqueYMuere() {
        superion.recibirAtaque(new Ataque(1000));
        assertFalse(superion.estaVivo());
    }

    @Test
    public void  test05SuperionCreadoConAutobotsHeridos() {

        optimus.recibirAtaque(new Ataque(400));
        bumblebee.recibirAtaque(new Ataque(250));
        ratchet.recibirAtaque(new Ataque(50));

        assertTrue(optimus.getPuntosDeVida()==100);
        assertTrue(bumblebee.getPuntosDeVida()==100);
        assertTrue(ratchet.getPuntosDeVida()==100);

        superionAutobotsHeridos = new Superion(optimus, bumblebee, ratchet);
        assertTrue(superionAutobotsHeridos.estaVivo());
        assertTrue(superionAutobotsHeridos.getPuntosDeVida()==300);
    }
    @Test
    public void  test06SuperionCreadoConAutobotsHeridosRecibeAtaqueYSigueConVida() {
        optimus.recibirAtaque(new Ataque(400));
        bumblebee.recibirAtaque(new Ataque(250));
        ratchet.recibirAtaque(new Ataque(50));

        assertTrue(optimus.getPuntosDeVida()==100);
        assertTrue(bumblebee.getPuntosDeVida()==100);
        assertTrue(ratchet.getPuntosDeVida()==100);

        superionAutobotsHeridos = new Superion(optimus, bumblebee, ratchet);
        superionAutobotsHeridos.recibirAtaque(new Ataque(10));

        assertTrue(superionAutobotsHeridos.estaVivo());
        assertTrue(superionAutobotsHeridos.getPuntosDeVida()==290);
    }
    @Test
    public void  test07SuperionCreadoConAutobotsHeridosRecibeAtaqueYMuere() {
        optimus.recibirAtaque(new Ataque(400));
        bumblebee.recibirAtaque(new Ataque(250));
        ratchet.recibirAtaque(new Ataque(50));

        assertTrue(optimus.getPuntosDeVida()==100);
        assertTrue(bumblebee.getPuntosDeVida()==100);
        assertTrue(ratchet.getPuntosDeVida()==100);

        superionAutobotsHeridos = new Superion(optimus, bumblebee, ratchet);
        superionAutobotsHeridos.recibirAtaque(new Ataque(300));

        assertFalse(superionAutobotsHeridos.estaVivo());
        assertTrue(superionAutobotsHeridos.getPuntosDeVida()==0);
     }

	@Test
	public void test08StatsModoHumanoide (){
		assertEquals(superion.getAtaque(), 100);
		assertEquals(superion.getDistanciaDeAtaque(), 2);
		assertEquals(superion.getVelocidad(),3 );
	}
	
	@Test
	public void test10SuperionAfectadoAlPasarPorEspinas(){
		Superficie superficieTerrestre =new Espinas();
		Superficie superficieAerea=new Nube();
		int vida=superion.getPuntosDeVida();
		superion.pasarPor(superficieTerrestre,superficieAerea);
		assertTrue(superion.getPuntosDeVida()<vida);
	}
	

	@Test
	public void test11SuperionNoafectadoAlPasarPorTormentaPsionica(){
		Superficie superficieTerrestre =new Rocoso();
		Superficie superficieAerea=new TormentaPsionica();
		int ataque=superion.getAtaque();
		superion.pasarPor(superficieTerrestre,superficieAerea);
		assertEquals(superion.getAtaque(),ataque);
	}
	
	
	@Test
	public void test12SuperionAfectadoAlPasarPorPantanoso(){
		Superficie superficieTerrestre =new Pantanoso();
		Superficie superficieAerea=new Nube();
		int velocidad=superion.getVelocidad();
		superion.pasarPor(superficieTerrestre,superficieAerea);
		assertTrue(superion.getVelocidad()<velocidad);
	}
	
	
	@Test
	public void test13ataqueBonusSeDuplicaEnModoHumanoide(){
		int ataque=superion.getAtaque();
		superion.recibirColocable(new DobleCanion());
		assertTrue(ataque<superion.getAtaque());
	}

	@Test(expected = NoPuedeTransformarsePorSerCombinado.class)
	public void superionNoPuedeTransformarse()throws NoPuedeTransformarsePorSerCombinado {
		superion.transformar();
	}
}
