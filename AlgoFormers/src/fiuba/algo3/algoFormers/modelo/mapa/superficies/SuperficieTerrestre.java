package fiuba.algo3.algoFormers.modelo.mapa.superficies;

import fiuba.algo3.algoFormers.modelo.efecto.Efecto;
import fiuba.algo3.algoFormers.modelo.interfaces.Atacable;

public class SuperficieTerrestre extends Superficie{

	public SuperficieTerrestre(Efecto efecto) {
		super(efecto);
	}

	@Override
	public void afectar(Atacable atacable) {
		atacable.afectarConSuperficie(this);
		
	}

}
