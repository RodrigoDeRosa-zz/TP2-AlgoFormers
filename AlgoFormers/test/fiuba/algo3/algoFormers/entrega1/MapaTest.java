package fiuba.algo3.algoFormers.entrega1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.algoFormers.modelo.mapas.Casillero;
import fiuba.algo3.algoFormers.modelo.mapas.Mapa;
import fiuba.algo3.algoFormers.modelo.mapas.Posicion;

public class MapaTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCrearUnMapa() {
		
		Mapa mapa = new Mapa();
		assertNotNull(mapa);
		
	}
	
	@Test
	public void testCrearUnMapaDeTamanioCorrectoLlenoDeCasilleros() {
		
		Mapa mapa = new Mapa();
		int tamanio = mapa.getTamanio();
		for(int i = 0; i < tamanio; i++){
			for(int j = 0; j < tamanio; j++){
				assertTrue(mapa.getCasillero(new Posicion(i,j)).class, Casillero);
			}
		}
		
	}

}
