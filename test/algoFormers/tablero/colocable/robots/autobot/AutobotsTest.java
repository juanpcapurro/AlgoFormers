package algoFormers.tablero.colocable.robots.autobot;


import algoFormers.tablero.colocable.robots.decepticon.BoneCrusher;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class AutobotsTest{
    Autobots autobots;

    @Before
    public void Setup(){
        autobots= new Autobots();
    }
    @Test
    public void test01ElAutobotTipoOptimusOcupaLugar(){

        Optimus optimus = autobots.getOptimus();
        assertTrue(optimus.ocupaLugar());
    }

    @Test
    public void test02ElAutobotTipoBumplebeeOcupaLugar(){

        Bumblebee bumblebee = autobots.getBumblebee();
        assertTrue(bumblebee.ocupaLugar());
    }

    @Test
    public void test03ElAutobotTipoRatchetOcupaLugar(){

        Ratchet ratchet = autobots.getRatchet();
        assertTrue(ratchet.ocupaLugar());
    }


}
