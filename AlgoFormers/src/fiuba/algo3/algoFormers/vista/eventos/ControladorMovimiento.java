
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
import fiuba.algo3.algoFormers.modelo.excepciones.FueraDelMapaException;
import fiuba.algo3.algoFormers.modelo.juego.Juego;
import fiuba.algo3.algoFormers.vista.contenedores.ContenedorTablero;
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
	private ControladorJuego controlador;
	private ContenedorTablero tablero;

    @FXML
    void CancelarMovimiento(ActionEvent event) {
    	//A partir del evento obtengo el stage principal
    	this.cerrarStage(event);
    }

    @FXML
    void MoverAbajo(ActionEvent event) {
    	Direccion dir = new DirAbajo();
    	try{
    		this.juego.mover(dir);
    	}catch(FueraDelMapaException e){
    		System.out.println("No es una posicion disponible");
    	} 
    	this.redibujarTablero();
    	this.controlador.accionado();
    	this.cerrarStage(event);
    }

    @FXML
    void MoverAbajoIzq(ActionEvent event) {
    	Direccion dir = new DirAbajoIzq();
    	try{
    		this.juego.mover(dir); 
    	}catch(FueraDelMapaException e){
    		System.out.println("No es una posicion disponible");
    	} 
    	this.redibujarTablero();
    	this.controlador.accionado();
    	this.cerrarStage(event);
    }

    @FXML
    void MoverAbjDer(ActionEvent event) {
    	Direccion dir = new DirAbajoDer();
    	try{
    		this.juego.mover(dir);
    	}catch(FueraDelMapaException e){
    		System.out.println("No es una posicion disponible");
    	} 
    	this.redibujarTablero();
    	this.controlador.accionado();
    	this.cerrarStage(event);
    }

    @FXML
    void MoverArrDer(ActionEvent event) {
    	Direccion dir = new DirArribaDer();
    	try{
    		this.juego.mover(dir);
    	}catch(FueraDelMapaException e){
    		System.out.println("No es una posicion disponible");
    	} 
    	this.redibujarTablero();
    	this.controlador.accionado();
    	this.cerrarStage(event);
    }

    @FXML
    void MoverArriba(ActionEvent event) {
    	Direccion dir = new DirArriba();
    	try{
    		this.juego.mover(dir);
    	}catch(FueraDelMapaException e){
    		System.out.println("No es una posicion disponible");
    	} 
    	this.redibujarTablero();
    	this.controlador.accionado();
    	this.cerrarStage(event);
    }

    @FXML
    void MoverDerecha(ActionEvent event) {
    	Direccion dir = new DirDerecha();
    	try{
    		this.juego.mover(dir);
    	}catch(FueraDelMapaException e){
    		System.out.println("No es una posicion disponible");
    	} 
    	this.redibujarTablero();
    	this.controlador.accionado();
    	this.cerrarStage(event);
    }

    @FXML
    void MoverIzqArr(ActionEvent event) {
    	Direccion dir = new DirArribaIzq();
    	try{
    		this.juego.mover(dir);
    	}catch(FueraDelMapaException e){
    		System.out.println("No es una posicion disponible");
    	} 
    	this.redibujarTablero();
    	this.controlador.accionado();
    	this.cerrarStage(event);
    }

    @FXML
    void MoverIzquierda(ActionEvent event) {
    	Direccion dir = new DirIzquierda();
    	try{
    		this.juego.mover(dir);
    	}catch(FueraDelMapaException e){
    		System.out.println("No es una posicion disponible");
    	} 
    	this.redibujarTablero();
    	this.controlador.accionado();
    	this.cerrarStage(event);
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