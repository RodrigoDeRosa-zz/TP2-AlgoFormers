package fiuba.algo3.algoFormers.modelo.efecto;

import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;

public class EfectoEstaticoVida extends EfectoEstatico{
	
	public EfectoEstaticoVida(int multiplicador, int base) {
		super(multiplicador, base);
	}

	@Override
	public void aplicarseEn(AlgoFormer algoformer) {
		algoformer.guardarEfecto(this);
	}

}
