package fiuba.algo3.algoFormers.vista.eventos;

import fiuba.algo3.algoFormers.vista.Aplicacion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ControladorBienvenida {

	private Aplicacion aplicacion;
	
    @FXML
    private TextField NombreAutobot;

    @FXML
    private TextField NombreDecepticon;

    @FXML
    private void ComenzarJuego(ActionEvent event) throws Exception {
    	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	BorderPane contenedorJuego = (BorderPane) FXMLLoader.load(getClass().getResource("ContenedorJuego.fxml"));
		stage.setScene(new Scene(contenedorJuego));
		stage.show();
    }
    
    

}
