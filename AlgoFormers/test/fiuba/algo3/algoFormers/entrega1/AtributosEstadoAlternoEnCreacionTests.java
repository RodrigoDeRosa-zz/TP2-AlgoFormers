package fiuba.algo3.algoFormers.entrega1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.algoFormers.modelo.fabricas.AlgoformerFactory;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;

public class AtributosEstadoAlternoEnCreacionTests {

	//Tests de velocidad
	@Test
	public void testOptimusPrimeSeCreaConVelocidadAlternaCorrecta(){
		AlgoformerFactory factory = new AlgoformerFactory();
		AlgoFormer optimusPrime = factory.getOptimusPrime();
		optimusPrime.transformarse();
		assertEquals(optimusPrime.getPuntosVelocidad(), 5);
	}
	
	@Test
	public void testBumblebeeSeCreaConVelocidadAlternaCorrecta(){
		AlgoformerFactory factory = new AlgoformerFactory();
		AlgoFormer bumblebee = factory.getBumblebee();
		bumblebee.transformarse();
		assertEquals(bumblebee.getPuntosVelocidad(), 5);
	}
	
	@Test
	public void testRatchetSeCreaConVelocidadAlternaCorrecta(){
		AlgoformerFactory factory = new AlgoformerFactory();
		AlgoFormer ratchet = factory.getRatchet();
		ratchet.transformarse();
		assertEquals(ratchet.getPuntosVelocidad(), 8);
	}
	
	@Test
	public void testMegatronSeCreaConVelocidadAlternaCorrecta(){
		AlgoformerFactory factory = new AlgoformerFactory();
		AlgoFormer megatron = factory.getMegatron();
		megatron.transformarse();
		assertEquals(megatron.getPuntosVelocidad(), 8);
	}
	
	@Test
	public void testFrenzySeCreaConVelocidadAlternaCorrecta(){
		AlgoformerFactory factory = new AlgoformerFactory();
		AlgoFormer frenzy = factory.getFrenzy();
		frenzy.transformarse();
		assertEquals(frenzy.getPuntosVelocidad(), 6);
	}
	
	@Test
	public void testBonecrusherSeCreaConVelocidadAlternaCorrecta(){
		AlgoformerFactory factory = new AlgoformerFactory();
		AlgoFormer bonecrusher = factory.getBonecrusher();
		bonecrusher.transformarse();
		assertEquals(bonecrusher.getPuntosVelocidad(), 8);
	}
	
	//Tests de Ataque
	@Test
	public void testOptimusPrimeSeCreaConAtaqueAlternaCorrecta(){
		AlgoformerFactory factory = new AlgoformerFactory();
		AlgoFormer optimusPrime = factory.getOptimusPrime();
		optimusPrime.transformarse();
		assertEquals(optimusPrime.getPuntosAtaque(), 15);
	}
	
	@Test
	public void testBumblebeeSeCreaConAtaqueAlternaCorrecta(){
		AlgoformerFactory factory = new AlgoformerFactory();
		AlgoFormer bumblebee = factory.getBumblebee();
		bumblebee.transformarse();
		assertEquals(bumblebee.getPuntosAtaque(), 20);
	}
	
	@Test
	public void testRatchetSeCreaConAtaqueAlternaCorrecta(){
		AlgoformerFactory factory = new AlgoformerFactory();
		AlgoFormer ratchet = factory.getRatchet();
		ratchet.transformarse();
		assertEquals(ratchet.getPuntosAtaque(), 35);
	}
	
	@Test
	public void testMegatronSeCreaConAtaqueAlternaCorrecta(){
		AlgoformerFactory factory = new AlgoformerFactory();
		AlgoFormer megatron = factory.getMegatron();
		megatron.transformarse();
		assertEquals(megatron.getPuntosAtaque(), 55);
	}
	
	@Test
	public void testFrenzySeCreaConAtaqueAlternaCorrecta(){
		AlgoformerFactory factory = new AlgoformerFactory();
		AlgoFormer frenzy = factory.getFrenzy();
		frenzy.transformarse();
		assertEquals(frenzy.getPuntosAtaque(), 25);
	}
	
	@Test
	public void testBonecrusherSeCreaConAtaqueAlternaCorrecta(){
		AlgoformerFactory factory = new AlgoformerFactory();
		AlgoFormer bonecrusher = factory.getBonecrusher();
		bonecrusher.transformarse();
		assertEquals(bonecrusher.getPuntosAtaque(), 30);
	}
	
	//Tests de Distancia de Ataque
	@Test
	public void testOptimusPrimeSeCreaConDistanciaDeAtaqueAlternaCorrecta(){
		AlgoformerFactory factory = new AlgoformerFactory();
		AlgoFormer optimusPrime = factory.getOptimusPrime();
		optimusPrime.transformarse();
		assertEquals(optimusPrime.getPuntosDistanciaDeAtaque(), 4);
	}
	
	@Test
	public void testBumblebeeSeCreaConDistanciaDeAtaqueAlternaCorrecta(){
		AlgoformerFactory factory = new AlgoformerFactory();
		AlgoFormer bumblebee = factory.getBumblebee();
		bumblebee.transformarse();
		assertEquals(bumblebee.getPuntosDistanciaDeAtaque(), 3);
	}
	
	@Test
	public void testRatchetSeCreaConDistanciaDeAtaqueAlternaCorrecta(){
		AlgoformerFactory factory = new AlgoformerFactory();
		AlgoFormer ratchet = factory.getRatchet();
		ratchet.transformarse();
		assertEquals(ratchet.getPuntosDistanciaDeAtaque(), 2);
	}
	
	@Test
	public void testMegatronSeCreaConDistanciaDeAtaqueAlternaCorrecta(){
		AlgoformerFactory factory = new AlgoformerFactory();
		AlgoFormer megatron = factory.getMegatron();
		megatron.transformarse();
		assertEquals(megatron.getPuntosDistanciaDeAtaque(), 2);
	}
	
	@Test
	public void testFrenzySeCreaConDistanciaDeAtaqueAlternaCorrecta(){
		AlgoformerFactory factory = new AlgoformerFactory();
		AlgoFormer frenzy = factory.getFrenzy();
		frenzy.transformarse();
		assertEquals(frenzy.getPuntosDistanciaDeAtaque(), 2);
	}
	
	@Test
	public void testBonecrusherSeCreaConDistanciaDeAtaqueAlternaCorrecta(){
		AlgoformerFactory factory = new AlgoformerFactory();
		AlgoFormer bonecrusher = factory.getBonecrusher();
		bonecrusher.transformarse();
		assertEquals(bonecrusher.getPuntosDistanciaDeAtaque(), 3);
	}
}
