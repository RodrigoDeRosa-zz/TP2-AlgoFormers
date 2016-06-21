package fiuba.algo3.algoFormers.vista.eventos;

import fiuba.algo3.algoFormers.modelo.interfaces.Capturable;
import fiuba.algo3.algoFormers.modelo.juego.Juego;
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
    	this.setBotonera(contenedorJuego);
    	stage.setScene(new Scene(contenedorJuego));
    	//obtengo el controlador para asignarle el juego
    	ControladorJuego controlador = loader.<ControladorJuego>getController();
    	controlador.initData(juego);
    	//se guardan los nombres de los jugadores
    	String nombreA = NombreAutobot.getText();
    	String nombreD = NombreDecepticon.getText();
    	this.juego.setNombres(nombreA,nombreD);
    	stage.setFullScreen(true);
    	stage.show();
    	
    }
    
	private void setBotonera(BorderPane stage){
		
		Button mover = new BotonMover(this.juego);
		Button atacar = new BotonAtacar(this.juego);
		Button transformar = new BotonTransformar(this.juego);
		Button combinar = new BotonCombinar(this.juego);
		Button finalizarTurno = new BotonFinalizarTurno(this.juego);
		
		ContenedorBotonesPrincipal botones = new ContenedorBotonesPrincipal(mover, atacar, transformar, combinar, finalizarTurno);
		
		stage.setBottom(botones);		
	}

	public void initData(Juego juego) {
		this.juego = juego;
		
	}
    

}
