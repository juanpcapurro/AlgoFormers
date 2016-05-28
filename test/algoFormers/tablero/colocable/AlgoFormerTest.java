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

	@Test
	public void elAlgoFormerTipoOptimusOcupaLugar(){

		AlgoFormer optimus = new Optimus();
		assertTrue(optimus.ocupaLugar());
	}

	@Test
	public void elAlgoFormerTipoBumplebeeOcupaLugar(){

		AlgoFormer bumplebee = new Bumplebee();
		assertTrue(bumplebee.ocupaLugar());
	}

	@Test
	public void elAlgoFormerTipoRatchetOcupaLugar(){

		AlgoFormer ratchet = new Ratchet();
		assertTrue(ratchet.ocupaLugar());
	}
}
