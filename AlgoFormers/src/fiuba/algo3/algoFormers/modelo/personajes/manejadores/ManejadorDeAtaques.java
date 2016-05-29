package fiuba.algo3.algoFormers.modelo.personajes.manejadores;

import fiuba.algo3.algoFormers.modelo.excepciones.AtaqueEspacioVacioException;
import fiuba.algo3.algoFormers.modelo.excepciones.AtaqueFueraDeRangoException;
import fiuba.algo3.algoFormers.modelo.excepciones.AtaqueInvalidoException;
import fiuba.algo3.algoFormers.modelo.excepciones.FuegoAmigoException;
import fiuba.algo3.algoFormers.modelo.excepciones.NoEsAtacableException;
import fiuba.algo3.algoFormers.modelo.interfaces.Atacable;
import fiuba.algo3.algoFormers.modelo.interfaces.Ubicable;
import fiuba.algo3.algoFormers.modelo.mapas.Mapa;
import fiuba.algo3.algoFormers.modelo.mapas.Posicion;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;
import fiuba.algo3.algoFormers.modelo.personajes.atributos.Ataque;

public class ManejadorDeAtaques {
	
	private AlgoFormer atacante;
	private Atacable destino;
	private int distanciaPretendida;
	

	
	// private Ubicable atacado;
	// private int distanciaPretendida;
	
	public ManejadorDeAtaques(Mapa mapa, AlgoFormer algoformer, Posicion posicion){
		/*constructor del manejador de ataques. Este contiene la distancia de 
		 * ataque del algoformer en su modo actual y el poder de ataque*/
		
		distanciaPretendida = calcularDistancia(algoformer.getPosicion(), posicion);
		
		atacante = algoformer;
		destino = mapa.getAtacable(posicion);

		
		
	}
		
	public void realizarAtaque() throws AtaqueFueraDeRangoException, AtaqueInvalidoException, FuegoAmigoException{
		/*Funcion atacar del manejador de ataques. esta funcion le pide al mapa
		 * que ataca a una posicion. recibe el algoformer que esta atacando por parametro
		 * la posicion a la que se ataca y el mapa.
		 */
		if ( distanciaPretendida > atacante.getDistanciaDeAtaque()) {
			
			throw new AtaqueFueraDeRangoException();
		}
		
		if ( destino == null ) {
			
			throw new AtaqueInvalidoException();
		}
		
		try {
			
			destino.recibirDanio(atacante);
			
		}
		
			
		catch (FuegoAmigoException e) {
			
			throw e;
		}
				
		
	}
	
	private int abs(int a) {
		
		if (a >= 0) {
			return a;
		}
		return -a;
	}
	
	private int max(int a, int b) {
		
		if (a >= b) {
			
			return a;
		}
		return b;
	}
	
	private int calcularDistancia(Posicion PosUno, Posicion PosDos) {
		
		return max(abs(PosUno.getX() - PosDos.getX()), abs(PosUno.getY() - PosDos.getY()));
	}
}
