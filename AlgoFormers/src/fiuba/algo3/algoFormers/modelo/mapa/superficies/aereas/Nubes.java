package fiuba.algo3.algoFormers.modelo.mapa.superficies.aereas;

import fiuba.algo3.algoFormers.modelo.mapa.superficies.SuperficieAerea;

public class Nubes extends SuperficieAerea {

	private static Nubes instancia;
	
	private Nubes(){
	}

	public static Nubes getInstance(){
		if (instancia == null){
			instancia = new Nubes();
		}
		return instancia;
	}
}
