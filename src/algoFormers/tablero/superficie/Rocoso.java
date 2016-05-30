package algoFormers.tablero.superficie;

import algoFormers.tablero.colocable.robots.Arma;

/**
 * Created by Charly on 5/29/16.
 */
public class Rocoso extends Superficie{
    private static Rocoso ourInstance = new Rocoso();

    public static Rocoso getInstance() {
        return ourInstance;
    }

    private Rocoso() {
    }

    @Override
    public void cambiarALlano(SuperficieConcretaActual superficieActual){
       superficieActual.cambiarActual(Llano.getInstance());
    }
    @Override
    public void cambiarARocoso(SuperficieConcretaActual superficieActual){}

    @Override
    public void cambiarAPantanoso(SuperficieConcretaActual superficieActual) {
        superficieActual.cambiarActual(Pantanoso.getInstance());
    }

	@Override
	public void recibirAtaque(Arma unArma) {
		// TODO Auto-generated method stub
		/*this.cambiarALlano(ourinstance); ?????? */
	}

}
