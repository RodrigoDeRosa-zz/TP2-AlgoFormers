package fiuba.algo3.algoFormers.entrega1;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.algoFormers.modelo.fabricas.AutoBotFactory;
import fiuba.algo3.algoFormers.modelo.fabricas.DecepticonFactory;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;
import fiuba.algo3.algoFormers.modelo.personajes.estadosDeTransformacion.AlternoAereo;
import fiuba.algo3.algoFormers.modelo.personajes.estadosDeTransformacion.AlternoTerrestre;
import fiuba.algo3.algoFormers.modelo.personajes.estadosDeTransformacion.Humanoide;

public class EstadoDeTransformacionDePersonajesTests {
	
	//Tests estados AutoBots
		//Tests estados OptimusPrime
	@Test
	public void testOptimusPrimeSeCreaEnEstadoHumanoide(){
		AutoBotFactory factory = new AutoBotFactory();
		AlgoFormer optimusPrime = factory.getOptimusPrime(); // Se crea en estado humanoide
		assertEquals(optimusPrime.getEstado().getClass(), Humanoide.class);
	}
	
	@Test
	public void testOptimusPrimeSeTransformaDeHumanoideEnAlterno(){
		AutoBotFactory factory = new AutoBotFactory();
		AlgoFormer optimusPrime = factory.getOptimusPrime();
		optimusPrime.transformarse();
		assertEquals(optimusPrime.getEstado().getClass(), AlternoTerrestre.class);
	}
	
	@Test
	public void testOptimusPrimeSeTransformaDeAlternoEnHumanoide(){
		AutoBotFactory factory = new AutoBotFactory();
		AlgoFormer optimusPrime = factory.getOptimusPrime();
		optimusPrime.transformarse();
		optimusPrime.transformarse();
		assertEquals(optimusPrime.getEstado().getClass(), Humanoide.class);
	}
	
		//Tests estados Bumblebee
	@Test
	public void testBumblebeeSeCreaEnEstadoHumanoide(){
		AutoBotFactory factory = new AutoBotFactory();
		AlgoFormer bumblebee = factory.getBumblebee(); // Se crea en estado humanoide
		assertEquals(bumblebee.getEstado().getClass(), Humanoide.class);
	}
	
	@Test
	public void testBumblebeeSeTransformaDeHumanoideEnAlterno(){
		AutoBotFactory factory = new AutoBotFactory();
		AlgoFormer bumblebee = factory.getBumblebee();
		bumblebee.transformarse();
		assertEquals(bumblebee.getEstado().getClass(), AlternoTerrestre.class);
	}
	
	@Test
	public void testBumblebeeSeTransformaDeAlternoEnHumanoide(){
		AutoBotFactory factory = new AutoBotFactory();
		AlgoFormer bumblebee = factory.getBumblebee();
		bumblebee.transformarse();
		bumblebee.transformarse();
		assertEquals(bumblebee.getEstado().getClass(), Humanoide.class);
	}
	
		//Tests estados Ratchet
	@Test
	public void testRatchetSeCreaEnEstadoHumanoide(){
		AutoBotFactory factory = new AutoBotFactory();
		AlgoFormer ratchet = factory.getRatchet(); // Se crea en estado humanoide
		assertEquals(ratchet.getEstado().getClass(), Humanoide.class);
	}
	
	@Test
	public void testRatchetSeTransformaDeHumanoideEnAlterno(){
		AutoBotFactory factory = new AutoBotFactory();
		AlgoFormer ratchet = factory.getRatchet();
		ratchet.transformarse();
		assertEquals(ratchet.getEstado().getClass(), AlternoAereo.class);
	}
	
	@Test
	public void testRatchetSeTransformaDeAlternoEnHumanoide(){
		AutoBotFactory factory = new AutoBotFactory();
		AlgoFormer ratchet = factory.getRatchet();
		ratchet.transformarse();
		ratchet.transformarse();
		assertEquals(ratchet.getEstado().getClass(), Humanoide.class);
	}
	
	//Tests estados Decepticons
		//Tests estados Megatron
	@Test
	public void testMegatronSeCreaEnEstadoHumanoide(){
		DecepticonFactory factory = new DecepticonFactory();
		AlgoFormer megatron = factory.getMegatron();
		assertEquals(megatron.getEstado().getClass(), Humanoide.class);
	}
	
	@Test
	public void testMegatronSeTransformaDeHumanoideEnAlterno(){
		DecepticonFactory factory = new DecepticonFactory();
		AlgoFormer megatron = factory.getMegatron();
		megatron.transformarse();
		assertEquals(megatron.getEstado().getClass(), AlternoAereo.class);
	}
	
	@Test
	public void testMegatronSeTransformaDeAlternoEnHumanoide(){
		DecepticonFactory factory = new DecepticonFactory();
		AlgoFormer megatron = factory.getMegatron();
		megatron.transformarse();
		megatron.transformarse();
		assertEquals(megatron.getEstado().getClass(), Humanoide.class);
	}
	
	//Tests de estado de Frenzy
	@Test
	public void testFrenzySeCreaEnEstadoHumanoide(){
		DecepticonFactory factory = new DecepticonFactory();
		AlgoFormer frenzy = factory.getFrenzy();
		assertEquals(frenzy.getEstado().getClass(), Humanoide.class);
	}
	
	@Test
	public void testFrenzySeTransformaDeHumanoideEnAlterno(){
		DecepticonFactory factory = new DecepticonFactory();
		AlgoFormer frenzy = factory.getFrenzy();
		frenzy.transformarse();
		assertEquals(frenzy.getEstado().getClass(), AlternoTerrestre.class);
	}
	
	@Test
	public void testFrenzySeTransformaDeAlternoEnHumanoide(){
		DecepticonFactory factory = new DecepticonFactory();
		AlgoFormer frenzy = factory.getFrenzy();
		frenzy.transformarse();
		frenzy.transformarse();
		assertEquals(frenzy.getEstado().getClass(), Humanoide.class);
	}
	
	//Tests de estado de Bonecrusher
	@Test
	public void testBonecrusherSeCreaEnEstadoHumanoide(){
		DecepticonFactory factory = new DecepticonFactory();
		AlgoFormer bonecrusher = factory.getBonecrusher();
		assertEquals(bonecrusher.getEstado().getClass(), Humanoide.class);
	}
	
	@Test
	public void testBonecrusherSeTransformaDeHumanoideEnAlterno(){
		DecepticonFactory factory = new DecepticonFactory();
		AlgoFormer bonecrusher = factory.getBonecrusher();
		bonecrusher.transformarse();
		assertEquals(bonecrusher.getEstado().getClass(), AlternoTerrestre.class);
	}
	
	@Test
	public void testBonecrusherSeTransformaDeAlternoEnHumanoide(){
		DecepticonFactory factory = new DecepticonFactory();
		AlgoFormer bonecrusher = factory.getBonecrusher();
		bonecrusher.transformarse();
		bonecrusher.transformarse();
		assertEquals(bonecrusher.getEstado().getClass(), Humanoide.class);
	}
}
