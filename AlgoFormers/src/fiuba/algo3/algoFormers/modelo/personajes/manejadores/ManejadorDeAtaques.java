package fiuba.algo3.algoFormers.modelo.personajes.manejadores;

import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;
import fiuba.algo3.algoFormers.modelo.personajes.Mapa;
import fiuba.algo3.algoFormers.modelo.personajes.Posicion;
import fiuba.algo3.algoFormers.modelo.personajes.atributos.Ataque;

public class ManejadorDeAtaques {
	
	
	public ManejadorDeAtaques(){
	}
	
	public void atacar(AlgoFormer algoformer, Posicion posicion, Mapa mapa){
		mapa.atacarPosicion(algoformer, posicion);
	}
}
