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
	
	public void lala(){
		//lalalong
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
