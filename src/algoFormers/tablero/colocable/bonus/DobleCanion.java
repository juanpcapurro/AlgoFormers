package algoFormers.tablero.colocable.bonus;

import algoFormers.tablero.colocable.Colocable;
import algoFormers.tablero.colocable.robots.ContextoModoAlgoformer;
import algoFormers.tablero.colocable.robots.armas.Ataque;
import algoFormers.tablero.colocable.robots.modificadores.BuffDobleCanion;
import algoFormers.tablero.superficie.Superficie;

/*Duplica capacidad de ataque durante tres turnos propios*/
public
class DobleCanion extends Colocable {

    @Override
    public boolean ocupaLugar() {
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
        modo.afectarEstado(new BuffDobleCanion());
    }

    @Override
    public boolean esMovible() {
        return false;
    }

    @Override
    public void recibirAtaque(Ataque unAtaque) {

    }
}
