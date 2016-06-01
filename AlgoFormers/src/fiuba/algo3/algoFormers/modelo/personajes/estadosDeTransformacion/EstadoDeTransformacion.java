package fiuba.algo3.algoFormers.modelo.personajes.estadosDeTransformacion;

import fiuba.algo3.algoFormers.modelo.mapa.superficies.Superficie;
import fiuba.algo3.algoFormers.modelo.personajes.atributos.Ataque;
import fiuba.algo3.algoFormers.modelo.personajes.atributos.Velocidad;
import fiuba.algo3.algoFormers.modelo.personajes.manejadores.ManejadorDeAtaques;
import fiuba.algo3.algoFormers.modelo.personajes.manejadores.ManejadorDeMovimientos;

public class EstadoDeTransformacion {

	protected Velocidad velocidad;
	protected Ataque ataque;
	
	public EstadoDeTransformacion(int velocidad, int ataque, int distAtaque){
		this.setVelocidad(velocidad);
		this.setAtaque(ataque, distAtaque);
	}
	
	private void setVelocidad(int velocidad){
		this.velocidad = new Velocidad(velocidad);
	}
	
	private void setAtaque(int ataque, int distAtaque){
		this.ataque = new Ataque(ataque, distAtaque);
	}
	
	public Ataque obtenerAtaque(){
		return this.ataque;
	}
	
	public ManejadorDeMovimientos crearManejadorMovimientos() {
		/*Funcion que le pide al objeto velocidad que devuelva un manejador
		 * de movimientos con los movimientos del algoformer en su modo actual.
		 */
		return this.velocidad.crearManejadorMovimientos();
	}
	
	public ManejadorDeAtaques crearManejadorAtaque() {
		/* Funcion que le pide al objeto ataque que devuelva un manejador de ataque
		 * con el poder de ataque y la distancia en su  modo actual.
		 */
		return this.ataque.crearManejadorAtaque();
	}
	
	//Metodos para las pruebas. No se deberian usar.
	public int getVelocidad(){
		return this.velocidad.getVelocidad();
	}
	
	public int getAtaque(){
		return this.ataque.getAtaque();
	}
	
	public int getDistanciaDeAtaque(){
		return this.ataque.getDistanciaDeAtaque();
	}

	public void afectarseConSuperficie(Superficie superficie) {
		// TODO Auto-generated method stub
		
	}

}
