package fiuba.algo3.algoFormers.modelo.mapa.superficies;

import fiuba.algo3.algoFormers.modelo.efecto.Efecto;
import fiuba.algo3.algoFormers.modelo.interfaces.Atacable;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;

public abstract class Superficie {
	
	protected Efecto efecto;
	
	public Superficie(){
	}	

	public abstract void afectar(Atacable atacable);

	public void aplicarEfecto(AlgoFormer algoformer){
		this.efecto.aplicarseEn(algoformer);
	}
	
	
}
