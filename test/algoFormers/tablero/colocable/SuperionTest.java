package algoFormers.tablero.colocable;


import algoFormers.tablero.colocable.robots.Bumblebee;
import algoFormers.tablero.colocable.robots.DisparoConvencional;
import algoFormers.tablero.colocable.robots.Optimus;
import algoFormers.tablero.colocable.robots.Ratchet;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
        superion.recibirAtaque(new DisparoConvencional(100));

        assertTrue(superion.estaVivo());
        assertTrue(superion.getPuntosDeVida() == 900);
    }

    @Test
    public void  test04SuperionRecibeAtaqueYMuere() {
        superion.recibirAtaque(new DisparoConvencional(1000));
        assertFalse(superion.estaVivo());
    }

    @Test
        public void  test05SuperionCreadoConAutobotsHeridos() {

            optimus.recibirAtaque(new DisparoConvencional(400));
            bumblebee.recibirAtaque(new DisparoConvencional(250));
            ratchet.recibirAtaque(new DisparoConvencional(50));

            assertTrue(optimus.getPuntosDeVida()==100);
            assertTrue(bumblebee.getPuntosDeVida()==100);
            assertTrue(ratchet.getPuntosDeVida()==100);

            superionAutobotsHeridos = new Superion(optimus, bumblebee, ratchet);
            assertTrue(superionAutobotsHeridos.estaVivo());
            assertTrue(superionAutobotsHeridos.getPuntosDeVida()==300);
        }
        @Test
        public void  test06SuperionCreadoConAutobotsHeridosRecibeAtaqueYSigueConVida() {
            optimus.recibirAtaque(new DisparoConvencional(400));
            bumblebee.recibirAtaque(new DisparoConvencional(250));
            ratchet.recibirAtaque(new DisparoConvencional(50));

            assertTrue(optimus.getPuntosDeVida()==100);
            assertTrue(bumblebee.getPuntosDeVida()==100);
            assertTrue(ratchet.getPuntosDeVida()==100);

            superionAutobotsHeridos = new Superion(optimus, bumblebee, ratchet);
            superionAutobotsHeridos.recibirAtaque(new DisparoConvencional(10));

            assertTrue(superionAutobotsHeridos.estaVivo());
            assertTrue(superionAutobotsHeridos.getPuntosDeVida()==290);
        }
        @Test
        public void  test07SuperionCreadoConAutobotsHeridosRecibeAtaqueYMuere() {
            optimus.recibirAtaque(new DisparoConvencional(400));
            bumblebee.recibirAtaque(new DisparoConvencional(250));
            ratchet.recibirAtaque(new DisparoConvencional(50));

            assertTrue(optimus.getPuntosDeVida()==100);
            assertTrue(bumblebee.getPuntosDeVida()==100);
            assertTrue(ratchet.getPuntosDeVida()==100);

            superionAutobotsHeridos = new Superion(optimus, bumblebee, ratchet);
            superionAutobotsHeridos.recibirAtaque(new DisparoConvencional(300));

            assertFalse(superionAutobotsHeridos.estaVivo());
            assertTrue(superionAutobotsHeridos.getPuntosDeVida()==0);
         }







}
