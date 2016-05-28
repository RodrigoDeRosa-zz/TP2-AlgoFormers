package fiuba.algo3.algoFormers.modelo.personajes.atributos;

public class Vida {

	private int vida;
	
	public Vida(int vida){
		this.setVida(vida);
	}
	
	private void setVida(int vida){
		this.vida = vida;
	}
	
	public void descontarVida(int descuento){
		/*Metodo que sirve para descontarle la vida a un jugador
		 * que es atacado.
		 */
		this.vida -=descuento;
	}
	//Metodo para las pruebas. No se deberia usar
	public int getVida(){
		return this.vida;
	}
	
}
