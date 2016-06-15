package algoFormers.tablero.superficieTerrestre;

import algoFormers.tablero.colocable.robots.armas.Ataque;

public class ContextoSuperficieTerrestre {
    StateSuperficieTerrestre actual;

    public ContextoSuperficieTerrestre(){
        actual=new Rocoso();
    }

    void cambiarEspinas(){
        actual=new Espinas();
    }
    void cambiarPantanoso(){
        actual=new Pantanoso();
    }
    void cambiarRocoso(){
        actual=new Rocoso();
    }
    public void recibirAtaque(Ataque ataque){
        actual.recibirAtaque(ataque);
    }
}