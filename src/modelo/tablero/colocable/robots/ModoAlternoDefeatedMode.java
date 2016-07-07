package modelo.tablero.colocable.robots;

import modelo.tablero.superficie.Superficie;

public class ModoAlternoDefeatedMode extends ModoAlgoformer {
    public ModoAlternoDefeatedMode() {
        super(null,0,0,0);
    }

    @Override
    public void pasarPor(Superficie superficieTerrestre, Superficie superficieAerea) {

    }

    @Override
    public String getModificadorActivo(){
        return "Debilitado";
    }

    @Override
    public boolean esHumanoide() {
        return false;
    }

    @Override
    public boolean estaEnModoAlterno() {
        return false;
    }
}
