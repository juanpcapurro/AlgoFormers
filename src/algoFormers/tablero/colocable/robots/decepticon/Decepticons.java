package algoFormers.tablero.colocable.robots.decepticon;

import algoFormers.tablero.Tablero;
import algoFormers.tablero.colocable.robots.AlgoFormer;
import algoFormers.tablero.colocable.robots.Equipo;
import algoFormers.tablero.posiciones.Posicion;

public class Decepticons extends Equipo {

    private final BoneCrusher boneCrusher;
    private final Frenzy frenzy;
    private final Megatron megatron;
    private boolean estaCombinado;

    public Decepticons(){
        this.boneCrusher = new BoneCrusher();
        this.frenzy = new Frenzy();
        this.megatron = new Megatron();
        estaCombinado = false;
    }

    @Override
    public AlgoFormer combinarme() {
        estaCombinado = true;
        return new Menasor(megatron,boneCrusher,frenzy);
    }

    public void ubicarUnidades(Tablero tablero){
        Posicion posicion1=new Posicion(2,6);
        Posicion posicion2=new Posicion(0,3);
        Posicion posicion3=new Posicion(7,4);
        tablero.colocarAlgoformer(posicion1,boneCrusher);
        tablero.colocarAlgoformer(posicion2,frenzy);
        tablero.colocarAlgoformer(posicion3,megatron);
    }

    @Override
    public boolean estaVivo() {
        return (boneCrusher.estaVivo() || frenzy.estaVivo() || megatron.estaVivo());
    }

    @Override
    public boolean estanTodosAlgoformersVivos() {
        return (boneCrusher.estaVivo() && frenzy.estaVivo() && megatron.estaVivo());
    }

    @Override
    public void notificar() {
        boneCrusher.notificar();
        frenzy.notificar();
        megatron.notificar();
    }

    @Override
    public boolean estaCombinado() {
        return estaCombinado;
    }

    public BoneCrusher getBoneCrusher() {
        return boneCrusher;
    }
    public Frenzy getFrenzy() {
        return frenzy;
    }
    public Megatron getMegatron() {
        return megatron;
    }

}
