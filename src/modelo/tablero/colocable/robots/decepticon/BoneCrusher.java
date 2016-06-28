package modelo.tablero.colocable.robots.decepticon;

import modelo.tablero.colocable.robots.*;

public class BoneCrusher extends Decepticon{
    public BoneCrusher(){
        this.ptosDeVida = new Vida(200);
		this.modoActual = new ContextoModoAlgoformer();
		modoActual.setActual(new ModoHumanoide(ptosDeVida,30,3,1));
		modoActual.setAlternativo(new ModoAlternoTerrestre(ptosDeVida,30,3,8));
    }

}
