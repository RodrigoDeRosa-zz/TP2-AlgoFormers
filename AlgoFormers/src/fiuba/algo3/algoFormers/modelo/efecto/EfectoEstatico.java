package fiuba.algo3.algoFormers.modelo.efecto;

import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;

public abstract class EfectoEstatico extends Efecto{

	public EfectoEstatico(int multiplicador, int base){
		super(multiplicador,base);
	}

	public abstract void aplicarseEn(AlgoFormer algoformer);
}
