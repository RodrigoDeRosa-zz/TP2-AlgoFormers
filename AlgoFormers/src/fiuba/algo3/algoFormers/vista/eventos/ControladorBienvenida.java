package fiuba.algo3.algoFormers.vista.eventos;

import fiuba.algo3.algoFormers.modelo.interfaces.Capturable;
import fiuba.algo3.algoFormers.modelo.juego.Juego;
import fiuba.algo3.algoFormers.modelo.mapa.Posicion;
import fiuba.algo3.algoFormers.modelo.mapa.superficies.SuperficieAerea;
import fiuba.algo3.algoFormers.modelo.mapa.superficies.SuperficieTerrestre;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;
import fiuba.algo3.algoFormers.vista.Aplicacion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
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

	private Aplicacion aplicacion;
	
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
    	GridPane tablero = new GridPane();
    	
    	this.armarTablero(tablero, juego);
    	contenedorCentro.setContent(tablero);
    	contenedorJuego.setCenter(contenedorCentro);
    	stage.setScene(new Scene(contenedorJuego));
    	//obtengo el controlador para asignarle el juego
    	ControladorJuego controlador = loader.<ControladorJuego>getController();
    	controlador.initData(juego);
    	//se guardan los nombres de los jugadores
    	String nombreA = NombreAutobot.getText();
    	String nombreD = NombreDecepticon.getText();
    	this.juego.setNombres(nombreA,nombreD);
    	stage.show();
    	
    }
    
	private void armarTablero(GridPane tablero, Juego juego) {
		for(int i = 0; i < 40; i++){
    		for(int j = 0; j < 40; j++){
    			Posicion posicion = new Posicion(i,j);
    			SuperficieTerrestre supTerrestre = juego.getSuperficieTerrestre(posicion);
    			SuperficieAerea supAerea = juego.getSuperficieAerea(posicion);
    			AlgoFormer algoformer = (AlgoFormer) juego.getAtacable(posicion);
    			AnchorPane casillero = new AnchorPane();
    			Capturable capturable = juego.getCapturable(posicion);
    			
    			//se dibujan y setean la superficies
    			String nombreSupT = supTerrestre.getNombre();
    			Image imagenTerrestre = new Image(("file:src/fiuba/algo3/algoFormers/vista/imagenes/" + nombreSupT + ".png"));
    	        String nombreSupA = supAerea.getNombre();
    	        if (nombreSupA != "Nube"){
    	        	//se define la terrestre como fondo
    	        	BackgroundImage imagenDeFondo = new BackgroundImage(imagenTerrestre, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        	        casillero.setBackground(new Background(imagenDeFondo));
    	        	//se superpone la aerea
        	        ImageView imagenAerea = new ImageView(new Image(("file:src/fiuba/algo3/algoFormers/vista/imagenes/Tormenta.png")));
    	        	casillero.getChildren().add(imagenAerea);
    	        }else{
    	        	//solo de define la terrestre
    	        	ImageView imagen = new ImageView(imagenTerrestre);
    	        	casillero.getChildren().add(imagen);
    	        }
    	        
    	        //se agrega al algoformer
    	        if(algoformer != null){
    	        	String nombreAlgoformer = algoformer.getNombre();
    	        	ImageView imagenAlgoformer = new ImageView(new Image(("file:src/fiuba/algo3/algoFormers/vista/imagenes/" + nombreAlgoformer + ".png")));
    	        	casillero.getChildren().add(imagenAlgoformer);
    	        }
    	        
    	        //se agrega al bonus
    	        if(capturable != null){
    	        	String nombreCapturable = capturable.getNombre();
    	        	ImageView imagenCapturable = new ImageView(new Image(("file:src/fiuba/algo3/algoFormers/vista/imagenes/" + nombreCapturable + ".png")));
    	        	casillero.getChildren().add(imagenCapturable);
    	        }
    	        
    			tablero.add(casillero, i, j);
    		}
		}	
	}

	public void initData(Juego juego) {
		this.juego = juego;
		
	}
    

}
