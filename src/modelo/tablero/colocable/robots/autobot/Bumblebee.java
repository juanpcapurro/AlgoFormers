package modelo.tablero.colocable.robots.autobot;

import modelo.tablero.colocable.robots.*;
public class Bumblebee extends Autobot{
	
    public Bumblebee(){
        this.ptosDeVida = new Vida(350);
		modoActual= new ContextoModoAlgoformer();
		modoActual.setActual(new ModoHumanoide(ptosDeVida,40, 1, 2));
		modoActual.setAlternativo(new ModoAlternoTerrestre(ptosDeVida,20,3,5));
    }

    @Override
    public void afectarColocable(ContextoModoAlgoformer modo) {

    }
}