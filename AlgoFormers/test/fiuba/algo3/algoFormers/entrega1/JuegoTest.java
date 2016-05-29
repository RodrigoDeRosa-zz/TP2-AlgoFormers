package fiuba.algo3.algoFormers.entrega1;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.algoFormers.modelo.juego.Juego;

public class JuegoTest {

	@Test
	public void crearJuegoNoDevuelveNullTest() {

		Juego juego = new Juego();
		assertNotNull(juego);
		
	}
	
	

}
