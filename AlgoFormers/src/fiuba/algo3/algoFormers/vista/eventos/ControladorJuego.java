package fiuba.algo3.algoFormers.vista.eventos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import fiuba.algo3.algoFormers.modelo.juego.Juego;
import fiuba.algo3.algoFormers.modelo.jugadores.Jugador;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;
import fiuba.algo3.algoFormers.vista.contenedores.ContenedorTablero;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ControladorJuego {

	private AlgoFormer personajeUno;
	private AlgoFormer personajeDos;
	private AlgoFormer personajeTres;
	
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
	private ContenedorTablero tablero;
	private ToggleButton toggleActual;
	private AlgoFormer personajeActual;

    @FXML
    void Atacar(ActionEvent event) throws IOException {
    	//se abre la ventana de ataque
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("ContenedorAtaque.fxml"));
    	BorderPane contenedorAtaque = (BorderPane) loader.load();
    	
    	//obtengo el controlador para asignarle el juego
    	ControladorAtaque controlador = loader.<ControladorAtaque>getController();
    	controlador.initData(juego);
    	
    	Stage stage = new Stage();
		stage.setTitle("Mover");
    	stage.setScene(new Scene(contenedorAtaque));
    	stage.show();
    }

    @FXML
    void Combinar(ActionEvent event) {
    	this.juego.combinar();
    }

    @FXML
    void FinalzarTurno(ActionEvent event) {
    	this.juego.finalizarTurno();
    	this.setJugador(juego.getJugadorActual());
    }

    @FXML
    void Mover(ActionEvent event) throws IOException {
    	//se abre la ventana de movimiento
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("ContenedorMovimiento.fxml"));
    	BorderPane contenedorMovimiento = (BorderPane) loader.load();
    	
    	//obtengo el controlador para asignarle el juego
    	ControladorMovimiento controlador = loader.<ControladorMovimiento>getController();
    	controlador.initData(juego);
    	
    	Stage stage = new Stage();
		stage.setTitle("Mover");
    	stage.setScene(new Scene(contenedorMovimiento));
    	stage.show();
    }

    @FXML
    void SeleccionarPersonajeActual1(ActionEvent event) {
    	this.deseleccionarToggle(Personaje2, personajeDos);
    	this.deseleccionarToggle(Personaje3, personajeTres);
    	this.seleccionarToggle(Personaje1, personajeUno);
    	this.juego.setPersonajeActual(this.personajeUno);
    }

    @FXML
    void SeleccionarPersonajeActual2(ActionEvent event) {
    	this.deseleccionarToggle(Personaje1, personajeUno);
    	this.deseleccionarToggle(Personaje3, personajeTres);
    	this.seleccionarToggle(Personaje2, personajeDos);
    	this.juego.setPersonajeActual(this.personajeDos);
    }

    @FXML
    void SeleccionarPersonajeActual3(ActionEvent event) {
    	this.deseleccionarToggle(Personaje2, personajeDos);
    	this.deseleccionarToggle(Personaje1, personajeUno);
    	this.seleccionarToggle(Personaje3, personajeTres);
    	this.juego.setPersonajeActual(this.personajeTres);
    }

    @FXML
    void Transformar(ActionEvent event) {
    	this.juego.transformar();
    	this.setEstiloToggle(this.personajeActual.getNombreEstado(), this.toggleActual); 
    	this.seleccionarToggle(this.toggleActual, this.personajeActual);
    }
    
    public void setPersonajes(AlgoFormer uno, AlgoFormer dos, AlgoFormer tres){
    	this.personajeUno = uno;
    	this.setEstiloToggle(uno.getNombreEstado(), this.Personaje1);    	
    	this.personajeDos = dos;
    	this.setEstiloToggle(dos.getNombreEstado(), this.Personaje2);
    	this.personajeTres = tres;
    	this.setEstiloToggle(tres.getNombreEstado(), this.Personaje3);
    }
    
    private void setEstiloToggle(String nombre, ToggleButton boton){
    	boton.setGraphic(new ImageView(new Image((("file:src/fiuba/algo3/algoFormers/vista/imagenes/" + nombre + ".png")))));
    	boton.setStyle("-fx-background-color: transparent;");
    }
    
    private void deseleccionarToggle(ToggleButton boton, AlgoFormer personaje){
    	boton.setSelected(false);
    	boton.setStyle("-fx-background-color: transparent;");
    }
    
    private void seleccionarToggle(ToggleButton boton, AlgoFormer personaje){
    	this.personajeActual = personaje;
    	this.toggleActual = boton;
    	boton.setSelected(true);
    	boton.requestFocus();
    	boton.setStyle("-fx-shadow: black");
    }

	public void initData(Juego juego) {
		this.juego = juego;	
		this.setJugador(juego.getJugadorActual());
	}
	
	private void setJugador(Jugador jugador){
		Set<AlgoFormer> personajes  = jugador.getPersonajes();
		ArrayList<AlgoFormer> guardar = new ArrayList<AlgoFormer>();
		personajes.forEach((personaje) -> guardar.add(personaje));
		int tam = guardar.size();
		AlgoFormer uno=null, dos=null, tres=null;
		uno = guardar.get(0);
		if (tam > 1) dos = guardar.get(1);
		if (tam > 2) tres = guardar.get(2);
		this.setPersonajes(uno, dos, tres);
	}

	public void initTablero(ContenedorTablero tablero) {
		this.tablero = tablero;
		
	}

}
