package algoFormers.tablero.colocable.robots.autobot;


import algoFormers.tablero.colocable.robots.decepticon.BoneCrusher;
import org.junit.Test;
import static org.junit.Assert.*;


public class AutobotTest{
    @Test
    public void test01ElAutobotTipoOptimusOcupaLugar(){

        Optimus optimus = new Optimus();
        assertTrue(optimus.ocupaLugar());
    }

    @Test
    public void test02ElAutobotTipoBumplebeeOcupaLugar(){

        Bumblebee bumblebee = new Bumblebee();
        assertTrue(bumblebee.ocupaLugar());
    }

    @Test
    public void test03ElAutobotTipoRatchetOcupaLugar(){

        Ratchet ratchet = new Ratchet();
        assertTrue(ratchet.ocupaLugar());
    }

}
