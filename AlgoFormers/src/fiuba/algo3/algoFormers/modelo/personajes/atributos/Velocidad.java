package fiuba.algo3.algoFormers.modelo.personajes.atributos;

import fiuba.algo3.algoFormers.modelo.personajes.manejadores.ManejadorDeMovimientos;

public class Velocidad {

	private int velocidad;
	
	public Velocidad(int velocidad){
		this.setVelocidad(velocidad);
	}
	
	private void setVelocidad(int velocidad){
		this.velocidad = velocidad;
	}
	
	//Metodo para las pruebas. No se deberian usar
	public int getVelocidad(){
		return this.velocidad;
	}

	public ManejadorDeMovimientos crearManejadorMovimientos() {
		ManejadorDeMovimientos manejador = new ManejadorDeMovimientos(this.velocidad);
		return manejador;
	}
	
}
