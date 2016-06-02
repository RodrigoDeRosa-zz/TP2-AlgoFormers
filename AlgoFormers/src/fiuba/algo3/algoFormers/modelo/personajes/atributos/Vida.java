package fiuba.algo3.algoFormers.modelo.personajes.atributos;

import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;

public class Vida extends Atributo{
	
	public Vida(int vida){
		super(vida);
	}
	
	public void descontarVida(int descuento){
		/*Metodo que sirve para descontarle la vida a un jugador
		 * que es atacado.
		 */
		this.valor -= descuento;
	}

	@Override
	public void aplicarseEn(AlgoFormer algoformer) {
		algoformer.aplicarEfecto(this);		
	}	
}
