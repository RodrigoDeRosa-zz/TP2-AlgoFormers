package fiuba.algo3.algoFormers.modelo.personajes.atributos;

import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;
import fiuba.algo3.algoFormers.modelo.personajes.manejadores.ManejadorDeMovimientos;

public class Velocidad extends Atributo{
	
	public Velocidad(int velocidad){
		super(velocidad);
	}
	
	//Metodo para las pruebas. No se deberian usar

	public ManejadorDeMovimientos crearManejadorMovimientos() {
		ManejadorDeMovimientos manejador = new ManejadorDeMovimientos(this.valor);
		return manejador;
	}
	
	public void aplicarseEn(AlgoFormer algoformer) {
		algoformer.aplicarEfecto(this);	
	}
	
}
