package algoFormers.tablero.colocable.robots.decepticon;

import algoFormers.tablero.colocable.robots.armas.DisparoConvencional;
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
        menasor.recibirAtaque(new DisparoConvencional(100));

        assertTrue(menasor.estaVivo());
        assertTrue(menasor.getPuntosDeVida() == 1050);
    }

    @Test
    public void  test04MenasorRecibeAtaqueYMuere() {
        menasor.recibirAtaque(new DisparoConvencional(1150));
        assertFalse(menasor.estaVivo());
    }

    @Test
    public void  test05MenasorCreadoConDecepticonsHeridos() {

        megatron.recibirAtaque(new DisparoConvencional(450));
        boneCrusher.recibirAtaque(new DisparoConvencional(100));
        frenzy.recibirAtaque(new DisparoConvencional(300));

        assertTrue(megatron.getPuntosDeVida()==100);
        assertTrue(boneCrusher.getPuntosDeVida()==100);
        assertTrue(frenzy.getPuntosDeVida()==100);

        menasorDecepticonsHeridos = new Menasor(megatron, boneCrusher, frenzy);
        assertTrue(menasorDecepticonsHeridos.estaVivo());
        assertTrue(menasorDecepticonsHeridos.getPuntosDeVida()==300);
    }
    @Test
    public void  test06MenasorCreadoConDecepticonsHeridosRecibeAtaqueYSigueConVida() {
        megatron.recibirAtaque(new DisparoConvencional(450));
        boneCrusher.recibirAtaque(new DisparoConvencional(100));
        frenzy.recibirAtaque(new DisparoConvencional(300));

        assertTrue(megatron.getPuntosDeVida()==100);
        assertTrue(boneCrusher.getPuntosDeVida()==100);
        assertTrue(frenzy.getPuntosDeVida()==100);

        menasorDecepticonsHeridos = new Menasor(megatron, boneCrusher, frenzy);
        menasorDecepticonsHeridos.recibirAtaque(new DisparoConvencional(10));

        assertTrue(menasorDecepticonsHeridos.estaVivo());
        assertTrue(menasorDecepticonsHeridos.getPuntosDeVida()==290);
    }
    @Test
    public void  test07MenasorCreadoConDecepticonsHeridosRecibeAtaqueYMuere() {
        megatron.recibirAtaque(new DisparoConvencional(450));
        boneCrusher.recibirAtaque(new DisparoConvencional(100));
        frenzy.recibirAtaque(new DisparoConvencional(300));

        assertTrue(megatron.getPuntosDeVida()==100);
        assertTrue(boneCrusher.getPuntosDeVida()==100);
        assertTrue(frenzy.getPuntosDeVida()==100);

        menasorDecepticonsHeridos = new Menasor(megatron, boneCrusher, frenzy);
        menasorDecepticonsHeridos.recibirAtaque(new DisparoConvencional(300));

        assertFalse(menasorDecepticonsHeridos.estaVivo());
        assertTrue(menasorDecepticonsHeridos.getPuntosDeVida()==0);
    }
	@Test
	public void testStatsModoHumanoide (){
		assertEquals(menasor.getAtaque(), 115);
		assertEquals(menasor.getDistanciaDeAtaque(), 2);
		assertEquals(menasor.getVelocidad(),2 );
	}
	@Test
	public void testStatsNoCambianAlCambiarModo(){
		menasor.cambiarModo();
		assertEquals(menasor.getAtaque(), 115);
		assertEquals(menasor.getDistanciaDeAtaque(), 2);
		assertEquals(menasor.getVelocidad(),2 );
	}


}
