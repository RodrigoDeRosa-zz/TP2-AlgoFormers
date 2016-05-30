package fiuba.algo3.algoFormers.entrega1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.algoFormers.modelo.fabricas.AlgoformerFactory;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;

public class AtributosEnCreacionTest {

	//Tests de vida
	@Test
	public void testOptimusPrimeSeCreaConVidaCorrecta(){
		AlgoformerFactory factory = new AlgoformerFactory();
		AlgoFormer optimusPrime = factory.getOptimusPrime();
		assertEquals(optimusPrime.getPuntosVida(), 500);
	}
	
	@Test
	public void testBumblebeeSeCreaConVidaCorrecta(){
		AlgoformerFactory factory = new AlgoformerFactory();
		AlgoFormer bumblebee = factory.getBumblebee();
		assertEquals(bumblebee.getPuntosVida(), 350);
	}
	
	@Test
	public void testRatchetSeCreaConVidaCorrecta(){
		AlgoformerFactory factory = new AlgoformerFactory();
		AlgoFormer ratchet = factory.getRatchet();
		assertEquals(ratchet.getPuntosVida(), 150);
	}
	
	@Test
	public void testMegatronSeCreaConVidaCorrecta(){
		AlgoformerFactory factory = new AlgoformerFactory();
		AlgoFormer megatron = factory.getMegatron();
		assertEquals(megatron.getPuntosVida(), 550);
	}
	
	@Test
	public void testFrenzySeCreaConVidaCorrecta(){
		AlgoformerFactory factory = new AlgoformerFactory();
		AlgoFormer frenzy = factory.getFrenzy();
		assertEquals(frenzy.getPuntosVida(), 400);
	}
	
	@Test
	public void testBonecrusherSeCreaConVidaCorrecta(){
		AlgoformerFactory factory = new AlgoformerFactory();
		AlgoFormer bonecrusher = factory.getBonecrusher();
		assertEquals(bonecrusher.getPuntosVida(), 200);
	}
}
