package fiuba.algo3.algoFormers.entrega1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.algoFormers.modelo.personajes.Algoformer;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoformerFactory;

public class AtributosEstadoHumanoideEnCreacionTests {

	//Tests de velocidad
	@Test
	public void testOptimusPrimeSeCreaConVelocidadHumanoideCorrecta(){
		AlgoformerFactory factory = new AlgoformerFactory();
		Algoformer optimusPrime = factory.getOptimusPrime();
		assertEquals(optimusPrime.getPuntosVelocidad(), 2);
	}
	
	@Test
	public void testBumblebeeSeCreaConVelocidadHumanoideCorrecta(){
		AlgoformerFactory factory = new AlgoformerFactory();
		Algoformer bumblebee = factory.getBumblebee();
		assertEquals(bumblebee.getPuntosVelocidad(), 2);
	}
	
	@Test
	public void testRatchetSeCreaConVelocidadHumanoideCorrecta(){
		AlgoformerFactory factory = new AlgoformerFactory();
		Algoformer ratchet = factory.getRatchet();
		assertEquals(ratchet.getPuntosVelocidad(), 1);
	}
	
	@Test
	public void testMegatronSeCreaConVelocidadHumanoideCorrecta(){
		AlgoformerFactory factory = new AlgoformerFactory();
		Algoformer megatron = factory.getMegatron();
		assertEquals(megatron.getPuntosVelocidad(), 1);
	}
	
	@Test
	public void testFrenzySeCreaConVelocidadHumanoideCorrecta(){
		AlgoformerFactory factory = new AlgoformerFactory();
		Algoformer frenzy = factory.getFrenzy();
		assertEquals(frenzy.getPuntosVelocidad(), 2);
	}
	
	@Test
	public void testBonecrusherSeCreaConVelocidadHumanoideCorrecta(){
		AlgoformerFactory factory = new AlgoformerFactory();
		Algoformer bonecrusher = factory.getBonecrusher();
		assertEquals(bonecrusher.getPuntosVelocidad(), 1);
	}
	
	//Tests de Ataque
	@Test
	public void testOptimusPrimeSeCreaConAtaqueHumanoideCorrecta(){
		AlgoformerFactory factory = new AlgoformerFactory();
		Algoformer optimusPrime = factory.getOptimusPrime();
		assertEquals(optimusPrime.getPuntosAtaque(), 50);
	}
	
	@Test
	public void testBumblebeeSeCreaConAtaqueHumanoideCorrecta(){
		AlgoformerFactory factory = new AlgoformerFactory();
		Algoformer bumblebee = factory.getBumblebee();
		assertEquals(bumblebee.getPuntosAtaque(), 40);
	}
	
	@Test
	public void testRatchetSeCreaConAtaqueHumanoideCorrecta(){
		AlgoformerFactory factory = new AlgoformerFactory();
		Algoformer ratchet = factory.getRatchet();
		assertEquals(ratchet.getPuntosAtaque(), 5);
	}
	
	@Test
	public void testMegatronSeCreaConAtaqueHumanoideCorrecta(){
		AlgoformerFactory factory = new AlgoformerFactory();
		Algoformer megatron = factory.getMegatron();
		assertEquals(megatron.getPuntosAtaque(), 10);
	}
	
	@Test
	public void testFrenzySeCreaConAtaqueHumanoideCorrecta(){
		AlgoformerFactory factory = new AlgoformerFactory();
		Algoformer frenzy = factory.getFrenzy();
		assertEquals(frenzy.getPuntosAtaque(), 10);
	}
	
	@Test
	public void testBonecrusherSeCreaConAtaqueHumanoideCorrecta(){
		AlgoformerFactory factory = new AlgoformerFactory();
		Algoformer bonecrusher = factory.getBonecrusher();
		assertEquals(bonecrusher.getPuntosAtaque(), 30);
	}
	
	//Test de Distancia de Ataque
	@Test
	public void testOptimusPrimeSeCreaConDistanciaDeAtaqueHumanoideCorrecta(){
		AlgoformerFactory factory = new AlgoformerFactory();
		Algoformer optimusPrime = factory.getOptimusPrime();
		assertEquals(optimusPrime.getPuntosDistanciaDeAtaque(), 2);
	}
	
	@Test
	public void testBumblebeeSeCreaConDistanciaDeAtaqueHumanoideCorrecta(){
		AlgoformerFactory factory = new AlgoformerFactory();
		Algoformer bumblebee = factory.getBumblebee();
		assertEquals(bumblebee.getPuntosDistanciaDeAtaque(), 1);
	}
	
	@Test
	public void testRatchetSeCreaConDistanciaDeAtaqueHumanoideCorrecta(){
		AlgoformerFactory factory = new AlgoformerFactory();
		Algoformer ratchet = factory.getRatchet();
		assertEquals(ratchet.getPuntosDistanciaDeAtaque(), 5);
	}
	
	@Test
	public void testMegatronSeCreaConDistanciaDeAtaqueHumanoideCorrecta(){
		AlgoformerFactory factory = new AlgoformerFactory();
		Algoformer megatron = factory.getMegatron();
		assertEquals(megatron.getPuntosDistanciaDeAtaque(), 3);
	}
	
	@Test
	public void testFrenzySeCreaConDistanciaDeAtaqueHumanoideCorrecta(){
		AlgoformerFactory factory = new AlgoformerFactory();
		Algoformer frenzy = factory.getFrenzy();
		assertEquals(frenzy.getPuntosDistanciaDeAtaque(), 5);
	}
	
	@Test
	public void testBonecrusherSeCreaConDistanciaDeAtaqueHumanoideCorrecta(){
		AlgoformerFactory factory = new AlgoformerFactory();
		Algoformer bonecrusher = factory.getBonecrusher();
		assertEquals(bonecrusher.getPuntosDistanciaDeAtaque(), 3);
	}
}
