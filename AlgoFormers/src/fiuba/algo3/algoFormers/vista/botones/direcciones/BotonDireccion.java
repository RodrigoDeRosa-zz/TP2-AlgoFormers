package fiuba.algo3.algoFormers.vista.botones.direcciones;

import javafx.event.ActionEvent;
import fiuba.algo3.algoFormers.modelo.juego.Juego;
import fiuba.algo3.algoFormers.modelo.direcciones.Direccion;
import fiuba.algo3.algoFormers.vista.botones.BotonImagen;
import fiuba.algo3.algoFormers.vista.botones.handlers.HandlerBotonDireccion;

public class BotonDireccion extends BotonImagen {

	protected Juego juego;
	protected Direccion direccion;
	
	public BotonDireccion(Juego juego, Direccion direccion, String urlImagen){
		super(urlImagen, 50, 50);
		this.setJuego(juego);
		this.setDireccion(direccion);
		this.setHandler();
	}
	
	private void setJuego(Juego juego){
		this.juego = juego;
	}
	
	private void setDireccion(Direccion direccion){
		this.direccion = direccion;
	}
	
	private void setHandler(){
		HandlerBotonDireccion handler = new HandlerBotonDireccion(this.juego, this.direccion, this);
		this.setEventHandler(ActionEvent.ACTION, handler);
	}
	
}
