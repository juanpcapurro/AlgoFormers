package algoFormers.tablero.colocable;

import algoFormers.tablero.colocable.robots.autobot.Optimus;
import org.junit.Test;
import static org.junit.Assert.*;

import algoFormers.tablero.colocable.robots.AlgoFormer;

public class ColocableTest{
	
	@Test
	public void  test01EspacioVacioNoOcupaLugar(){
		Colocable unColocable = new EspacioVacio();
		assertFalse(unColocable.ocupaLugar());
	}

	
	@Test
	public void test02AlgoFormerOcupaLugar (){
		Optimus optimus = new Optimus();
		Colocable unAlgoFormer = optimus;
		assertTrue(unAlgoFormer.ocupaLugar());
	}
}
