package fiuba.algo3.algoFormers.modelo.personajes.estadosDeTransformacion.tipos;

import fiuba.algo3.algoFormers.modelo.mapa.superficies.SuperficieAerea;
import fiuba.algo3.algoFormers.modelo.mapa.superficies.SuperficieTerrestre;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;

public abstract class TipoDeUnidad {

	public TipoDeUnidad(){
		
	}
	
	public abstract void afectarseConSuperficie(SuperficieTerrestre superficie, AlgoFormer personaje);
	public abstract void afectarseConSuperficie(SuperficieAerea superficie, AlgoFormer personaje);
}