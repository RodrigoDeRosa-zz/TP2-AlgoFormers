package fiuba.algo3.algoFormers.modelo.mapa.superficies;

import fiuba.algo3.algoFormers.modelo.interfaces.Atacable;

public class SuperficieAerea extends Superficie{

	@Override
	public void afectar(Atacable atacable) {
		atacable.afectarConSuperficie(this);
		
	}

}
