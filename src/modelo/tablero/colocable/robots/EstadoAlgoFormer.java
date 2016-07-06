package modelo.tablero.colocable.robots;

public  class EstadoAlgoFormer {
	protected int velocidad;
	protected int distanciaDeAtaque;
	protected int ataque;
	Vida vida;
	boolean inmovilizado=false;

	EstadoAlgoFormer(Vida unaVida,int unAtaque, int unaDistancia, int unaVelocidad){
		ataque=unAtaque;
		velocidad=unaVelocidad;
		distanciaDeAtaque=unaDistancia;
		vida=unaVida;
	}
	public int getVida(){
		return vida.getVidaActual();
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

	public void setDistanciaDeAtaque(int nuevoAlcance){//No borrar porque puede que luego haga falta un debuff que
		distanciaDeAtaque=nuevoAlcance;//haga mas lento al algoformer
	}
	public void setAtaque(int nuevoAtaque){
		ataque=nuevoAtaque;
	}
	public void setVida(int unaVida){
		vida.setVidaActual(unaVida);
	}

	public void inmovilizar(){
		inmovilizado=true;
	}
	public void movilizar(){
		inmovilizado=false;
	}
	public boolean estaInmovilizado(){
		return inmovilizado;
	}
	public void setIndaniable(){
		vida.setIndaniable();
	}
	public void setDaniable(){
		vida.setDaniable();
	}


}
