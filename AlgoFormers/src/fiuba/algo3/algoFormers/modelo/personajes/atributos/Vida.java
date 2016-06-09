package fiuba.algo3.algoFormers.modelo.personajes.atributos;

import fiuba.algo3.algoFormers.modelo.capturables.bonus.BurbujaInmaculada;

public class Vida extends Atributo{
	
	public Vida(int vida){
		super(vida);
	}
	
	public void descontarVida(int descuento){
		/*Metodo que sirve para descontarle la vida a un jugador
		 * que es atacado.
		 */
		int danioTotal = this.calcularDanio(descuento);
		this.valorActual -= danioTotal;
	}
	
	private int calcularDanio(int danioOriginal){
		if (this.efectosTemporales.contains((new BurbujaInmaculada()))){
			return 0;
		}
		return danioOriginal;
	}
	
	//Metodo para las pruebas. No se deberia usar
	public int getVida(){
		return this.valorActual;
	}
//
//	public void recalcularVida() {
//		valorActual = this.calcularValorActual();
//	}
}
