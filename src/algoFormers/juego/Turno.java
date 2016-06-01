package algoFormers.juego;

public class Turno {

    int turno;
    Jugador jugador1;
    Jugador jugador2;
    
	public Turno(Jugador jugadorUno, Jugador jugadorDos) {
		this.jugador1 = jugadorUno;
		this.jugador2 = jugadorDos;
		this.turno = 1;
	}
	
	public void avanzarTurno() {
        this.turno++;
        this.alternarTurnos();

    }

    private void alternarTurnos(){

        if ( (this.turno)%2==0){
            this.jugador1.esSuTurno(false);
            this.jugador2.esSuTurno(true);
       }else{
            this.jugador1.esSuTurno(true);
            this.jugador2.esSuTurno(false);
       }

    }
    
	public int obtenerTurnoActual() {
        return this.turno;
    }


}
