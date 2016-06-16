package algoFormers.tablero.colocable.robots.decepticon;

import algoFormers.tablero.colocable.robots.*;

public class BoneCrusher extends AlgoFormer {
    public BoneCrusher(){
        this.ptosDeVida = 200;
		this.modoActual = new ContextoModoAlgoformer();
		modoActual.setActual(new ModoHumanoide(30,3,1));
		modoActual.setAlternativo(new ModoAlternoTerrestre(30,3,8));
    }
}
