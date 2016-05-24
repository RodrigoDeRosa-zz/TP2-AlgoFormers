package algoFormers.modelo.personajes;

public abstract class Personaje {

	protected Transformable estado;
	public static int ALTERNO = 0;
	public static int HUMANOIDE = 1;
	protected int vida;
	
	public Personaje(){
		this.setEstado(ALTERNO);
	}
	
	abstract public void setEstado(int estado);
	abstract public Transformable getEstado();
}
