package fiuba.algo3.algoFormers.modelo.mapa.superficies.terrestres;

import fiuba.algo3.algoFormers.modelo.mapa.superficies.SuperficieTerrestre;

public class Espinas extends SuperficieTerrestre {
	
	private static Espinas instancia;
	
	private Espinas(){
	}

	public static Espinas getInstance(){
		if (instancia == null){
			instancia = new Espinas();
		}
		return instancia;
	}

}
