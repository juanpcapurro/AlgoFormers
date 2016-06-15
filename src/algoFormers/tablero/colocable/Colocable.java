package algoFormers.tablero.colocable;

import algoFormers.tablero.Atacable;
import algoFormers.tablero.superficie.Superficie;

public abstract class Colocable implements Atacable{
	public abstract boolean ocupaLugar();

	public abstract void pasarPor(Superficie superficieTerrestre,Superficie superficieAerea);
}
