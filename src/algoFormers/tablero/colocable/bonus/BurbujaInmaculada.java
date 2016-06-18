package algoFormers.tablero.colocable.bonus;

import algoFormers.tablero.colocable.Colocable;
import algoFormers.tablero.colocable.robots.ContextoModoAlgoformer;
import algoFormers.tablero.colocable.robots.armas.Ataque;
import algoFormers.tablero.colocable.robots.modificadores.BuffBurbujaInmaculada;
import algoFormers.tablero.colocable.robots.modificadores.BuffDobleCanion;
import algoFormers.tablero.superficie.Superficie;

/*No recibe ataque de otro algoformer durante dos turnos propios*/
public class BurbujaInmaculada extends Colocable {

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
    	modo.afectarEstado(new BuffBurbujaInmaculada());
    }

    @Override
    public boolean esMovible() {
        return false;
    }


    @Override
    public void recibirAtaque(Ataque unAtaque) {

    }
}
