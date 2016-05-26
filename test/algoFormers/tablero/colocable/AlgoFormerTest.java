package algoFormers.tablero.colocable;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import algoFormers.tablero.colocable.robots.AlgoFormer;

public class AlgoFormerTest{
	AlgoFormer mauricio = new AlgoFormer();//Mauricio es un algoformer que lucha por la alegria

	
	@Test
	public void elAlgoFormerOcupaLugar (){
		assertTrue(mauricio.ocupaLugar());
	}
}
