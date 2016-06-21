package fiuba.algo3.algoFormers.vista.botones.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import fiuba.algo3.algoFormers.modelo.juego.Juego;
import fiuba.algo3.algoFormers.modelo.direcciones.Direccion;

public class HandlerBotonDireccion implements EventHandler<ActionEvent>{
	
	private Juego juego;
	private Button boton;
	private Direccion direccion;
	
	public HandlerBotonDireccion(Juego juego, Direccion direccion, Button boton){
		this.setJuego(juego);
		this.setBoton(boton);
		this.setDireccion(direccion);
	}
	
	private void setJuego(Juego juego){
		this.juego = juego;
	}

	private void setBoton(Button boton){
		this.boton = boton;
	}
	
	private void setDireccion(Direccion direccion){
		this.direccion = direccion;
	}

	@Override
	public void handle(ActionEvent event) {
		this.juego.mover(this.direccion);	
		Stage stage = (Stage) this.boton.getScene().getWindow();
		stage.close();
	}

}
