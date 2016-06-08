package fiuba.algo3.algoFormers.modelo.efecto;

import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;

public class EfectoTemporalVida extends EfectoTemporal{
	
	public EfectoTemporalVida(int multiplicador, int base, int turnos) {
		super(multiplicador, base, turnos);
	}

	@Override
	public void aplicarseEn(AlgoFormer algoformer) {
		algoformer.guardarEfecto(this);	
	}

}
