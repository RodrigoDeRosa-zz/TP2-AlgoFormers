package fiuba.algo3.algoFormers.entrega2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import fiuba.algo3.algoFormers.modelo.direcciones.DirArriba;
import fiuba.algo3.algoFormers.modelo.direcciones.DirDerecha;
import fiuba.algo3.algoFormers.modelo.fabricas.AlgoFormerFactory;
import fiuba.algo3.algoFormers.modelo.fabricas.SuperficiesFactory;
import fiuba.algo3.algoFormers.modelo.juego.Juego;
import fiuba.algo3.algoFormers.modelo.mapa.Mapa;
import fiuba.algo3.algoFormers.modelo.mapa.Posicion;
import fiuba.algo3.algoFormers.modelo.mapa.superficies.SuperficieAerea;
import fiuba.algo3.algoFormers.modelo.mapa.superficies.SuperficieTerrestre;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;
import fiuba.algo3.algoFormers.modelo.personajes.estadosDeTransformacion.AlternoTerrestre;
import fiuba.algo3.algoFormers.modelo.personajes.estadosDeTransformacion.Humanoide;
import fiuba.algo3.algoFormers.modelo.excepciones.AtaqueEspacioVacioException;
import fiuba.algo3.algoFormers.modelo.excepciones.AtaqueFueraDeRangoException;
import fiuba.algo3.algoFormers.modelo.excepciones.FuegoAmigoException;
import fiuba.algo3.algoFormers.modelo.excepciones.HumanoideNoPuedeAtravesarException;
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
	public void testOptimusHumanoideAtraviesaZonaRocosa(){
		SuperficieTerrestre superficie = factoryS.getRocas();
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
	public void testRatchetHumanoideAtraviesaZonaRocosa(){
		SuperficieTerrestre superficie = factoryS.getRocas();
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
	public void testBumblebeeHumanoideAtraviesaZonaRocosa(){
		SuperficieTerrestre superficie = factoryS.getRocas();
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
	public void testMegatronHumanoideAtraviesaZonaRocosa(){
		SuperficieTerrestre superficie = factoryS.getRocas();
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
	public void testFrenzyHumanoideAtraviesaZonaRocosa(){
		SuperficieTerrestre superficie = factoryS.getRocas();
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
	public void testBonecrusherHumanoideAtraviesaZonaRocosa(){
		SuperficieTerrestre superficie = factoryS.getRocas();
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
	public void testOptimusAlternoAtraviesaZonaRocosa(){
		SuperficieTerrestre superficie = factoryS.getRocas();
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
	public void testRatchetAlternoAtraviesaZonaRocosa(){
		SuperficieTerrestre superficie = factoryS.getRocas();
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
	public void testBumblebeeAlternoAtraviesaZonaRocosa(){
		SuperficieTerrestre superficie = factoryS.getRocas();
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
	public void testMegatronAlternoAtraviesaZonaRocosa(){
		SuperficieTerrestre superficie = factoryS.getRocas();
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
	public void testFrenzyAlternoAtraviesaZonaRocosa(){
		SuperficieTerrestre superficie = factoryS.getRocas();
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
	public void testBonecrusherAlternoAtraviesaZonaRocosa(){
		SuperficieTerrestre superficie = factoryS.getRocas();
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
	
	@Test(expected = HumanoideNoPuedeAtravesarException.class)
	public void testOptimusHumanoideNoAtraviesaZonaPantano(){
		SuperficieTerrestre superficie = factoryS.getPantano();
		Posicion posicion1 = new Posicion(1,1);
		Posicion posicion2 = new Posicion(1,2);
		mapa.ubicarAtacable(optimus, posicion1);
		mapa.ubicarSuperficie(superficie, posicion2);
		DirArriba direccion = new DirArriba();
		optimus.moverEnDireccion(direccion, mapa);	
		}
	
	@Test(expected = HumanoideNoPuedeAtravesarException.class)
	public void testBumblebeeHumanoideNoAtraviesaZonaPantano(){
		SuperficieTerrestre superficie = factoryS.getPantano();
		Posicion posicion1 = new Posicion(1,1);
		Posicion posicion2 = new Posicion(1,2);
		mapa.ubicarAtacable(bumblebee, posicion1);
		mapa.ubicarSuperficie(superficie, posicion2);
		DirArriba direccion = new DirArriba();
		bumblebee.moverEnDireccion(direccion, mapa);	
		}

	@Test(expected = HumanoideNoPuedeAtravesarException.class)
	public void testRatchetHumanoideNoAtraviesaZonaPantano(){
		SuperficieTerrestre superficie = factoryS.getPantano();
		Posicion posicion1 = new Posicion(1,1);
		Posicion posicion2 = new Posicion(1,2);
		mapa.ubicarAtacable(ratchet, posicion1);
		mapa.ubicarSuperficie(superficie, posicion2);
		DirArriba direccion = new DirArriba();
		ratchet.moverEnDireccion(direccion, mapa);	
		}
	
	@Test(expected = HumanoideNoPuedeAtravesarException.class)
	public void testMegatronHumanoideNoAtraviesaZonaPantano(){
		SuperficieTerrestre superficie = factoryS.getPantano();
		Posicion posicion1 = new Posicion(1,1);
		Posicion posicion2 = new Posicion(1,2);
		mapa.ubicarAtacable(megatron, posicion1);
		mapa.ubicarSuperficie(superficie, posicion2);
		DirArriba direccion = new DirArriba();
		megatron.moverEnDireccion(direccion, mapa);	
		}
	
	@Test(expected = HumanoideNoPuedeAtravesarException.class)
	public void testFrenzyHumanoideNoAtraviesaZonaPantano(){
		SuperficieTerrestre superficie = factoryS.getPantano();
		Posicion posicion1 = new Posicion(1,1);
		Posicion posicion2 = new Posicion(1,2);
		mapa.ubicarAtacable(frenzy, posicion1);
		mapa.ubicarSuperficie(superficie, posicion2);
		DirArriba direccion = new DirArriba();
		frenzy.moverEnDireccion(direccion, mapa);	
		}
	
	@Test(expected = HumanoideNoPuedeAtravesarException.class)
	public void testBonecrusherHumanoideNoAtraviesaZonaPantano(){
		SuperficieTerrestre superficie = factoryS.getPantano();
		Posicion posicion1 = new Posicion(1,1);
		Posicion posicion2 = new Posicion(1,2);
		mapa.ubicarAtacable(bonecrusher, posicion1);
		mapa.ubicarSuperficie(superficie, posicion2);
		DirArriba direccion = new DirArriba();
		bonecrusher.moverEnDireccion(direccion, mapa);	
		}
	
	@Test
	public void testOptimusAlternoAtraviesaZonaPantanoConLaMitadDeVelocidad(){
		SuperficieTerrestre superficie = factoryS.getPantano();
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
	
	@Test
	public void testRatchetAlternoAtraviesaZonaPantano(){
		SuperficieTerrestre superficie = factoryS.getPantano();
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
	public void testMegatronAlternoAtraviesaZonaPantano(){
		SuperficieTerrestre superficie = factoryS.getPantano();
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
	public void testOptimusHumanoideAtraviesaZonaEspinasYSeDania(){
		SuperficieTerrestre superficie = factoryS.getEspina();
		Posicion posicion1 = new Posicion(1,1);
		Posicion posicion2 = new Posicion(1,2);
		Posicion posicion3 = new Posicion(1,3);
		mapa.ubicarAtacable(optimus, posicion1);
		mapa.ubicarSuperficie(superficie, posicion2);
		mapa.ubicarSuperficie(superficie, posicion3);
		DirArriba direccion = new DirArriba();
		optimus.moverEnDireccion(direccion, mapa);	
		assertTrue(optimus.getVida() == 475);
		optimus.moverEnDireccion(direccion, mapa);	
		assertTrue(optimus.getVida() == 451);
	}
	
	@Test
	public void testRatchetHumanoideAtraviesaZonaEspinasYSeDania(){
		SuperficieTerrestre superficie = factoryS.getEspina();
		Posicion posicion1 = new Posicion(1,1);
		Posicion posicion2 = new Posicion(1,2);
		mapa.ubicarAtacable(ratchet, posicion1);
		mapa.ubicarSuperficie(superficie, posicion2);
		DirArriba direccion = new DirArriba();
		ratchet.moverEnDireccion(direccion, mapa);	
		assertEquals(ratchet.getVida(), 143);		
	}
	
	@Test
	public void testBumblebeeHumanoideAtraviesaZonaEspinasYSeDania(){
		SuperficieTerrestre superficie = factoryS.getEspina();
		Posicion posicion1 = new Posicion(1,1);
		Posicion posicion2 = new Posicion(1,2);
		Posicion posicion3 = new Posicion(1,3);
		mapa.ubicarAtacable(bumblebee, posicion1);
		mapa.ubicarSuperficie(superficie, posicion2);
		mapa.ubicarSuperficie(superficie, posicion3);
		DirArriba direccion = new DirArriba();
		bumblebee.moverEnDireccion(direccion, mapa);	
		assertTrue(bumblebee.getVida() == 333);
		bumblebee.moverEnDireccion(direccion, mapa);	
		assertTrue(bumblebee.getVida() == 316);
	
	}
	
	@Test
	public void testMegatronHumanoideAtraviesaZonaEspinasYSeDania(){
		SuperficieTerrestre superficie = factoryS.getEspina();
		Posicion posicion1 = new Posicion(1,1);
		Posicion posicion2 = new Posicion(1,2);
		mapa.ubicarAtacable(megatron, posicion1);
		mapa.ubicarSuperficie(superficie, posicion2);
		DirArriba direccion = new DirArriba();
		megatron.moverEnDireccion(direccion, mapa);	
		assertTrue(megatron.getVida() == 523);
	}
	
	@Test
	public void testFrenzyHumanoideAtraviesaZonaEspinasYSeDania(){
		SuperficieTerrestre superficie = factoryS.getEspina();
		Posicion posicion1 = new Posicion(1,1);
		Posicion posicion2 = new Posicion(1,2);
		Posicion posicion3 = new Posicion(1,3);
		mapa.ubicarAtacable(frenzy, posicion1);
		mapa.ubicarSuperficie(superficie, posicion2);
		mapa.ubicarSuperficie(superficie, posicion3);
		DirArriba direccion = new DirArriba();
		frenzy.moverEnDireccion(direccion, mapa);	
		assertTrue(frenzy.getVida() == 380);
		frenzy.moverEnDireccion(direccion, mapa);	
		assertTrue(frenzy.getVida() == 361);
	}
	
	@Test
	public void testBonecrusherHumanoideAtraviesaZonaEspinasYSeDania(){
		SuperficieTerrestre superficie = factoryS.getEspina();
		Posicion posicion1 = new Posicion(1,1);
		Posicion posicion2 = new Posicion(1,2);
		mapa.ubicarAtacable(bonecrusher, posicion1);
		mapa.ubicarSuperficie(superficie, posicion2);
		DirArriba direccion = new DirArriba();
		bonecrusher.moverEnDireccion(direccion, mapa);	
		assertTrue(bonecrusher.getVida() == 190);		
	}
	
	@Test
	public void testRatchetAlternoAtraviesaZonaEspinas(){
		SuperficieTerrestre superficie = factoryS.getEspina();
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
	public void testMegatronAlternoAtraviesaZonaEspinas(){
		SuperficieTerrestre superficie = factoryS.getEspina();
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
	public void testRatchetAlternoAtraviesaZonaNube(){
		SuperficieAerea superficie = factoryS.getNube();
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
	public void testMegatronAlternoAtraviesaZonaNube(){
		SuperficieAerea superficie = factoryS.getNube();
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
	public void testRatchetAlternoAtrapadoEnLaNebulosaDeAndromeda(){
		SuperficieAerea superficie = factoryS.getNebulosaAndromeda();
		Posicion posicion1 = new Posicion(1,1);
		Posicion posicion2 = new Posicion(1,2);
		Posicion posicion3 = new Posicion(1,3);
		mapa.ubicarAtacable(ratchet, posicion1);
		mapa.ubicarSuperficie(superficie, posicion2);
		DirArriba direccion = new DirArriba();
		ratchet.transformarse();
		ratchet.moverEnDireccion(direccion, mapa);
		for(int i = 0; i < 3; i++){
			try {
				ratchet.moverEnDireccion(direccion, mapa);
			} catch (MovimientosAgotadosException e) {
				assertTrue(mapa.getAtacable(posicion2).getClass() == ratchet.getClass());
			}
		}
		ratchet.moverEnDireccion(direccion, mapa);
		assertTrue(mapa.getAtacable(posicion3).getClass() == ratchet.getClass());
	}
	
	@Test
	public void testMegatronAlternoAtrapadoEnLaNebulosaDeAndromeda(){
		SuperficieAerea superficie = factoryS.getNebulosaAndromeda();
		Posicion posicion1 = new Posicion(1,1);
		Posicion posicion2 = new Posicion(1,2);
		Posicion posicion3 = new Posicion(1,3);
		mapa.ubicarAtacable(megatron, posicion1);
		mapa.ubicarSuperficie(superficie, posicion2);
		DirArriba direccion = new DirArriba();
		megatron.transformarse();
		megatron.moverEnDireccion(direccion, mapa);
		for(int i = 0; i < 3; i++){
			try {
				megatron.moverEnDireccion(direccion, mapa);
			} catch (MovimientosAgotadosException e) {
				assertTrue(mapa.getAtacable(posicion2).getClass() == megatron.getClass());
			}
		}
		megatron.moverEnDireccion(direccion, mapa);
		assertTrue(mapa.getAtacable(posicion3).getClass() == megatron.getClass());
	}
	
	@Test
	public void testMegatronAlternoAtraviesaTormentaPsionicaYSeDania(){
		SuperficieAerea superficie = factoryS.getTormentaPsionica();
		Posicion posicion1 = new Posicion(1,1);
		Posicion posicion2 = new Posicion(1,2);
		mapa.ubicarAtacable(megatron, posicion1);
		mapa.ubicarSuperficie(superficie, posicion2);
		DirArriba direccion = new DirArriba();
		megatron.moverEnDireccion(direccion, mapa);	
		assertTrue(megatron.getAtaque() == 33);		
	}
	
	@Test
	public void testRatchetAlternoAtraviesaTormentaPsionicaYSeDania(){
		SuperficieAerea superficie = factoryS.getTormentaPsionica();
		Posicion posicion1 = new Posicion(1,1);
		Posicion posicion2 = new Posicion(1,2);
		mapa.ubicarAtacable(ratchet, posicion1);
		mapa.ubicarSuperficie(superficie, posicion2);
		DirArriba direccion = new DirArriba();
		ratchet.moverEnDireccion(direccion, mapa);	
		assertTrue(ratchet.getAtaque() == 21);		
	}
	
	@Test
	public void testMegatronAlternoAtraviesaTormentaPsionicaDosVecesYSeDaniaUna(){
		SuperficieAerea superficie = factoryS.getTormentaPsionica();
		Posicion posicion1 = new Posicion(1,1);
		Posicion posicion2 = new Posicion(1,2);
		Posicion posicion3 = new Posicion(1,3);
		mapa.ubicarAtacable(megatron, posicion1);
		mapa.ubicarSuperficie(superficie, posicion2);
		mapa.ubicarSuperficie(superficie, posicion3);
		DirArriba direccion = new DirArriba();
		megatron.moverEnDireccion(direccion, mapa);	
		assertTrue(megatron.getAtaque() == 33);
		megatron.moverEnDireccion(direccion, mapa);	
		assertTrue(megatron.getAtaque() == 33);
	}
	
	@Test
	public void testRatchetAlternoAtraviesaTormentaPsionicaDosVecesYSeDaniaUna(){
		SuperficieAerea superficie = factoryS.getTormentaPsionica();
		Posicion posicion1 = new Posicion(1,1);
		Posicion posicion2 = new Posicion(1,2);
		Posicion posicion3 = new Posicion(1,3);
		mapa.ubicarAtacable(ratchet, posicion1);
		mapa.ubicarSuperficie(superficie, posicion2);
		mapa.ubicarSuperficie(superficie, posicion3);
		DirArriba direccion = new DirArriba();
		ratchet.moverEnDireccion(direccion, mapa);	
		assertTrue(ratchet.getAtaque() == 21);
		ratchet.moverEnDireccion(direccion, mapa);	
		assertTrue(ratchet.getAtaque() == 21);
	}
	
	
}
