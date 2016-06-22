package fiuba.algo3.algoFormers.vista.eventos;

import fiuba.algo3.algoFormers.modelo.direcciones.DirAbajo;
import fiuba.algo3.algoFormers.modelo.direcciones.DirAbajoDer;
import fiuba.algo3.algoFormers.modelo.direcciones.DirAbajoIzq;
import fiuba.algo3.algoFormers.modelo.direcciones.DirArriba;
import fiuba.algo3.algoFormers.modelo.direcciones.DirArribaDer;
import fiuba.algo3.algoFormers.modelo.direcciones.DirArribaIzq;
import fiuba.algo3.algoFormers.modelo.direcciones.DirDerecha;
import fiuba.algo3.algoFormers.modelo.direcciones.DirIzquierda;
import fiuba.algo3.algoFormers.modelo.direcciones.Direccion;
import fiuba.algo3.algoFormers.modelo.juego.Juego;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
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

    @FXML
    void CancelarMovimiento(ActionEvent event) {
    	//A partir del evento obtengo el stage principal
    	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	stage.close();
    }

    @FXML
    void MoverAbajo(ActionEvent event) {
    	Direccion dir = new DirAbajo();
    	this.juego.mover(dir);

    }

    @FXML
    void MoverAbajoIzq(ActionEvent event) {
    	Direccion dir = new DirAbajoIzq();
    	this.juego.mover(dir);

    }

    @FXML
    void MoverAbjDer(ActionEvent event) {
    	Direccion dir = new DirAbajoDer();
    	this.juego.mover(dir);
    }

    @FXML
    void MoverArrDer(ActionEvent event) {
    	Direccion dir = new DirArribaDer();
    	this.juego.mover(dir);
    }

    @FXML
    void MoverArriba(ActionEvent event) {
    	Direccion dir = new DirArriba();
    	this.juego.mover(dir);
    }

    @FXML
    void MoverDerecha(ActionEvent event) {
    	Direccion dir = new DirDerecha();
    	this.juego.mover(dir);
    }

    @FXML
    void MoverIzqArr(ActionEvent event) {
    	Direccion dir = new DirArribaIzq();
    	this.juego.mover(dir);
    }

    @FXML
    void MoverIzquierda(ActionEvent event) {
    	Direccion dir = new DirIzquierda();
    	this.juego.mover(dir);
    }

	public void initData(Juego juego) {
		this.juego = juego;
	}

}
