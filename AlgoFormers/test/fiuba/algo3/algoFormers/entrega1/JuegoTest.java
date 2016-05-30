package fiuba.algo3.algoFormers.entrega1;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.algoFormers.modelo.excepciones.AtaqueFueraDeRangoException;
import fiuba.algo3.algoFormers.modelo.excepciones.FuegoAmigoException;
import fiuba.algo3.algoFormers.modelo.interfaces.Accion;
import fiuba.algo3.algoFormers.modelo.juego.Juego;
import fiuba.algo3.algoFormers.modelo.juego.Jugador;
import fiuba.algo3.algoFormers.modelo.juego.JugadorAutobots;
import fiuba.algo3.algoFormers.modelo.juego.Turno;
import fiuba.algo3.algoFormers.modelo.juego.acciones.Atacar;
import fiuba.algo3.algoFormers.modelo.mapas.Mapa;
import fiuba.algo3.algoFormers.modelo.mapas.Posicion;
import fiuba.algo3.algoFormers.modelo.personajes.Algoformer;

public class JuegoTest {

	@Test
	public void crearJuegoNoDevuelveNullTest() {

		Juego juego = new Juego();
		assertNotNull(juego);
		
	}
	
	@Test (expected=FuegoAmigoException.class)
	public void AtacarAmigoEnDistanciaValidaLanzaExcepcionFuegoAmigoTest() {
		
		
		Mapa mapa = new Mapa();
		
		Jugador jugadorAutobots = new JugadorAutobots();
		jugadorAutobots.inicializarEquipo();
		jugadorAutobots.ubicarPersonajes(mapa);
		Turno turno = new Turno(jugadorAutobots);	
		Algoformer optimus = jugadorAutobots.getAlgoformer("OPTIMUS");
		assertTrue(optimus.getNombre() == mapa.getUbicable(new Posicion(1, 19)).getNombre());
	
		turno.setAlgoformerActual(optimus);
		
		Posicion pos = new Posicion(1, 21);
		Accion accion = new Atacar(mapa, turno.getAlgoformerActual(), pos);
		accion.ejecutar();
		
	}
	
	@Test (expected=AtaqueFueraDeRangoException.class)
	public void AtacarEnDistanciaInvalidaLanzaExcepcionFueraDeRango() {
		
		
		Mapa mapa = new Mapa();
		
		Jugador jugadorAutobots = new JugadorAutobots();
		jugadorAutobots.inicializarEquipo();
		jugadorAutobots.ubicarPersonajes(mapa);
		Turno turno = new Turno(jugadorAutobots);	
		Algoformer optimus = jugadorAutobots.getAlgoformer("OPTIMUS");
	
		turno.setAlgoformerActual(optimus);
		
		Posicion pos = new Posicion(2, 23);
		Accion accion = new Atacar(mapa, turno.getAlgoformerActual(), pos);
		accion.ejecutar();
		
	}
	
	

}
