package fiuba.algo3.algoFormers.modelo.personajes.atributos;

import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;
import fiuba.algo3.algoFormers.modelo.personajes.manejadores.ManejadorDeAtaques;

public class Ataque extends Atributo{
	private DistanciaDeAtaque distAtaque;
	
	public Ataque(int ataque, int distAtaque){
		super(ataque);
		this.setDistanciaDeAtaque(distAtaque);
	}
	
	private void setDistanciaDeAtaque(int distAtaque){
		this.distAtaque = new DistanciaDeAtaque(distAtaque);
	}
	
	public ManejadorDeAtaques crearManejadorAtaque() {
		/*Funcion utilizada para la creacion del manejador de ataque*/
		return this.distAtaque.crearManejadorAtaques(this.valor);
	}
	
	public void aplicarseEn(AlgoFormer algoformer) {
		algoformer.aplicarEfecto(this);	
	}
	
	//Este metodo es para las pruebas. No se deberia usar
	
	public int getDistanciaDeAtaque(){
		return this.distAtaque.getValor();
	}

}
