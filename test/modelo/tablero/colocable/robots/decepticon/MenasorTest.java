package modelo.tablero.colocable.robots.decepticon;

import modelo.tablero.colocable.bonus.DobleCanion;
import modelo.tablero.colocable.robots.NoPuedeTransformarsePorSerCombinado;
import modelo.tablero.colocable.robots.ObjetoInmovible;
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

public class MenasorTest {

    private Megatron megatron;
    private BoneCrusher boneCrusher;
    private Frenzy frenzy;
    private Menasor menasor;
    private Menasor menasorDecepticonsHeridos;

    @Before
    public void setUp() throws Exception {
        megatron = new Megatron();
        boneCrusher = new BoneCrusher();
        frenzy = new Frenzy();

        menasor = new Menasor(megatron, boneCrusher, frenzy);

    }

    @Test
    public void  test01MenasorCreadoConUnMegatronUnBoneCrusherYUnFrenzy() {
        assertTrue(menasor.estaVivo());

    }
    @Test
    public void  test02MenasorSusPuntosDeVidaEsLaSumaDeLosDeceptionsQueLoForman() {
        assertTrue(menasor.getPuntosDeVida() == 1150);

    }
    @Test
    public void  test03MenasorRecibeAtaqueYSigueConVida() {
        menasor.recibirAtaque(new Ataque(100));

        assertTrue(menasor.estaVivo());
        assertTrue(menasor.getPuntosDeVida() == 1050);
    }

    @Test
    public void  test04MenasorRecibeAtaqueYMuere() {
        menasor.recibirAtaque(new Ataque(1150));
        assertFalse(menasor.estaVivo());
    }

    @Test
    public void  test05MenasorCreadoConDecepticonsHeridos() {

        megatron.recibirAtaque(new Ataque(450));
        boneCrusher.recibirAtaque(new Ataque(100));
        frenzy.recibirAtaque(new Ataque(300));

        assertTrue(megatron.getPuntosDeVida()==100);
        assertTrue(boneCrusher.getPuntosDeVida()==100);
        assertTrue(frenzy.getPuntosDeVida()==100);

        menasorDecepticonsHeridos = new Menasor(megatron, boneCrusher, frenzy);
        assertTrue(menasorDecepticonsHeridos.estaVivo());
        assertTrue(menasorDecepticonsHeridos.getPuntosDeVida()==300);
    }
    @Test
    public void  test06MenasorCreadoConDecepticonsHeridosRecibeAtaqueYSigueConVida() {
        megatron.recibirAtaque(new Ataque(450));
        boneCrusher.recibirAtaque(new Ataque(100));
        frenzy.recibirAtaque(new Ataque(300));

        assertTrue(megatron.getPuntosDeVida()==100);
        assertTrue(boneCrusher.getPuntosDeVida()==100);
        assertTrue(frenzy.getPuntosDeVida()==100);

        menasorDecepticonsHeridos = new Menasor(megatron, boneCrusher, frenzy);
        menasorDecepticonsHeridos.recibirAtaque(new Ataque(10));

        assertTrue(menasorDecepticonsHeridos.estaVivo());
        assertTrue(menasorDecepticonsHeridos.getPuntosDeVida()==290);
    }
    @Test
    public void  test07MenasorCreadoConDecepticonsHeridosRecibeAtaqueYMuere() {
        megatron.recibirAtaque(new Ataque(450));
        boneCrusher.recibirAtaque(new Ataque(100));
        frenzy.recibirAtaque(new Ataque(300));

        assertTrue(megatron.getPuntosDeVida()==100);
        assertTrue(boneCrusher.getPuntosDeVida()==100);
        assertTrue(frenzy.getPuntosDeVida()==100);

        menasorDecepticonsHeridos = new Menasor(megatron, boneCrusher, frenzy);
        menasorDecepticonsHeridos.recibirAtaque(new Ataque(300));

        assertFalse(menasorDecepticonsHeridos.estaVivo());
        assertTrue(menasorDecepticonsHeridos.getPuntosDeVida()==0);
    }
	@Test
	public void test08StatsModoHumanoide (){
		assertEquals(menasor.getAtaque(), 115);
		assertEquals(menasor.getDistanciaDeAtaque(), 2);
		assertEquals(menasor.getVelocidad(),2 );
	}
	@Test(expected = NoPuedeTransformarsePorSerCombinado.class)
	public void menasorNoPuedeTransformarse()throws NoPuedeTransformarsePorSerCombinado {
		menasor.transformar();
	}
	
	@Test
	public void test10MenasorAfectadoAlPasarPorEspinas(){
		Superficie superficieTerrestre =new Espinas();
		Superficie superficieAerea=new Nube();
		int vida=menasor.getPuntosDeVida();
		menasor.pasarPor(superficieTerrestre,superficieAerea);
		assertTrue(menasor.getPuntosDeVida()<vida);
	}
	

	@Test
	public void test11MenasorNoafectadoAlPasarPorTormentaPsionica(){
		Superficie superficieTerrestre =new Rocoso();
		Superficie superficieAerea=new TormentaPsionica();
		int ataque=menasor.getAtaque();
		menasor.pasarPor(superficieTerrestre,superficieAerea);
		assertEquals(menasor.getAtaque(),ataque);
	}
	
	
	@Test(expected = ObjetoInmovible.class)
	public void test12MenasorAfectadoAlPasarPorPantanoso()throws ObjetoInmovible{
		Superficie superficieTerrestre =new Pantanoso();
		Superficie superficieAerea=new Nube();
		int velocidad=menasor.getVelocidad();
		menasor.pasarPor(superficieTerrestre,superficieAerea);
        menasor.esMovible();
	}
	
	
	@Test
	public void test13ataqueBonusSeDuplicaEnModoHumanoide(){
		int ataque=menasor.getAtaque();
		menasor.recibirColocable(new DobleCanion());
		assertTrue(ataque<menasor.getAtaque());
	}
}
