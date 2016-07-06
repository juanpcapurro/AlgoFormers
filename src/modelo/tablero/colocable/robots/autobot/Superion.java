package modelo.tablero.colocable.robots.autobot;

import modelo.tablero.colocable.robots.*;

import java.util.ArrayList;

public class Superion extends Autobot implements AlgoformerCombinado{
    private final Autobot optimus;
    private final Autobot bumblebee;
    private final Autobot ratchet;

    public Superion( Autobot optimus, Autobot bumblebee, Autobot ratchet){
        this.optimus = optimus;
        this.bumblebee = bumblebee;
        this.ratchet = ratchet;
        this.ptosDeVida =new Vida(optimus.getPuntosDeVida() + bumblebee.getPuntosDeVida() + ratchet.getPuntosDeVida());
		contextoModoActual =new ContextoModoAlgoformer();
        contextoModoActual.setActual(new ModoHumanoide(ptosDeVida,100,2,3));
        contextoModoActual.setAlternativo(new ModoHumanoide(ptosDeVida,100,2,3));
    }
    public ArrayList<AlgoFormer> descomponer(){
        ArrayList<AlgoFormer> unaLista = new ArrayList<>();
        unaLista.add(optimus);
        unaLista.add(bumblebee);
        unaLista.add(ratchet);
        return unaLista;
    }
    @Override
    public void transformar()throws NoPuedeTransformarsePorSerCombinado{
        throw new NoPuedeTransformarsePorSerCombinado();
    }
}
