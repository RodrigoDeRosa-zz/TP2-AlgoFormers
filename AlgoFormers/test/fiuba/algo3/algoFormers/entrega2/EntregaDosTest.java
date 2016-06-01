package fiuba.algo3.algoFormers.entrega2;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.algoFormers.modelo.direcciones.DirArriba;
import fiuba.algo3.algoFormers.modelo.excepciones.SuperficieInaccesibleException;
import fiuba.algo3.algoFormers.modelo.fabricas.AlgoFormerFactory;
import fiuba.algo3.algoFormers.modelo.mapa.Mapa;
import fiuba.algo3.algoFormers.modelo.mapa.Posicion;
import fiuba.algo3.algoFormers.modelo.mapa.superficies.terrestres.Pantano;
import fiuba.algo3.algoFormers.modelo.mapa.superficies.terrestres.Rocas;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;

public class EntregaDosTest {

	@Test
	public void testHumanoideAtraviesaZonaRocosaSinProblema(){
		Mapa mapa = new Mapa();
		Posicion posicionSuperficie = new Posicion(1, 2);
		mapa.agregarSuperficieEnCasillero(Rocas.getInstance(), posicionSuperficie);
		
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer optimus = factory.getOptimusPrime();
		
		mapa.ubicarAtacable(optimus, new Posicion(1, 1));
		
		optimus.moverEnDireccion(new DirArriba(), mapa);
		optimus.moverEnDireccion(new DirArriba(), mapa);
		
		assertEquals(mapa.getAtacable(new Posicion(1, 3)), optimus);
	}
	
	@Test(expected=SuperficieInaccesibleException.class)
	public void testHumanoideNoPuedeAtravesarZonaPantano(){
		Mapa mapa = new Mapa();
		Posicion posicionSuperficie = new Posicion(1, 2);
		mapa.agregarSuperficieEnCasillero(Pantano.getInstance(), posicionSuperficie);
		
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AlgoFormer optimus = factory.getOptimusPrime();
		
		mapa.ubicarAtacable(optimus, new Posicion(1, 1));
		
		optimus.moverEnDireccion(new DirArriba(), mapa);
	}
	
}
