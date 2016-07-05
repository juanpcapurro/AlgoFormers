package modelo.tablero.colocable.robots.decepticon;

import modelo.tablero.colocable.robots.*;

public class Megatron extends Decepticon{
    public Megatron(){
        this.ptosDeVida = new Vida(550);
		this.modoActual= new ContextoModoAlgoformer();
        //ataque original=10
		modoActual.setActual( new ModoHumanoide(ptosDeVida,1000,3,1));
        modoActual.setAlternativo(new ModoAlternoAereo(ptosDeVida,55,2,8));
    }

}
