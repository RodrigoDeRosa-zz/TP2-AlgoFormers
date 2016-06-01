package fiuba.algo3.algoFormers.modelo.jugadores;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.algoFormers.modelo.mapa.Mapa;
import fiuba.algo3.algoFormers.modelo.mapa.Posicion;
import fiuba.algo3.algoFormers.modelo.personajes.Decepticon;

public class JugadorDecepticons extends Jugador {

	private List<Decepticon> personajes;
	public JugadorDecepticons() {
		
		super();
		this.personajes = new ArrayList<Decepticon>();
		inicializarEquipo();
	}
	
	@Override
	public void inicializarEquipo() {
		
		this.personajes.add(0, (Decepticon) this.fabrica.getMegatron());
		this.personajes.add(1, (Decepticon) this.fabrica.getBonecrusher());
		this.personajes.add(2, (Decepticon) this.fabrica.getFrenzy());

	}

	@Override
	public void ubicarPersonajes(Mapa mapa) {
		int columnaActual = ( mapa.getTamanio() / 2 ) - 2;
		int filaInicio = 39;
		
		for (Decepticon algoformer : this.personajes) {
            
			Posicion pos = new Posicion(filaInicio, columnaActual);
			mapa.ubicarAtacable(algoformer, pos);
            columnaActual++;
		}

	}

	@Override
	public Decepticon getAlgoformer(String nombre) {
		for (Decepticon algoformer : this.personajes) {
            
			if (algoformer.getNombre() == nombre) {
				
				return algoformer;
			}
			
		}
		return null;
	}

}