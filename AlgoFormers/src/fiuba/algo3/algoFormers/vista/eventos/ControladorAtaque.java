package fiuba.algo3.algoFormers.vista.eventos;

import fiuba.algo3.algoFormers.modelo.juego.Juego;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ControladorAtaque {

    @FXML
    private ImageView ImagenEnemigo1;

    @FXML
    private RadioButton SeleccionEnemigo1;

    @FXML
    private RadioButton SeleccionEnemigo2;

    @FXML
    private RadioButton SeleccionEnemigo3;

    @FXML
    private ImageView ImagenEnemigo2;

    @FXML
    private ImageView ImagenEnemigo3;

    @FXML
    private Label CartelMensaje;

    @FXML
    private Button BotonCancelar;

    @FXML
    private Button BotonAtacar;

	private Juego juego;

    @FXML
    void Atacar(ActionEvent event) {

    }

    @FXML
    void CancelarAtaque(ActionEvent event) {
    	//A partir del evento obtengo el stage principal
    	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	stage.close();
    }

    @FXML
    void SeleccionarEnemigo1(ActionEvent event) {

    }

    @FXML
    void SeleccionarEnemigo2(ActionEvent event) {

    }

    @FXML
    void SeleccionarEnemigo3(ActionEvent event) {

    }
    
	public void initData(Juego juego) {
		this.juego = juego;
		
	}
}
