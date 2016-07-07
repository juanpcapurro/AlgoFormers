package modelo.tablero.colocable;

import modelo.juego.JuegoFinalizado;
import modelo.tablero.colocable.robots.ContextoModoAlgoformer;
import modelo.tablero.superficie.Superficie;

public class Chispa extends Colocable{

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
        throw new JuegoFinalizado();
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
