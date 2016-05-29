package fiuba.algo3.algoFormers.modelo.juego;

import fiuba.algo3.algoFormers.modelo.mapas.Mapa;
import fiuba.algo3.algoFormers.modelo.mapas.Posicion;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;

public class JugadorAutobots extends Jugador {

	@Override
	public void inicializarEquipo() {

		this.personajes.add(this.fabrica.getOptimusPrime());
		this.personajes.add(this.fabrica.getBumblebee());
		this.personajes.add(this.fabrica.getRatchet());

	}

	@Override
	public void ubicarPersonajes(Mapa mapa) {
		int columnaActual = mapa.getTamanio() / 2;
		int filaInicio = 1;
		
		for (AlgoFormer algoformer : this.personajes) {
            
			Posicion pos = new Posicion(filaInicio, columnaActual);
			mapa.ubicar(algoformer, pos);
            columnaActual++;
		}
		
	}

}
