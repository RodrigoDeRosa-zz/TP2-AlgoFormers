package fiuba.algo3.algoFormers.modelo.mapa.superficies.terrestres;

import fiuba.algo3.algoFormers.modelo.bonus.EfectoPantano;
import fiuba.algo3.algoFormers.modelo.mapa.superficies.SuperficieTerrestre;

public class Pantano extends SuperficieTerrestre {

	private static Pantano instancia;
	private static int DISMINUCION_VELOCIDAD = 2;
	
	private Pantano(){
		this.setEfecto();
	}
	
	private void setEfecto(){
		this.efecto = new EfectoPantano(DISMINUCION_VELOCIDAD);
	}

	public static Pantano getInstance(){
		if (instancia == null){
			instancia = new Pantano();
		}
		return instancia;
	}
}
