package fiuba.algo3.algoFormers.vista.eventos;

import fiuba.algo3.algoFormers.modelo.juego.Juego;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ControladorJuego {

	private Juego juego;
	
    @FXML
    private Button Mover;

    @FXML
    private Button Atacar;

    @FXML
    void FinalzarTurno(ActionEvent event) {

    }
    
	public void initData(Juego juego) {
		this.juego = juego;
		
	}

}
