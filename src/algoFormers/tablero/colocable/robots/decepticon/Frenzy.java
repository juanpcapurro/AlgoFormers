package algoFormers.tablero.colocable.robots.decepticon;

import algoFormers.tablero.colocable.robots.*;

public class Frenzy extends Decepticon {
    public Frenzy(){
        this.ptosDeVida = 400;
		this.modoActual = new ContextoModoAlgoformer();
		modoActual.setActual(new ModoHumanoide(10, 5, 2));
		modoActual.setAlternativo(new ModoAlternoTerrestre(25,2,6));
    }
}
