package modelo.tablero.colocable.bonus;

import modelo.tablero.colocable.Colocable;
import modelo.tablero.colocable.robots.ContextoModoAlgoformer;
import modelo.tablero.colocable.robots.modificadores.BuffBurbujaInmaculada;
import modelo.tablero.superficie.Superficie;

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
    public Object getModo() {
        return null;
    }

    @Override
    public boolean retirar() {
        return false;
    }


}
