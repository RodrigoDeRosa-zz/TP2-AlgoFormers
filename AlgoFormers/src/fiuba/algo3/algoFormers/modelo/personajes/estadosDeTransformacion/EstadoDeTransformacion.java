package fiuba.algo3.algoFormers.modelo.personajes.estadosDeTransformacion;

import fiuba.algo3.algoFormers.modelo.personajes.atributos.Velocidad;

public class EstadoDeTransformacion {

	protected Velocidad velocidad;
	
	public EstadoDeTransformacion(int velocidad){
		this.setVelocidad(velocidad);
	}
	
	private void setVelocidad(int velocidad){
		this.velocidad = new Velocidad(velocidad);
	}
	
	//Metodos para las pruebas. No se deberian usar.
	public int getVelocidad(){
		return this.velocidad.getVelocidad();
	}
	
}
