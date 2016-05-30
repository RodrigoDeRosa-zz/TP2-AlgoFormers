package fiuba.algo3.algoFormers.entrega1;

import static org.junit.Assert.*;
import org.junit.Test;

import fiuba.algo3.algoFormers.modelo.mapas.Mapa;
import fiuba.algo3.algoFormers.modelo.mapas.Posicion;
import fiuba.algo3.algoFormers.modelo.personajes.Algoformer;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoformerFactory;
import fiuba.algo3.algoFormers.modelo.personajes.estadosDeTransformacion.AlternoTerrestre;
import fiuba.algo3.algoFormers.modelo.personajes.estadosDeTransformacion.Humanoide;
import fiuba.algo3.algoFormers.modelo.direcciones.*;
import fiuba.algo3.algoFormers.modelo.excepciones.AtaqueFueraDeRangoException;
import fiuba.algo3.algoFormers.modelo.excepciones.AtaqueInvalidoException;
import fiuba.algo3.algoFormers.modelo.excepciones.FuegoAmigoException;
import fiuba.algo3.algoFormers.modelo.juego.Juego;
import fiuba.algo3.algoFormers.modelo.juego.Jugador;
import fiuba.algo3.algoFormers.modelo.personajes.manejadores.*;



public class EntregaUnoTest {
	
	@Test
	public void testUbicarAlfoFormerHumanoideMoverloYVerificarNuevaPosicion(){
		
		AlgoformerFactory factory = new AlgoformerFactory();
		Algoformer optimus = factory.getOptimusPrime();
		Mapa mapa = new Mapa();
		DireccionArriba direccion = new DireccionArriba();
		Posicion posicion = new Posicion(1,1);
		mapa.ubicar(optimus, posicion);
		
		ManejadorDeMovimientos manejador = new ManejadorDeMovimientos(mapa, optimus, direccion);		
			
		for (int i = 1; i <= optimus.getPuntosVelocidad(); i++){
			manejador.RealizarMovimiento();	
		}
		assertEquals(optimus, mapa.getUbicable(new Posicion(1, 3)));
		
		//Puede ser un Ubicable o null.
		//Hay que hacer una prueba para cuando se queda sin nafta(SinPuntosDeMovimientoException)
	}
	
	
	@Test
	public void testUbicarAlfoFormerAlternoMoverloYVerificarNuevaPosicion(){
		AlgoformerFactory factory = new AlgoformerFactory();
		Algoformer ratchet = factory.getRatchet();
		ratchet.transformarse(); //Se transforma en Alterno
		Mapa mapa = new Mapa();
		Posicion posicion = new Posicion(1,1);
		mapa.ubicar(ratchet, posicion);
		DireccionArriba direccion = new DireccionArriba();
		
		ManejadorDeMovimientos manejador = new ManejadorDeMovimientos(mapa, ratchet, direccion);	
		for (int i = 1; i <= ratchet.getPuntosVelocidad(); i++){
			manejador.RealizarMovimiento();	
		}
		assertEquals(ratchet, mapa.getUbicable(new Posicion(1, 9)));
	}
	
	@Test
	public void testTransformarAlgoformerDeHumanoideAAlterno(){
		AlgoformerFactory factory = new AlgoformerFactory();
		Algoformer bumblebee = factory.getBumblebee(); //Se crea Humanoide
		assertEquals(bumblebee.getEstado().getClass(), Humanoide.class);
		bumblebee.transformarse();
		assertEquals(bumblebee.getEstado().getClass(), AlternoTerrestre.class);
		bumblebee.transformarse();
		assertEquals(bumblebee.getEstado().getClass(), Humanoide.class);
	}
	
	@Test
	public void testIntegracionUbicarDosEquiposDeTresPersonajesYChispa(){
		Juego juego = new Juego();
		
		Jugador autob = juego.getJugadorAutobots();
		Jugador decep = juego.getJugadorDecepticons();
		
		assertEquals(autob.getAlgoformer("OPTIMUS"), juego.getUbicable(new Posicion(1, 19)));
		assertEquals(autob.getAlgoformer("BUMBLEBEE"), juego.getUbicable(new Posicion(1, 20)));
		assertEquals(autob.getAlgoformer("RATCHET"), juego.getUbicable(new Posicion(1, 21)));
		
		assertEquals(decep.getAlgoformer("MEGATRON"), juego.getUbicable(new Posicion(40, 19)));
		assertEquals(decep.getAlgoformer("BONECRUSHER"), juego.getUbicable(new Posicion(40, 20)));
		assertEquals(decep.getAlgoformer("FRENZY"), juego.getUbicable(new Posicion(40, 21)));
		
		/*Posicion posicionChispa = juego.getPosicionChispa();
		int coordenadaX = posicionChispa.getX();
		int coordenadaY = posicionChispa.getY();
		assertTrue(coordenadaX <= 22);
		assertTrue(coordenadaX >= 18);
		assertTrue(coordenadaY <= 22);
		assertTrue(coordenadaY >= 18);*/
	}
	
	@Test
	public void testAutoBotAtacaDecepticonEnRango(){
		AlgoformerFactory AlgoformerFactory = new AlgoformerFactory();
		Algoformer optimus = AlgoformerFactory.getOptimusPrime();
		Algoformer megatron = AlgoformerFactory.getMegatron();
		
		Mapa mapa = new Mapa();
		Posicion posicionOptimus = new Posicion(1, 1);
		Posicion posicionMegatron = new Posicion(1, 3);
		mapa.ubicar(optimus, posicionOptimus);
		mapa.ubicar(megatron, posicionMegatron);
		
		ManejadorDeAtaques manejador = new ManejadorDeAtaques(mapa, optimus, posicionMegatron);
		manejador.realizarAtaque();
		assertEquals(megatron.getPuntosVida(), 500);
	}
	
	@Test(expected=AtaqueFueraDeRangoException.class)
	public void testAutoBotAtacaFueraDeRango(){
		AlgoformerFactory AlgoformerFactory = new AlgoformerFactory();
		Algoformer optimus = AlgoformerFactory.getOptimusPrime();
		Mapa mapa = new Mapa();
		Posicion posicionOptimus = new Posicion(1, 1);
		Posicion destino = new Posicion(1, 6);
		mapa.ubicar(optimus, posicionOptimus);
		
		ManejadorDeAtaques manejador = new ManejadorDeAtaques(mapa, optimus, destino);
		manejador.realizarAtaque();
		//Falta cuando se ataca una posicion en rango con un aliado(FuegoAmigoException)
	}
	
	@Test(expected=AtaqueInvalidoException.class)
	public void testAutoBotAtacaEspacioVacio(){
		AlgoformerFactory AlgoformerFactory = new AlgoformerFactory();
		Algoformer optimus = AlgoformerFactory.getOptimusPrime();
		Mapa mapa = new Mapa();
		Posicion posicionOptimus = new Posicion(1, 1);
		Posicion destino = new Posicion(1, 2);
		mapa.ubicar(optimus, posicionOptimus);
		
		ManejadorDeAtaques manejador = new ManejadorDeAtaques(mapa, optimus, destino);
		manejador.realizarAtaque();
	}
	
	@Test(expected=FuegoAmigoException.class)
	public void testAutoBotAtacaAutoBot(){
		AlgoformerFactory AlgoformerFactory = new AlgoformerFactory();
		Algoformer optimus = AlgoformerFactory.getOptimusPrime();
		Algoformer bumblebee = AlgoformerFactory.getBumblebee();
		Mapa mapa = new Mapa();
		Posicion posicionOptimus = new Posicion(1, 1);
		Posicion posicionBumblebee = new Posicion(1, 2);
		mapa.ubicar(optimus, posicionOptimus);
		mapa.ubicar(bumblebee, posicionBumblebee);
		
		ManejadorDeAtaques manejador = new ManejadorDeAtaques(mapa, optimus, posicionBumblebee);
		manejador.realizarAtaque();
		
	}
	
}

