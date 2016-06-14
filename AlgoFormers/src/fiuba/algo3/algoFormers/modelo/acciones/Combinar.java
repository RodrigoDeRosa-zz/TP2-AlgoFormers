package fiuba.algo3.algoFormers.modelo.acciones;

import fiuba.algo3.algoFormers.modelo.interfaces.Accion;
import fiuba.algo3.algoFormers.modelo.jugadores.Jugador;

public class Combinar implements Accion {

	private Jugador jugador;
	
	public Combinar(Jugador jugador){
		this.setJugador(jugador);
	}
	
	private void setJugador(Jugador jugador){
		this.jugador = jugador;
	}
	
	@Override
	public void ejecutar() {
//		this.jugador.combinar();
	}

}
