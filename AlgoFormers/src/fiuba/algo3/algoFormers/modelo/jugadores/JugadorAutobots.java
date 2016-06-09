package fiuba.algo3.algoFormers.modelo.jugadores;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.algoFormers.modelo.mapa.Mapa;
import fiuba.algo3.algoFormers.modelo.mapa.Posicion;
import fiuba.algo3.algoFormers.modelo.personajes.AutoBot;

public class JugadorAutobots extends Jugador {

	private List<AutoBot> personajes;
	public JugadorAutobots() {
		
		super();
		this.personajes = new ArrayList<AutoBot>();
		inicializarEquipo();
	}
	
	@Override
	public void inicializarEquipo() {
		
		this.personajes.add(0, (AutoBot) this.fabrica.getOptimusPrime());
		this.personajes.add(1, (AutoBot) this.fabrica.getBumblebee());
		this.personajes.add(2, (AutoBot) this.fabrica.getRatchet());

	}

	@Override
	public void ubicarPersonajes(Mapa mapa) {
		int columnaActual = ( mapa.getTamanio() / 2 ) - 2;
		int filaInicio = 0;
		
		for (AutoBot algoformer : this.personajes) {
            
			Posicion pos = new Posicion(filaInicio, columnaActual);
			mapa.ubicar(algoformer, pos);
            columnaActual++;
		}

	}

	@Override
	public AutoBot getAlgoformer(String nombre) {
		for (AutoBot algoformer : this.personajes) {
            
			if (algoformer.getNombre() == nombre) {
				
				return algoformer;
			}
			
		}
		return null;
	}

}
