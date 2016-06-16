package algoFormers.tablero.colocable.robots.decepticon;

import algoFormers.tablero.colocable.robots.*;

public class BoneCrusher extends AlgoFormer {
    public BoneCrusher(){
        this.ptosDeVida = new Vida(200);
		this.modoActual = new ContextoModoAlgoformer();
		modoActual.setActual(new ModoHumanoide(ptosDeVida,30,3,1));
		modoActual.setAlternativo(new ModoAlternoTerrestre(ptosDeVida,30,3,8));
    }
}
