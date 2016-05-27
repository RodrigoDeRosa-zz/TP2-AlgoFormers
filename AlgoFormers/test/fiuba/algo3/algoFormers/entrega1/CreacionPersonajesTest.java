package fiuba.algo3.algoFormers.entrega1;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.algoFormers.modelo.fabricas.AutoBotFactory;
import fiuba.algo3.algoFormers.modelo.fabricas.DecepticonFactory;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;

public class CreacionPersonajesTest {

	//Tests de creacion de fabricas
	@Test
	public void testCrearFabricaDeAutoBots(){
		AutoBotFactory factory = new AutoBotFactory();
		assertNotNull(factory);
	}
	
	@Test
	public void testCrearFabricaDeDecepticons(){
		DecepticonFactory factory = new DecepticonFactory();
		assertNotNull(factory);
	}
	
	//Tests de creacion de AlgoFormers	
	@Test
	public void testCrearOptimusPrime(){
		AutoBotFactory factory = new AutoBotFactory();
		AlgoFormer optimusPrime = factory.getOptimusPrime();
		assertNotNull(optimusPrime);
	}
	
	@Test
	public void testCrearBumblebee(){
		AutoBotFactory factory = new AutoBotFactory();
		AlgoFormer bumblebee = factory.getBumblebee();
		assertNotNull(bumblebee);
	}
	
	@Test
	public void testCrearRatchet(){
		AutoBotFactory factory = new AutoBotFactory();
		AlgoFormer ratchet = factory.getRatchet();
		assertNotNull(ratchet);
	}
	
	@Test
	public void testCrearMegatron(){
		DecepticonFactory factory = new DecepticonFactory();
		AlgoFormer megatron = factory.getMegatron();
		assertNotNull(megatron);
	}
	
	@Test
	public void testCrearFrenzy(){
		DecepticonFactory factory = new DecepticonFactory();
		AlgoFormer frenzy = factory.getFrenzy();
		assertNotNull(frenzy);
	}
	
	@Test
	public void testCrearBonecrusher(){
		DecepticonFactory factory = new DecepticonFactory();
		AlgoFormer bonecrusher = factory.getBonecrusher();
		assertNotNull(bonecrusher);
	}
}
