package fiuba.algo3.algoFormers.entrega1;

import static org.junit.Assert.*;
import org.junit.Test;

import fiuba.algo3.algoFormers.modelo.fabricas.AutoBotFactory;
import fiuba.algo3.algoFormers.modelo.fabricas.DecepticonFactory;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;
import fiuba.algo3.algoFormers.modelo.personajes.estadosDeTransformacion.AlternoTerrestre;
import fiuba.algo3.algoFormers.modelo.personajes.estadosDeTransformacion.Humanoide;

public class EntregaUnoTest {
	
	@Test
	public void testUbicarAlfoFormerHumanoideMoverloYVerificarNuevaPosicion(){
		AutoBotFactory factory = new AutoBotFactory();
		AlgoFormer optimus = factory.getOptimusPrime();
		Mapa mapa = new Mapa();
		Posicion posicion = new Posicion(1,1);
		mapa.ubicar(optimus, posicion);
		Direccion direccion = new DireccionArriba();
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
		AutoBotFactory factory = new AutoBotFactory();
		AlgoFormer ratchet = factory.getRatchet();
		ratchet.transformarse(); //Se transforma en Alterno
		Mapa mapa = new Mapa();
		Posicion posicion = new Posicion(1,1);
		mapa.ubicar(ratchet, posicion);
		Direccion direccion = new DireccionArriba();
		for (int i = 1; i <= ratchet.getVelocidad(); i++){
			ratchet.moverEnDireccion(direccion);	
		}
		assertEquals(ratchet, mapa.getUbicable(new Posicion(1, 9)));
	}
	
	@Test
	public void testTransformarAlgoFormerDeHumanoideAAlterno(){
		AutoBotFactory factory = new AutoBotFactory();
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
		
		AutoBotFactory autoBotFactory = new AutoBotFactory();
		
		AlgoFormer optimus = autoBotFactory.getOptimusPrime();
		AlgoFormer bumblebee = autoBotFactory.getBumblebee();
		AlgoFormer ratchet = autoBotFactory.getRatchet();

		DecepticonFactory decepticonFactory = new DecepticonFactory();
		
		AlgoFormer megatron = decepticonFactory.getMegatron();
		AlgoFormer bonecrusher = decepticonFactory.getBonecrusher();
		AlgoFormer frenzy = decepticonFactory.getFrenzy();
		
		assertEquals(optimus, juego.getUbicable(new Posicion(1, 19)));
		assertEquals(bumblebee, juego.getUbicable(new Posicion(1, 20)));
		assertEquals(ratchet, juego.getUbicable(new Posicion(1, 21)));
		
		assertEquals(megatron, juego.getUbicable(new Posicion(40, 19)));
		assertEquals(bonecrusher, juego.getUbicable(new Posicion(40, 20)));
		assertEquals(frenzy, juego.getUbicable(new Posicion(40, 21)));
		
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
		AutoBotFactory autoBotFactory = new AutoBotFactory();
		AlgoFormer optimus = autoBotFactory.getOptimusPrime();
		DecepticonFactory decepticonFactory = new DecepticonFactory();
		AlgoFormer megatron = decepticonFactory.getMegatron();
		
		Mapa mapa = new Mapa();
		Posicion posicionOptimus = new Posicion(1, 1);
		Posicion posicionMegatron = new Posicion(1, 3);
		mapa.ubicar(optimus, posicionOptimus);
		mapa.ubicar(megatron, posicionMegatron);
		
		optimus.atacar(posicionMegatron);
		assertEquals(megatron.getVida(), 500);
	}
	
	@Test(expected=AtaqueFueraDeRangoException.class)
	public void testAutoBotAtacaFueraDeRango(){
		AutoBotFactory autoBotFactory = new AutoBotFactory();
		AlgoFormer optimus = autoBotFactory.getOptimusPrime();
		
		Mapa mapa = new Mapa();
		Posicion posicionOptimus = new Posicion(1, 1);
		mapa.ubicar(optimus, posicionOptimus);
		
		optimus.atacar(new Posicion(1, 6));
		//Falta cuando se ataca una posicion en rango pero sin AlgoFormer(AtaqueAEspacioVacioException)
		//Falta cuando se ataca una posicion en rango con un aliado(FuegoAmigoException)
	}
	
	
}
