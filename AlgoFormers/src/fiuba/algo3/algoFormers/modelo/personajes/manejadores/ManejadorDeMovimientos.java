package fiuba.algo3.algoFormers.modelo.personajes.manejadores;

import fiuba.algo3.algoFormers.modelo.direcciones.Direccion;
import fiuba.algo3.algoFormers.modelo.excepciones.CasilleroOcupadoException;
import fiuba.algo3.algoFormers.modelo.excepciones.NoQuedanMovimientosDisponiblesException;
import fiuba.algo3.algoFormers.modelo.excepciones.PosicionFueraDelMapaException;
import fiuba.algo3.algoFormers.modelo.mapas.Mapa;
import fiuba.algo3.algoFormers.modelo.mapas.Posicion;
import fiuba.algo3.algoFormers.modelo.personajes.Algoformer;

public class ManejadorDeMovimientos {
	
	private Posicion posicionOrigen;
	private Algoformer algoformerActual;
	private Mapa mapa;
	private int movimientosDisponibles;
	private Direccion direccion;
	
	public ManejadorDeMovimientos(Mapa mapaDelJuego, Algoformer algoformer, Direccion unaDireccion) {
		
		mapa = mapaDelJuego;
				
		movimientosDisponibles = algoformer.getPuntosVelocidad();
		algoformerActual = algoformer;
		direccion = unaDireccion;
		
	}
	
	public void  setDireccion(Direccion unaDireccion) {
		
		direccion = unaDireccion;
	}
	
	public void RealizarMovimiento() {
		
		if (movimientosDisponibles <= 0) {
			
			throw new NoQuedanMovimientosDisponiblesException();
		}
		
		try {
			posicionOrigen = algoformerActual.getPosicion();
			Posicion posicionDestino = posicionOrigen.sumarDireccion(direccion);
			mapa.ubicar(algoformerActual, posicionDestino);
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
