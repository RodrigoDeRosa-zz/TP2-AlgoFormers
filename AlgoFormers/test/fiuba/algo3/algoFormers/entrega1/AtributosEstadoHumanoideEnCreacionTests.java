package fiuba.algo3.algoFormers.entrega1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.algoFormers.modelo.fabricas.AutoBotFactory;
import fiuba.algo3.algoFormers.modelo.fabricas.DecepticonFactory;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;

public class AtributosEstadoHumanoideEnCreacionTests {

	//Tests de velocidad
	@Test
	public void testOptimusPrimeSeCreaConVelocidadHumanoideCorrecta(){
		AutoBotFactory factory = new AutoBotFactory();
		AlgoFormer optimusPrime = factory.getOptimusPrime();
		assertEquals(optimusPrime.getVelocidad(), 2);
	}
	
	@Test
	public void testBumblebeeSeCreaConVelocidadHumanoideCorrecta(){
		AutoBotFactory factory = new AutoBotFactory();
		AlgoFormer bumblebee = factory.getBumblebee();
		assertEquals(bumblebee.getVelocidad(), 2);
	}
	
	@Test
	public void testRatchetSeCreaConVelocidadHumanoideCorrecta(){
		AutoBotFactory factory = new AutoBotFactory();
		AlgoFormer ratchet = factory.getRatchet();
		assertEquals(ratchet.getVelocidad(), 1);
	}
	
	@Test
	public void testMegatronSeCreaConVelocidadHumanoideCorrecta(){
		DecepticonFactory factory = new DecepticonFactory();
		AlgoFormer megatron = factory.getMegatron();
		assertEquals(megatron.getVelocidad(), 1);
	}
	
	@Test
	public void testFrenzySeCreaConVelocidadHumanoideCorrecta(){
		DecepticonFactory factory = new DecepticonFactory();
		AlgoFormer frenzy = factory.getFrenzy();
		assertEquals(frenzy.getVelocidad(), 2);
	}
	
	@Test
	public void testBonecrusherSeCreaConVelocidadHumanoideCorrecta(){
		DecepticonFactory factory = new DecepticonFactory();
		AlgoFormer bonecrusher = factory.getBonecrusher();
		assertEquals(bonecrusher.getVelocidad(), 1);
	}
	
	//Tests de Ataque
	@Test
	public void testOptimusPrimeSeCreaConAtaqueHumanoideCorrecta(){
		AutoBotFactory factory = new AutoBotFactory();
		AlgoFormer optimusPrime = factory.getOptimusPrime();
		assertEquals(optimusPrime.getAtaque(), 50);
	}
	
	@Test
	public void testBumblebeeSeCreaConAtaqueHumanoideCorrecta(){
		AutoBotFactory factory = new AutoBotFactory();
		AlgoFormer bumblebee = factory.getBumblebee();
		assertEquals(bumblebee.getAtaque(), 40);
	}
	
	@Test
	public void testRatchetSeCreaConAtaqueHumanoideCorrecta(){
		AutoBotFactory factory = new AutoBotFactory();
		AlgoFormer ratchet = factory.getRatchet();
		assertEquals(ratchet.getAtaque(), 5);
	}
	
	@Test
	public void testMegatronSeCreaConAtaqueHumanoideCorrecta(){
		DecepticonFactory factory = new DecepticonFactory();
		AlgoFormer megatron = factory.getMegatron();
		assertEquals(megatron.getAtaque(), 10);
	}
	
	@Test
	public void testFrenzySeCreaConAtaqueHumanoideCorrecta(){
		DecepticonFactory factory = new DecepticonFactory();
		AlgoFormer frenzy = factory.getFrenzy();
		assertEquals(frenzy.getAtaque(), 10);
	}
	
	@Test
	public void testBonecrusherSeCreaConAtaqueHumanoideCorrecta(){
		DecepticonFactory factory = new DecepticonFactory();
		AlgoFormer bonecrusher = factory.getBonecrusher();
		assertEquals(bonecrusher.getAtaque(), 30);
	}
	
	//Test de Distancia de Ataque
	@Test
	public void testOptimusPrimeSeCreaConDistanciaDeAtaqueHumanoideCorrecta(){
		AutoBotFactory factory = new AutoBotFactory();
		AlgoFormer optimusPrime = factory.getOptimusPrime();
		assertEquals(optimusPrime.getDistanciaDeAtaque(), 2);
	}
	
	@Test
	public void testBumblebeeSeCreaConDistanciaDeAtaqueHumanoideCorrecta(){
		AutoBotFactory factory = new AutoBotFactory();
		AlgoFormer bumblebee = factory.getBumblebee();
		assertEquals(bumblebee.getDistanciaDeAtaque(), 1);
	}
	
	@Test
	public void testRatchetSeCreaConDistanciaDeAtaqueHumanoideCorrecta(){
		AutoBotFactory factory = new AutoBotFactory();
		AlgoFormer ratchet = factory.getRatchet();
		assertEquals(ratchet.getDistanciaDeAtaque(), 5);
	}
	
	@Test
	public void testMegatronSeCreaConDistanciaDeAtaqueHumanoideCorrecta(){
		DecepticonFactory factory = new DecepticonFactory();
		AlgoFormer megatron = factory.getMegatron();
		assertEquals(megatron.getDistanciaDeAtaque(), 3);
	}
	
	@Test
	public void testFrenzySeCreaConDistanciaDeAtaqueHumanoideCorrecta(){
		DecepticonFactory factory = new DecepticonFactory();
		AlgoFormer frenzy = factory.getFrenzy();
		assertEquals(frenzy.getDistanciaDeAtaque(), 5);
	}
	
	@Test
	public void testBonecrusherSeCreaConDistanciaDeAtaqueHumanoideCorrecta(){
		DecepticonFactory factory = new DecepticonFactory();
		AlgoFormer bonecrusher = factory.getBonecrusher();
		assertEquals(bonecrusher.getDistanciaDeAtaque(), 3);
	}
}
