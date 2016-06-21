package fiuba.algo3.algoFormers.vista.botones.personajes;

import javafx.event.ActionEvent;
import fiuba.algo3.algoFormers.modelo.juego.Juego;
import fiuba.algo3.algoFormers.vista.botones.BotonImagen;
import fiuba.algo3.algoFormers.vista.botones.handlers.HandlerBotonPersonaje;

public class BotonPersonaje extends BotonImagen{

	public BotonPersonaje(Juego juego, String urlImagen, int ancho, int alto) {
		super(urlImagen, ancho, alto);
		this.setHandler(juego);
	}
	
	private void setHandler(Juego juego){
		HandlerBotonPersonaje handler = new HandlerBotonPersonaje(juego, this);
		this.setEventHandler(ActionEvent.ACTION, handler);
	}

}
