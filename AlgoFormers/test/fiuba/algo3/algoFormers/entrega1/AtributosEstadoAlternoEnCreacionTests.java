package fiuba.algo3.algoFormers.entrega1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.algoFormers.modelo.fabricas.AutoBotFactory;
import fiuba.algo3.algoFormers.modelo.fabricas.DecepticonFactory;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;

public class AtributosEstadoAlternoEnCreacionTests {

	//Tests de velocidad
	@Test
	public void testOptimusPrimeSeCreaConVelocidadAlternaCorrecta(){
		AutoBotFactory factory = new AutoBotFactory();
		AlgoFormer optimusPrime = factory.getOptimusPrime();
		optimusPrime.transformarse();
		assertEquals(optimusPrime.getVelocidad(), 5);
	}
	
	@Test
	public void testBumblebeeSeCreaConVelocidadAlternaCorrecta(){
		AutoBotFactory factory = new AutoBotFactory();
		AlgoFormer bumblebee = factory.getBumblebee();
		bumblebee.transformarse();
		assertEquals(bumblebee.getVelocidad(), 5);
	}
	
	@Test
	public void testRatchetSeCreaConVelocidadAlternaCorrecta(){
		AutoBotFactory factory = new AutoBotFactory();
		AlgoFormer ratchet = factory.getRatchet();
		ratchet.transformarse();
		assertEquals(ratchet.getVelocidad(), 8);
	}
	
	@Test
	public void testMegatronSeCreaConVelocidadAlternaCorrecta(){
		DecepticonFactory factory = new DecepticonFactory();
		AlgoFormer megatron = factory.getMegatron();
		megatron.transformarse();
		assertEquals(megatron.getVelocidad(), 8);
	}
	
	@Test
	public void testFrenzySeCreaConVelocidadAlternaCorrecta(){
		DecepticonFactory factory = new DecepticonFactory();
		AlgoFormer frenzy = factory.getFrenzy();
		frenzy.transformarse();
		assertEquals(frenzy.getVelocidad(), 6);
	}
	
	@Test
	public void testBonecrusherSeCreaConVelocidadAlternaCorrecta(){
		DecepticonFactory factory = new DecepticonFactory();
		AlgoFormer bonecrusher = factory.getBonecrusher();
		bonecrusher.transformarse();
		assertEquals(bonecrusher.getVelocidad(), 8);
	}
	
	//Tests de Ataque
	@Test
	public void testOptimusPrimeSeCreaConAtaqueAlternaCorrecta(){
		AutoBotFactory factory = new AutoBotFactory();
		AlgoFormer optimusPrime = factory.getOptimusPrime();
		optimusPrime.transformarse();
		assertEquals(optimusPrime.getAtaque(), 15);
	}
	
	@Test
	public void testBumblebeeSeCreaConAtaqueAlternaCorrecta(){
		AutoBotFactory factory = new AutoBotFactory();
		AlgoFormer bumblebee = factory.getBumblebee();
		bumblebee.transformarse();
		assertEquals(bumblebee.getAtaque(), 20);
	}
	
	@Test
	public void testRatchetSeCreaConAtaqueAlternaCorrecta(){
		AutoBotFactory factory = new AutoBotFactory();
		AlgoFormer ratchet = factory.getRatchet();
		ratchet.transformarse();
		assertEquals(ratchet.getAtaque(), 35);
	}
	
	@Test
	public void testMegatronSeCreaConAtaqueAlternaCorrecta(){
		DecepticonFactory factory = new DecepticonFactory();
		AlgoFormer megatron = factory.getMegatron();
		megatron.transformarse();
		assertEquals(megatron.getAtaque(), 55);
	}
	
	@Test
	public void testFrenzySeCreaConAtaqueAlternaCorrecta(){
		DecepticonFactory factory = new DecepticonFactory();
		AlgoFormer frenzy = factory.getFrenzy();
		frenzy.transformarse();
		assertEquals(frenzy.getAtaque(), 25);
	}
	
	@Test
	public void testBonecrusherSeCreaConAtaqueAlternaCorrecta(){
		DecepticonFactory factory = new DecepticonFactory();
		AlgoFormer bonecrusher = factory.getBonecrusher();
		bonecrusher.transformarse();
		assertEquals(bonecrusher.getAtaque(), 30);
	}
	
	//Tests de Distancia de Ataque
	@Test
	public void testOptimusPrimeSeCreaConDistanciaDeAtaqueAlternaCorrecta(){
		AutoBotFactory factory = new AutoBotFactory();
		AlgoFormer optimusPrime = factory.getOptimusPrime();
		optimusPrime.transformarse();
		assertEquals(optimusPrime.getDistanciaDeAtaque(), 4);
	}
	
	@Test
	public void testBumblebeeSeCreaConDistanciaDeAtaqueAlternaCorrecta(){
		AutoBotFactory factory = new AutoBotFactory();
		AlgoFormer bumblebee = factory.getBumblebee();
		bumblebee.transformarse();
		assertEquals(bumblebee.getDistanciaDeAtaque(), 3);
	}
	
	@Test
	public void testRatchetSeCreaConDistanciaDeAtaqueAlternaCorrecta(){
		AutoBotFactory factory = new AutoBotFactory();
		AlgoFormer ratchet = factory.getRatchet();
		ratchet.transformarse();
		assertEquals(ratchet.getDistanciaDeAtaque(), 2);
	}
	
	@Test
	public void testMegatronSeCreaConDistanciaDeAtaqueAlternaCorrecta(){
		DecepticonFactory factory = new DecepticonFactory();
		AlgoFormer megatron = factory.getMegatron();
		megatron.transformarse();
		assertEquals(megatron.getDistanciaDeAtaque(), 2);
	}
	
	@Test
	public void testFrenzySeCreaConDistanciaDeAtaqueAlternaCorrecta(){
		DecepticonFactory factory = new DecepticonFactory();
		AlgoFormer frenzy = factory.getFrenzy();
		frenzy.transformarse();
		assertEquals(frenzy.getDistanciaDeAtaque(), 2);
	}
	
	@Test
	public void testBonecrusherSeCreaConDistanciaDeAtaqueAlternaCorrecta(){
		DecepticonFactory factory = new DecepticonFactory();
		AlgoFormer bonecrusher = factory.getBonecrusher();
		bonecrusher.transformarse();
		assertEquals(bonecrusher.getDistanciaDeAtaque(), 3);
	}
}
