package fiuba.algo3.algoFormers.entrega1;

import static org.junit.Assert.*;
import org.junit.Test;

import fiuba.algo3.algoFormers.modelo.direcciones.DirArriba;
import fiuba.algo3.algoFormers.modelo.direcciones.Direccion;
import fiuba.algo3.algoFormers.modelo.fabricas.AlgoFormerFactory;
import fiuba.algo3.algoFormers.modelo.juego.Juego;
import fiuba.algo3.algoFormers.modelo.mapas.Mapa;
import fiuba.algo3.algoFormers.modelo.mapas.Posicion;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;
import fiuba.algo3.algoFormers.modelo.personajes.estadosDeTransformacion.AlternoTerrestre;
import fiuba.algo3.algoFormers.modelo.personajes.estadosDeTransformacion.Humanoide;
import fiuba.algo3.algoFormers.modelo.excepciones.AtaqueEspacioVacioException;
import fiuba.algo3.algoFormers.modelo.excepciones.AtaqueFueraDeRangoException;
import fiuba.algo3.algoFormers.modelo.excepciones.FuegoAmigoException;

public class EntregaUnoTest {
	
	@Test
	public void testUbicarAlfoFormerHumanoideMoverloYVerificarNuevaPosicion(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer optimus = factory.getOptimusPrime();
		Mapa mapa = new Mapa();
		Posicion posicion = new Posicion(1,1);
		mapa.ubicar(optimus, posicion);
		optimus.inicializarTurno();
		DirArriba direccion = new DirArriba();
		for (int i = 1; i <= optimus.getVelocidad(); i++){
			optimus.moverEnDireccion(direccion, mapa);	
		}
		assertEquals(optimus, mapa.getUbicable(new Posicion(1, 3)));
		//El mapa le dice al casillero que devuelva el Ubicable que tiene guardado
		//Puede ser un Ubicable o null.
		//Hay que hacer una prueba para cuando se queda sin nafta(SinPuntosDeMovimientoException)
	}
	
	@Test
	public void testUbicarAlfoFormerAlternoMoverloYVerificarNuevaPosicion(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer ratchet = factory.getRatchet();
		ratchet.transformarse(); //Se transforma en Alterno
		Mapa mapa = new Mapa();
		Posicion posicion = new Posicion(1,1);
		mapa.ubicar(ratchet, posicion);
		DirArriba direccion = new DirArriba();
		ratchet.inicializarTurno();
		for (int i = 1; i <= ratchet.getVelocidad(); i++){
			ratchet.moverEnDireccion(direccion, mapa);	
		}
		assertEquals(ratchet, mapa.getUbicable(new Posicion(1, 9)));
	}
	
	@Test
	public void testTransformarAlgoFormerDeHumanoideAAlterno(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer bumblebee = factory.getBumblebee(); //Se crea Humanoide
		assertEquals(bumblebee.getEstado().getClass(), Humanoide.class);
		bumblebee.transformarse();
		assertEquals(bumblebee.getEstado().getClass(), AlternoTerrestre.class);
		bumblebee.transformarse();
		assertEquals(bumblebee.getEstado().getClass(), Humanoide.class);
	}
	
	@Test
	public void testIntegracionUbicarDosEquiposDeTresPersonajesYChispa(){
		Juego juego = new Juego();
		
		AlgoFormerFactory factory = new AlgoFormerFactory();
		
		AlgoFormer optimus = factory.getOptimusPrime();
		AlgoFormer bumblebee = factory.getBumblebee();
		AlgoFormer ratchet = factory.getRatchet();
		
		AlgoFormer megatron = factory.getMegatron();
		AlgoFormer bonecrusher = factory.getBonecrusher();
		AlgoFormer frenzy = factory.getFrenzy();
		
		assertEquals(optimus, juego.getUbicable(new Posicion(0, 18)));
		assertEquals(bumblebee, juego.getUbicable(new Posicion(0, 19)));
		assertEquals(ratchet, juego.getUbicable(new Posicion(0, 20)));
		
		assertEquals(megatron, juego.getUbicable(new Posicion(39, 18)));
		assertEquals(bonecrusher, juego.getUbicable(new Posicion(39, 19)));
		assertEquals(frenzy, juego.getUbicable(new Posicion(39, 20)));
		
		Posicion posicionChispa = juego.getPosicionChispa();
		int coordenadaX = posicionChispa.getX();
		int coordenadaY = posicionChispa.getY();
		assertTrue(coordenadaX <= 21);
		assertTrue(coordenadaX >= 17);
		assertTrue(coordenadaY <= 21);
		assertTrue(coordenadaY >= 17);
	}
	
	@Test
	public void testAutoBotAtacaDecepticonEnRango(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer optimus = factory.getOptimusPrime();
		AlgoFormer megatron = factory.getMegatron();
		
		Mapa mapa = new Mapa();
		Posicion posicionOptimus = new Posicion(1, 1);
		Posicion posicionMegatron = new Posicion(1, 3);
		mapa.ubicar(optimus, posicionOptimus);
		mapa.ubicar(megatron, posicionMegatron);
		optimus.inicializarTurno();
		optimus.atacarPosicion(posicionMegatron, mapa);
		assertEquals(megatron.getVida(), 500);
	}
	
	@Test(expected=AtaqueFueraDeRangoException.class)
	public void testAutoBotAtacaFueraDeRango(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer optimus = factory.getOptimusPrime();
		Mapa mapa = new Mapa();
		Posicion posicionOptimus = new Posicion(1, 1);
		mapa.ubicar(optimus, posicionOptimus);
		optimus.inicializarTurno();
		optimus.atacarPosicion(new Posicion(1, 6),mapa);
	}
	
	@Test(expected=AtaqueEspacioVacioException.class)
	public void testAutoBotAtacaEspacioVacio(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer optimus = factory.getOptimusPrime();
		Mapa mapa = new Mapa();
		Posicion posicionOptimus = new Posicion(1, 1);
		mapa.ubicar(optimus, posicionOptimus);
		optimus.inicializarTurno();
		optimus.atacarPosicion(new Posicion(1, 2),mapa);
	}
	
	@Test(expected=FuegoAmigoException.class)
	public void testAutoBotAtacaAutoBot(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer optimus = factory.getOptimusPrime();
		AlgoFormer bumblebee = factory.getBumblebee();
		Mapa mapa = new Mapa();
		Posicion posicionOptimus = new Posicion(1, 1);
		Posicion posicionBumblebee = new Posicion(1, 2);
		mapa.ubicar(optimus, posicionOptimus);
		mapa.ubicar(bumblebee, posicionBumblebee);
		optimus.inicializarTurno();
		optimus.atacarPosicion(new Posicion(1, 2),mapa);
	}
}
