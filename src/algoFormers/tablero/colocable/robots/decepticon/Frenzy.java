package algoFormers.tablero.colocable.robots.decepticon;

import algoFormers.tablero.colocable.robots.*;

public class Frenzy extends AlgoFormer {
    public Frenzy(){
        this.ptosDeVida = new Vida(400);
		this.modoActual = new ContextoModoAlgoformer();
		modoActual.setActual(new ModoHumanoide(ptosDeVida,10, 5, 2));
		modoActual.setAlternativo(new ModoAlternoTerrestre(ptosDeVida,25,2,6));
    }
}
