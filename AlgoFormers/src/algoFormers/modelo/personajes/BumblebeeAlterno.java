package algoFormers.modelo.personajes;

public class BumblebeeAlterno implements Estado{

	private static BumblebeeAlterno instancia = null;
	private BumblebeeHumanoide estadoOpuesto;
	
	private BumblebeeAlterno(){
	}
	
	public static BumblebeeAlterno getInstance(){
		if (instancia == null){
			instancia = new BumblebeeAlterno();
		}
		return instancia;
	}
	
	public Estado getInstanceEstadoOpuesto(){
		return this.estadoOpuesto.getInstance();
	}
	
}
