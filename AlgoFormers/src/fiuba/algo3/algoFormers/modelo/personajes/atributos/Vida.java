package fiuba.algo3.algoFormers.modelo.personajes.atributos;

public class Vida extends Atributo {
	
	private boolean hayEscudo;
	
	public Vida(int inicial) {
		super(inicial);
		
	}	
			
	public void aplicarEscudo() {
		hayEscudo = true;
	}
	
	public void quitarEscudo() {
		hayEscudo = false;
	}
	
	public void descontar(int descuento){
		/*Metodo que sirve para descontarle la vida a un jugador
		 * que es atacado.
		 * ACA SE DEBERIA MANEJAR LO DE LOS BONUS CUANDO NO LE HACEN DANIO
		 */		
		if (hayEscudo) {
			return;
		}		
		this.valor -=descuento;
	}
	
	
}
