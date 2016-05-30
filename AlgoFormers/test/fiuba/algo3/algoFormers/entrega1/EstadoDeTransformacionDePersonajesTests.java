package fiuba.algo3.algoFormers.entrega1;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.algoFormers.modelo.personajes.Algoformer;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoformerFactory;
import fiuba.algo3.algoFormers.modelo.personajes.estadosDeTransformacion.AlternoAereo;
import fiuba.algo3.algoFormers.modelo.personajes.estadosDeTransformacion.AlternoTerrestre;
import fiuba.algo3.algoFormers.modelo.personajes.estadosDeTransformacion.Humanoide;

public class EstadoDeTransformacionDePersonajesTests {
	
	//Tests estados AutoBots
		//Tests estados OptimusPrime
	@Test
	public void testOptimusPrimeSeCreaEnEstadoHumanoide(){
		AlgoformerFactory factory = new AlgoformerFactory();
		Algoformer optimusPrime = factory.getOptimusPrime(); // Se crea en estado humanoide
		assertEquals(optimusPrime.getEstado().getClass(), Humanoide.class);
	}
	
	@Test
	public void testOptimusPrimeSeTransformaDeHumanoideEnAlterno(){
		AlgoformerFactory factory = new AlgoformerFactory();
		Algoformer optimusPrime = factory.getOptimusPrime();
		optimusPrime.transformarse();
		assertEquals(optimusPrime.getEstado().getClass(), AlternoTerrestre.class);
	}
	
	@Test
	public void testOptimusPrimeSeTransformaDeAlternoEnHumanoide(){
		AlgoformerFactory factory = new AlgoformerFactory();
		Algoformer optimusPrime = factory.getOptimusPrime();
		optimusPrime.transformarse();
		optimusPrime.transformarse();
		assertEquals(optimusPrime.getEstado().getClass(), Humanoide.class);
	}
	
		//Tests estados Bumblebee
	@Test
	public void testBumblebeeSeCreaEnEstadoHumanoide(){
		AlgoformerFactory factory = new AlgoformerFactory();
		Algoformer bumblebee = factory.getBumblebee(); // Se crea en estado humanoide
		assertEquals(bumblebee.getEstado().getClass(), Humanoide.class);
	}
	
	@Test
	public void testBumblebeeSeTransformaDeHumanoideEnAlterno(){
		AlgoformerFactory factory = new AlgoformerFactory();
		Algoformer bumblebee = factory.getBumblebee();
		bumblebee.transformarse();
		assertEquals(bumblebee.getEstado().getClass(), AlternoTerrestre.class);
	}
	
	@Test
	public void testBumblebeeSeTransformaDeAlternoEnHumanoide(){
		AlgoformerFactory factory = new AlgoformerFactory();
		Algoformer bumblebee = factory.getBumblebee();
		bumblebee.transformarse();
		bumblebee.transformarse();
		assertEquals(bumblebee.getEstado().getClass(), Humanoide.class);
	}
	
		//Tests estados Ratchet
	@Test
	public void testRatchetSeCreaEnEstadoHumanoide(){
		AlgoformerFactory factory = new AlgoformerFactory();
		Algoformer ratchet = factory.getRatchet(); // Se crea en estado humanoide
		assertEquals(ratchet.getEstado().getClass(), Humanoide.class);
	}
	
	@Test
	public void testRatchetSeTransformaDeHumanoideEnAlterno(){
		AlgoformerFactory factory = new AlgoformerFactory();
		Algoformer ratchet = factory.getRatchet();
		ratchet.transformarse();
		assertEquals(ratchet.getEstado().getClass(), AlternoAereo.class);
	}
	
	@Test
	public void testRatchetSeTransformaDeAlternoEnHumanoide(){
		AlgoformerFactory factory = new AlgoformerFactory();
		Algoformer ratchet = factory.getRatchet();
		ratchet.transformarse();
		ratchet.transformarse();
		assertEquals(ratchet.getEstado().getClass(), Humanoide.class);
	}
	
	//Tests estados Decepticons
		//Tests estados Megatron
	@Test
	public void testMegatronSeCreaEnEstadoHumanoide(){
		AlgoformerFactory factory = new AlgoformerFactory();
		Algoformer megatron = factory.getMegatron();
		assertEquals(megatron.getEstado().getClass(), Humanoide.class);
	}
	
	@Test
	public void testMegatronSeTransformaDeHumanoideEnAlterno(){
		AlgoformerFactory factory = new AlgoformerFactory();
		Algoformer megatron = factory.getMegatron();
		megatron.transformarse();
		assertEquals(megatron.getEstado().getClass(), AlternoAereo.class);
	}
	
	@Test
	public void testMegatronSeTransformaDeAlternoEnHumanoide(){
		AlgoformerFactory factory = new AlgoformerFactory();
		Algoformer megatron = factory.getMegatron();
		megatron.transformarse();
		megatron.transformarse();
		assertEquals(megatron.getEstado().getClass(), Humanoide.class);
	}
	
	//Tests de estado de Frenzy
	@Test
	public void testFrenzySeCreaEnEstadoHumanoide(){
		AlgoformerFactory factory = new AlgoformerFactory();
		Algoformer frenzy = factory.getFrenzy();
		assertEquals(frenzy.getEstado().getClass(), Humanoide.class);
	}
	
	@Test
	public void testFrenzySeTransformaDeHumanoideEnAlterno(){
		AlgoformerFactory factory = new AlgoformerFactory();
		Algoformer frenzy = factory.getFrenzy();
		frenzy.transformarse();
		assertEquals(frenzy.getEstado().getClass(), AlternoTerrestre.class);
	}
	
	@Test
	public void testFrenzySeTransformaDeAlternoEnHumanoide(){
		AlgoformerFactory factory = new AlgoformerFactory();
		Algoformer frenzy = factory.getFrenzy();
		frenzy.transformarse();
		frenzy.transformarse();
		assertEquals(frenzy.getEstado().getClass(), Humanoide.class);
	}
	
	//Tests de estado de Bonecrusher
	@Test
	public void testBonecrusherSeCreaEnEstadoHumanoide(){
		AlgoformerFactory factory = new AlgoformerFactory();
		Algoformer bonecrusher = factory.getBonecrusher();
		assertEquals(bonecrusher.getEstado().getClass(), Humanoide.class);
	}
	
	@Test
	public void testBonecrusherSeTransformaDeHumanoideEnAlterno(){
		AlgoformerFactory factory = new AlgoformerFactory();
		Algoformer bonecrusher = factory.getBonecrusher();
		bonecrusher.transformarse();
		assertEquals(bonecrusher.getEstado().getClass(), AlternoTerrestre.class);
	}
	
	@Test
	public void testBonecrusherSeTransformaDeAlternoEnHumanoide(){
		AlgoformerFactory factory = new AlgoformerFactory();
		Algoformer bonecrusher = factory.getBonecrusher();
		bonecrusher.transformarse();
		bonecrusher.transformarse();
		assertEquals(bonecrusher.getEstado().getClass(), Humanoide.class);
	}
}
