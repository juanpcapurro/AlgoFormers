package algoFormers.tablero.colocable;


import algoFormers.tablero.colocable.robots.Bumblebee;
import algoFormers.tablero.colocable.robots.Optimus;
import algoFormers.tablero.colocable.robots.Ratchet;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SuperionTest {
    Optimus optimus;
    Bumblebee bumblebee;
    Ratchet ratchet;
    Superion superion;
    Optimus optimusHerido;
    Bumblebee bumblebeeHerido;
    Ratchet ratchetHerido;
    Superion superionHerido;

    @Before
    public void setUp() throws Exception {
        optimus = new Optimus();
        bumblebee = new Bumblebee();
        ratchet = new Ratchet();

        optimusHerido.recibirAtaque(400);
        bumblebeeHerido.recibirAtaque(250);
        ratchetHerido.recibirAtaque(50);

        Superion superionHerido = new Superion(optimusHerido, bumblebeeHerido, ratchetHerido);


    }

    @Test
    public void superionCreadoConUnOptimusUnBumblebeeYUnRatchet() {
        superion = new Superion(optimus, bumblebee, ratchet);

        assertTrue(superion.estaVivo());

    }
    @Test
    public void superionSusPuntosDeVidaEsLaSumaDeLosAutobosQueLoForman() {
        assertTrue(superion.getPuntosDeVida() == 1000);

    }
    @Test
    public void superionRecibeAtaqueYSigueConVida() {
        superion.recibirAtaque(100);

        assertTrue(superion.estaVivo());
        assertTrue(superion.getPuntosDeVida() == 900);
    }

    @Test
    public void superionRecibeAtaqueYMuere() {
        superion.recibirAtaque(1000);

        assertFalse(superion.estaVivo());
    }




    @Test
        public void superionCreadoConAutobotsHeridos() {
            assertTrue(superionHerido.estaVivo());

            assertTrue(optimusHerido.getPuntosDeVida()==100);
            assertTrue(bumblebeeHerido.getPuntosDeVida()==100);
            assertTrue(ratchetHerido.getPuntosDeVida()==100);

         assertTrue(superionHerido.getPuntosDeVida()==300);
        }

        @Test
        public void superionCreadoConAutobotsHeridosRecibeAtaqueYMuere() {
            superionHerido.recibirAtaque(300);

            assertFalse(superionHerido.estaVivo());
            assertTrue(superionHerido.getPuntosDeVida()==0);
         }

        @Test
        public void superionCreadoConAutobotsHeridosRecibeAtaqueYSigueConVida() {
            superionHerido.recibirAtaque(10);

            assertTrue(superionHerido.estaVivo());
            assertTrue(superionHerido.getPuntosDeVida()==290);
        }





}
