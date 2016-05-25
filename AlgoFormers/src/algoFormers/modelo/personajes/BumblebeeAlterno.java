package algoFormers.modelo.personajes;

public class BumblebeeAlterno implements Estado{

	private static BumblebeeAlterno instancia = null;
	
	private BumblebeeAlterno(){
	}
	
	public static BumblebeeAlterno getInstance(){
		if (instancia == null){
			instancia = new BumblebeeAlterno();
		}
		return instancia;
	}
	
	public Estado getInstanceEstadoOpuesto(){
		return BumblebeeHumanoide.getInstance();
	}
	
}
