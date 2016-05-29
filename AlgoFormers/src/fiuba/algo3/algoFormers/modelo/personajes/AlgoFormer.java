package fiuba.algo3.algoFormers.modelo.personajes;

import fiuba.algo3.algoFormers.modelo.direcciones.Direccion;
import fiuba.algo3.algoFormers.modelo.interfaces.Atacable;
import fiuba.algo3.algoFormers.modelo.interfaces.Ubicable;
import fiuba.algo3.algoFormers.modelo.mapas.Mapa;
import fiuba.algo3.algoFormers.modelo.mapas.Posicion;
import fiuba.algo3.algoFormers.modelo.personajes.atributos.Ataque;
import fiuba.algo3.algoFormers.modelo.personajes.atributos.Vida;
import fiuba.algo3.algoFormers.modelo.personajes.estadosDeTransformacion.Alterno;
import fiuba.algo3.algoFormers.modelo.personajes.estadosDeTransformacion.EstadoDeTransformacion;
import fiuba.algo3.algoFormers.modelo.personajes.estadosDeTransformacion.Humanoide;
import fiuba.algo3.algoFormers.modelo.personajes.manejadores.ManejadorDeAtaques;
import fiuba.algo3.algoFormers.modelo.personajes.manejadores.ManejadorDeMovimientos;

public abstract class AlgoFormer implements Atacable {

	protected String nombre;
	protected Vida vida;
	protected EstadoDeTransformacion estadoDeTransformacionActual;
	protected EstadoDeTransformacion estadoDeTransformacionOpuesto;
	protected ManejadorDeMovimientos manDeMovimientos;
	protected ManejadorDeAtaques manDeAtaques;
	
	public abstract void recibirDanio(Decepticon decepticon, int poderAtaque);
	public abstract void recibirDanio(AutoBot autobot, int poderAtaque);
	
	
	public AlgoFormer(String nombre, int vida, Alterno alterno, int velocidadH, int ataqueH, int distAtaqueH){
		this.setNombre(nombre);
		this.setVida(vida);
		this.setEstadosDeTransformacion(alterno, velocidadH, ataqueH, distAtaqueH);
		this.setManejadorMovimientosNull();
		this.setManejadorAtaquesNull();
	}

	private void setNombre(String nombre){
		this.nombre = nombre;
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
		/*Funcion para mover un algoformer. Recibe una direccion de movimiento
		 * y el mapa. Esta delega su comportamiento en el manejador de movimiento.
		 */
		this.manDeMovimientos.moverEnDireccion(this, direccion,mapa);
	}
	
	public void atacarPosicion(Posicion posicion, Mapa mapa){
		/* Funcion delega su comportamiento en atacar de manejador de ataques.
		 *Recibe como parametro una posicion a la cual atacar y el mapa.
		 */
		this.manDeAtaques.atacar(this,posicion,mapa);
	}
	
	
	public void inicializarTurno(){
		/*Funcion para setear los manejadores de un algoformer en el momento
		en el que el algoformer es seleccionado como el personaje de turno.
		*/
		ManejadorDeMovimientos manejadorM=this.estadoDeTransformacionActual.crearManejadorMovimientos();
		ManejadorDeAtaques manejadorA=this.estadoDeTransformacionActual.crearManejadorAtaque();
		this.manDeMovimientos = manejadorM;
		this.manDeAtaques = manejadorA;
	}
	
	//Metodos para las pruebas. No se deberian llamar en otras clases.
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
