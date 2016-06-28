package modelo.tablero.colocable.robots.decepticon;

import modelo.tablero.colocable.robots.*;

public class Frenzy extends Decepticon{
    public Frenzy(){
        this.ptosDeVida = new Vida(400);
		this.modoActual = new ContextoModoAlgoformer();
		modoActual.setActual(new ModoHumanoide(ptosDeVida,10, 5, 2));
		modoActual.setAlternativo(new ModoAlternoTerrestre(ptosDeVida,25,2,6));
    }
}
