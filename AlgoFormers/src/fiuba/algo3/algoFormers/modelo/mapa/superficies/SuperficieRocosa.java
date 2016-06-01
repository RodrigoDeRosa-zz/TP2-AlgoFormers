package fiuba.algo3.algoFormers.modelo.mapa.superficies;

import fiuba.algo3.algoFormers.modelo.interfaces.Atacable;;

public class SuperficieRocosa extends SuperficieTerrestre{

	private static SuperficieRocosa instancia;
	
	private SuperficieRocosa(){
	}
	
	public static SuperficieRocosa getInstance(){
		if (instancia == null){
			instancia = new SuperficieRocosa();
		}
		return instancia;
	}

	@Override
	public void afectar(Atacable atacable) {		
	}
}
