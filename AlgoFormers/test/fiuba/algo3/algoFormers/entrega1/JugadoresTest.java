package fiuba.algo3.algoFormers.entrega1;
import static org.junit.Assert.*;
import org.junit.Test;

import fiuba.algo3.algoFormers.modelo.fabricas.AutoBotFactory;
import fiuba.algo3.algoFormers.modelo.fabricas.DecepticonFactory;
import fiuba.algo3.algoFormers.modelo.jugadores.JugadorAutobots;
import fiuba.algo3.algoFormers.modelo.jugadores.JugadorDecepticons;
import fiuba.algo3.algoFormers.modelo.mapa.Mapa;
import fiuba.algo3.algoFormers.modelo.mapa.Posicion;
import fiuba.algo3.algoFormers.modelo.personajes.AutoBot;
import fiuba.algo3.algoFormers.modelo.personajes.Decepticon;

public class JugadoresTest {
	
	
	@Test
	public void crearJugadorAutobotsInicializaCorrectamenteASusAutobots() {
		
		JugadorAutobots jug = new JugadorAutobots();
		jug.inicializarEquipo();
		
		AutoBotFactory fabrica = new AutoBotFactory();
		AutoBot optimus = fabrica.getOptimusPrime();
		AutoBot bumb = fabrica.getBumblebee();
		AutoBot rat = fabrica.getRatchet();
		
		assertEquals(optimus, jug.getAlgoformer("Optimus Prime"));
		assertEquals(bumb, jug.getAlgoformer("Bumblebee"));
		assertEquals(rat, jug.getAlgoformer("Ratchet"));
		
	}
	
	@Test
	public void crearJugadorDecepticonsInicializaCorrectamenteASusDecepticons() {
		
		JugadorDecepticons jug = new JugadorDecepticons();
		jug.inicializarEquipo();
		
		DecepticonFactory fabrica = new DecepticonFactory();
		Decepticon optimus = fabrica.getMegatron();
		Decepticon bumb = fabrica.getBonecrusher();
		Decepticon rat = fabrica.getFrenzy();
		
		assertEquals(optimus, jug.getAlgoformer("Megatron"));
		assertEquals(bumb, jug.getAlgoformer("Bonecrusher"));
		assertEquals(rat, jug.getAlgoformer("Frenzy"));
		
	}
	
	@Test
	public void JugadorAutobotsUbicaCorrectamenteASusAutobots() {
		
		Mapa mapa = new Mapa();
		JugadorAutobots jug = new JugadorAutobots();
		jug.inicializarEquipo();
		AutoBotFactory fabrica = new AutoBotFactory();
		AutoBot optimus = fabrica.getOptimusPrime();
		AutoBot bumb = fabrica.getBumblebee();
		AutoBot rat = fabrica.getRatchet();
		Posicion posOptimus = new Posicion(0, 18);
		Posicion posBumb = new Posicion(0, 19);
		Posicion posRat = new Posicion(0, 20);
		
		jug.ubicarPersonajes(mapa);
		
		assertEquals(optimus, mapa.getAtacable(posOptimus));
		assertEquals(bumb, mapa.getAtacable(posBumb));
		assertEquals(rat, mapa.getAtacable(posRat));
		
		
		
	}
	
	@Test
	public void JugadorDecepticonsUbicaCorrectamenteASusDecepticons() {
		
		Mapa mapa = new Mapa();
		JugadorDecepticons jug = new JugadorDecepticons();
		jug.inicializarEquipo();
		DecepticonFactory fabrica = new DecepticonFactory();
		Decepticon megatron = fabrica.getMegatron();
		Decepticon boneC = fabrica.getBonecrusher();
		Decepticon frenzy = fabrica.getFrenzy();
		Posicion posOptimus = new Posicion(39, 18);
		Posicion posBumb = new Posicion(39, 19);
		Posicion posRat = new Posicion(39, 20);
		
		jug.ubicarPersonajes(mapa);
		
		assertEquals(megatron, mapa.getAtacable(posOptimus));
		assertEquals(boneC, mapa.getAtacable(posBumb));
		assertEquals(frenzy, mapa.getAtacable(posRat));
		
		
		
	}
}
