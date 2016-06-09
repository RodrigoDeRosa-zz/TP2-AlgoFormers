package fiuba.algo3.algoFormers.modelo.personajes.atributos;

public class Vida extends Atributo{
	
	private int escudo = 0;
	
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
		if (this.escudo != 0){ danioOriginal = 0; }
		return danioOriginal;
	}
	
	public void crearEscudo() {
		this.escudo = 3;		
	}
	
	@Override
	public void actualizar(){
		if(this.escudo > 0) this.escudo--;
	}
	
	//Metodo para las pruebas. No se deberia usar
	public int getVida(){
		return this.valorActual;
	}
}
