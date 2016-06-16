package algoFormers.tablero.colocable.robots;

public  class EstadoAlgoFormer extends AlgoFormer{
	protected int velocidad;
	protected int distanciaDeAtaque;
	protected int ataque;
	Vida vida;

	EstadoAlgoFormer(Vida unaVida,int unAtaque, int unaDistancia, int unaVelocidad){
		ataque=unAtaque;
		velocidad=unaVelocidad;
		distanciaDeAtaque=unaDistancia;
		vida=unaVida;
	}
	public int getVida(){
		return vida.getVida();
	}
	public int getVelocidad(){
		return velocidad;
	}
	public int getAtaque(){
		return ataque;
	}
	public int getDistanciaDeAtaque(){
		return distanciaDeAtaque;
	}
	public void setVelocidad(int nuevaVelocidad){
		velocidad=nuevaVelocidad;
	}

	public void setDistanciaDeAtaque(int nuevoAlcance){
		distanciaDeAtaque=nuevoAlcance;
	}
	public void setAtaque(int nuevoAtaque){
		ataque=nuevoAtaque;
	}
	public void setVida(int unaVida){
		vida.setVida(unaVida);
	}





}
