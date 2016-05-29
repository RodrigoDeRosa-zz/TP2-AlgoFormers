package fiuba.algo3.algoFormers.modelo.juego;

import fiuba.algo3.algoFormers.modelo.mapas.Mapa;
import fiuba.algo3.algoFormers.modelo.mapas.Posicion;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;

public class JugadorDecepticons extends Jugador {

	@Override
	public void inicializarEquipo() {
		this.personajes.add(this.fabrica.getMegatron());
		this.personajes.add(this.fabrica.getBonecrusher());
		this.personajes.add(this.fabrica.getFrenzy());

	}

	@Override
	public void ubicarPersonajes(Mapa mapa) {
		int columnaActual = mapa.getTamanio() / 2;
		int filaInicio = mapa.getTamanio();
		
		for (AlgoFormer algoformer : this.personajes) {
			Posicion pos = new Posicion(filaInicio, columnaActual);
			mapa.ubicar(algoformer, pos);
            columnaActual++;
		}

	}

}
