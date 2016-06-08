package fiuba.algo3.algoFormers.modelo.efecto;

import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;

public class EfectoEstaticoVelocidad extends EfectoEstatico{
	
	public EfectoEstaticoVelocidad(int multiplicador, int base) {
		super(multiplicador, base);
	}

	@Override
	public void aplicarseEn(AlgoFormer algoformer) {
		algoformer.guardarEfecto(this);
	}

}
