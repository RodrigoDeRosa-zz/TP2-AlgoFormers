package fiuba.algo3.algoFormers.modelo.personajes.estadosDeTransformacion.tipos;

import fiuba.algo3.algoFormers.modelo.mapa.superficies.SuperficieTerrestre;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;

public class UnidadTerrestre extends TipoDeUnidad {

	@Override
	public void afectarseConSuperficie(SuperficieTerrestre superficie, AlgoFormer personaje) {
		superficie.aplicarEfectoA(personaje);
	}

//	@Override
//	public void afectarseConSuperficie(SuperficieAerea superficie) {
//		
//	}
	
}
