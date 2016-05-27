package fiuba.algo3.algoFormers.entrega1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.algoFormers.modelo.fabricas.AutoBotFactory;
import fiuba.algo3.algoFormers.modelo.fabricas.DecepticonFactory;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;

public class AtributosEstadoHumanoideEnCreacionTests {

	//Tests de velocidad
	@Test
	public void testOptimusPrimeSeCreaConVelocidadAlternaCorrecta(){
		AutoBotFactory factory = new AutoBotFactory();
		AlgoFormer optimusPrime = factory.getOptimusPrime();
		assertEquals(optimusPrime.getVelocidad(), 2);
	}
	
	@Test
	public void testBumblebeeSeCreaConVelocidadAlternaCorrecta(){
		AutoBotFactory factory = new AutoBotFactory();
		AlgoFormer bumblebee = factory.getBumblebee();
		assertEquals(bumblebee.getVelocidad(), 2);
	}
	
	@Test
	public void testRatchetSeCreaConVelocidadAlternaCorrecta(){
		AutoBotFactory factory = new AutoBotFactory();
		AlgoFormer ratchet = factory.getRatchet();
		assertEquals(ratchet.getVelocidad(), 1);
	}
	
	@Test
	public void testMegatronSeCreaConVelocidadAlternaCorrecta(){
		DecepticonFactory factory = new DecepticonFactory();
		AlgoFormer megatron = factory.getMegatron();
		assertEquals(megatron.getVelocidad(), 1);
	}
	
	@Test
	public void testFrenzySeCreaConVelocidadAlternaCorrecta(){
		DecepticonFactory factory = new DecepticonFactory();
		AlgoFormer frenzy = factory.getFrenzy();
		assertEquals(frenzy.getVelocidad(), 2);
	}
	
	@Test
	public void testBonecrusherSeCreaConVelocidadAlternaCorrecta(){
		DecepticonFactory factory = new DecepticonFactory();
		AlgoFormer bonecrusher = factory.getBonecrusher();
		assertEquals(bonecrusher.getVelocidad(), 1);
	}
	
	//Tests de Ataque
	@Test
	public void testOptimusPrimeSeCreaConAtaqueAlternaCorrecta(){
		AutoBotFactory factory = new AutoBotFactory();
		AlgoFormer optimusPrime = factory.getOptimusPrime();
		assertEquals(optimusPrime.getAtaque(), 2);
	}
	
	@Test
	public void testBumblebeeSeCreaConAtaqueAlternaCorrecta(){
		AutoBotFactory factory = new AutoBotFactory();
		AlgoFormer bumblebee = factory.getBumblebee();
		assertEquals(bumblebee.getAtaque(), 2);
	}
	
	@Test
	public void testRatchetSeCreaConAtaqueAlternaCorrecta(){
		AutoBotFactory factory = new AutoBotFactory();
		AlgoFormer ratchet = factory.getRatchet();
		assertEquals(ratchet.getAtaque(), 1);
	}
	
	@Test
	public void testMegatronSeCreaConAtaqueAlternaCorrecta(){
		DecepticonFactory factory = new DecepticonFactory();
		AlgoFormer megatron = factory.getMegatron();
		assertEquals(megatron.getAtaque(), 1);
	}
	
	@Test
	public void testFrenzySeCreaConAtaqueAlternaCorrecta(){
		DecepticonFactory factory = new DecepticonFactory();
		AlgoFormer frenzy = factory.getFrenzy();
		assertEquals(frenzy.getAtaque(), 2);
	}
	
	@Test
	public void testBonecrusherSeCreaConAtaqueAlternaCorrecta(){
		DecepticonFactory factory = new DecepticonFactory();
		AlgoFormer bonecrusher = factory.getBonecrusher();
		assertEquals(bonecrusher.getAtaque(), 1);
	}
}
