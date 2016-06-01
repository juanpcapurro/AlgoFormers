package algoFormers.juego;

import algoFormers.tablero.Tablero;


public class Partida {
	
    private Turno turno;
    private Tablero tablero;
    private Jugador jugadorUno;
    private Jugador jugadorDos;

    public Partida(String nombreJugadorUno, String nombreJugadorDos, int dimension) {
    	
        this.jugadorUno = this.generarJugador();
        this.jugadorDos = this.generarJugador();

        this.turno = new Turno(jugadorUno,jugadorDos);

        this.tablero = new Tablero(dimension);
    }

	private Jugador generarJugador() {
		/*HAY QUE CODEAR LA GENERACION. DUDAS DE COMO OBTENEMOS LOS DATOS*/
		return null;
	}

}
