package fiuba.algo3.algoFormers.modelo.jugadores;

import fiuba.algo3.algoFormers.modelo.excepciones.SeleccionPersonajeEnemigoException;
import fiuba.algo3.algoFormers.modelo.mapa.Mapa;
import fiuba.algo3.algoFormers.modelo.personajes.AutoBot;
import fiuba.algo3.algoFormers.modelo.personajes.Decepticon;

public class JugadorDecepticons extends Jugador {

	private static int FILA_INICIO = 39;
	
	public JugadorDecepticons() {
		super();
		inicializarEquipo();
	}
	
	@Override
	public void inicializarEquipo() {
		this.equipo.agregarIntegrante(this.fabrica.getMegatron());
		this.equipo.agregarIntegrante(this.fabrica.getBonecrusher());
		this.equipo.agregarIntegrante(this.fabrica.getFrenzy());
	}

	@Override
	public void ubicarPersonajes(Mapa mapa) {
		this.equipo.ubicarPersonajes(mapa, FILA_INICIO);
	}

	@Override
	public Decepticon getAlgoformer(String nombre) {
		Decepticon personaje = (Decepticon) this.equipo.getAlgoFormer(nombre);
		return personaje;
	}

	@Override
	public void setPersonajeActual(AutoBot personaje) {
		throw new SeleccionPersonajeEnemigoException();
	}

	@Override
	public void setPersonajeActual(Decepticon personaje) {
		this.equipo.setPersonajeActual(personaje);
	}
	
}