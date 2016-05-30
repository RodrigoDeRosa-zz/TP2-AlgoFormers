package fiuba.algo3.algoFormers.modelo.juego.acciones;

import fiuba.algo3.algoFormers.modelo.excepciones.AtaqueFueraDeRangoException;
import fiuba.algo3.algoFormers.modelo.excepciones.AtaqueInvalidoException;
import fiuba.algo3.algoFormers.modelo.juego.Accion;
import fiuba.algo3.algoFormers.modelo.mapas.Mapa;
import fiuba.algo3.algoFormers.modelo.mapas.Posicion;
import fiuba.algo3.algoFormers.modelo.personajes.Algoformer;
import fiuba.algo3.algoFormers.modelo.personajes.manejadores.ManejadorDeAtaques;

public class Atacar implements Accion {

	private ManejadorDeAtaques manejador;
	
	/**
	 * Crea un manejador de ataques y lo asigna a esta accion, segun los parametros recibidos,
	 * para poder ejecutar la accion de ataque.
	 * @param mapa :Mapa del juego en estado valido
	 * @param algoformerAtacante :algoformer en estado valido
	 * @param posicion :posicion en estado valido
	 */
	public Atacar(Mapa mapa, Algoformer algoformerAtacante, Posicion posicion) {
		
		manejador = new ManejadorDeAtaques(mapa, algoformerAtacante, posicion);
	}
	
	@Override
	/**
	 * Realiza el ataque segun el manejador establecido.
	 */
	public void ejecutar() {

		try {
			manejador.realizarAtaque();
		} catch (AtaqueFueraDeRangoException e) {
			throw e;
		} catch (AtaqueInvalidoException e) {
			throw e;
		}
	}

}
