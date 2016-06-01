package fiuba.algo3.algoFormers.modelo.mapa.superficies;

import fiuba.algo3.algoFormers.modelo.interfaces.Atacable;

public class SuperficiePantano extends SuperficieTerrestre {

	private static SuperficiePantano instancia;
	
	private SuperficiePantano(){
	}

	public static SuperficiePantano getInstance(){
		if (instancia == null){
			instancia = new SuperficiePantano();
		}
		return instancia;
	}
	
	@Override
	public void afectar(Atacable atacable) {
		atacable.afectarseConSuperficie(this);
	}

}
