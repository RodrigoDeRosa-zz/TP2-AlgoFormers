package fiuba.algo3.algoFormers.modelo.efecto;

import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;

public class EfectoTemporalVelocidad extends EfectoTemporal{
	
	public EfectoTemporalVelocidad(int multiplicador, int base, int turnos) {
		super(multiplicador, base, turnos);
	}

	@Override
	public void aplicarseEn(AlgoFormer algoformer) {
		algoformer.guardarEfecto(this);	
	}

}
