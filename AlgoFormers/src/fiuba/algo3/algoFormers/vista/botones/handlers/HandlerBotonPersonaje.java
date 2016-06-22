package fiuba.algo3.algoFormers.vista.botones.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import fiuba.algo3.algoFormers.modelo.juego.Juego;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;

public class HandlerBotonPersonaje implements EventHandler<ActionEvent>{

	private Juego juego;
	private Button boton;
	private AlgoFormer algoformer;
	
	public HandlerBotonPersonaje(Juego juego, Button boton, AlgoFormer algo){
		this.setJuego(juego);
		this.setBoton(boton);
		this.setAlgoFormer(algo);
	}
	
	private void setAlgoFormer(AlgoFormer algo){
		this.algoformer = algo;
	}
	private void setJuego(Juego juego){
		this.juego = juego;
	}

	private void setBoton(Button boton){
		this.boton = boton;
	}
	
	@Override
	public void handle(ActionEvent event) {
//		this.juego.atacar();
//		Stage stage = (Stage) this.boton.getScene().getWindow();
//		stage.close();
		
		this.juego.setPersonajeActual(this.algoformer);
	}
	
	
}
