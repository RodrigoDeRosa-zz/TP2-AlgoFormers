package fiuba.algo3.algoFormers.vista.eventos;

import fiuba.algo3.algoFormers.modelo.juego.Juego;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ToggleButton;

public class ControladorJuego {

    @FXML
    private MenuBar BarraMenu;

    @FXML
    private Button BotonFinalizarTurno;

    @FXML
    private Button BotonCombinar;

    @FXML
    private Button BotonTransformar;

    @FXML
    private Button BotonAtacar;

    @FXML
    private Button BotonMover;

    @FXML
    private ToggleButton Personaje2;

    @FXML
    private ToggleButton Personaje3;

    @FXML
    private ToggleButton Personaje1;

	private Juego juego;

    @FXML
    void Atacar(ActionEvent event) {
    	
    }

    @FXML
    void Combinar(ActionEvent event) {
    	this.juego.combinar();
    }

    @FXML
    void FinalzarTurno(ActionEvent event) {
    	this.juego.finalizarTurno();
    }

    @FXML
    void Mover(ActionEvent event) {

    }

    @FXML
    void SeleccionarPersonajeActual1(ActionEvent event) {

    }

    @FXML
    void SeleccionarPersonajeActual2(ActionEvent event) {

    }

    @FXML
    void SeleccionarPersonajeActual3(ActionEvent event) {

    }

    @FXML
    void Transformar(ActionEvent event) {
    	this.juego.transformar();
    }

	public void initData(Juego juego) {
		this.juego = juego;
		
	}

}
