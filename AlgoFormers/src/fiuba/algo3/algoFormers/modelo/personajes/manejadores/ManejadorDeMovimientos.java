package fiuba.algo3.algoFormers.modelo.personajes.manejadores;

import fiuba.algo3.algoFormers.modelo.direcciones.Direccion;
import fiuba.algo3.algoFormers.modelo.excepciones.CasilleroOcupadoException;
import fiuba.algo3.algoFormers.modelo.excepciones.NoQuedanMovimientosDisponiblesException;
import fiuba.algo3.algoFormers.modelo.excepciones.PosicionFueraDelMapaException;
import fiuba.algo3.algoFormers.modelo.mapas.Mapa;
import fiuba.algo3.algoFormers.modelo.mapas.Posicion;
import fiuba.algo3.algoFormers.modelo.personajes.Algoformer;

public class ManejadorDeMovimientos {
	
	private Posicion posicionOrigen, posicionDestino;
	private Algoformer algoformer;
	private Mapa mapa;
	private int movimientosDisponibles;
	
	public ManejadorDeMovimientos(Mapa mapaDelJuego, Algoformer algoformer, Direccion dir) {
		
		posicionOrigen = algoformer.getPosicion();
		posicionDestino = posicionOrigen.sumarDireccion(dir);
		mapa = mapaDelJuego;
		movimientosDisponibles = algoformer.getPuntosVelocidad();
		
	}
	
	public void RealizarMovimiento() {
		
		if (movimientosDisponibles <= 0) {
			
			throw new NoQuedanMovimientosDisponiblesException();
		}
		
		try {
			mapa.ubicar(algoformer, posicionDestino);
		}
		catch (PosicionFueraDelMapaException e) {
			throw e;
		}
		catch (CasilleroOcupadoException e) {
			throw e;
		}
		mapa.desocupar(posicionOrigen);
		movimientosDisponibles--;
		
	}
	
}
