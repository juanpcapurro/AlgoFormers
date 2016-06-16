package algoFormers.tablero.colocable.robots.decepticon;


import static org.junit.Assert.*;
import org.junit.Test;

public class DecepticonsTest {


    @Test
    public void test01ElDecepticonTipoMegatronOcupaLugar(){

        Megatron megatron = new Megatron();
        assertTrue(megatron.ocupaLugar());
    }

    @Test
    public void test02ElDecepticonTipoBonecrusherOcupaLugar(){

        BoneCrusher boneCrusher = new BoneCrusher();
        assertTrue(boneCrusher.ocupaLugar());
    }

    @Test
    public void test03ElDecepticonTipoFrenzyOcupaLugar(){

        Frenzy frenzy = new Frenzy();
        assertTrue(frenzy.ocupaLugar());
    }


}
