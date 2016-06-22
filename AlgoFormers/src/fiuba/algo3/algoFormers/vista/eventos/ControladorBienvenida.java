package fiuba.algo3.algoFormers.vista.eventos;

import java.util.ArrayList;

import fiuba.algo3.algoFormers.modelo.fabricas.algoFormers.AlgoFormerFactory;
import fiuba.algo3.algoFormers.modelo.interfaces.Capturable;
import fiuba.algo3.algoFormers.modelo.juego.Juego;
import fiuba.algo3.algoFormers.modelo.jugadores.JugadorAutobots;
import fiuba.algo3.algoFormers.modelo.mapa.Posicion;
import fiuba.algo3.algoFormers.modelo.mapa.superficies.SuperficieAerea;
import fiuba.algo3.algoFormers.modelo.mapa.superficies.SuperficieTerrestre;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;
import fiuba.algo3.algoFormers.vista.Aplicacion;
import fiuba.algo3.algoFormers.vista.botones.acciones.BotonAtacar;
import fiuba.algo3.algoFormers.vista.botones.acciones.BotonCombinar;
import fiuba.algo3.algoFormers.vista.botones.acciones.BotonFinalizarTurno;
import fiuba.algo3.algoFormers.vista.botones.acciones.BotonMover;
import fiuba.algo3.algoFormers.vista.botones.acciones.BotonTransformar;
import fiuba.algo3.algoFormers.vista.botones.personajes.BotonBonecrusher;
import fiuba.algo3.algoFormers.vista.botones.personajes.BotonBumblebee;
import fiuba.algo3.algoFormers.vista.botones.personajes.BotonFrenzy;
import fiuba.algo3.algoFormers.vista.botones.personajes.BotonMegatron;
import fiuba.algo3.algoFormers.vista.botones.personajes.BotonOptimus;
import fiuba.algo3.algoFormers.vista.botones.personajes.BotonPersonaje;
import fiuba.algo3.algoFormers.vista.botones.personajes.BotonRatchet;
import fiuba.algo3.algoFormers.vista.contenedores.ContenedorBotonesPrincipal;
import fiuba.algo3.algoFormers.vista.contenedores.ContenedorTablero;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ControladorBienvenida {

	@FXML
    private TextField NombreAutobot;

    @FXML
    private TextField NombreDecepticon;

	private Juego juego;

    @FXML
    private void ComenzarJuego(ActionEvent event) throws Exception {
    	
    	//A partir del evento obtengo el stage principal
    	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	
    	//Se carga el contenedor del juego
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("ContenedorJuego.fxml"));
    	BorderPane contenedorJuego = (BorderPane) loader.load();
    	//Se busca en el centro donde hay guardado un GridPane de 40*40
    	ScrollPane contenedorCentro = (ScrollPane) contenedorJuego.getCenter();
    	ContenedorTablero tablero = new ContenedorTablero();
    	tablero.armarTablero(juego);
    	contenedorCentro.setContent(tablero);
    	contenedorJuego.setCenter(contenedorCentro);
    	this.setBotonera(contenedorJuego, tablero);
    	stage.setScene(new Scene(contenedorJuego));
    	//obtengo el controlador para asignarle el juego
    	ControladorJuego controlador = loader.<ControladorJuego>getController();
    	controlador.initData(juego);

    	//se guardan los nombres de los jugadores
    	String nombreA = NombreAutobot.getText();
    	String nombreD = NombreDecepticon.getText();
    	this.juego.setNombres(nombreA,nombreD);
    	
//    	AlgoFormerFactory factory = new AlgoFormerFactory();
//    	AlgoFormer optimus = factory.getOptimusPrime();
//    	this.juego.setPersonajeActual(optimus);
    	stage.setFullScreen(true);
    	stage.show();
    	
    }
    
	private void setBotonera(BorderPane stage,ContenedorTablero tablero){
		
		Button mover = new BotonMover(this.juego, tablero);
		Button atacar = new BotonAtacar(this.juego);
		Button transformar = new BotonTransformar(this.juego);
		Button combinar = new BotonCombinar(this.juego);
		Button finalizarTurno = new BotonFinalizarTurno(this.juego, tablero);
		Button personaje1, personaje2, personaje3;
		personaje1 = new BotonOptimus(this.juego);
		personaje2 = new BotonBumblebee(this.juego);
		personaje3 = new BotonRatchet(this.juego);
		
//		ArrayList<Button> personajes = setBotonesPersonajes();
//		
//		ContenedorBotonesPrincipal botones = new ContenedorBotonesPrincipal(mover, atacar, transformar, combinar,
//				finalizarTurno,personajes.get(1), personajes.get(2), personajes.get(3));
		ContenedorBotonesPrincipal botones = new ContenedorBotonesPrincipal(mover, atacar, transformar, combinar,
				finalizarTurno,personaje1, personaje2, personaje3);
		
		stage.setBottom(botones);
	}
	
	private ArrayList<Button> setBotonesPersonajes(){
		Button personaje1, personaje2, personaje3;
		if( ((this.juego.getJugadorActual()).getClass()) == (new JugadorAutobots()).getClass()){
			personaje1 = new BotonOptimus(this.juego);
			personaje2 = new BotonBumblebee(this.juego);
			personaje3 = new BotonRatchet(this.juego);
		}
		else{
			personaje1 = new BotonMegatron(this.juego);
			personaje2 = new BotonFrenzy(this.juego);
			personaje3 = new BotonBonecrusher(this.juego);
		}
		ArrayList<Button> personajes = new ArrayList<Button>();
		personajes.add(personaje1);
		personajes.add(personaje2);
		personajes.add(personaje3);
		return personajes;
	}

	public void initData(Juego juego) {
		this.juego = juego;
		
	}
    

}
