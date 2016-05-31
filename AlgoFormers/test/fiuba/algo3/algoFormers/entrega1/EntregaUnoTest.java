package fiuba.algo3.algoFormers.entrega1;

import static org.junit.Assert.*;
import org.junit.Test;

import fiuba.algo3.algoFormers.modelo.direcciones.DirArriba;
import fiuba.algo3.algoFormers.modelo.fabricas.AlgoFormerFactory;
import fiuba.algo3.algoFormers.modelo.juego.Juego;
import fiuba.algo3.algoFormers.modelo.mapa.Mapa;
import fiuba.algo3.algoFormers.modelo.mapa.Posicion;
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
		mapa.ubicarAtacable(optimus, posicion);
		DirArriba direccion = new DirArriba();
		for (int i = 1; i <= optimus.getVelocidad(); i++){
			optimus.moverEnDireccion(direccion, mapa);	
		}
		assertEquals(optimus, mapa.getAtacable(new Posicion(1, 3)));
	}
	
	@Test
	public void testUbicarAlfoFormerAlternoMoverloYVerificarNuevaPosicion(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer ratchet = factory.getRatchet();
		ratchet.transformarse(); //Se transforma en Alterno
		Mapa mapa = new Mapa();
		Posicion posicion = new Posicion(1,1);
		mapa.ubicarAtacable(ratchet, posicion);
		DirArriba direccion = new DirArriba();
		for (int i = 1; i <= ratchet.getVelocidad(); i++){
			ratchet.moverEnDireccion(direccion, mapa);	
		}
		assertEquals(ratchet, mapa.getAtacable(new Posicion(1, 9)));
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
		
		assertEquals(optimus, juego.getAtacable(new Posicion(0, 18)));
		assertEquals(bumblebee, juego.getAtacable(new Posicion(0, 19)));
		assertEquals(ratchet, juego.getAtacable(new Posicion(0, 20)));
		
		assertEquals(megatron, juego.getAtacable(new Posicion(39, 18)));
		assertEquals(bonecrusher, juego.getAtacable(new Posicion(39, 19)));
		assertEquals(frenzy, juego.getAtacable(new Posicion(39, 20)));
		
		Posicion posicionChispa = juego.getPosicionChispa();
		int coordenadaX = posicionChispa.getX();
		int coordenadaY = posicionChispa.getY();
		assertTrue(coordenadaX <= 22);
		assertTrue(coordenadaX >= 18);
		assertTrue(coordenadaY <= 22);
		assertTrue(coordenadaY >= 18);
	}
	
	@Test
	public void testAutoBotAtacaDecepticonEnRango(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer optimus = factory.getOptimusPrime();
		AlgoFormer megatron = factory.getMegatron();
		
		Mapa mapa = new Mapa();
		Posicion posicionOptimus = new Posicion(1, 1);
		Posicion posicionMegatron = new Posicion(1, 3);
		mapa.ubicarAtacable(optimus, posicionOptimus);
		mapa.ubicarAtacable(megatron, posicionMegatron);
		optimus.atacarPosicion(posicionMegatron, mapa);
		assertEquals(megatron.getVida(), 500);
	}
	
	@Test(expected=AtaqueFueraDeRangoException.class)
	public void testAutoBotAtacaFueraDeRango(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer optimus = factory.getOptimusPrime();
		Mapa mapa = new Mapa();
		Posicion posicionOptimus = new Posicion(1, 1);
		mapa.ubicarAtacable(optimus, posicionOptimus);
		optimus.atacarPosicion(new Posicion(1, 6),mapa);
	}
	
	@Test(expected=AtaqueEspacioVacioException.class)
	public void testAutoBotAtacaEspacioVacio(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer optimus = factory.getOptimusPrime();
		Mapa mapa = new Mapa();
		Posicion posicionOptimus = new Posicion(1, 1);
		mapa.ubicarAtacable(optimus, posicionOptimus);
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
		mapa.ubicarAtacable(optimus, posicionOptimus);
		mapa.ubicarAtacable(bumblebee, posicionBumblebee);
		optimus.atacarPosicion(new Posicion(1, 2),mapa);
	}
}
