package algoFormers.tablero;

import algoFormers.tablero.colocable.robots.Arma;
public interface Atacable{
	//La idea es que aca esten los metodos para recibir ataques con cualquier arma
	public void recibirAtaque(Arma unArma);
}
