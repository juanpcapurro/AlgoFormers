package algoFormers.tablero.colocable;
import algoFormers.tablero.colocable.robots.Decepticon;
import algoFormers.tablero.colocable.robots.Megatron;
import algoFormers.tablero.colocable.robots.BoneCrusher;
import algoFormers.tablero.colocable.robots.Frenzy;


import static org.junit.Assert.*;
import org.junit.Test;

public class DecepticonsTest {


    @Test
    public void elDecepticonTipoMegatronOcupaLugar(){

        Decepticon megatron = new Megatron();
        assertTrue(megatron.ocupaLugar());
    }

    @Test
    public void elDecepticonTipoBonecrusherOcupaLugar(){

        Decepticon boneCrusher = new BoneCrusher();
        assertTrue(boneCrusher.ocupaLugar());
    }

    @Test
    public void elDecepticonTipoFrenzyOcupaLugar(){

        Decepticon frenzy = new Frenzy();
        assertTrue(frenzy.ocupaLugar());
    }


}
