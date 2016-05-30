package fiuba.algo3.algoFormers.modelo.personajes.manejadores;

import fiuba.algo3.algoFormers.modelo.direcciones.Direccion;
import fiuba.algo3.algoFormers.modelo.excepciones.CasilleroOcupadoException;
import fiuba.algo3.algoFormers.modelo.excepciones.PosicionFueraDelMapaException;
import fiuba.algo3.algoFormers.modelo.mapas.Mapa;
import fiuba.algo3.algoFormers.modelo.mapas.Posicion;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;

public class ManejadorDeMovimientos {
	
	private Posicion posicionOrigen, posicionDestino;
	private AlgoFormer algoformer;
	private Mapa mapa;
	
	public ManejadorDeMovimientos(Mapa mapaDelJuego, AlgoFormer algoformer, Direccion dir) {
		
		posicionOrigen = algoformer.getPosicion();
		posicionDestino = posicionOrigen.sumarDireccion(dir);
		mapa = mapaDelJuego;
		
	}
	
	public void RealizarMovimiento() {
		
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
		
	}
	
}
