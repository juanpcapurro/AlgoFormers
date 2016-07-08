package modelo.tablero.colocable.bonus;

import modelo.tablero.colocable.Colocable;
import modelo.tablero.colocable.robots.ContextoModoAlgoformer;
import modelo.tablero.colocable.robots.modificadores.BuffFlash;
import modelo.tablero.superficie.Superficie;

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
