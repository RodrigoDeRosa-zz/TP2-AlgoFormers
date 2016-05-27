package fiuba.algo3.algoFormers.modelo.personajes.atributos;

public class Velocidad {

	private int velocidad;
	
	public Velocidad(int velocidad){
		this.setVelocidad(velocidad);
	}
	
	private void setVelocidad(int velocidad){
		this.velocidad = velocidad;
	}
	
	//Metodo para las pruebas. No se deberian usar
	public int getVelocidad(){
		return this.velocidad;
	}
	
}
