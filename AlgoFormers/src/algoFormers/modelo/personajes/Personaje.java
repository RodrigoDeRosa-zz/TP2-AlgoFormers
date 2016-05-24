package algoFormers.modelo.personajes;

public abstract class Personaje {

	protected Estado estado;
	
	public Personaje(){
		this.setEstado();
	}
	
	abstract public void setEstado();
	abstract public Estado getEstado();
}
