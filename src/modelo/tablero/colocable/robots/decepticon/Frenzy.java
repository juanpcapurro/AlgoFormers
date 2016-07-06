package modelo.tablero.colocable.robots.decepticon;

import modelo.tablero.colocable.robots.*;

public class Frenzy extends Decepticon{
    public Frenzy(){
        this.ptosDeVida = new Vida(400);
		this.contextoModoActual = new ContextoModoAlgoformer();
		contextoModoActual.setActual(new ModoHumanoide(ptosDeVida,10, 5, 2));
		contextoModoActual.setAlternativo(new ModoAlternoTerrestre(ptosDeVida,25,2,6));
    }
}
