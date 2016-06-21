package fiuba.algo3.algoFormers.vista.botones.acciones;

import javafx.event.ActionEvent;
import fiuba.algo3.algoFormers.modelo.juego.Juego;
import fiuba.algo3.algoFormers.vista.botones.BotonImagen;
import fiuba.algo3.algoFormers.vista.botones.handlers.HandlerBotonFinalizarTurno;

public class BotonFinalizarTurno extends BotonImagen {

	private Juego juego;
	
	public BotonFinalizarTurno(Juego juego){
		super("/home/rodrigo/git/PruebasJavaFX/Botones/FinalizarTurno.png", 184, 108);
		this.setJuego(juego);
		this.setHandler();
	}

	private void setJuego(Juego juego) {
		this.juego = juego;	
	}
	
	private void setHandler(){
		HandlerBotonFinalizarTurno handler = new HandlerBotonFinalizarTurno(this.juego);
		this.setEventHandler(ActionEvent.ACTION, handler);
	}
	
}
