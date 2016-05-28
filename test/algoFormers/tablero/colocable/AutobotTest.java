package algoFormers.tablero.colocable;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class AutobotTest{
    @Test
    public void elAutobotTipoOptimusOcupaLugar(){

        Autobot optimus = new Optimus();
        assertTrue(optimus.ocupaLugar());
    }

    @Test
    public void elAutobotTipoBumplebeeOcupaLugar(){

        Autobot bumblebee = new Bumblebee();
        assertTrue(bumblebee.ocupaLugar());
    }

    @Test
    public void elAutobotTipoRatchetOcupaLugar(){

        Autobot ratchet = new Ratchet();
        assertTrue(ratchet.ocupaLugar());
    }

}
