package fiuba.algo3.algoFormers.modelo.juego;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.algoFormers.modelo.mapas.Mapa;
import fiuba.algo3.algoFormers.modelo.mapas.Posicion;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;
import fiuba.algo3.algoFormers.modelo.personajes.AutoBot;
import fiuba.algo3.algoFormers.modelo.personajes.Decepticon;

public class JugadorDecepticons extends Jugador {

	private List<Decepticon> personajes;
	
	public JugadorDecepticons() {
		
		super();
		this.personajes = new ArrayList<Decepticon>();
	}
	
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
