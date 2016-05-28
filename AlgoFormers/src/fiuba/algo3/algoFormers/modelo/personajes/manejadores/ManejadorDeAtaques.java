package fiuba.algo3.algoFormers.modelo.personajes.manejadores;

import fiuba.algo3.algoFormers.modelo.mapas.Mapa;
import fiuba.algo3.algoFormers.modelo.mapas.Posicion;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;
import fiuba.algo3.algoFormers.modelo.personajes.atributos.Ataque;

public class ManejadorDeAtaques {
	
	private int poderAtaque;
	private int distanciaAtaque;
	
	public ManejadorDeAtaques(int poder, int distancia){
		/*constructor del manejador de ataques. Este contiene la distancia de 
		 * ataque del algoformer en su modo actual y el poder de ataque*/
		
		this.setPoder(poder);
		this.setDistancia(distancia);
	}
	
	private void setPoder(int poder){
		this.poderAtaque = poder;
	}
	
	private void setDistancia(int distancia){
		this.distanciaAtaque = distancia;
	}
	
	public void atacar(AlgoFormer algoformer, Posicion posicion, Mapa mapa){
		/*Funcion atacar del manejador de ataques. esta funcion le pide al mapa
		 * que ataca a una posicion. recibe el algoformer que esta atacando por parametro
		 * la posicion a la que se ataca y el mapa.
		 */
		mapa.atacarPosicion(algoformer, this.poderAtaque, this.distanciaAtaque, posicion);
	}
}
