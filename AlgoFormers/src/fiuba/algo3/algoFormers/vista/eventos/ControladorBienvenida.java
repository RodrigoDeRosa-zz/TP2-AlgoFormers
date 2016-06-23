package fiuba.algo3.algoFormers.vista.eventos;

import java.io.File;

import fiuba.algo3.algoFormers.modelo.juego.Juego;
import fiuba.algo3.algoFormers.vista.botones.acciones.BotonAtacar;
import fiuba.algo3.algoFormers.vista.botones.acciones.BotonCombinar;
import fiuba.algo3.algoFormers.vista.botones.acciones.BotonFinalizarTurno;
import fiuba.algo3.algoFormers.vista.botones.acciones.BotonMover;
import fiuba.algo3.algoFormers.vista.botones.acciones.BotonTransformar;
import fiuba.algo3.algoFormers.vista.contenedores.ContenedorBotonesPrincipal;
import fiuba.algo3.algoFormers.vista.contenedores.ContenedorTablero;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
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
    	stage.setScene(new Scene(contenedorJuego));
    	//Se busca en el centro donde hay guardado un GridPane de 40*40
    	ScrollPane contenedorCentro = (ScrollPane) contenedorJuego.getCenter();
    	ContenedorTablero tablero = new ContenedorTablero();
    	contenedorCentro.setContent(tablero);
    	contenedorJuego.setCenter(contenedorCentro);
    	tablero.armarTablero(juego);
    	
//    	this.setBotonera(contenedorJuego, tablero);
    	
    	//se guardan los nombres de los jugadores
    	String nombreA = NombreAutobot.getText();
    	String nombreD = NombreDecepticon.getText();
    	this.juego.setNombres(nombreA,nombreD);
    	
    	//obtengo el controlador para asignarle el juego
    	ControladorJuego controlador = loader.<ControladorJuego>getController();
    	controlador.initData(juego);
    	controlador.initTablero(tablero);
    	
    	stage.setFullScreen(true);
    	stage.show();
    	String musicFile = "src/fiuba/algo3/algoFormers/vista/sonidos/InicioJuego.mp3";
    	Media sonido = new Media(new File(musicFile).toURI().toString());
    	MediaPlayer mediaPlayer = new MediaPlayer(sonido);
    	mediaPlayer.play();
    	
    }
    
	private void setBotonera(BorderPane stage, ContenedorTablero tablero){
		
		Button mover = new BotonMover(this.juego, tablero);
		Button atacar = new BotonAtacar(this.juego);
		Button transformar = new BotonTransformar(this.juego);
		Button combinar = new BotonCombinar(this.juego);
		Button finalizarTurno = new BotonFinalizarTurno(this.juego, tablero);
//		Button personaje1, personaje2, personaje3;
//		personaje1 = new BotonOptimus(this.juego);
//		personaje2 = new BotonBumblebee(this.juego);
//		personaje3 = new BotonRatchet(this.juego);
		
//		ArrayList<Button> personajes = setBotonesPersonajes();
//		
//		ContenedorBotonesPrincipal botones = new ContenedorBotonesPrincipal(mover, atacar, transformar, combinar,
//				finalizarTurno,personajes.get(1), personajes.get(2), personajes.get(3));
		ContenedorBotonesPrincipal botones = new ContenedorBotonesPrincipal(mover, atacar, transformar, combinar,
				finalizarTurno, this.juego);
		
		stage.setBottom(botones);
	}

	public void initData(Juego juego) {
		this.juego = juego;
		
	}
    

}
