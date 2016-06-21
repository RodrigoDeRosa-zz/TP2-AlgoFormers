package fiuba.algo3.algoFormers.vista.botones.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import fiuba.algo3.algoFormers.modelo.juego.Juego;

public class HandlerBotonCombinar implements EventHandler<ActionEvent>{

	private Juego juego;
	
	public HandlerBotonCombinar(Juego juego){
		this.setJuego(juego);
	}

	private void setJuego(Juego juego){
		this.juego = juego;
	}
	
	@Override
	public void handle(ActionEvent event) {
		this.juego.combinar();
	}
	
}
