package fiuba.algo3.algoFormers.vista;

import java.io.IOException;

import fiuba.algo3.algoFormers.modelo.juego.Juego;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Aplicacion extends Application{
	
	private Stage primaryStage;
	
	public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(final Stage primaryStage) throws Exception {
    	this.primaryStage = primaryStage;
    	BorderPane contenedorBienvenida = (BorderPane) FXMLLoader.load(getClass().getResource("ContenedorBienvenida.fxml"));
    	Image imagen = new Image("file:src/fiuba/algo3/algoFormers/vista/imagenes/2704.jpg");//si se cambia la imagen, cambiar esto
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.SPACE, BackgroundRepeat.SPACE, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        contenedorBienvenida.setBackground(new Background(imagenDeFondo));
        this.primaryStage.setTitle("AlgoFormers");
    	this.primaryStage.setScene(new Scene(contenedorBienvenida, 640, 480));
        this.primaryStage.setFullScreen(true);
        this.primaryStage.show();
        

    }

    private Juego crearModelo() {
        Juego juego = new Juego();
        return juego;
    }

	public void comenzarJuego() throws Exception {
		BorderPane contenedorJuego = (BorderPane) FXMLLoader.load(getClass().getResource("ContenedorJuego.fxml"));
		this.primaryStage.setScene(new Scene(contenedorJuego));
		this.primaryStage.show();
	}
}

	

