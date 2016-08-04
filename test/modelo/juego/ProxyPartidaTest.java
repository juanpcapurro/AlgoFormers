package modelo.juego;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProxyPartidaTest {
    AdaptadorPartida unaPartida = new AdaptadorPartida("Bonnie", "Clyde",8);//Una partida entre tipos rudos!
    @Test
    public void saltearseUnTurno(){
        assertEquals(unaPartida.getDatosJugadorActual().nombreJugador, "Clyde");
        unaPartida.saltearTurno();
        assertEquals(unaPartida.getDatosJugadorActual().nombreJugador, "Bonnie");
    }
}
