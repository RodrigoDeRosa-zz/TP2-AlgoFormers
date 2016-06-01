package fiuba.algo3.algoFormers.modelo.mapa.superficies;

import fiuba.algo3.algoFormers.modelo.interfaces.Atacable;

public class SuperficieAerea extends Superficie {

	public SuperficieAerea(){
		super();
	}
	
	@Override
	public void afectar(Atacable atacable) {
		atacable.afectarseConSuperficie(this);
	}

}
