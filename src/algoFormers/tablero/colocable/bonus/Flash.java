package algoFormers.tablero.colocable.bonus;

import algoFormers.tablero.colocable.Colocable;
import algoFormers.tablero.colocable.robots.ContextoModoAlgoformer;
import algoFormers.tablero.colocable.robots.armas.Ataque;
import algoFormers.tablero.colocable.robots.modificadores.BuffFlash;
import algoFormers.tablero.superficie.Superficie;

/*Triplica velocidad de desplazamiento durante tres turnos propios*/
public class Flash extends Colocable {

    @Override
    public boolean ocupaLugar(){
        return false;
    }

    @Override
    public void recibirColocable(Colocable colocableEndestino) {

    }

    @Override
    public void pasarPor(Superficie superficieTerrestre, Superficie superficieAerea) {

    }

    @Override
    public void afectarColocable(ContextoModoAlgoformer modo) {
        modo.afectarEstado(new BuffFlash());
    }

    @Override
    public void recibirAtaque(Ataque unAtaque) {

    }
}
