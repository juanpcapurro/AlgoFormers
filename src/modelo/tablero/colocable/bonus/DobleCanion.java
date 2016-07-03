package modelo.tablero.colocable.bonus;

import modelo.tablero.colocable.Colocable;
import modelo.tablero.colocable.robots.ContextoModoAlgoformer;
import modelo.tablero.colocable.robots.modificadores.BuffDobleCanion;
import modelo.tablero.superficie.Superficie;

/*Duplica capacidad de ataque durante tres turnos propios*/
public class DobleCanion extends Colocable {

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
    public Object getEstado() {
        return null;
    }

    @Override
    public boolean retirar() {
        return false;
    }

}
