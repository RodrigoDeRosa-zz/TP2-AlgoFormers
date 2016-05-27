package fiuba.algo3.algoFormers.entrega1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.algoFormers.modelo.fabricas.AutoBotFactory;
import fiuba.algo3.algoFormers.modelo.fabricas.DecepticonFactory;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;

public class AtributosEnCreacionTest {

	//Tests de vida
	@Test
	public void testOptimusPrimeSeCreaConVidaCorrecta(){
		AutoBotFactory factory = new AutoBotFactory();
		AlgoFormer optimusPrime = factory.getOptimusPrime();
		assertEquals(optimusPrime.getVida(), 500);
	}
	
	@Test
	public void testBumblebeeSeCreaConVidaCorrecta(){
		AutoBotFactory factory = new AutoBotFactory();
		AlgoFormer bumblebee = factory.getBumblebee();
		assertEquals(bumblebee.getVida(), 350);
	}
	
	@Test
	public void testRatchetSeCreaConVidaCorrecta(){
		AutoBotFactory factory = new AutoBotFactory();
		AlgoFormer ratchet = factory.getRatchet();
		assertEquals(ratchet.getVida(), 150);
	}
	
	@Test
	public void testMegatronSeCreaConVidaCorrecta(){
		DecepticonFactory factory = new DecepticonFactory();
		AlgoFormer megatron = factory.getMegatron();
		assertEquals(megatron.getVida(), 550);
	}
	
	@Test
	public void testFrenzySeCreaConVidaCorrecta(){
		DecepticonFactory factory = new DecepticonFactory();
		AlgoFormer frenzy = factory.getFrenzy();
		assertEquals(frenzy.getVida(), 400);
	}
	
	@Test
	public void testBonecrusherSeCreaConVidaCorrecta(){
		DecepticonFactory factory = new DecepticonFactory();
		AlgoFormer bonecrusher = factory.getBonecrusher();
		assertEquals(bonecrusher.getVida(), 200);
	}
}
