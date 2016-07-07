package modelo.tablero.colocable.robots.decepticon;

import modelo.tablero.colocable.robots.*;

public class Megatron extends Decepticon{
    public Megatron(){
        this.ptosDeVida = new Vida(550);
		this.contextoModoActual = new ContextoModoAlgoformer();
		contextoModoActual.setActual( new ModoHumanoide(ptosDeVida,10,3,1));
        contextoModoActual.setAlternativo(new ModoAlternoAereo(ptosDeVida,55,2,8));
    }

}
