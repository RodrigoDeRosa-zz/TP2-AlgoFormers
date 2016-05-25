package algoFormers.modelo.personajes;

public abstract class Personaje {

	protected Estado estado;
	protected int vida;
	protected String nombre;
	
	public Personaje(){
		this.setEstado();
	}
	
	abstract protected void setEstado();

	
	public void cambiarEstado(){
		this.estado = this.estado.getInstanceEstadoOpuesto();
	}
	
	public Estado getEstado(){
		return this.estado;
	}
}
