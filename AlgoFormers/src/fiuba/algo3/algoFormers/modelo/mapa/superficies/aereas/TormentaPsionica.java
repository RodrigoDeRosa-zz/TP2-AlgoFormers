package fiuba.algo3.algoFormers.modelo.mapa.superficies.aereas;

import fiuba.algo3.algoFormers.modelo.mapa.superficies.SuperficieAerea;

public class TormentaPsionica extends SuperficieAerea {
	
	private static TormentaPsionica instancia;
	
	private TormentaPsionica(){
	}

	public static TormentaPsionica getInstance(){
		if (instancia == null){
			instancia = new TormentaPsionica();
		}
		return instancia;
	}

}
