package fiuba.algo3.algoFormers.vista.eventos;

import fiuba.algo3.algoFormers.modelo.juego.Juego;
import fiuba.algo3.algoFormers.modelo.mapa.Posicion;
import fiuba.algo3.algoFormers.modelo.mapa.superficies.SuperficieAerea;
import fiuba.algo3.algoFormers.modelo.mapa.superficies.SuperficieTerrestre;
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

    @FXML
    private void ComenzarJuego(ActionEvent event) throws Exception {
    	Juego juego = new Juego();
    	
    	//A partir del evento obtengo el stage principal
    	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	
    	//Se carga el contenedor del juego
    	BorderPane contenedorJuego = (BorderPane) FXMLLoader.load(getClass().getResource("ContenedorJuego.fxml"));
    	//Se busca en el centro donde hay guardado un GridPane de 40*40
    	ScrollPane contenedorCentro = (ScrollPane) contenedorJuego.getCenter();
    	GridPane tablero = new GridPane();
    	
    	this.armarTablero(tablero, juego);
    	contenedorCentro.setContent(tablero);
    	contenedorJuego.setCenter(contenedorCentro);
    	stage.setScene(new Scene(contenedorJuego));
		stage.show();	
    }
    
	private void armarTablero(GridPane tablero, Juego juego) {
		for(int i = 1; i <= 40; i++){
    		for(int j = 1; j <= 40; j++){
//    			Posicion posicion = new Posicion(i,j);
//    			SuperficieTerrestre supTerrestre = juego.getSuperficieTerrestre(posicion);
//    			SuperficieAerea supAerea = juego.getSuperficieAerea(posicion);
//    			GridPane casillero = new GridPane();
    			HBox casillero = new HBox();
    			casillero.getChildren().add(new ImageView(new Image("file:src/fiuba/algo3/algoFormers/vista/imagenes/transformers-optimus.png")));
//    			if(supAerea != Nube){
//    				casillero.add(new ImageView("direccion de la imagen SupTerrestre y aerea"), 1, 1);
//    			}else{ 
//    				casillero.add(new ImageView("superficie terrestre"), 1, 1);
//    			}
//    			casillero.add(new ImageView("file:src/fiuba/algo3/algoFormers/vista/imagenes/transformers-optimus.png"), 1, 2);
    			casillero.setAlignment(Pos.CENTER);
    			tablero.add(casillero, i, j);
    		}
		}	
	}
    

}
