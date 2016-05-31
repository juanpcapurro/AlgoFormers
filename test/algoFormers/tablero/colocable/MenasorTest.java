package algoFormers.tablero.colocable;

import algoFormers.tablero.colocable.robots.BoneCrusher;
import algoFormers.tablero.colocable.robots.Megatron;
import algoFormers.tablero.colocable.robots.Frenzy;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
    public void menasorCreadoConUnMegatronUnBoneCrusherYUnFrenzy() {
        assertTrue(menasor.estaVivo());

    }
    @Test
    public void menasorSusPuntosDeVidaEsLaSumaDeLosDeceptionsQueLoForman() {
        assertTrue(menasor.getPuntosDeVida() == 1150);

    }
    @Test
    public void menasorRecibeAtaqueYSigueConVida() {
        menasor.recibirAtaque(100);

        assertTrue(menasor.estaVivo());
        assertTrue(menasor.getPuntosDeVida() == 1050);
    }

    @Test
    public void menasorRecibeAtaqueYMuere() {
        menasor.recibirAtaque(1150);
        assertFalse(menasor.estaVivo());
    }

    @Test
    public void menasorCreadoConDecepticonsHeridos() {

        megatron.recibirAtaque(450);
        boneCrusher.recibirAtaque(100);
        frenzy.recibirAtaque(300);

        assertTrue(megatron.getPuntosDeVida()==100);
        assertTrue(boneCrusher.getPuntosDeVida()==100);
        assertTrue(frenzy.getPuntosDeVida()==100);

        menasorDecepticonsHeridos = new Menasor(megatron, boneCrusher, frenzy);
        assertTrue(menasorDecepticonsHeridos.estaVivo());
        assertTrue(menasorDecepticonsHeridos.getPuntosDeVida()==300);
    }
    @Test
    public void menasorCreadoConDecepticonsHeridosRecibeAtaqueYSigueConVida() {
        megatron.recibirAtaque(450);
        boneCrusher.recibirAtaque(100);
        frenzy.recibirAtaque(300);

        assertTrue(megatron.getPuntosDeVida()==100);
        assertTrue(boneCrusher.getPuntosDeVida()==100);
        assertTrue(frenzy.getPuntosDeVida()==100);

        menasorDecepticonsHeridos = new Menasor(megatron, boneCrusher, frenzy);
        menasorDecepticonsHeridos.recibirAtaque(10);

        assertTrue(menasorDecepticonsHeridos.estaVivo());
        assertTrue(menasorDecepticonsHeridos.getPuntosDeVida()==290);
    }
    @Test
    public void menasorCreadoConDecepticonsHeridosRecibeAtaqueYMuere() {
        megatron.recibirAtaque(450);
        boneCrusher.recibirAtaque(100);
        frenzy.recibirAtaque(300);

        assertTrue(megatron.getPuntosDeVida()==100);
        assertTrue(boneCrusher.getPuntosDeVida()==100);
        assertTrue(frenzy.getPuntosDeVida()==100);

        menasorDecepticonsHeridos = new Menasor(megatron, boneCrusher, frenzy);
        menasorDecepticonsHeridos.recibirAtaque(300);

        assertFalse(menasorDecepticonsHeridos.estaVivo());
        assertTrue(menasorDecepticonsHeridos.getPuntosDeVida()==0);
    }



}
