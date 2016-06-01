package fiuba.algo3.algoFormers.modelo.personajes.estadosDeTransformacion.tipos;

import fiuba.algo3.algoFormers.modelo.mapa.superficies.SuperficieAerea;
import fiuba.algo3.algoFormers.modelo.mapa.superficies.SuperficieTerrestre;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;

public class UnidadAerea extends TipoDeUnidad {

	@Override
	public void afectarseConSuperficie(SuperficieTerrestre superficie, AlgoFormer personaje) {
	}

	@Override
	public void afectarseConSuperficie(SuperficieAerea superficie, AlgoFormer personaje) {
		superficie.aplicarEfectoA(personaje);
	}

}
