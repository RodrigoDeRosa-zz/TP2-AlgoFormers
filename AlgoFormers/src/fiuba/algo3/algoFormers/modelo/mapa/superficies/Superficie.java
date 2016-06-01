package fiuba.algo3.algoFormers.modelo.mapa.superficies;

import fiuba.algo3.algoFormers.modelo.interfaces.Atacable;

public abstract class Superficie {
	
	public Superficie(){
	}	

	public abstract void afectar(Atacable atacable);

	public abstract void aplicarEfectoA(AlgoFormer algoformer){
		this.efecto.aplicarA(algoformer);
	}
}
