package fiuba.algo3.algoFormers.entrega1;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.algoFormers.modelo.personajes.Algoformer;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoformerFactory;

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
		Algoformer optimusPrime = factory.getOptimusPrime();
		assertNotNull(optimusPrime);
	}
	
	@Test
	public void testCrearBumblebee(){
		AlgoformerFactory factory = new AlgoformerFactory();
		Algoformer bumblebee = factory.getBumblebee();
		assertNotNull(bumblebee);
	}
	
	@Test
	public void testCrearRatchet(){
		AlgoformerFactory factory = new AlgoformerFactory();
		Algoformer ratchet = factory.getRatchet();
		assertNotNull(ratchet);
	}
	
	@Test
	public void testCrearMegatron(){
		AlgoformerFactory factory = new AlgoformerFactory();
		Algoformer megatron = factory.getMegatron();
		assertNotNull(megatron);
	}
	
	@Test
	public void testCrearFrenzy(){
		AlgoformerFactory factory = new AlgoformerFactory();
		Algoformer frenzy = factory.getFrenzy();
		assertNotNull(frenzy);
	}
	
	@Test
	public void testCrearBonecrusher(){
		AlgoformerFactory factory = new AlgoformerFactory();
		Algoformer bonecrusher = factory.getBonecrusher();
		assertNotNull(bonecrusher);
	}
}
