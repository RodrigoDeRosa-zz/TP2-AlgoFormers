package algoFormers.modelo.personajes;

public abstract class Personaje {

	protected Estado estadoActual;
	protected Estado estadoOtro;
	
	public Personaje(int vidaH, int ataqueH, int distanciaAtaqueH, int velocidadH, int vidaA, int ataqueA, int distanciaAtaqueA, int velocidadA){
		//supuesto: el estado actual por defecto es el humanoide
		this.estadoActual = new Humanoide(vidaH, ataqueH, distanciaAtaqueH, velocidadH);
		this.estadoOtro = new Alterno(vidaA, ataqueA, distanciaAtaqueA, velocidadA);	
	}
	
	abstract protected void setEstado();
	abstract public Estado getEstado();
	
	public void cambiarEstado(){
		Estado estadoAnterior = this.estadoActual;
		this.estadoActual = this.estadoOtro;
		this.estadoOtro = estadoAnterior;
	}
}