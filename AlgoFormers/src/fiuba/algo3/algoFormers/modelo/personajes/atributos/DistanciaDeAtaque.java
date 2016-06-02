package fiuba.algo3.algoFormers.modelo.personajes.atributos;

import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;
import fiuba.algo3.algoFormers.modelo.personajes.manejadores.ManejadorDeAtaques;

public class DistanciaDeAtaque extends Atributo{
	
	public DistanciaDeAtaque(int distAtaque){
		super(distAtaque);
	}
	
	public ManejadorDeAtaques crearManejadorAtaques(int ataque) {
		/*Metodo que devuelve el manejador de ataque seteado con el poder
		 * de ataque y la distancia.
		 */
		ManejadorDeAtaques manejador = new ManejadorDeAtaques(ataque, this.valor);
		return manejador;
	}
	
	public void aplicarseEn(AlgoFormer algoformer) {
	}
}
