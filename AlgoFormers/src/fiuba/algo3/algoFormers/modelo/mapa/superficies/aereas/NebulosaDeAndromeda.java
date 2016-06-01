package fiuba.algo3.algoFormers.modelo.mapa.superficies.aereas;

import fiuba.algo3.algoFormers.modelo.mapa.superficies.SuperficieAerea;

public class NebulosaDeAndromeda extends SuperficieAerea {
	
	private static NebulosaDeAndromeda instancia;
	
	private NebulosaDeAndromeda(){
	}

	public static NebulosaDeAndromeda getInstance(){
		if (instancia == null){
			instancia = new NebulosaDeAndromeda();
		}
		return instancia;
	}
}
