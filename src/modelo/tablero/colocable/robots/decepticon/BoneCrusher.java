package modelo.tablero.colocable.robots.decepticon;

import modelo.tablero.colocable.robots.*;

public class BoneCrusher extends Decepticon{
    public BoneCrusher(){
        this.ptosDeVida = new Vida(200);
		this.contextoModoActual = new ContextoModoAlgoformer();
		contextoModoActual.setActual(new ModoHumanoide(ptosDeVida,30,3,1));
		contextoModoActual.setAlternativo(new ModoAlternoTerrestre(ptosDeVida,30,3,8));
    }

}
