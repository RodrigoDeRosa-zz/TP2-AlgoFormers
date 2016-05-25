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
	
	@Test
	public void testCambiarDeAlternoAHumanoide(){
		Personaje personaje = Bumblebee.getInstance();
		assertEquals(BumblebeeAlterno.getInstance(), personaje.getEstado());
		personaje.cambiarEstado();
		assertEquals(BumblebeeHumanoide.getInstance(), personaje.getEstado());
	}
	
	
}
