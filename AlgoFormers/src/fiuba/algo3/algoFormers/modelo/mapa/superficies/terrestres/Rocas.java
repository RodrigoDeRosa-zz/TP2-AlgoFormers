package fiuba.algo3.algoFormers.modelo.mapa.superficies.terrestres;

import fiuba.algo3.algoFormers.modelo.mapa.superficies.SuperficieTerrestre;

public class Rocas extends SuperficieTerrestre{

	private static Rocas instancia;
	
	private Rocas(){
	}
	
	public static Rocas getInstance(){
		if (instancia == null){
			instancia = new Rocas();
		}
		return instancia;
	}
}
