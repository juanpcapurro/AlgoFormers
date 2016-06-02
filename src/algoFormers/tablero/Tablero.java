package algoFormers.tablero;

import algoFormers.tablero.colocable.Colocable;
import algoFormers.tablero.colocable.robots.AlgoFormer;
import algoFormers.tablero.colocable.robots.Ataque;

public class Tablero{
	private final int DIMENSION;
	private Casillero[][] matrizCasilleros;

	public Tablero(int dimension_pedida){
		matrizCasilleros = new Casillero[dimension_pedida][dimension_pedida];
		DIMENSION = dimension_pedida;
		for (Casillero[] row: matrizCasilleros) {//Este for llena la matriz
			for(int i=0;i<DIMENSION;i++)
				row[i]= new Casillero();
		}
	}

    public boolean estaTodoVacio(){
        for (Casillero[] row : this.matrizCasilleros)
            for (Casillero casillero : row)
                if (casillero.estaOcupado())
                    return false;
        return true;
    }

	public void colocar(int fila, int columna,Colocable aColocar){
		this.vericarCoordenadas(fila,columna);
		Casillero casillero= this.matrizCasilleros[fila][columna];
		casillero.colocar(aColocar);
	}

	public void colocarAlgoformer(int fila,int columna){
		this.colocar(fila,columna, new AlgoFormer());
	}

	public void mover(int filaOrigen, int columnaOrigen, int filaDestino, int columnaDestino){
		/*MOVER DEBE SER MEJORADO PARA CONSIDERAR:
		 * -Distancias permitidas de los algoformers
		 * -Posibilidad de elegir paso a paso el casillero siguiente
		 * -En cada eleccion, el tablero validaria si es posible o no.*/
		this.vericarCoordenadas(filaDestino, columnaDestino);
		this.vericarCoordenadas(filaOrigen, filaDestino);
		
		Colocable colocableAMover = (this.matrizCasilleros[filaOrigen][columnaOrigen]).obtenerColocado();
		this.vaciarPosicion(filaOrigen, columnaOrigen);
		this.colocar(filaDestino, columnaDestino, colocableAMover);
	}
	
	public boolean estaOcupadoEnPosicion(int fila, int columna){
		this.vericarCoordenadas(fila,columna);
		Casillero casillero= this.matrizCasilleros[fila][columna];
		return casillero.estaOcupado();
	}

	private void vericarCoordenadas(int fila, int columna) {
		if (fila<0 || columna <0 || fila >= DIMENSION || columna >= DIMENSION)
			throw new CoordenadasInvalidas() ;
	}
	public void vaciarPosicion(int fila, int columna){
		this.vericarCoordenadas(fila, columna);
		this.matrizCasilleros[fila][columna].vaciar();
	}

	public void atacar(int fila , int columna,Ataque ataque){
		vericarCoordenadas(fila,columna);
		(matrizCasilleros[fila][columna]).atacarCasillero(ataque);
	}
}
