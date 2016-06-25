package modelo.tablero;

import modelo.tablero.colocable.robots.armas.Ataque;
public interface Atacable{
	//La idea es que aca esten los metodos para recibir ataques con cualquier arma
	void recibirAtaque(Ataque unAtaque);
}
