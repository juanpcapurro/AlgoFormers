package algoFormers.tablero.colocable.robots;

import algoFormers.tablero.Atacable;

/**
 * Created by Charly on 6/1/16.
 */
public class Misil implements Ataque {
    int danio;
    int bonusdeMisil;
    public Misil(int unDanio){
        bonusdeMisil=100;
        danio=unDanio+bonusdeMisil;
    }
    @Override
    public void atacar(Atacable target) {
        target.recibirAtaque(this);
    }
    @Override
    public int getDanio(){
        return danio;
    }

}
