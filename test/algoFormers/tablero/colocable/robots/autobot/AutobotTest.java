package algoFormers.tablero.colocable.robots.autobot;


import algoFormers.tablero.colocable.robots.AlgoFormer;
import algoFormers.tablero.colocable.robots.armas.*;
import org.junit.Test;
import static org.junit.Assert.*;


public class AutobotTest{
    @Test
    public void test01ElAutobotTipoOptimusOcupaLugar(){

        Autobot optimus = new Optimus();
        assertTrue(optimus.ocupaLugar());
    }

    @Test
    public void test02ElAutobotTipoBumplebeeOcupaLugar(){

        Autobot bumblebee = new Bumblebee();
        assertTrue(bumblebee.ocupaLugar());
    }

    @Test
    public void test03ElAutobotTipoRatchetOcupaLugar(){

        Autobot ratchet = new Ratchet();
        assertTrue(ratchet.ocupaLugar());
    }

}
