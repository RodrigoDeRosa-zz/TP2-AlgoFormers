package fiuba.algo3.algoFormers.modelo.personajes.atributos;

public class Vida extends Atributo{

	
	
	public Vida(int vida){
		super(vida);
	}
	
	public void descontarVida(int descuento){
		/*Metodo que sirve para descontarle la vida a un jugador
		 * que es atacado.
		 */
		this.valorActual -=descuento;
	}
	//Metodo para las pruebas. No se deberia usar
	public int getVida(){
		return this.valorActual;
	}

	public void recalcularVida() {
		valorActual = this.calcularValorActual();
	}
}
