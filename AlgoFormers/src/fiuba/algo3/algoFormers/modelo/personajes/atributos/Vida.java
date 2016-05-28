package fiuba.algo3.algoFormers.modelo.personajes.atributos;

//HOLA

public class Vida {

	private int vida;
	
	public Vida(int vida){
		this.setVida(vida);
	}
	
	private void setVida(int vida){
		this.vida = vida;
	}
	
	//Metodo para las pruebas. No se deberia usar
	public int getVida(){
		return this.vida;
	}
	
}
