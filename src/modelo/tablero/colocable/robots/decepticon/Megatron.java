package modelo.tablero.colocable.robots.decepticon;

import modelo.tablero.colocable.robots.*;

public class Megatron extends Decepticon{
    public Megatron(){
        this.ptosDeVida = new Vida(550);
		this.contextoModoActual = new ContextoModoAlgoformer();
        // 10 y 3 y 1
		contextoModoActual.setActual( new ModoHumanoide(ptosDeVida,1000,1000,1000));
        contextoModoActual.setAlternativo(new ModoAlternoAereo(ptosDeVida,55,2,8));
    }

}
