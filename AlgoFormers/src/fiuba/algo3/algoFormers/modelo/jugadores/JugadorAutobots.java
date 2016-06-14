package fiuba.algo3.algoFormers.modelo.jugadores;

import fiuba.algo3.algoFormers.modelo.excepciones.SeleccionPersonajeEnemigoException;
import fiuba.algo3.algoFormers.modelo.mapa.Mapa;
import fiuba.algo3.algoFormers.modelo.personajes.AutoBot;
import fiuba.algo3.algoFormers.modelo.personajes.Decepticon;

public class JugadorAutobots extends Jugador {

	private static int FILA_INICIO = 0;
	
	public JugadorAutobots() {
		super();
		inicializarEquipo();
	}
	
	@Override
	public void inicializarEquipo() {
		this.equipo.agregarIntegrante(this.fabrica.getOptimusPrime());
		this.equipo.agregarIntegrante(this.fabrica.getBumblebee());
		this.equipo.agregarIntegrante(this.fabrica.getRatchet());
	}

	@Override
	public void ubicarPersonajes(Mapa mapa) {
		this.equipo.ubicarPersonajes(mapa, FILA_INICIO);
	}

	@Override
	public AutoBot getAlgoformer(String nombre) {
		AutoBot personaje = (AutoBot) this.equipo.getAlgoFormer(nombre);
		return personaje;
	}
	
	@Override
	public void setPersonajeActual(AutoBot personaje) {
		this.equipo.setPersonajeActual(personaje);
	}

	@Override
	public void setPersonajeActual(Decepticon personaje) {
		throw new SeleccionPersonajeEnemigoException();
	}

}
