package fiuba.algo3.algoFormers.entrega2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import fiuba.algo3.algoFormers.modelo.direcciones.DirArriba;
import fiuba.algo3.algoFormers.modelo.direcciones.DirDerecha;
import fiuba.algo3.algoFormers.modelo.fabricas.AlgoFormerFactory;
import fiuba.algo3.algoFormers.modelo.fabricas.SuperficieRocosa;
import fiuba.algo3.algoFormers.modelo.juego.Juego;
import fiuba.algo3.algoFormers.modelo.mapa.Mapa;
import fiuba.algo3.algoFormers.modelo.mapa.Posicion;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;
import fiuba.algo3.algoFormers.modelo.personajes.estadosDeTransformacion.AlternoTerrestre;
import fiuba.algo3.algoFormers.modelo.personajes.estadosDeTransformacion.Humanoide;
import fiuba.algo3.algoFormers.modelo.excepciones.AtaqueEspacioVacioException;
import fiuba.algo3.algoFormers.modelo.excepciones.AtaqueFueraDeRangoException;
import fiuba.algo3.algoFormers.modelo.excepciones.FuegoAmigoException;
import fiuba.algo3.algoFormers.modelo.excepciones.MovimientosAgotadosException;

public class EntregaDosTest {

	private Mapa mapa;
	private AlgoFormerFactory factoryA;
	private AlgoFormer optimus;
	private AlgoFormer ratchet;
	private AlgoFormer bumblebee;
	private AlgoFormer megatron;
	private AlgoFormer frenzy;
	private AlgoFormer bonecrusher;
	private SuperficiesFactory factoryS;
	
	@Before
	public void setUp(){
		mapa = new Mapa();
		factoryA = new AlgoFormerFactory();
		optimus = factoryA.getOptimusPrime();
		ratchet = factoryA.getRatchet();
		bumblebee = factoryA.getBumblebee();
		megatron = factoryA.getMegatron();
		frenzy = factoryA.getFrenzy();
		bonecrusher = factoryA.getBonecrusher();
		factoryS= new SuperficiesFactory();
	}

	@Test
	public void testOptimusHumanoideAtraviezaZonaRocosa(){
		SuperficieRocosa superficie = factoryS.getRocosa();
		Posicion posicion1 = new Posicion(1,1);
		Posicion posicion2 = new Posicion(1,2);
		mapa.ubicarAtacable(optimus, posicion1);
		mapa.ubicarSuperficie(superficie, posicion2);
		DirArriba direccion = new DirArriba();
		optimus.moverEnDireccion(direccion, mapa);	
		assertTrue(optimus.getVida() == 500);
		assertTrue(optimus.getAtaque() == 50);
		assertTrue(optimus.getDistanciaDeAtaque() == 2);
		assertTrue(optimus.getVelocidad() == 2);		
	}
	
	@Test
	public void testOptimusAlternoAtraviezaZonaRocosa(){
		SuperficieRocosa superficie = factoryS.getRocosa();
		Posicion posicion1 = new Posicion(1,1);
		Posicion posicion2 = new Posicion(1,2);
		mapa.ubicarAtacable(optimus, posicion1);
		mapa.ubicarSuperficie(superficie, posicion2);
		DirArriba direccion = new DirArriba();
		optimus.transformarse();
		optimus.moverEnDireccion(direccion, mapa);	
		assertTrue(optimus.getVida() == 500);
		assertTrue(optimus.getAtaque() == 15);
		assertTrue(optimus.getDistanciaDeAtaque() == 4);
		assertTrue(optimus.getVelocidad() == 5);
	}

		//FALTAN LOS OTROS 5 ALGOFORMERS
	
	@Test(expected = HumanoideNoPuedeAtravezarException.class)
	public void testOptimusHumanoideNoAtraviezaZonaPantano(){
		SuperficiePantano superficie = factoryS.getPantano();
		Posicion posicion1 = new Posicion(1,1);
		Posicion posicion2 = new Posicion(1,2);
		mapa.ubicarAtacable(optimus, posicion1);
		mapa.ubicarSuperficie(superficie, posicion2);
		DirArriba direccion = new DirArriba();
		optimus.moverEnDireccion(direccion, mapa);	
		}
	
		//FALTAN LOS OTROS 5 ALGOFORMERS
	
	@Test(expected = MovimientosAgotadosException.class)
	public void testOptimusAlternoAtraviezaZonaPantanoConLaMitadDeVelocidad(){
		SuperficiePantano superficie = factoryS.getPantano();
		Posicion posicion1 = new Posicion(1,1);
		Posicion posicion2 = new Posicion(1,2);
		Posicion posicion3 = new Posicion(1,3);
		Posicion posicion4 = new Posicion(1,4);
		mapa.ubicarAtacable(optimus, posicion1);
		mapa.ubicarSuperficie(superficie, posicion2);
		mapa.ubicarSuperficie(superficie, posicion3);
		mapa.ubicarSuperficie(superficie, posicion4);
		DirArriba direccion = new DirArriba();
		optimus.transformarse();
		for(int x=0; x<=3; x++){
			optimus.moverEnDireccion(direccion, mapa);	
		}
	}

}
