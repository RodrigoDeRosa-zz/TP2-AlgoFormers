package fiuba.algo3.algoFormers.modelo.personajes;

import fiuba.algo3.algoFormers.modelo.personajes.atributos.Vida;
import fiuba.algo3.algoFormers.modelo.personajes.estadosDeTransformacion.Alterno;
import fiuba.algo3.algoFormers.modelo.personajes.estadosDeTransformacion.EstadoDeTransformacion;
import fiuba.algo3.algoFormers.modelo.personajes.estadosDeTransformacion.Humanoide;
import fiuba.algo3.algoFormers.modelo.personajes.manejadores.ManejadorDeAtaques;
import fiuba.algo3.algoFormers.modelo.personajes.manejadores.ManejadorDeMovimientos;

public class AlgoFormer {

	protected Vida vida;
	protected EstadoDeTransformacion estadoDeTransformacionActual;
	protected EstadoDeTransformacion estadoDeTransformacionOpuesto;
	protected ManejadorDeMovimientos manDeMovimientos;
	protected ManejadorDeAtaques manDeAtaques;
	
	public AlgoFormer(int vida, Alterno alterno, int velocidadH, int ataqueH, int distAtaqueH){
		this.setVida(vida);
		this.setEstadosDeTransformacion(alterno, velocidadH, ataqueH, distAtaqueH);
		this.setManejadorMovimientosNull();
		this.setManejadorAtaquesNull();
	}

	private void setManejadorMovimientosNull(){
		this.manDeMovimientos = null;
	}

	private void setManejadorAtaquesNull(){
		this.manDeAtaques =null;
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
	
	public void moverEnDireccion(Direccion direccion, Mapa mapa){
		this.manDeMovimientos.moverEnDireccion(this, direccion,mapa);
	}
	
	public void inicializarTurno(){
		//Funcion para setear los manejadores de un algoformer en el momento
		//en el que el algoformer es seleccionado como el personaje de turno.
		int movimientos = this.estadoDeTransformacionActual.getVelocidad();
		this.manDeMovimientos = new ManejadorDeMovimientos(movimientos);
		this.manDeAtaques = new ManejadorDeAtaques();
	}
	
	public void finalizarTurno(){
		this.setManejadorAtaquesNull();
		this.setManejadorMovimientosNull();
	}
	
	//Metodos para las pruebas. No se deberían llamar en otras clases.
	public int getVida(){
		return this.vida.getVida();
	}

	public EstadoDeTransformacion getEstado() {
		return this.estadoDeTransformacionActual;
	}
	
	public int getVelocidad(){
		return this.estadoDeTransformacionActual.getVelocidad();
	}
	
	public int getAtaque(){
		return this.estadoDeTransformacionActual.getAtaque();
	}
	
	public int getDistanciaDeAtaque(){
		return this.estadoDeTransformacionActual.getDistanciaDeAtaque();
	}
}
