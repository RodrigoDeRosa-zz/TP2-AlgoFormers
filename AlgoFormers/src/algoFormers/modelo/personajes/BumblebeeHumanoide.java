package algoFormers.modelo.personajes;

public class BumblebeeHumanoide implements Estado{

	private static BumblebeeHumanoide instancia = null;
	private BumblebeeAlterno estadoOpuesto;
	
	private BumblebeeHumanoide(){
		this.estadoOpuesto = BumblebeeAlterno.getInstance();
	}
	
	public static BumblebeeHumanoide getInstance(){
		if (instancia == null){
			instancia = new BumblebeeHumanoide();
		}
		return instancia;
	}
	
	public Estado getInstanceEstadoOpuesto(){
		return this.estadoOpuesto;
	}
}
