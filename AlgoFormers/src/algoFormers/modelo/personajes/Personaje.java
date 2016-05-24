package algoFormers.modelo.personajes;

public abstract class Personaje {

	protected Estado estado;
	
	public Personaje(){
		this.setEstado();
	}
	
	abstract protected void setEstado();
	abstract public Estado getEstado();
	abstract public void cambiarEstado();
}
