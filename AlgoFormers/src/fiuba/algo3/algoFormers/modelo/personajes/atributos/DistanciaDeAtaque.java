package fiuba.algo3.algoFormers.modelo.personajes.atributos;

public class DistanciaDeAtaque {

	private int distAtaque;
	
	public DistanciaDeAtaque(int distAtaque){
		this.setDistanciaDeAtaque(distAtaque);
	}
	
	private void setDistanciaDeAtaque(int distAtaque){
		this.distAtaque = distAtaque;
	}
	
	//Este metodo es para las pruebas. No se deberia usar
	public int getDistanciaDeAtaque(){
		return this.distAtaque;
	}
	
}
