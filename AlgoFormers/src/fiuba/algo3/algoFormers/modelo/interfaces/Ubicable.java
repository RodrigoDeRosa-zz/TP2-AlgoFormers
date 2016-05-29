package fiuba.algo3.algoFormers.modelo.interfaces;

import fiuba.algo3.algoFormers.modelo.mapas.Posicion;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;


public interface Ubicable {
	
	/**
	 * Hace que este ubicable reciba los danios del atacante recibido como parametro,
	 * segun sea este un Autobot o un Decepticon.
	 * @param atacante :Un algoformer en estado valido.
	 */
	public void recibirDanio(AlgoFormer atacante);		
	
	/**
	 * Establece la posicion de este ubicable en la posicion recibida por parametro.
	 * @param pos :una posicion en estado valido.
	 */
	public void setPosicion(Posicion pos);
	
	/**
	 * Devuelve la posicion de este ubicable.
	 * @return Una posicion.
	 */
	public Posicion getPosicion();
	
	
	/**
	 * Devuelve el nombre de este ubicable.
	 * @return Un String con el nombre de este ubicable.
	 */
	public String getNombre();
}
