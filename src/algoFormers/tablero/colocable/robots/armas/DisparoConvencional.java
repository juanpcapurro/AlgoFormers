package algoFormers.tablero.colocable.robots.armas;

import algoFormers.tablero.Atacable;

public class DisparoConvencional implements Ataque {
    int danio;
    public DisparoConvencional(int unDanio){
        danio=unDanio;
    }
    @Override
    public void atacar(Atacable target) {
        target.recibirAtaque(this);
    }

    @Override
    public int getDanio() {
        return danio;
    }
}
