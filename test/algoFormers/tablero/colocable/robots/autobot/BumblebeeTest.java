package algoFormers.tablero.colocable.robots.autobot;

import algoFormers.tablero.colocable.robots.Modificador;
import algoFormers.tablero.colocable.robots.armas.DisparoConvencional;
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
	public void tests03ModificadorBumblebeeDisminuyeStats(){
		Modificador modificador=new Modificador();
		modificador.setModificadorAtaque(50);
		mauricio.setModificadorDeEstado(modificador);
		assertEquals(mauricio.getAtaque(),20);
	}
	@Test
	public void tests03ModificadorBumblebeeDisminuyeStatsEnModoAlterno(){
		Modificador modificador=new Modificador();
		modificador.setModificadorAtaque(50);
		mauricio.setModificadorDeEstado(modificador);
		mauricio.cambiarModo();
		assertEquals(mauricio.getVelocidad(),5);
	}
}
