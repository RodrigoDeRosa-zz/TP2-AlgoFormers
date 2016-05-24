package algoFormers.modelo.personajes;

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
	
	protected void setEstado(){
		this.estado = BumblebeeAlterno.getInstance();
	}
	
	public void cambiarEstado(){
		this.estado.getInstanceEstadoOpuesto();
	}
	
	public Estado getEstado(){
		return this.estado;
	}
}
