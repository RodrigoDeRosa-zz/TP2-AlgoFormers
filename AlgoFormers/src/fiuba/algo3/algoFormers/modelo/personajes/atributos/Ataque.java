package fiuba.algo3.algoFormers.modelo.personajes.atributos;

public class Ataque {

	private int ataque;
	private DistanciaDeAtaque distAtaque;
	
	public Ataque(int ataque, int distAtaque){
		this.setAtaque(ataque);
		this.setDistanciaDeAtaque(distAtaque);
	}
	
	private void setAtaque(int ataque){
		this.ataque = ataque;
	}
	
	private void setDistanciaDeAtaque(int distAtaque){
		this.distAtaque = new DistanciaDeAtaque(distAtaque);
	}
	
	//Este metodo es para las pruebas. No se deberia usar
	public int getAtaque(){
		return this.ataque;
	}
	
	public int getDistanciaDeAtaque(){
		return this.distAtaque.getDistanciaDeAtaque();
	}
}
