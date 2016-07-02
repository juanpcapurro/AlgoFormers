package modelo.tablero;

import modelo.tablero.colocable.robots.armas.AtaqueAutobot;
import modelo.tablero.colocable.robots.armas.AtaqueDecepticon;

public interface Atacable{
	//La idea es que aca esten los metodos para recibir ataques con cualquier arma
	void recibirAtaque(AtaqueAutobot unAtaque);
	void recibirAtaque(AtaqueDecepticon unAtaque);
}
