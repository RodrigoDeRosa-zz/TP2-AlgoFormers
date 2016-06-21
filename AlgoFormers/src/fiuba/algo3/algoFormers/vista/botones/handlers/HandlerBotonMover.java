package fiuba.algo3.algoFormers.vista.botones.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import fiuba.algo3.algoFormers.modelo.juego.Juego;
import fiuba.algo3.algoFormers.vista.contenedores.ContenedorMoverEmergente;

public class HandlerBotonMover implements EventHandler<ActionEvent>{

	private Juego juego;
	private Scene ventanaEmergente;
	
	public HandlerBotonMover(Juego juego){
		this.setJuego(juego);
		this.setVentanaEmergente();
	}
	
	private void setJuego(Juego juego){
		this.juego = juego;
	}
	
	private void setVentanaEmergente(){
		ContenedorMoverEmergente contenedorEmergente = new ContenedorMoverEmergente(this.juego);
		this.ventanaEmergente = new Scene(contenedorEmergente);
	}
	
	@Override
	public void handle(ActionEvent event) {
		Stage stage = new Stage();
		stage.setTitle("Mover");
		stage.setScene(this.ventanaEmergente);
		stage.show();
	}

}
