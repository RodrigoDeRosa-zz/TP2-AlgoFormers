package fiuba.algo3.algoFormers.entrega1;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.algoFormers.modelo.fabricas.AlgoformerFactory;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;

public class CreacionPersonajesTest {

	//Tests de creacion de fabrica
	@Test
	public void testCrearFabricaDeAutoBots(){
		AlgoformerFactory factory = new AlgoformerFactory();
		assertNotNull(factory);
	}
	
	@Test
	public void testCrearFabricaDeDecepticons(){
		AlgoformerFactory factory = new AlgoformerFactory();
		assertNotNull(factory);
	}
	
	//Tests de creacion de AlgoFormers	
	@Test
	public void testCrearOptimusPrime(){
		AlgoformerFactory factory = new AlgoformerFactory();
		AlgoFormer optimusPrime = factory.getOptimusPrime();
		assertNotNull(optimusPrime);
	}
	
	@Test
	public void testCrearBumblebee(){
		AlgoformerFactory factory = new AlgoformerFactory();
		AlgoFormer bumblebee = factory.getBumblebee();
		assertNotNull(bumblebee);
	}
	
	@Test
	public void testCrearRatchet(){
		AlgoformerFactory factory = new AlgoformerFactory();
		AlgoFormer ratchet = factory.getRatchet();
		assertNotNull(ratchet);
	}
	
	@Test
	public void testCrearMegatron(){
		AlgoformerFactory factory = new AlgoformerFactory();
		AlgoFormer megatron = factory.getMegatron();
		assertNotNull(megatron);
	}
	
	@Test
	public void testCrearFrenzy(){
		AlgoformerFactory factory = new AlgoformerFactory();
		AlgoFormer frenzy = factory.getFrenzy();
		assertNotNull(frenzy);
	}
	
	@Test
	public void testCrearBonecrusher(){
		AlgoformerFactory factory = new AlgoformerFactory();
		AlgoFormer bonecrusher = factory.getBonecrusher();
		assertNotNull(bonecrusher);
	}
}
