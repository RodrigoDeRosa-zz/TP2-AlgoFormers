package fiuba.algo3.algoFormers.modelo.efecto;

import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;

public abstract class Efecto {
	
	protected int multiplicador;
	protected int base;
	public abstract void aplicarseEn(AlgoFormer algoformer);
	
	public Efecto(int multiplicador, int base){
		this.multiplicador = multiplicador;
		this.base = base;
	}
	
}
