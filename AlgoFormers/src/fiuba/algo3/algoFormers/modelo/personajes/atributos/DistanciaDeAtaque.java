package fiuba.algo3.algoFormers.modelo.personajes.atributos;

import fiuba.algo3.algoFormers.modelo.personajes.manejadores.ManejadorDeAtaques;

public class DistanciaDeAtaque {

	private int distAtaque;
	
	public DistanciaDeAtaque(int distAtaque){
		this.setDistanciaDeAtaque(distAtaque);
	}
	
	private void setDistanciaDeAtaque(int distAtaque){
		this.distAtaque = distAtaque;
	}
	
	public ManejadorDeAtaques crearManejadorAtaques(int ataque) {
		/*Metodo que devuelve el manejador de ataque seteado con el poder
		 * de ataque y la distancia.
		 */
		
		ManejadorDeAtaques manejador = new ManejadorDeAtaques(ataque, this.distAtaque);
		return manejador;
	}
	
	//Este metodo es para las pruebas. No se deberia usar
	public int getDistanciaDeAtaque(){
		return this.distAtaque;
	}
	
}
