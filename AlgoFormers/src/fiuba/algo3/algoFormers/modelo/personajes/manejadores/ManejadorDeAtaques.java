package fiuba.algo3.algoFormers.modelo.personajes.manejadores;

import fiuba.algo3.algoFormers.modelo.excepciones.AtaqueFueraDeRangoException;
import fiuba.algo3.algoFormers.modelo.mapas.Mapa;
import fiuba.algo3.algoFormers.modelo.mapas.Posicion;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;

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
	
	public void atacar(AlgoFormer algoformer, Posicion posicionAtacable, Mapa mapa){
		/*Funcion atacar del manejador de ataques. esta funcion le pide al mapa
		 * que ataca a una posicion. recibe el algoformer que esta atacando por parametro
		 * la posicion a la que se ataca y el mapa.
		 */
		Posicion posicionAlgoformerAtacante = mapa.obtenerPosicion(algoformer);
		this.verificarDistancia(posicionAlgoformerAtacante, posicionAtacable, this.distanciaAtaque);
		AlgoFormer algoformerAtacado = (AlgoFormer) mapa.getAtacable(posicionAtacable);
		algoformer.atacarEnemigo(algoformerAtacado, poderAtaque);
	}	
	
	private void verificarDistancia(Posicion posicionUbicable, Posicion posicionAtacable, int distanciaAtaque) {
		double distanciaFila = posicionUbicable.obtenerDistanciaFila(posicionAtacable);
		double distanciaColumna = posicionUbicable.obtenerDistanciaColumna(posicionAtacable);
		if ((distanciaFila > (double) distanciaAtaque) || (distanciaColumna > (double) distanciaAtaque)){
			throw new AtaqueFueraDeRangoException("La distacia entre ellos es mayor que posible (" + distanciaAtaque + ")");
		}
		
	}
}
