package fiuba.algo3.algoFormers.modelo.personajes;

public class AlgoFormer {

	protected int vida;
	
	public AlgoFormer(int vida){
		this.setVida(vida);
	}
	
	private void setVida(int vida){
		this.vida = vida;
	}
	
	
	
	
	//Metodos para las pruebas. No se deberían llamar en otras clases.
	public int getVida(){
		return this.vida;
	}
}
