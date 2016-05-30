package fiuba.algo3.algoFormers.modelo.personajes;

import fiuba.algo3.algoFormers.modelo.interfaces.Atacable;
import fiuba.algo3.algoFormers.modelo.mapas.Posicion;
import fiuba.algo3.algoFormers.modelo.personajes.atributos.Vida;
import fiuba.algo3.algoFormers.modelo.personajes.estadosDeTransformacion.Alterno;
import fiuba.algo3.algoFormers.modelo.personajes.estadosDeTransformacion.EstadoDeTransformacion;
import fiuba.algo3.algoFormers.modelo.personajes.estadosDeTransformacion.Humanoide;


public abstract class Algoformer implements Atacable {

	protected Vida vida;
	protected EstadoDeTransformacion estadoDeTransformacionActual;
	protected EstadoDeTransformacion estadoDeTransformacionOpuesto;
	protected Posicion posicionActual;
	private String nombre;
	
	public abstract void atacar(Autobot autobot);
	public abstract void atacar(Decepticon decepticon);	
	
	public Algoformer(String nombre, int vida, Alterno alterno, int velocidadH, int ataqueH, int distAtaqueH){
		this.setVida(vida);
		this.setEstadosDeTransformacion(alterno, velocidadH, ataqueH, distAtaqueH);
		this.nombre = nombre;

	}
	
	private void setVida(int vida){
		this.vida = new Vida(vida);
	}
	
	private void setEstadosDeTransformacion(Alterno alterno, int velocidadH, int ataqueH, int distAtaqueH){
		EstadoDeTransformacion humanoide = new Humanoide(velocidadH, ataqueH, distAtaqueH);
		this.estadoDeTransformacionActual = humanoide;
		this.estadoDeTransformacionOpuesto = alterno;
	}
	
	public void transformarse(){
		EstadoDeTransformacion estadoAux = this.estadoDeTransformacionActual;
		this.estadoDeTransformacionActual = this.estadoDeTransformacionOpuesto;
		this.estadoDeTransformacionOpuesto = estadoAux;
	}
	
	public void setPosicion(Posicion pos) {
		
		posicionActual = pos;
	}
	
	public Posicion getPosicion() {
		
		return posicionActual;
	}
	
	public EstadoDeTransformacion getEstado() {
		return this.estadoDeTransformacionActual;
	}
	
	public int getPuntosVida(){
		return this.vida.get();
	}
	
	public int getPuntosVelocidad(){
		return this.estadoDeTransformacionActual.getVelocidad().get();
	}
	
	public int getPuntosAtaque(){
		return this.estadoDeTransformacionActual.getAtaque().get();
	}
	
	public int getPuntosDistanciaDeAtaque(){
		return this.estadoDeTransformacionActual.getDistanciaDeAtaque().get();
	}
	public String getNombre() {
		return this.nombre;
	}	

}
