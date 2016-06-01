package fiuba.algo3.algoFormers.modelo.mapa.superficies.terrestres;

import fiuba.algo3.algoFormers.modelo.mapa.superficies.SuperficieTerrestre;

public class Pantano extends SuperficieTerrestre {

	private static Pantano instancia;
	
	private Pantano(){
	}

	public static Pantano getInstance(){
		if (instancia == null){
			instancia = new Pantano();
		}
		return instancia;
	}
}
