package fiuba.algo3.algoFormers.vista.eventos;

import java.util.ArrayList;
import java.util.Set;

import fiuba.algo3.algoFormers.modelo.excepciones.AtaqueFueraDeRangoException;
import fiuba.algo3.algoFormers.modelo.juego.Juego;
import fiuba.algo3.algoFormers.modelo.jugadores.Jugador;
import fiuba.algo3.algoFormers.modelo.mapa.Posicion;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
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
    
    @FXML
    private Label NotificacionError;
    
	private Juego juego;
	private ControladorJuego controlador;

	private AlgoFormer personajeUno;
	private AlgoFormer personajeDos;
	private AlgoFormer personajeTres;
	private AlgoFormer elegido;

    @FXML
    void Atacar(ActionEvent event) {
    	Posicion posicion = this.juego.getPosicionAlgoformer(this.elegido);
    	try{this.juego.atacar(posicion);} catch(AtaqueFueraDeRangoException e){NotificacionError.setText(e.getMessage());return;}
    	this.controlador.setJugador(juego.getJugadorActual());
    	this.CerrarVentana(event);
    }

    @FXML
    void CancelarAtaque(ActionEvent event) {
    	//A partir del evento obtengo el stage principal
    	this.CerrarVentana(event);
    }
    
    public void CerrarVentana(ActionEvent event){
    	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	stage.close();
    }

    @FXML
    void SeleccionarEnemigo1(ActionEvent event){
    	this.seleccionarRadio(this.SeleccionEnemigo1);
    	this.deseleccionarRadio(this.SeleccionEnemigo2);
    	this.deseleccionarRadio(this.SeleccionEnemigo3);
    	this.elegido= this.personajeUno;
    }

    @FXML
    void SeleccionarEnemigo2(ActionEvent event) {
    	this.seleccionarRadio(this.SeleccionEnemigo2);
    	this.deseleccionarRadio(this.SeleccionEnemigo1);
    	this.deseleccionarRadio(this.SeleccionEnemigo3);
    	this.elegido= this.personajeDos;
    }

    @FXML
    void SeleccionarEnemigo3(ActionEvent event) {
    	this.seleccionarRadio(this.SeleccionEnemigo3);
    	this.deseleccionarRadio(this.SeleccionEnemigo2);
    	this.deseleccionarRadio(this.SeleccionEnemigo1);
    	this.elegido= this.personajeTres;
    }
    
	public void initData(Juego juego, ControladorJuego controlador) {
		this.juego = juego;
		this.controlador = controlador;
		this.setJugador(this.juego.getJugadorOpuesto());
	}
	
    private void deseleccionarRadio(RadioButton boton){
    	boton.setSelected(false);
    	boton.setStyle("-fx-background-color: transparent;");
    }
    
    private void seleccionarRadio(RadioButton boton){
    	boton.setSelected(true);
    	boton.setStyle("-fx-shadow-color: black;");
    }
    
    private void setEstiloRadio(String nombre, ImageView imagen){
    	imagen.setImage(new Image((("file:src/fiuba/algo3/algoFormers/vista/imagenes/" + nombre + ".png"))));
    	imagen.setStyle("-fx-background-color: transparent;");
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
	
	public void setPersonajes(AlgoFormer uno, AlgoFormer dos, AlgoFormer tres){
		if (uno != null){
			this.personajeUno = uno;
			this.setEstiloRadio(uno.getNombreEstado(), this.ImagenEnemigo1);    	
		} else {this.desactivar(this.ImagenEnemigo1, this.SeleccionEnemigo1);}
		if (dos != null){
			this.personajeDos = dos;
			this.setEstiloRadio(dos.getNombreEstado(), this.ImagenEnemigo2);
		} else {this.desactivar(this.ImagenEnemigo2, this.SeleccionEnemigo2);}
		if (tres != null){
			this.personajeTres = tres;
			this.setEstiloRadio(tres.getNombreEstado(), this.ImagenEnemigo3);
		} else {this.desactivar(this.ImagenEnemigo3, this.SeleccionEnemigo3);;}
	}
	 
	
	private void desactivar(ImageView imagen, RadioButton radio){
		imagen.setVisible(false);
		radio.setVisible(false);
	}
	  
}
