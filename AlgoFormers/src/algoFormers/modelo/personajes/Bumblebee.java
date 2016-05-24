package algoFormers.modelo.personajes;

//anda la concha de la lora

public class Bumblebee extends Personaje{
	
	private static Bumblebee instancia = null;

	private Bumblebee(){
		super();
	}
	
	public static Bumblebee getInstance(){
		if (instancia == null){
			instancia = new Bumblebee();
		}
		return instancia;
	}
	
	public void setEstado(int estado){
		if (estado == Personaje.ALTERNO){
			this.estado = BumblebeeAlterno.getInstance();
			return;
		}
		this.estado = BumblebeeHumanoide.getInstance();
	}
	
	public Transformable getEstado(){
		return this.estado;
	}
}
