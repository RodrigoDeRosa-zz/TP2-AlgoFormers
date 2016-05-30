package fiuba.algo3.algoFormers.modelo.personajes.atributos;

public class Atributo {
	
	protected int valor;
	
	public Atributo(int inicial) {
		
		valor = inicial;
	}
	
	public void set(int valorNuevo) {
		
		valor = valorNuevo;
	}
	
	public int get() {
		
		return valor;
	}
	
}
