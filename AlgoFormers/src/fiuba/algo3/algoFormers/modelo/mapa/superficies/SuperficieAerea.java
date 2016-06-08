package fiuba.algo3.algoFormers.modelo.mapa.superficies;

import fiuba.algo3.algoFormers.modelo.efecto.Efecto;
import fiuba.algo3.algoFormers.modelo.interfaces.Atacable;

public class SuperficieAerea extends Superficie{
	
	public SuperficieAerea(Efecto efecto) {
		super(efecto);
	}

	@Override
	public void afectar(Atacable atacable) {
		atacable.afectarConSuperficie(this);
		
	}

}
