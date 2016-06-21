package fiuba.algo3.algoFormers.vista.botones;

import javafx.event.ActionEvent;
import fiuba.algo3.algoFormers.vista.botones.handlers.HandlerBotonCancelar;

public class BotonCancelar extends BotonImagen {

	public BotonCancelar(){
		super("/home/rodrigo/git/PruebasJavaFX/Botones/Cancelar.png", 150, 54);
		this.setHandler();
	}
	
	private void setHandler(){
		HandlerBotonCancelar handler = new HandlerBotonCancelar(this);
		this.setEventHandler(ActionEvent.ACTION, handler);
	}
	
}
