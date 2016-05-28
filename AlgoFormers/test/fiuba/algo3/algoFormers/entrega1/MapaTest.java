package fiuba.algo3.algoFormers.entrega1;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.algoFormers.modelo.fabricas.AutoBotFactory;
import fiuba.algo3.algoFormers.modelo.fabricas.DecepticonFactory;
import fiuba.algo3.algoFormers.modelo.mapas.Casillero;
import fiuba.algo3.algoFormers.modelo.mapas.Mapa;
import fiuba.algo3.algoFormers.modelo.mapas.Posicion;
import fiuba.algo3.algoFormers.modelo.personajes.AutoBot;
import fiuba.algo3.algoFormers.modelo.personajes.Decepticon;
import fiuba.algo3.algoFormers.modelo.direcciones.DirAbajo;
import fiuba.algo3.algoFormers.modelo.direcciones.DirAbajoDer;
import fiuba.algo3.algoFormers.modelo.direcciones.DirArriba;
import fiuba.algo3.algoFormers.modelo.direcciones.DirArribaDer;
import fiuba.algo3.algoFormers.modelo.excepciones.CasilleroOcupadoException;
import fiuba.algo3.algoFormers.modelo.excepciones.UbicableNoPertenceAlMapaException;


public class MapaTest {

	private Mapa mapa;
	private Decepticon megatron;
	private AutoBot optimusPrime;
	private Posicion posicion1;
	private AutoBot bumblebee;
	private Decepticon frenzy;

	@Before
	public void setUp(){
		AutoBotFactory factoryA = new AutoBotFactory();
		optimusPrime = factoryA.getOptimusPrime();
		bumblebee = factoryA.getBumblebee();
		DecepticonFactory factoryD = new DecepticonFactory();
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
		for(int i = 0; i < tamanio; i++){
			for(int j = 0; j < tamanio; j++){
				assertEquals(mapa.getCasillero(new Posicion(i,j)).getClass(), Casillero.class);
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

	@Test
	public void testMoverAUnAutobotUnaVezExitosamente(){
		Posicion posicion = new Posicion(2,8); 
		mapa.ubicar(optimusPrime, posicion);
		mapa.moverUbicableEnDireccion(optimusPrime, new DirAbajoDer());
		Posicion nuevaPosicion = new Posicion (3,7);
		
		assertEquals(mapa.getUbicable(nuevaPosicion).getClass(), optimusPrime.getClass());
		//En la posicion vieja no esta mas optimus
		assertNull(mapa.getUbicable(posicion));
	}
	
	@Test
	public void testMoverAUnDecepticonUnaVezExitosamente(){
		Posicion posicion = new Posicion(2,8); 
		mapa.ubicar(megatron, posicion);
		mapa.moverUbicableEnDireccion(megatron, new DirArribaDer());
		Posicion nuevaPosicion = new Posicion (3,9);
		
		assertEquals(mapa.getUbicable(nuevaPosicion).getClass(), megatron.getClass());
		//En la posicion vieja no esta mas megatron
		assertNull(mapa.getUbicable(posicion));
	}	
	
	@Test(expected = CasilleroOcupadoException.class)
	public void testMoverAUnAutobotUnaVezADondeHabiaOtroAutobotFalla(){
		Posicion posicion = new Posicion(2,8); 
		mapa.ubicar(optimusPrime, posicion);
		
		Posicion nuevaPosicion = new Posicion (2,9);
		mapa.ubicar(bumblebee, nuevaPosicion);
		
		mapa.moverUbicableEnDireccion(optimusPrime, new DirArriba());
	}	

	@Test(expected = CasilleroOcupadoException.class)
	public void testMoverAUnAutobotUnaVezADondeHabiaOtroDecepticonFalla(){
		Posicion posicion = new Posicion(2,8); 
		mapa.ubicar(optimusPrime, posicion);
		
		Posicion nuevaPosicion = new Posicion (2,9);
		mapa.ubicar(megatron, nuevaPosicion);
		
		mapa.moverUbicableEnDireccion(optimusPrime, new DirArriba());
	}
	
	@Test(expected = UbicableNoPertenceAlMapaException.class)
	public void testMoverAUnAutobotQueNoEstaUbicadoFalla(){
		mapa.moverUbicableEnDireccion(optimusPrime, new DirArriba());
	}
	
	@Test(expected = UbicableNoPertenceAlMapaException.class)
	public void testMoverAUnDecepticonQueNoEstaUbicadoFalla(){
		mapa.moverUbicableEnDireccion(megatron, new DirAbajo());
	}
	
}
