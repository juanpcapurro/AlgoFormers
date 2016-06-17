package algoFormers.tablero.colocable;

import algoFormers.tablero.Atacable;
import algoFormers.tablero.colocable.robots.ContextoModoAlgoformer;
import algoFormers.tablero.superficie.Superficie;

public abstract class Colocable implements Atacable{
	public abstract boolean ocupaLugar();
	public abstract void recibirColocable(Colocable colocableEndestino);
	public abstract void pasarPor(Superficie superficieTerrestre,Superficie superficieAerea);

	public abstract void afectarColocable(ContextoModoAlgoformer modo);

	public abstract boolean esMovible();
}
