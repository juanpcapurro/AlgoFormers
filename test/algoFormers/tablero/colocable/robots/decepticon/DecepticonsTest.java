package algoFormers.tablero.colocable.robots.decepticon;

import algoFormers.tablero.colocable.robots.armas.*;
import algoFormers.tablero.colocable.robots.AlgoFormer;


import static org.junit.Assert.*;
import org.junit.Test;

public class DecepticonsTest {


    @Test
    public void test01ElDecepticonTipoMegatronOcupaLugar(){

        Decepticon megatron = new Megatron();
        assertTrue(megatron.ocupaLugar());
    }

    @Test
    public void test02ElDecepticonTipoBonecrusherOcupaLugar(){

        Decepticon boneCrusher = new BoneCrusher();
        assertTrue(boneCrusher.ocupaLugar());
    }

    @Test
    public void test03ElDecepticonTipoFrenzyOcupaLugar(){

        Decepticon frenzy = new Frenzy();
        assertTrue(frenzy.ocupaLugar());
    }


}
