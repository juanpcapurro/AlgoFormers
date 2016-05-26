package algoFormers.tablero;

import java.util.Arrays;

public class Tablero{
	private final int DIMENSION;
	private Casillero[][] matrizCasilleros;

	public Tablero(int dimension_pedida){
		matrizCasilleros = new Casillero[dimension_pedida][dimension_pedida];
		DIMENSION = dimension_pedida;
		for (Casillero[] row: matrizCasilleros)//Este for llena la matriz
			Arrays.fill(row, new Casillero());//Charly quiere usar esto, peguenle a el
	}

    public boolean estaTodoVacio(){
        for (Casillero[] row : matrizCasilleros)
            for (Casillero casillero : row)
                if (casillero.estaOcupado())
                    return false;
        return true;
    }

	public void colocar(int fila, int columna,Colocable aColocar){
		Casillero casillero= matrizCasilleros[fila][columna];
		casillero.colocar(aColocar);
	}

	public boolean estaOcupadoEnPosicion(int fila, int columna){
		Casillero casillero= matrizCasilleros[fila][columna];
		return casillero.estaOcupado();
	}
}
