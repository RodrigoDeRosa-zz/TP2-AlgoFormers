package fiuba.algo3.algoFormers.modelo.juego;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.algoFormers.modelo.mapas.Mapa;
import fiuba.algo3.algoFormers.modelo.mapas.Posicion;
import fiuba.algo3.algoFormers.modelo.personajes.Algoformer;
import fiuba.algo3.algoFormers.modelo.personajes.AutoBot;

public class JugadorAutobots extends Jugador {

	private List<AutoBot> personajes;
	
	public JugadorAutobots() {
		
		super();
		this.personajes = new ArrayList<AutoBot>();
	}
	
	public void inicializarEquipo() {

		this.personajes.add(this.fabrica.getOptimusPrime());
		this.personajes.add(this.fabrica.getBumblebee());
		this.personajes.add(this.fabrica.getRatchet());

	}

	@Override
	public void ubicarPersonajes(Mapa mapa) {
		int columnaActual = mapa.getTamanio() / 2;
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
