package algoFormers.tablero;

import tablero.Casillero;

public class Tablero{
	private final int DIMENSION;
	private Casillero[][] matrizCasilleros;

	public Tablero(int dimension_pedida){
		matrizCasilleros = new Casillero[dimension_pedida][dimension_pedida];
		DIMENSION = dimension_pedida;
		for (Casillero[] row: matrizCasilleros)//Este for llena la matriz
			Arrays.fill(row, new Casillero());//Charly quiere usar esto, peguenle a el
	}

    public boolean estaVacio(){
        for (Casillero[] row : matrizCasilleros)
            for (Casillero casillero : row)
                if (casillero.estaOcupado())
                    return true;
        return false;
    }
}
