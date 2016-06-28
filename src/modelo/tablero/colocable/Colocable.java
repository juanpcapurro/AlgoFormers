package modelo.tablero.colocable;

import modelo.tablero.Atacable;
import modelo.tablero.colocable.robots.ContextoModoAlgoformer;
import modelo.tablero.superficie.Superficie;

public abstract class Colocable implements Atacable{
	public abstract boolean ocupaLugar();
	public abstract void recibirColocable(Colocable colocableEndestino);
	public abstract void pasarPor(Superficie superficieTerrestre,Superficie superficieAerea);

	public abstract void afectarColocable(ContextoModoAlgoformer modo);

	public abstract boolean esMovible();
}