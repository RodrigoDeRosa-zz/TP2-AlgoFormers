package fiuba.algo3.algoFormers.modelo.interfaces;

/**
 *Interface Accion, tiene un metodo ejecutar que permite aplicarla a un juego.
 */
public interface Accion {
	
	/**
	 * Aplica la accion asociada a esta accion.
	 */
	public abstract void ejecutar();
}
