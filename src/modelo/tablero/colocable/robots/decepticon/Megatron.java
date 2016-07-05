package modelo.tablero.colocable.robots.decepticon;

import modelo.tablero.colocable.robots.*;

public class Megatron extends Decepticon{
    public Megatron(){
        this.ptosDeVida = new Vida(550);
		this.modoActual= new ContextoModoAlgoformer();
		modoActual.setActual( new ModoHumanoide(ptosDeVida,10,3,1));
        modoActual.setAlternativo(new ModoAlternoAereo(ptosDeVida,55,2,8));
    }

}
