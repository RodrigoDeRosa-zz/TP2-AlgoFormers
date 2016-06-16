package fiuba.algo3.algoFormers.entrega3;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.algoFormers.modelo.acciones.Combinar;
import fiuba.algo3.algoFormers.modelo.fabricas.algoFormers.AutoBotFactory;
import fiuba.algo3.algoFormers.modelo.jugadores.JugadorAutobots;
import fiuba.algo3.algoFormers.modelo.mapa.Mapa;
import fiuba.algo3.algoFormers.modelo.mapa.Posicion;

public class CombinacionTest {
	
	
	@Test
	public void testCombinacionRemueveAPersonajesAutobots() {
		
		JugadorAutobots jug = new JugadorAutobots();
		AutoBotFactory fab = new AutoBotFactory();
		Mapa map = new Mapa();
		jug.inicializarEquipo();
		jug.ubicarPersonajes(map);
		Posicion posUno = new Posicion(0,18);
		Posicion posDos = new Posicion(0,19);
		Posicion posTres = new Posicion(0,20);
		
		assertFalse(map.getAtacable(posUno) == null);
		
		assertFalse(map.getAtacable(posDos) == null);
		assertFalse(map.getAtacable(posTres) == null);
		
		Combinar accion = new Combinar(jug, map);
		accion.ejecutar();
	}
}
