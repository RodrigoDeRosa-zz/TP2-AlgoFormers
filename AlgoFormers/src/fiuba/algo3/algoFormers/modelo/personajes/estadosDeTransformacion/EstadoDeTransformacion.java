package fiuba.algo3.algoFormers.modelo.personajes.estadosDeTransformacion;

import fiuba.algo3.algoFormers.modelo.personajes.atributos.Ataque;
import fiuba.algo3.algoFormers.modelo.personajes.atributos.Velocidad;

public class EstadoDeTransformacion {

	protected Velocidad velocidad;
	protected Ataque ataque;
	
	public EstadoDeTransformacion(int velocidad, int ataque, int distAtaque){
		this.setVelocidad(velocidad);
		this.setAtaque(ataque, distAtaque);
	}
	
	private void setVelocidad(int velocidad){
		this.velocidad = new Velocidad(velocidad);
	}
	
	private void setAtaque(int ataque, int distAtaque){
		this.ataque = new Ataque(ataque, distAtaque);
	}
	
	//Metodos para las pruebas. No se deberian usar.
	public int getVelocidad(){
		return this.velocidad.getVelocidad();
	}
	
	public int getAtaque(){
		return this.ataque.getAtaque();
	}
	
	public int getDistanciaDeAtaque(){
		return this.ataque.getDistanciaDeAtaque();
	}
	
}