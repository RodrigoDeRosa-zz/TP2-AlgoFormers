package algoFormers.entrega1;

import static org.junit.Assert.*;

import org.junit.Test;
import algoFormers.modelo.personajes.*;

public class TestsEntregaUno {

	@Test
	public void testCrearPersonaje(){
		Personaje personaje = Bumblebee.getInstance();
		assertNotNull(personaje);
	}
	
	@Test
	public void testPersonajeSeCreaEnModoAlterno(){
		Personaje personaje = Bumblebee.getInstance();
		assertEquals(BumblebeeAlterno.getInstance(), personaje.getEstado());
	}
	
	
	
}
