package modelo.tablero.colocable.robots.decepticon;

import modelo.tablero.colocable.robots.*;

import java.util.ArrayList;

public class Menasor extends Decepticon implements AlgoformerCombinado{

    private final Decepticon megatron;
    private final Decepticon boneCrusher;
    private final Decepticon frenzy;

    public Menasor(Decepticon megatron, Decepticon boneCrusher, Decepticon frenzy) {
        this.megatron = megatron;
        this.boneCrusher = boneCrusher;
        this.frenzy = frenzy;
        this.ptosDeVida = new Vida(megatron.getPuntosDeVida() + boneCrusher.getPuntosDeVida() + frenzy.getPuntosDeVida());
        contextoModoActual =new ContextoModoAlgoformer();
		contextoModoActual.setActual(new ModoHumanoide(ptosDeVida,115,2,2));
        contextoModoActual.setAlternativo(new ModoHumanoide(ptosDeVida,115,2,2));
    }
    public ArrayList<AlgoFormer> descomponer(){
        ArrayList<AlgoFormer> unaLista = new ArrayList<>();
        unaLista.add(megatron);
        unaLista.add(boneCrusher);
        unaLista.add(frenzy);
        return unaLista;
    }
    @Override
    public void transformar()throws NoPuedeTransformarsePorSerCombinado{
        throw new NoPuedeTransformarsePorSerCombinado();
    }
}
