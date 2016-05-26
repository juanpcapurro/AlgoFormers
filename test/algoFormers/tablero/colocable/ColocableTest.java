package algoFormers.tablero.colocable;

import org.junit.Test;
import static org.junit.Assert.*;

public class ColocableTest{
	
	@Test
	public void  espacioVacioNoOcupaLugar(){
		Colocable unColocable = new EspacioVacio();
		assertFalse(unColocable.ocupaLugar());
	}

	
	@Test
	public void algoFormerOcupaLugar (){
		Colocable unAlgoFormer = new AlgoFormer();
		assertTrue(unAlgoFormer.ocupaLugar());
	}
}
