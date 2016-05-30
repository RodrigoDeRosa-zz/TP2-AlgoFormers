package fiuba.algo3.algoFormers.entrega1;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.algoFormers.modelo.fabricas.AlgoformerFactory;
import fiuba.algo3.algoFormers.modelo.mapas.Casillero;
import fiuba.algo3.algoFormers.modelo.mapas.Mapa;
import fiuba.algo3.algoFormers.modelo.mapas.Posicion;
import fiuba.algo3.algoFormers.modelo.personajes.AutoBot;
import fiuba.algo3.algoFormers.modelo.personajes.Decepticon;
import fiuba.algo3.algoFormers.modelo.excepciones.CasilleroOcupadoException;


public class MapaTest {

	private Mapa mapa;
	private Decepticon megatron;
	private AutoBot optimusPrime;
	private Posicion posicion1;
	private AutoBot bumblebee;
	private Decepticon frenzy;

	@Before
	public void setUp(){
		AlgoformerFactory factoryA = new AlgoformerFactory();
		optimusPrime = factoryA.getOptimusPrime();
		bumblebee = factoryA.getBumblebee();
		AlgoformerFactory factoryD = new AlgoformerFactory();
		megatron = factoryD.getMegatron();
		frenzy = factoryD.getFrenzy();
		mapa = new Mapa();
		posicion1 = new Posicion(3,4); 
	}

	@Test
	public void testCrearUnMapa() {
		assertNotNull(mapa);
	}
	
	@Test
	public void testCrearUnMapaDeTamanioCorrectoLlenoDeCasilleros() {
		int tamanio = mapa.getTamanio();
		for(int fila = 1; fila <= tamanio; fila++){
			for(int columna = 1; columna <= tamanio; columna++){
				assertEquals(mapa.getCasillero(new Posicion(fila,columna)).getClass(), Casillero.class);
			}
		}
	}
	
	@Test
	public void testUbicarExitosamenteAUnAutobot(){
		mapa.ubicar(optimusPrime, posicion1);
		assertEquals(mapa.getUbicable(posicion1), optimusPrime);
	}
	
	@Test
	public void testUbicarExitosamenteAUnDecepticon(){
		mapa.ubicar(megatron, posicion1);
		assertEquals(mapa.getUbicable(posicion1), megatron);
	}
	
	@Test(expected = CasilleroOcupadoException.class)
	public void testFallaUbicarAUnAutobot(){
		mapa.ubicar(optimusPrime, posicion1);
		mapa.ubicar(bumblebee, posicion1);
	}
	
	@Test(expected = CasilleroOcupadoException.class)
	public void testFallaUbicarAUnDecepticon(){
		mapa.ubicar(megatron, posicion1);
		mapa.ubicar(frenzy, posicion1);
	}	

	
}
