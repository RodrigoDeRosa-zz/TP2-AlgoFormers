package fiuba.algo3.algoFormers.modelo.mapa.superficies;

import fiuba.algo3.algoFormers.modelo.interfaces.Atacable;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;
import fiuba.algo3.algoFormers.modelo.personajes.atributos.Atributo;

public abstract class Superficie {
	
	protected Atributo efecto;
	
	public Superficie(){
	}	

	public abstract void afectar(Atacable atacable);

	public void aplicarEfectoA(AlgoFormer algoformer){
		this.efecto.aplicarseEn(algoformer);
	}
}
