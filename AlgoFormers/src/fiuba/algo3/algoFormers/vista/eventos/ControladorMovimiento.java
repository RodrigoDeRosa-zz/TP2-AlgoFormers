
package fiuba.algo3.algoFormers.vista.eventos;

import java.io.IOException;

import fiuba.algo3.algoFormers.modelo.direcciones.DirAbajo;
import fiuba.algo3.algoFormers.modelo.direcciones.DirAbajoDer;
import fiuba.algo3.algoFormers.modelo.direcciones.DirAbajoIzq;
import fiuba.algo3.algoFormers.modelo.direcciones.DirArriba;
import fiuba.algo3.algoFormers.modelo.direcciones.DirArribaDer;
import fiuba.algo3.algoFormers.modelo.direcciones.DirArribaIzq;
import fiuba.algo3.algoFormers.modelo.direcciones.DirDerecha;
import fiuba.algo3.algoFormers.modelo.direcciones.DirIzquierda;
import fiuba.algo3.algoFormers.modelo.direcciones.Direccion;
import fiuba.algo3.algoFormers.modelo.excepciones.CasilleroOcupadoException;
import fiuba.algo3.algoFormers.modelo.excepciones.FueraDelMapaException;
import fiuba.algo3.algoFormers.modelo.juego.Juego;
import fiuba.algo3.algoFormers.vista.contenedores.ContenedorTablero;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ControladorMovimiento {

    @FXML
    private Button BotonArriba;

    @FXML
    private Button BotonAbajo;

    @FXML
    private Button BotonIzqArr;

    @FXML
    private Button BotonArrDer;

    @FXML
    private Button BotonIzquierda;

    @FXML
    private Button BotonDerecha;

    @FXML
    private Button BotonAbajoIzq;

    @FXML
    private Button BotonAbjDer;

    @FXML
    private Button BotonCancelarMovimiento;

	private Juego juego;
	private ControladorJuego controlador;
	private ContenedorTablero tablero;

    @FXML
    void CancelarMovimiento(ActionEvent event) {
    	//A partir del evento obtengo el stage principal
    	this.cerrarStage(event);
    }
    
    private void mostrarError(String mensaje) throws IOException{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("ContenedorError.fxml"));
    	VBox contenedorError = (VBox) loader.load();
    	ControladorError controlador = loader.<ControladorError>getController();
    	controlador.initData(mensaje);
    	Stage stage = new Stage();
		stage.setTitle("Error");
    	stage.setScene(new Scene(contenedorError));
    	stage.show();
    }

    @FXML
    void MoverAbajo(ActionEvent event) throws IOException{
    	Direccion dir = new DirAbajo();
    	this.mover(dir, event);
    }

    private void mover(Direccion direccion, ActionEvent event) throws IOException{
    	try{
    		this.juego.mover(direccion);
    	}catch(FueraDelMapaException | CasilleroOcupadoException e){
    		this.mostrarError(e.getMessage());
    	} 
    	this.redibujarTablero();
    	this.controlador.accionado();
    }
    
    @FXML
    void MoverAbajoIzq(ActionEvent event) throws IOException{
    	Direccion dir = new DirAbajoIzq();
    	this.mover(dir, event);
    }

    @FXML
    void MoverAbjDer(ActionEvent event) throws IOException{
    	Direccion dir = new DirAbajoDer();
    	this.mover(dir, event);
    }

    @FXML
    void MoverArrDer(ActionEvent event) throws IOException{
    	Direccion dir = new DirArribaDer();
    	this.mover(dir, event);
    }

    @FXML
    void MoverArriba(ActionEvent event) throws IOException{
    	Direccion dir = new DirArriba();
    	this.mover(dir, event);
    }

    @FXML
    void MoverDerecha(ActionEvent event) throws IOException{
    	Direccion dir = new DirDerecha();
    	this.mover(dir, event);
    }

    @FXML
    void MoverIzqArr(ActionEvent event) throws IOException{
    	Direccion dir = new DirArribaIzq();
    	this.mover(dir, event);
    }

    @FXML
    void MoverIzquierda(ActionEvent event) throws IOException{
    	Direccion dir = new DirIzquierda();
    	this.mover(dir, event);
    }
    
    private void cerrarStage(ActionEvent event){
    	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	stage.close();
    }
    
    private void redibujarTablero(){
    	this.tablero.armarTablero(this.juego);
    }
    
	public void initData(Juego juego, ContenedorTablero tablero, ControladorJuego controlador) {
		this.tablero = tablero;
		this.juego = juego;
		this.controlador = controlador;
	}

}