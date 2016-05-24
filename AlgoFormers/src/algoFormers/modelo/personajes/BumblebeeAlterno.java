package algoFormers.modelo.personajes;

public class BumblebeeAlterno implements Alterno{

	private static BumblebeeAlterno instancia = null;
	
	private BumblebeeAlterno(){
		
	}
	
	public static BumblebeeAlterno getInstance(){
		if (instancia == null){
			instancia = new BumblebeeAlterno();
		}
		return instancia;
	}
	
}
