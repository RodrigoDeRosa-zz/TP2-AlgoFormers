package fiuba.algo3.algoFormers.modelo.juego;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.algoFormers.modelo.mapas.Mapa;
import fiuba.algo3.algoFormers.modelo.mapas.Posicion;
import fiuba.algo3.algoFormers.modelo.personajes.Algoformer;
import fiuba.algo3.algoFormers.modelo.personajes.Autobot;

public class JugadorAutobots extends Jugador {

	private List<Autobot> personajes;
	
	public JugadorAutobots() {
		
		super();
		this.personajes = new ArrayList<Autobot>();
	}
	
	public void inicializarEquipo() {

		this.personajes.add(0, this.fabrica.getOptimusPrime());
		this.personajes.add(1, this.fabrica.getBumblebee());
		this.personajes.add(2, this.fabrica.getRatchet());

	}

	@Override
	public void ubicarPersonajes(Mapa mapa) {
		int columnaActual = ( mapa.getTamanio() / 2 ) - 1;
		int filaInicio = 1;
		
		for (Algoformer algoformer : this.personajes) {
            
			Posicion pos = new Posicion(filaInicio, columnaActual);
			mapa.ubicar(algoformer, pos);
            columnaActual++;
		}
		
	}

	@Override
	public Algoformer getAlgoformer(String nombre) {

		for (Algoformer algoformer : this.personajes) {
            
			if (algoformer.getNombre() == nombre) {
				
				return algoformer;
			}
			
		}
		return null;		
	}
	
	

}
