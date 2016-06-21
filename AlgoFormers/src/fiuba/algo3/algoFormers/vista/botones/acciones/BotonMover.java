package fiuba.algo3.algoFormers.vista.botones.acciones;

import javafx.event.ActionEvent;
import fiuba.algo3.algoFormers.modelo.juego.Juego;
import fiuba.algo3.algoFormers.vista.botones.BotonImagen;
import fiuba.algo3.algoFormers.vista.botones.handlers.HandlerBotonMover;

public class BotonMover extends BotonImagen {
	
	private Juego juego;
	
	public BotonMover(Juego juego){
		super("/home/rodrigo/git/PruebasJavaFX/Botones/Mover.png", 150, 54);
		this.setJuego(juego);
		this.setHandler();
	}
	
	private void setJuego(Juego juego){
		this.juego = juego;
	}
	
	private void setHandler(){
		HandlerBotonMover handler = new HandlerBotonMover(this.juego);
		this.setEventHandler(ActionEvent.ACTION, handler);
	}

}
