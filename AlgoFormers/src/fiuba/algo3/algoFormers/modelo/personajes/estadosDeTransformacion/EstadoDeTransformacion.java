package fiuba.algo3.algoFormers.modelo.personajes.estadosDeTransformacion;

import fiuba.algo3.algoFormers.modelo.personajes.atributos.Ataque;
import fiuba.algo3.algoFormers.modelo.personajes.atributos.DistanciaDeAtaque;
import fiuba.algo3.algoFormers.modelo.personajes.atributos.Velocidad;

public class EstadoDeTransformacion {

	protected Velocidad velocidad;
	protected Ataque ataque;
	protected DistanciaDeAtaque distanciaAtaque;
	
	public EstadoDeTransformacion(int velocidadInicial, int ataqueInicial, int distAtaqueInicial){
		velocidad = new Velocidad(velocidadInicial);
		ataque = new Ataque(ataqueInicial);
		distanciaAtaque = new DistanciaDeAtaque(distAtaqueInicial);
		
	}
	
	public void setVelocidad(int nuevaVelocidad){
		velocidad = new Velocidad(nuevaVelocidad);
	}
	
	public Velocidad getVelocidad() {
		
		return velocidad;
	}
	
	public void setAtaque(int nuevoAtaque){
		this.ataque = new Ataque(nuevoAtaque);
	}
	
	public Ataque getAtaque(){
		return ataque;
	}
	
	public void setDistanciaDeAtaque(int nuevaDistancia) {
		
		distanciaAtaque = new DistanciaDeAtaque(nuevaDistancia);
	}
	
	public DistanciaDeAtaque getDistanciaDeAtaque() {
		
		return distanciaAtaque;
	}
}
