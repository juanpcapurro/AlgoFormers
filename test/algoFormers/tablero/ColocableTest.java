package algoFormers.tablero;

import org.junit.Test;
import static org.junit.Assert.*;

public class ColocableTest{
	
	@Test
	public void  espacioVacioNoOcupaLugar(){
		Colocable unColocable = new EspacioVacio();
		assertFalse(unColocable.ocupaLugar());
	}

}
