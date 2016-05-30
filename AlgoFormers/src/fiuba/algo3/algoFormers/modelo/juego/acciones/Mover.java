package fiuba.algo3.algoFormers.modelo.juego.acciones;

import fiuba.algo3.algoFormers.modelo.direcciones.Direccion;
import fiuba.algo3.algoFormers.modelo.excepciones.CasilleroOcupadoException;
import fiuba.algo3.algoFormers.modelo.excepciones.PosicionFueraDelMapaException;
import fiuba.algo3.algoFormers.modelo.juego.Accion;
import fiuba.algo3.algoFormers.modelo.mapas.Mapa;
import fiuba.algo3.algoFormers.modelo.personajes.Algoformer;
import fiuba.algo3.algoFormers.modelo.personajes.manejadores.ManejadorDeMovimientos;

public class Mover implements Accion {

	private ManejadorDeMovimientos manejador;
	
	public Mover(Mapa mapaDelJuego, Algoformer algoformer, Direccion dir) {
		
		manejador = new ManejadorDeMovimientos(mapaDelJuego, algoformer, dir);
		
	}	
	
	@Override
	public void ejecutar() {

		try {
			manejador.RealizarMovimiento();
		} 
		catch (PosicionFueraDelMapaException e) {
			throw e;
		}
		catch (CasilleroOcupadoException e) {
			throw e;
		}
		
	}

}
