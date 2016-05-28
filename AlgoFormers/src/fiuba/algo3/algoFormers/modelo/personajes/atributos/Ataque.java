package fiuba.algo3.algoFormers.modelo.personajes.atributos;

import fiuba.algo3.algoFormers.modelo.personajes.manejadores.ManejadorDeAtaques;

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
	
	public ManejadorDeAtaques crearManejadorAtaque() {
		/*Funcion utilizada para la creacion del manejador de ataque*/
		return this.distAtaque.crearManejadorAtaques(this.ataque);
		
	}
	//Este metodo es para las pruebas. No se deberia usar
	public int getAtaque(){
		return this.ataque;
	}
	
	public int getDistanciaDeAtaque(){
		return this.distAtaque.getDistanciaDeAtaque();
	}

}
