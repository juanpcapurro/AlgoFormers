package algoFormers.tablero;

import static org.junit.assert.*;
import org.junit.Test;

public class ColocableTest{
	
	@Test
	public void  espacioVacioNoOcupaLugar(){
		Colocable unColocable = new EspacioVacio();
		assertFalse(unColocable.ocupaLugar());
	}

}
