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
	public void testRatchetHumanoideAtraviezaZonaRocosa(){
		SuperficieRocosa superficie = factoryS.getRocosa();
		Posicion posicion1 = new Posicion(1,1);
		Posicion posicion2 = new Posicion(1,2);
		mapa.ubicarAtacable(ratchet, posicion1);
		mapa.ubicarSuperficie(superficie, posicion2);
		DirArriba direccion = new DirArriba();
		ratchet.moverEnDireccion(direccion, mapa);	
		assertTrue(ratchet.getVida() == 150);
		assertTrue(ratchet.getAtaque() == 5);
		assertTrue(ratchet.getDistanciaDeAtaque() == 5);
		assertTrue(ratchet.getVelocidad() == 1);		
	}
	
	@Test
	public void testBumblebeeHumanoideAtraviezaZonaRocosa(){
		SuperficieRocosa superficie = factoryS.getRocosa();
		Posicion posicion1 = new Posicion(1,1);
		Posicion posicion2 = new Posicion(1,2);
		mapa.ubicarAtacable(bumblebee, posicion1);
		mapa.ubicarSuperficie(superficie, posicion2);
		DirArriba direccion = new DirArriba();
		bumblebee.moverEnDireccion(direccion, mapa);	
		assertTrue(bumblebee.getVida() == 350);
		assertTrue(bumblebee.getAtaque() == 40);
		assertTrue(bumblebee.getDistanciaDeAtaque() == 1);
		assertTrue(bumblebee.getVelocidad() == 2);		
	}
	
	@Test
	public void testMegatronHumanoideAtraviezaZonaRocosa(){
		SuperficieRocosa superficie = factoryS.getRocosa();
		Posicion posicion1 = new Posicion(1,1);
		Posicion posicion2 = new Posicion(1,2);
		mapa.ubicarAtacable(megatron, posicion1);
		mapa.ubicarSuperficie(superficie, posicion2);
		DirArriba direccion = new DirArriba();
		megatron.moverEnDireccion(direccion, mapa);	
		assertTrue(megatron.getVida() == 550);
		assertTrue(megatron.getAtaque() == 10);
		assertTrue(megatron.getDistanciaDeAtaque() == 3);
		assertTrue(megatron.getVelocidad() == 1);		
	}
	
	@Test
	public void testFrenzyHumanoideAtraviezaZonaRocosa(){
		SuperficieRocosa superficie = factoryS.getRocosa();
		Posicion posicion1 = new Posicion(1,1);
		Posicion posicion2 = new Posicion(1,2);
		mapa.ubicarAtacable(frenzy, posicion1);
		mapa.ubicarSuperficie(superficie, posicion2);
		DirArriba direccion = new DirArriba();
		frenzy.moverEnDireccion(direccion, mapa);	
		assertTrue(frenzy.getVida() == 400);
		assertTrue(frenzy.getAtaque() == 10);
		assertTrue(frenzy.getDistanciaDeAtaque() == 5);
		assertTrue(frenzy.getVelocidad() == 2);		
	}
	
	@Test
	public void testBonecrusherHumanoideAtraviezaZonaRocosa(){
		SuperficieRocosa superficie = factoryS.getRocosa();
		Posicion posicion1 = new Posicion(1,1);
		Posicion posicion2 = new Posicion(1,2);
		mapa.ubicarAtacable(bonecrusher, posicion1);
		mapa.ubicarSuperficie(superficie, posicion2);
		DirArriba direccion = new DirArriba();
		bonecrusher.moverEnDireccion(direccion, mapa);	
		assertTrue(bonecrusher.getVida() == 200);
		assertTrue(bonecrusher.getAtaque() == 30);
		assertTrue(bonecrusher.getDistanciaDeAtaque() == 3);
		assertTrue(bonecrusher.getVelocidad() == 1);		
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
	
	@Test
	public void testRatchetAlternoAtraviezaZonaRocosa(){
		SuperficieRocosa superficie = factoryS.getRocosa();
		Posicion posicion1 = new Posicion(1,1);
		Posicion posicion2 = new Posicion(1,2);
		mapa.ubicarAtacable(ratchet, posicion1);
		mapa.ubicarSuperficie(superficie, posicion2);
		DirArriba direccion = new DirArriba();
		ratchet.transformarse();
		ratchet.moverEnDireccion(direccion, mapa);	
		assertTrue(ratchet.getVida() == 150);
		assertTrue(ratchet.getAtaque() == 35);
		assertTrue(ratchet.getDistanciaDeAtaque() == 2);
		assertTrue(ratchet.getVelocidad() == 8);		
	}
	
	@Test
	public void testBumblebeeAlternoAtraviezaZonaRocosa(){
		SuperficieRocosa superficie = factoryS.getRocosa();
		Posicion posicion1 = new Posicion(1,1);
		Posicion posicion2 = new Posicion(1,2);
		mapa.ubicarAtacable(bumblebee, posicion1);
		mapa.ubicarSuperficie(superficie, posicion2);
		DirArriba direccion = new DirArriba();
		bumblebee.transformarse();
		bumblebee.moverEnDireccion(direccion, mapa);
		assertTrue(bumblebee.getVida() == 350);
		assertTrue(bumblebee.getAtaque() == 20);
		assertTrue(bumblebee.getDistanciaDeAtaque() == 3);
		assertTrue(bumblebee.getVelocidad() == 5);		
	}
	
	@Test
	public void testMegatronAlternoAtraviezaZonaRocosa(){
		SuperficieRocosa superficie = factoryS.getRocosa();
		Posicion posicion1 = new Posicion(1,1);
		Posicion posicion2 = new Posicion(1,2);
		mapa.ubicarAtacable(megatron, posicion1);
		mapa.ubicarSuperficie(superficie, posicion2);
		DirArriba direccion = new DirArriba();
		megatron.transformarse();
		megatron.moverEnDireccion(direccion, mapa);	
		assertTrue(megatron.getVida() == 550);
		assertTrue(megatron.getAtaque() == 55);
		assertTrue(megatron.getDistanciaDeAtaque() == 2);
		assertTrue(megatron.getVelocidad() == 8);		
	}
	
	@Test
	public void testFrenzyAlternoAtraviezaZonaRocosa(){
		SuperficieRocosa superficie = factoryS.getRocosa();
		Posicion posicion1 = new Posicion(1,1);
		Posicion posicion2 = new Posicion(1,2);
		mapa.ubicarAtacable(frenzy, posicion1);
		mapa.ubicarSuperficie(superficie, posicion2);
		DirArriba direccion = new DirArriba();
		frenzy.transformarse();
		frenzy.moverEnDireccion(direccion, mapa);	
		assertTrue(frenzy.getVida() == 400);
		assertTrue(frenzy.getAtaque() == 25);
		assertTrue(frenzy.getDistanciaDeAtaque() == 2);
		assertTrue(frenzy.getVelocidad() == 6);		
	}
	
	@Test
	public void testBonecrusherAlternoAtraviezaZonaRocosa(){
		SuperficieRocosa superficie = factoryS.getRocosa();
		Posicion posicion1 = new Posicion(1,1);
		Posicion posicion2 = new Posicion(1,2);
		mapa.ubicarAtacable(bonecrusher, posicion1);
		mapa.ubicarSuperficie(superficie, posicion2);
		DirArriba direccion = new DirArriba();
		bonecrusher.transformarse();
		bonecrusher.moverEnDireccion(direccion, mapa);	
		assertTrue(bonecrusher.getVida() == 200);
		assertTrue(bonecrusher.getAtaque() == 30);
		assertTrue(bonecrusher.getDistanciaDeAtaque() == 3);
		assertTrue(bonecrusher.getVelocidad() == 8);		
	}
	
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
